package gov.va.api.health.urgentcare.api.resources;

import static gov.va.api.health.urgentcare.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.urgentcare.api.samples.SampleCapabilities;
import org.junit.Test;

public class CapabilityTest {

  @Test
  public void capability() {
    assertRoundTrip(SampleCapabilities.get().capability());
  }
}
