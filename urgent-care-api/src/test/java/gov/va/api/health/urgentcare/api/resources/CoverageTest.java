package gov.va.api.health.urgentcare.api.resources;

import static gov.va.api.health.urgentcare.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.urgentcare.api.ExactlyOneOfVerifier;
import gov.va.api.health.urgentcare.api.samples.SampleCoverages;
import org.junit.Test;

public class CoverageTest {

  private final SampleCoverages data = SampleCoverages.get();

  @Test
  public void coverage() {
    assertRoundTrip(data.coverage());
  }

  @Test
  public void relatedGroups() {
    ExactlyOneOfVerifier.builder().sample(data.coverage()).fieldPrefix("value").build();
  }
}
