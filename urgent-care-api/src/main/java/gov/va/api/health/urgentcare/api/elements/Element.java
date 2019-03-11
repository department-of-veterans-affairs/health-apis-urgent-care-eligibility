package gov.va.api.health.urgentcare.api.elements;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "https://www.hl7.org/fhir/R4/element.html")
public interface Element {

  List<Extension> extension();

  String id();
}
