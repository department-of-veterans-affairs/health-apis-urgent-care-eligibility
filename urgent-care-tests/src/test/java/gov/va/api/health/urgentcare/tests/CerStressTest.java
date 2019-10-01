package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.categories.Manual;
import gov.va.api.health.urgentcare.tests.StressBot.StressBotRequest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
public class CerStressTest {

  private static final List<String> userIds = Arrays.asList("va.api.user+idme.123@gmail.com");

  private static final String url =
      "/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}";

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
        "Begin stress test [{} requests, {} concurrent, {} minute(s) maximum runtime]",
        requests,
        concurrentRequests,
        maximumRuntime);
    StressBot stressBot =
        StressBot.builder()
            .maximumRuntime(maximumRuntime)
            .concurrentRequests(concurrentRequests)
            .configFile("config/lab.properties")
            .build();
    List<LabBotUserResult> results =
        stressBot.request(
            StressBotRequest.builder()
                .url(url)
                .times(requests)
                .userIds(userIds)
                .scopes(urgentCareScopes())
                .build());
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
            .append(requests * userIds.size())
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
}
