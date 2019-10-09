package gov.va.api.health.urgentcare.service.controller.capability;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.r4.api.resources.Capability;
import gov.va.api.health.r4.api.resources.Capability.Kind;
import gov.va.api.health.r4.api.resources.Capability.Status;
import gov.va.api.health.urgentcare.service.controller.capability.CapabilityStatementProperties.ContactProperties;
import gov.va.api.health.urgentcare.service.controller.capability.CapabilityStatementProperties.SecurityProperties;
import lombok.SneakyThrows;
import org.junit.Test;

public class MetadataControllerTest {
  @SneakyThrows
  private String pretty(Capability capability) {
    return JacksonConfig.createMapper()
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(capability);
  }

  private CapabilityStatementProperties properties() {
    return CapabilityStatementProperties.builder()
        .id("health-api-urgent-care-capability")
        .version("2.0.0")
        .status(Status.draft)
        .name("API Management Platform | Health - Urgent Care")
        .publisher("Department of Veterans Affairs")
        .contact(
            ContactProperties.builder().name("Test Person").email("test.person@va.gov").build())
        .publicationDate("2019-08-08T19:29:29Z")
        .description("Read and search support Urgent Care Eligibility.")
        .kind(Kind.instance)
        .softwareName("urgent-care")
        .fhirVersion("4.0.0")
        .resourceDocumentation(
            "Implemented per specification. See http://hl7.org/fhir/R4/http.html")
        .security(
            SecurityProperties.builder()
                .tokenEndpoint("https://example.com/oauth2/token")
                .authorizeEndpoint("https://example.com/oauth2/authorization")
                .description("http://docs.smarthealthit.org/")
                .build())
        .build();
  }

  @Test
  @SneakyThrows
  public void read() {
    CapabilityStatementProperties properties = properties();
    MetadataController controller = new MetadataController(properties);
    Capability old =
        JacksonConfig.createMapper()
            .readValue(getClass().getResourceAsStream("/capability.json"), Capability.class);
    try {
      assertThat(pretty(controller.read())).isEqualTo(pretty(old));
    } catch (AssertionError e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
}
