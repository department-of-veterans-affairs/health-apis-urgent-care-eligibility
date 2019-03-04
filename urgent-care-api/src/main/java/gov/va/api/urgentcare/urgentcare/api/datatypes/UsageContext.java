package gov.va.api.urgentcare.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.urgentcare.urgentcare.api.Fhir;
import gov.va.api.urgentcare.urgentcare.api.elements.Element;
import gov.va.api.urgentcare.urgentcare.api.elements.Extension;
import gov.va.api.urgentcare.urgentcare.api.elements.Reference;
import gov.va.api.urgentcare.urgentcare.api.validation.ExactlyOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#UsageContext")
@ExactlyOneOf(fields = {"valueCodeableConcept", "valueQuantity", "valueRange", "valueReference"})
public class UsageContext implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @NotNull Coding code;

  @Valid CodeableConcept valueCodeableConcept;

  @Valid Quantity valueQuantity;

  @Valid Range valueRange;

  @Valid Reference valueReference;
}
