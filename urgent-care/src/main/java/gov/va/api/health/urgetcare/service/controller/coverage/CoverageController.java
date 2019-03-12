package gov.va.api.health.urgetcare.service.controller.coverage;

import gov.va.api.health.urgentcare.api.resources.Coverage;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import java.util.function.Function;

public class CoverageController {

  public interface Transformer extends Function<GetEESummaryResponse, Coverage> {}
}
