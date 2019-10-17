package gov.va.api.health.urgentcare.service.api.swaggerexamples;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.r4.api.resources.Capability;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SwaggerMetadata {

  static final Capability SWAGGER_EXAMPLE_METADATA = swaggerExampleMetadata();

  @SneakyThrows
  static Capability swaggerExampleMetadata() {
    return JacksonConfig.createMapper()
        .readValue(SwaggerMetadata.class.getResourceAsStream("/capability.json"), Capability.class);
  }
}
