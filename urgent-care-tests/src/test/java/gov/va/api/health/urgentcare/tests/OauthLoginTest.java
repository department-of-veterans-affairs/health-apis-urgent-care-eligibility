package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.sentinel.LabBotOauthLogin;
import gov.va.api.health.sentinel.LoginResults;
import gov.va.api.health.sentinel.categories.Manual;
import java.io.File;
import java.util.Arrays;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/** Perform an Oauth login test with the application specific parameters. */
public class OauthLoginTest {

  /** As a minumum, verify all of the users are winners. */
  @Category(Manual.class)
  @Test
  @SneakyThrows
  public void testOauthRequests() {
    LabBotOauthLogin bot =
        LabBotOauthLogin.builder()
            .scopes(
                Arrays.asList(
                    "patient/CoverageEligibilityResponse.read", "offline_access", "launch/patient"))
            .configFile("config/lab.properties")
            .requestUrl("/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}")
            .expectedResponse("\"resourceType\":\"CoverageEligibilityResponse\"")
            .reportEnabled(true)
            .reportFileEnabled(true)
            .reportFile(new File("lab-users.txt"))
            .build();
    LoginResults results = bot.loginUsers();
    assertThat(results.losers().size()).isZero();
    assertThat(results.winners().size()).isNotZero();
  }
}
