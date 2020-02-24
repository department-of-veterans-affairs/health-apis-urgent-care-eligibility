package gov.va.api.health.urgentcare.service.api;

import gov.va.api.health.urgentcare.service.api.UrgentCareService.SearchFailed;
import gov.va.api.health.urgentcare.service.api.UrgentCareService.UnknownResource;
import org.junit.Test;

public class DataTypesTest {
  @Test
  @SuppressWarnings({"ThrowableNotThrown", "unused"})
  public void exceptionConstructors() {
    new UnknownResource("some id");
    new SearchFailed("some id", "some reason");
  }
}
