package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static gov.va.api.health.urgentcare.service.controller.Transformers.hasPayload;

import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.urgentcare.service.controller.Bundler;
import gov.va.api.health.urgentcare.service.controller.Bundler.BundleContext;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.QueenElizabethClient;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.Query;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import java.util.Collections;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Request Mappings for Coverage Eligibility Response Resournce, see
 * https://www.hl7.org/fhir/R4/coverageeligibilityresponse.html for
 * implementation details.
 */
@SuppressWarnings("WeakerAccess")
@Validated
@RestController
@RequestMapping(
    value = {"/api/CoverageEligibilityResponse"},
    produces = {"application/json", "application/json+fhir", "application/fhir+json"}
)
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CoverageEligibilityResponseController {
  private Transformer transformer;
  private QueenElizabethClient queenElizabethClient;
  private Bundler bundler;

  private Bundle bundle(String id) {
    GetEESummaryResponse eeSummaryResponse = search(id);
    LinkConfig linkConfig = LinkConfig.builder()
        .path("CoverageEligibilityResponse")
        .id(id)
        .build();
    return bundler.bundle(BundleContext.of(
        linkConfig,
        eeSummaryResponse == null
        ? Collections.emptyList()
        : eeSummaryResponse,
        transformer,
        CoverageEligibilityResponse.Entry::new,
        CoverageEligibilityResponse.Bundle::new));
  }

  private GetEESummaryResponse search(String id) {
    Query<GetEESummaryResponse> query =
        Query.forType(GetEESummaryResponse.class)
            .id(id)
            .build();
    return hasPayload(queenElizabethClient.search(query));
  }

  public interface Transformer
      extends Function<GetEESummaryResponse, CoverageEligibilityResponse> {}
}
