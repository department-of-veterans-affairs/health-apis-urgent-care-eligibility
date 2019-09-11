package gov.va.api.health.urgentcare.tests;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.sentinel.categories.Manual;
import gov.va.api.health.sentinel.junit.LabBotOauthLoginRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/** Perform an Oauth login test with the application specific parameters. */
@Slf4j
public class OauthLoginTest {

  public List<String> loserList = new ArrayList<>();

  public List<String> winnerList = new ArrayList<>();

  @Rule
  public LabBotOauthLoginRule labBotOauthLoginRule =
      new LabBotOauthLoginRule(
          Arrays.asList(
              "patient/CoverageEligibilityResponse.read", "offline_access", "launch/patient"),
          "config/lab.properties",
          "/services/fhir/v0/r4/CoverageEligibilityResponse?patient={icn}",
          "\"resourceType\":\"CoverageEligibilityResponse\"",
          winnerList,
          loserList);

  /** As a minumum, verify all of the users are winners. */
  @Test
  @Category(Manual.class)
  @LabBotOauthLoginRule.LabBotOauthLoginReport
  @LabBotOauthLoginRule.LabBotOauthLoginReportFile(filename = "lab-users.txt")
  public void testOauthRequests() {
    assertThat(loserList.size()).isZero();
    assertThat(winnerList.size()).isNotZero();
  }
}
