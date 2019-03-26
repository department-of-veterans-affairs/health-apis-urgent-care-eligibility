package gov.va.api.health.urgentcare.api.resources;

import static gov.va.api.health.urgentcare.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.urgentcare.api.bundle.AbstractBundle.BundleType.searchset;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.ExactlyOneOfVerifier;
import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import gov.va.api.health.urgentcare.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.urgentcare.api.resources.Coverage.Bundle;
import gov.va.api.health.urgentcare.api.resources.Coverage.Entry;
import gov.va.api.health.urgentcare.api.samples.SampleCoverages;
import org.junit.Test;

public class CoverageTest {

  private final SampleCoverages data = SampleCoverages.get();

  @Test
  public void bundlerCanBuildCoverageBundles() {
    Entry entry =
        Entry.builder()
            .extension(singletonList(data.extension()))
            .fullUrl("http://coverage.com")
            .id("123")
            .link(
                singletonList(
                    BundleLink.builder()
                        .relation(BundleLink.LinkRelation.self)
                        .url(("http://coverage/1"))
                        .build()))
            .resource(data.coverageWithValueQuanitity())
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
                        .url(("http://coverage.com/2"))
                        .build()))
            .type(searchset)
            .signature(data.signature())
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void coverage() {
    assertRoundTrip(data.coverageWithValueQuanitity());
    assertRoundTrip(data.coverageWithValueMoney());
  }

  @Test
  public void relatedGroups() {
    ExactlyOneOfVerifier.builder()
        .sample(data.costToBeneficiaryWithValueQuantity())
        .fieldPrefix("value")
        .build()
        .verify();
  }
}
