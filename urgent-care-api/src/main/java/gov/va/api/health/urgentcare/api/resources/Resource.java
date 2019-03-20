package gov.va.api.health.urgentcare.api.resources;

import gov.va.api.health.urgentcare.api.elements.Meta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "https://www.hl7.org/fhir/R4/resource.html")
public interface Resource {
  String id();

  String implicitRules();

  String language();

  Meta meta();
}
