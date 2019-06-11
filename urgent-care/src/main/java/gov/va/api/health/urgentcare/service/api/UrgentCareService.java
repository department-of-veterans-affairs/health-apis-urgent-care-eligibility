package gov.va.api.health.urgentcare.service.api;

import gov.va.api.health.r4.api.CoverageEligibilityResponseApi;
import gov.va.api.health.r4.api.MetadataApi;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import javax.ws.rs.Path;

@OpenAPIDefinition(
  info =
      @Info(
        title = "Urgent Care Eligibility",
        version = "v1",
        description =
            "FHIR (Fast Healthcare Interoperability Resources) specification defines a set of"
                + " \"Resources\" that represent granular clinical, financial, and administrative"
                + " concepts.  This CoverageEligibilityResponse resource is compliant with FHIR"
                + " version R4 standards."
      ),
  servers = {
    @Server(url = "https://dev-api.va.gov/services/fhir/v0/r4", description = "Development server")
  },
  externalDocs =
      @ExternalDocumentation(
        description = "CoverageEligibilityResponse",
        url = "https://www.hl7.org/fhir/r4/coverageeligibilityresponse.html"
      )
)
@Path("/")
public interface UrgentCareService extends CoverageEligibilityResponseApi, MetadataApi {
  class UrgentCareServiceException extends RuntimeException {
    UrgentCareServiceException(String message) {
      super(message);
    }
  }

  class SearchFailed extends UrgentCareServiceException {
    public SearchFailed(String id, String reason) {
      super(id + " Reason: " + reason);
    }
  }

  class UnknownResource extends UrgentCareServiceException {
    public UnknownResource(String id) {
      super(id);
    }
  }
}
