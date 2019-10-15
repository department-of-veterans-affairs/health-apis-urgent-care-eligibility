package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.queenelizabeth.ee.QueenElizabethService;
import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Entry;
import gov.va.api.health.urgentcare.service.controller.Bundler;
import gov.va.api.health.urgentcare.service.controller.Bundler.BundleContext;
import gov.va.api.health.urgentcare.service.controller.GetEeSummaryResponseTheRemix;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import gov.va.api.health.urgentcare.service.controller.Parameters;
import gov.va.api.health.urgentcare.service.controller.Validator;
import gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse.CoverageEligibilityResponseController.Transformer;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import java.util.function.Supplier;
import javax.validation.ConstraintViolationException;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.MultiValueMap;

public class CoverageEligibilityResponseControllerTest {
  @Mock QueenElizabethService client;

  @Mock Transformer tx;

  CoverageEligibilityResponseController controller;

  @Mock Bundler bundler;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
    controller = new CoverageEligibilityResponseController(tx, client, bundler);
  }

  private void assertSearch(
      Supplier<Bundle> invocation, MultiValueMap<String, String> params, String id) {
    GetEESummaryResponse getEESummaryResponse = new GetEESummaryResponse();
    GetEeSummaryResponseTheRemix theRemix =
        new GetEeSummaryResponseTheRemix(id, getEESummaryResponse);
    CoverageEligibilityResponse coverageEligibilityResponse =
        CoverageEligibilityResponse.builder().build();

    when(tx.apply(theRemix)).thenReturn(coverageEligibilityResponse);
    when(client.getEeSummary(id)).thenReturn(getEESummaryResponse);

    Bundle mockBundle = new Bundle();
    when(bundler.bundle(Mockito.any())).thenReturn(mockBundle);

    Bundle actual = invocation.get();

    assertThat(actual).isSameAs(mockBundle);

    ArgumentCaptor<
            BundleContext<GetEeSummaryResponseTheRemix, CoverageEligibilityResponse, Entry, Bundle>>
        captor = ArgumentCaptor.forClass(BundleContext.class);

    verify(bundler).bundle(captor.capture());

    LinkConfig expectedLinkConfig =
        LinkConfig.builder()
            .path("CoverageEligibilityResponse")
            .queryParams(params)
            .page(1)
            .recordsPerPage(1)
            .build();
    assertThat(captor.getValue().linkConfig()).isEqualTo(expectedLinkConfig);
    assertThat(captor.getValue().xmlItems().get(0).getEeSummaryResponse())
        .isEqualTo(theRemix.getEeSummaryResponse());
    assertThat(captor.getValue().newBundle().get()).isInstanceOf(Bundle.class);
    assertThat(captor.getValue().newEntry().get()).isInstanceOf(Entry.class);
    assertThat(captor.getValue().transformer()).isSameAs(tx);
  }

  private Bundle bundleOf(CoverageEligibilityResponse resource) {
    return Bundle.builder()
        .type(BundleType.searchset)
        .resourceType("Bundle")
        .entry(
            singletonList(
                CoverageEligibilityResponse.Entry.builder()
                    .fullUrl("http://example.com")
                    .resource(resource)
                    .build()))
        .build();
  }

  @Test
  public void searchByPatient() {
    assertSearch(
        () -> controller.searchByPatient("me", 1, 1),
        Parameters.builder().add("patient", "me").add("page", 1).add("_count", 1).build(),
        "me");
  }

  @Test
  @SneakyThrows
  public void validateAcceptsValidBundle() {
    CoverageEligibilityResponse resource =
        JacksonConfig.createMapper()
            .readValue(
                getClass().getResourceAsStream("/ee/coverageeligibilityresponse.json"),
                CoverageEligibilityResponse.class);
    Bundle bundle = bundleOf(resource);
    assertThat(controller.validate(bundle)).isEqualTo(Validator.ok());
  }

  @Test(expected = ConstraintViolationException.class)
  @SneakyThrows
  public void validateThrowsExceptionForInvalidBundle() {
    CoverageEligibilityResponse resource =
        JacksonConfig.createMapper()
            .readValue(
                getClass().getResourceAsStream("/ee/coverageeligibilityresponse.json"),
                CoverageEligibilityResponse.class);
    resource.resourceType(null);

    Bundle bundle = bundleOf(resource);
    controller.validate(bundle);
  }
}
