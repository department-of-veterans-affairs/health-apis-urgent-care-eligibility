package gov.va.api.health.urgentcare.service.controller.capability;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.urgentcare.api.resources.Capability;
import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import gov.va.api.health.urgetcare.service.controller.capability.CapabilityStatementProperties;
import gov.va.api.health.urgetcare.service.controller.capability.CapabilityStatementProperties.ContactProperties;
import lombok.SneakyThrows;

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
        .softwareName("Urgent Care")
        .fhirVersion("1.0.4")
        .resourceDocumentation("Implemented per the specification")
        .build();
  }

  /*@Test
  @Ignore
  @SneakyThrows
  public void read() {
    CapabilityStatementProperties properties = properties();
    gov.va.api.health.urgentcare.service.controller.capability.MetadataController controller =
        new gov.va.api.health.urgentcare.service.controller.capability.MetadataController(
            properties);
    Capability old =
        JacksonConfig.createMapper()
            .readValue(getClass().getResourceAsStream("/capability.json"), Capability.class);
    try {
      assertThat(pretty(controller.read())).isEqualTo(pretty(old));
    } catch (AssertionError e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }*/
}
