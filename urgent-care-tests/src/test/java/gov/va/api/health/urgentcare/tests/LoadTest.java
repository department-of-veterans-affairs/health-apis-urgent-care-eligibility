package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import gov.va.api.health.sentinel.LabBot;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.categories.Manual;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadTest {

  private static Properties properties;

  @BeforeClass
  public static void setup() {
    properties = System.getProperties();
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
  public void loadTest() {
    // Fetch the number of requests to execute per user (with a sensible default)
    int requestsPerUser = Integer.valueOf(properties.getProperty("requests-per-user", "5"));
    // Fetch the number of concurrent requests (threads) to execute (with a sensible default)
    int concurrentRequests = Integer.valueOf(properties.getProperty("concurrent-requests", "10"));

    assertThat(requestsPerUser).isGreaterThan(0);
    assertThat(concurrentRequests).isGreaterThan(0);

    LabBot bot =
        LabBot.builder()
            .userIds(LabBot.allUsers())
            .scopes(urgentCareScopes())
            .configFile("config/lab.properties")
            .build();

    log.info(
        "Starting load test ["
            + requestsPerUser
            + " request per user, "
            + concurrentRequests
            + " concurrent, "
            + requestsPerUser * bot.userIds().size()
            + " total]");

    List<LabBotUserResult> results =
        bot.request(
            "/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}",
            requestsPerUser,
            concurrentRequests);

    log.info("Checking that the number of users is not 0");
    assertThat(results.size()).isNotZero();

    List<String> report = new ArrayList<>();
    List<String> failures = new ArrayList<>();

    // Identify successful requests
    results
        .stream()
        .filter(success())
        .collect(Collectors.groupingBy(o -> o.user().id(), Collectors.counting()))
        .forEach(
            (id, count) -> {
              String message =
                  String.format("%s - %d of %d requests successful", id, count, requestsPerUser);
              report.add(message);
            });

    // Identify failed requests
    results
        .stream()
        .filter(success().negate())
        .forEach(
            failure -> {
              String message =
                  String.format(
                      "Failure for %s: %s - %s",
                      failure.user().id(),
                      failure.tokenExchange().error(),
                      failure.tokenExchange().errorDescription());
              failures.add(message);
              report.add(message);
            });

    String output = String.join("\n", report);
    Files.write(new File("load-test.txt").toPath(), output.getBytes(StandardCharsets.UTF_8));
    log.info("Load test results:\n{}", output);

    assertThat(failures.size()).isZero();
  }
}
