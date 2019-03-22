package gov.va.api.health.urgentcare.api;

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
                + " \"Resources\" that represent granular clinical concepts."
                + "This service is compiant with Urgent Care Eligibility Implementation."
      ),
  servers = {
    @Server(
      url = "https://dev-api.va.gov/services/argonaut/v0/",
      description = "Development server - url not definitive."
    )
  },
  externalDocs =
      @ExternalDocumentation(
        description = "Urgent Care Eligibility",
        url = "https://www.hl7.org/fhir/R4/index.html"
      )
)
@Path("/")
public interface UrgentCareService extends CoverageApi, MetadataApi {
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
