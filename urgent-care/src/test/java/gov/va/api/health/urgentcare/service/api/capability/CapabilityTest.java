package gov.va.api.health.urgentcare.service.api.capability;

import static gov.va.api.health.urgentcare.service.api.RoundTrip.assertRoundTrip;

import org.junit.Test;

public class CapabilityTest {

  @Test
  public void capability() {
    assertRoundTrip(SampleCapabilities.get().capability());
  }
}
