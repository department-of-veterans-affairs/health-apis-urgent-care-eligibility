package gov.va.api.health.urgentcare.service.controller.capability;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.urgentcare.api.resources.Capability;
import gov.va.api.health.urgentcare.api.resources.Capability.Kind;
import gov.va.api.health.urgentcare.api.resources.Capability.Status;
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
        .id("R4-fhir-capability")
        .version("1.0.0")
        .status(Status.active)
        .name("Urgent Care FHIR")
        .publisher("Liberty ITS")
        .contact(
            ContactProperties.builder()
                .name("Drew Myklegard")
                .email("david.myklegard@va.gov")
                .build())
        .date("2018-09-27T19:30:00-05:00")
        .description(
            "This is the base conformance statement for FHIR."
                + " It represents a server that provides the full"
                + " set of functionality defined by FHIR."
                + " It is provided to use as a template for system designers to"
                + " build their own conformance statements from.")
        .kind(Kind.capability)
        .softwareName("Urgent Care")
        .fhirVersion("1.0.4")
        .resourceDocumentation("Implemented per the specification")
        .security(
            SecurityProperties.builder()
                .tokenEndpoint("https://argonaut.lighthouse.va.gov/token")
                .authorizeEndpoint("https://argonaut.lighthouse.va.gov/authorize")
                .description(
                    "This is the conformance statement to declare that the server"
                        + " supports SMART-on-FHIR. See the SMART-on-FHIR docs for the"
                        + " extension that would go with such a server.")
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
