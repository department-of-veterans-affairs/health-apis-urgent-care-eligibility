package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import java.util.function.Function;

public class CoverageEligibilityResponseController {

  public interface Transformer
      extends Function<GetEESummaryResponse, CoverageEligibilityResponse> {}
}
