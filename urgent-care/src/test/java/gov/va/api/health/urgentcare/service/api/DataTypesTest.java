package gov.va.api.health.urgentcare.service.api;

import gov.va.api.health.urgentcare.service.api.UrgentCareService.SearchFailed;
import gov.va.api.health.urgentcare.service.api.UrgentCareService.UnknownResource;
import gov.va.api.health.urgentcare.service.api.capability.SampleDataTypes;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DataTypesTest {

  private final SampleDataTypes data = SampleDataTypes.get();

  @SuppressWarnings("ThrowableNotThrown")
  @Test
  public void exceptionConstructors() {
    new UnknownResource("some id");
    new SearchFailed("some id", "some reason");
  }
}
