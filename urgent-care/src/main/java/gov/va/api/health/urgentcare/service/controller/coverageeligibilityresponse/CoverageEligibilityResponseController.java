package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static gov.va.api.health.urgentcare.service.controller.Transformers.hasPayload;
import static java.util.Collections.singletonList;

import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.r4.api.resources.OperationOutcome;
import gov.va.api.health.urgentcare.service.controller.Bundler;
import gov.va.api.health.urgentcare.service.controller.Bundler.BundleContext;
import gov.va.api.health.urgentcare.service.controller.GetEeSummaryResponseTheRemix;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import gov.va.api.health.urgentcare.service.controller.Validator;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.QueenElizabethClient;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.Query;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Request Mappings for Coverage Eligibility Response Resource, see
 * https://www.hl7.org/fhir/R4/coverageeligibilityresponse.html for implementation details.
 */
@SuppressWarnings("WeakerAccess")
@Validated
@RestController
@RequestMapping(
  value = {"/CoverageEligibilityResponse"},
  produces = {"application/json", "application/json+fhir", "application/fhir+json"}
)
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CoverageEligibilityResponseController {
  private Transformer transformer;
  private QueenElizabethClient queenElizabethClient;
  private Bundler bundler;

  private Bundle bundle(String icn) {
    GetEeSummaryResponseTheRemix theRemix = search(icn);
    LinkConfig linkConfig =
        LinkConfig.builder().path("CoverageEligibilityResponse").icn(icn).build();
    return bundler.bundle(
        BundleContext.of(
            linkConfig,
            singletonList(theRemix),
            transformer,
            CoverageEligibilityResponse.Entry::new,
            CoverageEligibilityResponse.Bundle::new));
  }

  private GetEeSummaryResponseTheRemix search(String icn) {
    Query<GetEESummaryResponse> query = Query.forType(GetEESummaryResponse.class).id(icn).build();
    GetEESummaryResponse eeSummaryResponse = hasPayload(queenElizabethClient.search(query));
    return new GetEeSummaryResponseTheRemix(icn, eeSummaryResponse);
  }

  /** Search by patient. */
  @GetMapping(params = {"patient"})
  public Bundle searchByPatient(@RequestParam("patient") String patient) {
    return bundle(patient);
  }

  /** Validate endpoint... validates. */
  @PostMapping(
    value = "/$validate",
    consumes = {"application/json", "application/json+fhir", "application/fhir+json"}
  )
  public OperationOutcome validate(@RequestBody Bundle bundle) {
    return Validator.create().validate(bundle);
  }

  public interface Transformer
      extends Function<GetEeSummaryResponseTheRemix, CoverageEligibilityResponse> {}
}
