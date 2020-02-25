package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static java.util.Collections.singletonList;

import gov.va.api.health.queenelizabeth.ee.QueenElizabethService;
import gov.va.api.health.queenelizabeth.ee.exceptions.PersonNotFound;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.r4.api.resources.OperationOutcome;
import gov.va.api.health.urgentcare.service.controller.Bundler;
import gov.va.api.health.urgentcare.service.controller.Bundler.BundleContext;
import gov.va.api.health.urgentcare.service.controller.GetEeSummaryResponseTheRemix;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import gov.va.api.health.urgentcare.service.controller.Parameters;
import gov.va.api.health.urgentcare.service.controller.Validator;
import java.util.Collections;
import java.util.function.Function;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
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
    produces = {"application/json", "application/json+fhir", "application/fhir+json"})
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CoverageEligibilityResponseController {
  private Transformer transformer;
  private QueenElizabethService queenElizabethService;
  private Bundler bundler;

  private Bundle bundle(MultiValueMap<String, String> parameters, int page, int count, String icn) {
    GetEeSummaryResponseTheRemix theRemix = search(icn);
    LinkConfig linkConfig =
        LinkConfig.builder()
            .path("CoverageEligibilityResponse")
            .queryParams(parameters)
            .page(page)
            .recordsPerPage(count)
            .build();
    return bundler.bundle(
        BundleContext.of(
            linkConfig,
            theRemix.getEeSummaryResponse() == null || count == 0 || page != 1
                ? Collections.emptyList()
                : singletonList(theRemix),
            transformer,
            CoverageEligibilityResponse.Entry::new,
            CoverageEligibilityResponse.Bundle::new));
  }

  /**
   * Perform Queen Elizabeth getEESummary search on ICN. If the ICN is not found the transform is
   * performed on an null response object. Any other non-nominal exception from the SOAP Service
   * floats up and is handled by the WebExceptionHandler associated with this controller.
   *
   * @param icn The ICN to search.
   * @return A GetEeSummaryResponseTheRemix bean that holds an ICN and the GetEeSummaryResponse from
   *     the getEESummary SOAP Service.
   */
  private GetEeSummaryResponseTheRemix search(String icn) {
    try {
      return new GetEeSummaryResponseTheRemix(icn, queenElizabethService.getEeSummary(icn));
    } catch (PersonNotFound e) {
      return new GetEeSummaryResponseTheRemix(icn, null);
    }
  }

  /** Search by patient. */
  @GetMapping(params = {"patient"})
  public Bundle searchByPatient(
      @RequestParam("patient") String patient,
      @RequestParam(value = "page", defaultValue = "1") @Min(1) int page,
      @RequestParam(value = "_count", defaultValue = "15") @Min(0) int count) {
    return bundle(
        Parameters.builder().add("patient", patient).add("page", page).add("_count", count).build(),
        page,
        count,
        patient);
  }

  /** Validate endpoint... validates. */
  @PostMapping(
      value = "/$validate",
      consumes = {"application/json", "application/json+fhir", "application/fhir+json"})
  public OperationOutcome validate(@RequestBody Bundle bundle) {
    return Validator.create().validate(bundle);
  }

  public interface Transformer
      extends Function<GetEeSummaryResponseTheRemix, CoverageEligibilityResponse> {}
}
