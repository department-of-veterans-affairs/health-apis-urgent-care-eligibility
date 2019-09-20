package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import gov.va.api.health.sentinel.LabBot;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult.LabBotUserResultBuilder;
import gov.va.api.health.sentinel.categories.Manual;
import lombok.Builder;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CerStressTest {

  private static Properties properties;

  // Number of requests to execute (-Drequests=100)
  private static int requests = 100;

  // Concurrent requests (-Dconcurrent-requests=20)
  private static int concurrentRequests = 20;

  // Maximum test duration (in minutes) (-Dmaximum-runtime=10)
  private static int maximumRuntime = 10;

  @BeforeClass
  public static void setup() {
    properties = System.getProperties();

    // Override default config values if they are present as system properties
    requests = Integer.valueOf(properties.getProperty("requests", String.valueOf(requests)));
    concurrentRequests =
        Integer.valueOf(
            properties.getProperty("concurrent-requests", String.valueOf(concurrentRequests)));
    maximumRuntime =
        Integer.valueOf(properties.getProperty("maximum-runtime", String.valueOf(maximumRuntime)));

    // Ensure they make sense
    assertThat(requests).withFailMessage("Number of requests must be > 0").isGreaterThan(0);
    assertThat(concurrentRequests)
        .withFailMessage("Concurrent requests must be > 0")
        .isGreaterThan(0);
    assertThat(maximumRuntime).withFailMessage("Maximum runtime must be > 0").isGreaterThan(0);
  }

  private static Predicate<LabBotUserResult> success() {
    return p ->
        !p.tokenExchange().isError()
            && p.response().contains("\"resourceType\":\"CoverageEligibilityResponse\"");
  }

  private static List<String> urgentCareScopes() {
    return Arrays.asList(
        "patient/CoverageEligibilityResponse.read", "offline_access", "launch/patient");
  }

  @Test
  @Category(Manual.class)
  public void stressTest() {
    log.info(
        "Begin stress test [{} request, {} concurrent, {} minute(s) maximum runtime]",
        requests,
        concurrentRequests,
        maximumRuntime);

    StressBot stressBot =
        StressBot.builder()
            .user("va.api.user+idme.123@gmail.com")
            .scopes(urgentCareScopes())
            .configFile("config/lab.properties")
            .requests(requests)
            .concurrentRequests(concurrentRequests)
            .maximumRuntime(maximumRuntime)
            .build();

    List<LabBotUserResult> results =
        stressBot.request("/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}");

    assertThat(results.size()).withFailMessage("No results").isGreaterThan(0);

    List<String> failures = new ArrayList<>();

    // Identify failed requests
    results
        .stream()
        .filter(success().negate())
        .forEach(
            failure -> {
              failures.add(
                  String.format("Failure for %s: %s", failure.user().id(), failure.response()));
            });

    StringBuilder output =
        new StringBuilder()
            .append("Requests desired   : ")
            .append(requests)
            .append(System.lineSeparator())
            .append("Requests attempted : ")
            .append(results.size())
            .append(System.lineSeparator())
            .append("Requests succeeded : ")
            .append(results.size() - failures.size())
            .append(System.lineSeparator())
            .append("Requests failed    : ")
            .append(failures.size())
            .append(System.lineSeparator())
            .append(String.join(System.lineSeparator(), failures));

    log.info("Stress test results:{}{}", System.lineSeparator(), output);

    try {
      Files.write(
          new File("stress-test.txt").toPath(), output.toString().getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      log.error("Unable to write test results to a file", e);
    }

    assertThat(failures.size()).isZero();
  }

  /** Bot with functionality for repetitive requests (e.g. load/stress testing) */
  @Slf4j
  static class StressBot {

    private LabBot labBot;

    private int requests;

    private int concurrentRequests;

    private int maximumRuntime;

    /**
     * Constructs a new stress bot.
     *
     * @param user The user for executing requests.
     * @param scopes The scopes that for token requests.
     * @param configFile The configuration file.
     * @param requests The number of requests to execute.
     * @param concurrentRequests The number of concurrent requests / threads.
     * @param maximumRuntime The maximum runtime in minutes for all requests to finish.
     */
    @Builder
    public StressBot(
        @NonNull String user,
        @NonNull List<String> scopes,
        @NonNull String configFile,
        int requests,
        int concurrentRequests,
        int maximumRuntime) {
      labBot =
          LabBot.builder()
              .userIds(Arrays.asList(user))
              .scopes(scopes)
              .configFile(configFile)
              .build();

      this.requests = requests;
      this.concurrentRequests = concurrentRequests;
      this.maximumRuntime = maximumRuntime;
    }

    private LabBotUserResult authenticate() {
      List<LabBotUserResult> tokens = labBot.tokens();

      if (tokens.size() != 1) {
        throw new AssertionError("Token exchange not successful");
      }

      return tokens.get(0);
    }

    private void awaitResults(ExecutorService ex, List<Future<?>> futures)
        throws InterruptedException {
      ex.shutdown();

      if (!ex.awaitTermination(maximumRuntime, TimeUnit.MINUTES)) {
        log.info("Maximum runtime has been exceeded; cancelling remaining tasks");
      }

      /*
       * Proceed when all tasks are complete or when X minutes have been exceeded.
       *
       * Attempt to cancel any remaining tasks and fail the test if any unexpected
       * exceptions are thrown.
       */

      int errors =
          futures
              .stream()
              .mapToInt(
                  f -> {
                    try {
                      if (!f.isDone()) {
                        f.cancel(true);
                      }
                      f.get();
                      return 0;
                    } catch (CancellationException e) {
                      return 0;
                    } catch (Exception e) {
                      log.error(e.getMessage());
                      return 1;
                    }
                  })
              .sum();

      if (errors > 0) {
        throw new AssertionError("Thread processing had " + errors + " unexpected errors");
      }
    }

    /**
     * Given a path send a request for each user. Replaces {icn} with patient icn to send request.
     * Useful for when you want to send a given request to a set of users.
     *
     * @param path The path to use for the requests, must contain {icn} to be replaced with the
     *     patient icn.
     * @return a list of results.
     */
    @SneakyThrows
    public List<LabBotUserResult> request(String path) {
      LabBotUserResult token = authenticate();

      List<LabBotUserResult> results = new CopyOnWriteArrayList<>();
      List<Future<?>> futures = new ArrayList<>(requests);
      ExecutorService ex = Executors.newFixedThreadPool(concurrentRequests);

      for (int i = 0; i < requests; i++) {
        futures.add(
            ex.submit(
                () -> {
                  LabBotUserResultBuilder result =
                      LabBotUserResult.builder()
                          .user(token.user())
                          .tokenExchange(token.tokenExchange());
                  try {
                    result.response(
                        labBot.request(
                            path.replace("{icn}", token.tokenExchange().patient()),
                            token.tokenExchange().accessToken()));
                  } catch (Exception e) {
                    log.error("Request failure: {}", e.getMessage(), e.getCause());
                    result.response(e.getClass().getName() + ": " + e.getMessage());
                  } finally {
                    results.add(result.build());
                  }
                }));
      }

      awaitResults(ex, futures);

      return results;
    }
  }
}
