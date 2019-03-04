package gov.va.api.urgentcare.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.urgentcare.urgentcare.api.Fhir;
import gov.va.api.urgentcare.urgentcare.api.elements.Element;
import gov.va.api.urgentcare.urgentcare.api.elements.Extension;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#Expression")
public class Expression implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.STRING)
  String description;

  @Pattern(regexp = Fhir.ID)
  String name;

  @Pattern(regexp = Fhir.CODE)
  @NotNull
  String language;

  @Pattern(regexp = Fhir.STRING)
  String expression;

  @Pattern(regexp = Fhir.URI)
  String reference;
}
