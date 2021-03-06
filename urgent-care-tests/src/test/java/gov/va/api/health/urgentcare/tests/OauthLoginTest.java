package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.sentinel.LabBot;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.categories.Manual;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
public class OauthLoginTest {
  private static List<String> urgentCareScopes() {
    return Arrays.asList(
        "patient/CoverageEligibilityResponse.read", "offline_access", "launch/patient");
  }

  @Test
  @SneakyThrows
  @Category(Manual.class)
  public void RequestTest() {
    List<LabBotUserResult> labBotUserResultList =
        LabBot.builder()
            .userIds(LabBot.allUsers())
            .scopes(urgentCareScopes())
            .configFile("config/lab.properties")
            .build()
            .request("/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}");
    List<String> winners = new ArrayList<>();
    List<String> losers = new ArrayList<>();
    for (LabBotUserResult labBotUserResult : labBotUserResultList) {
      if (!labBotUserResult.tokenExchange().isError()
          && labBotUserResult
              .response()
              .contains("\"resourceType\":\"CoverageEligibilityResponse\"")) {
        log.info(
            "Winner: {} is patient {}.",
            labBotUserResult.user().id(),
            labBotUserResult.tokenExchange().patient());
        winners.add(
            labBotUserResult.user().id()
                + " is patient "
                + labBotUserResult.tokenExchange().patient());
      } else {
        log.info(
            "Loser: {} is patient {}.",
            labBotUserResult.user().id(),
            labBotUserResult.tokenExchange().patient());
        losers.add(
            labBotUserResult.user().id()
                + " is patient "
                + labBotUserResult.tokenExchange().patient()
                + " - "
                + labBotUserResult.tokenExchange().error()
                + ": "
                + labBotUserResult.tokenExchange().errorDescription());
      }
    }
    String report =
        Stream.concat(winners.stream().map(w -> w + " - OK"), losers.stream())
            .sorted()
            .collect(Collectors.joining("\n"));
    Files.write(new File("lab-users.txt").toPath(), report.getBytes(StandardCharsets.UTF_8));
    log.info("Lab Users:\n{}", report);
    assertThat(losers.size()).isZero();
  }
}
