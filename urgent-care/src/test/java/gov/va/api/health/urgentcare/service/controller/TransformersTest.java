package gov.va.api.health.urgentcare.service.controller;

import static gov.va.api.health.urgentcare.service.controller.Transformers.hasPayload;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.urgentcare.service.controller.Transformers.MissingPayload;
import org.junit.Test;

public class TransformersTest {

  @Test
  public void hasPayloadReturnsPayloadWhenNotNull() {
    assertThat(hasPayload("x")).isEqualTo("x");
  }

  @Test(expected = MissingPayload.class)
  public void hasPayloadThrowsMissingPayloadExceptionWhenNull() {
    hasPayload(null);
  }
}
