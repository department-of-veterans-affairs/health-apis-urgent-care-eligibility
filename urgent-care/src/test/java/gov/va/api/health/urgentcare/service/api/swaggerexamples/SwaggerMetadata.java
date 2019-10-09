package gov.va.api.health.urgentcare.service.api.swaggerexamples;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.r4.api.resources.Capability;
import java.io.IOException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SwaggerMetadata {

  static final Capability SWAGGER_EXAMPLE_METADATA;

  static {
    try {
      SWAGGER_EXAMPLE_METADATA =
          JacksonConfig.createMapper()
              .readValue(
                  SwaggerMetadata.class.getResourceAsStream("/capability.json"), Capability.class);
    } catch (IOException e) {
      throw new ExceptionInInitializerError(e);
    }
  }
}
