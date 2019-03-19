package gov.va.api.health.eeclient.ee.impl;

import gov.va.api.health.eeclient.Samples;
import gov.va.api.health.eeclient.ee.Eligibilities;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ValidateEligibilitiesTests {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Mock SoapRequester soapRequester;

  private ValidateEligibilities validateEligibilities;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
    validateEligibilities = new ValidateEligibilities(soapRequester);
  }

  @Test
  public void emptyIdShouldReturnMissingIcnValueException() {
    thrown.expect(Eligibilities.MissingIcnValue.class);
    validateEligibilities.request(
        SoapMessageGenerator.builder()
            .eeUsername("eeTestUsername")
            .eePassword("eeTestPassword")
            .eeRequestName("eeTestRequestName")
            .id("")
            .build());
  }

  @Test
  public void invalidIcnIdShouldReturnUnknownIdentityException() {
    thrown.expect(Eligibilities.UnknownIdentityInSearchParameter.class);
    validateEligibilities.request(
        SoapMessageGenerator.builder()
            .eeUsername("eeTestUsername")
            .eePassword("eeTestPassword")
            .eeRequestName("eeTestRequestName")
            .id("not-an-icn")
            .build());
  }

  private SoapMessageGenerator soapMessageGenerator() {
    return SoapMessageGenerator.builder()
        .eeUsername("eeTestUsername")
        .eePassword("eeTestPassword")
        .eeRequestName("eeTestRequestName")
        .id("1010101010V666666")
        .build();
  }

  @Test
  public void validIcnShouldParseAndWriteDocSuccessfully() {
    Mockito.when(validateEligibilities.request(soapMessageGenerator()))
        .thenReturn(Samples.create().getEeSummaryResponseBody());
    validateEligibilities.request(soapMessageGenerator());
  }
}
