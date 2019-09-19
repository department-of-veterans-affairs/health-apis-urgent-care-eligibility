package gov.va.api.health.urgentcare.tests;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.sentinel.LabBot;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult.LabBotUserResultBuilder;
import gov.va.api.health.sentinel.categories.Manual;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
public class CerStressTest {

  private static Properties properties;

  // Number of requests to execute (-Drequests-per-user=5)
  private static int requests = 100;

  // Concurrent requests (-Dconcurrent-requests=10)
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
  @SneakyThrows
  @Category(Manual.class)
  public void stressTest() {
    log.info(
        "Begin stress test [{} request, {} concurrent, {} minutes maximum runtime]",
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

    String output =
        String.format(
            "%d of %d requests successful%n%s",
            requests - failures.size(), requests, String.join(System.lineSeparator(), failures));
    Files.write(new File("stress-test.txt").toPath(), output.getBytes(StandardCharsets.UTF_8));
    log.info("Stress test results:\n{}", output);

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
      ex.awaitTermination(maximumRuntime, TimeUnit.MINUTES);

      String errors =
          futures
              .stream()
              .map(
                  f -> {
                    try {
                      f.get();
                      return null;
                    } catch (Exception e) {
                      log.error(e.getMessage());
                      return e.getMessage();
                    }
                  })
              .filter(Objects::nonNull)
              .collect(Collectors.joining("\n"));

      if (isNotBlank(errors)) {
        throw new AssertionError(errors);
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
