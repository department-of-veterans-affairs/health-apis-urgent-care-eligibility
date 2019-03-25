package gov.va.api.health.urgentcare.api.resources;

import static gov.va.api.health.urgentcare.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.urgentcare.api.bundle.AbstractBundle.BundleType.searchset;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.ZeroOrOneOfVerifier;
import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import gov.va.api.health.urgentcare.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Entry;
import gov.va.api.health.urgentcare.api.samples.SampleCoverageEligibilityResponses;
import org.junit.Test;

public class CoverageEligibilityResponseTest {

  private final SampleCoverageEligibilityResponses data = SampleCoverageEligibilityResponses.get();

  @Test
  public void bundlerCanBuildCoverageBundles() {
    Entry entry =
        Entry.builder()
            .extension(singletonList(data.extension()))
            .fullUrl("http://coverage-eligibility-response.com")
            .id("123")
            .link(
                singletonList(
                    BundleLink.builder()
                        .relation(BundleLink.LinkRelation.self)
                        .url(("http://coverage-eligibility-response/1"))
                        .build()))
            .resource(data.coverageEligibilityResponse())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Bundle bundle =
        Bundle.builder()
            .entry(singletonList(entry))
            .link(
                singletonList(
                    BundleLink.builder()
                        .relation(LinkRelation.self)
                        .url(("http://coverage-eligibility-response.com/2"))
                        .build()))
            .type(searchset)
            .signature(data.signature())
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void coverageEligibilityResponse() {
    assertRoundTrip(data.coverageEligibilityResponse());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.coverageEligibilityResponse())
        .fieldPrefix("serviced")
        .build();
    ZeroOrOneOfVerifier.builder()
        .sample(data.coverageEligibilityResponse())
        .fieldPrefix("allowed")
        .build();
    ZeroOrOneOfVerifier.builder()
        .sample(data.coverageEligibilityResponse())
        .fieldPrefix("used")
        .build();
  }
}
