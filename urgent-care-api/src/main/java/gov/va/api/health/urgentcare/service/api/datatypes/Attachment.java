package gov.va.api.health.urgentcare.service.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.service.api.Fhir;
import gov.va.api.health.urgentcare.service.api.elements.Element;
import gov.va.api.health.urgentcare.service.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://www.hl7.org/fhir/R4/datatypes.html#Attachment")
public class Attachment implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.CODE)
  String contentType;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Pattern(regexp = Fhir.BASE64)
  String data;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Pattern(regexp = Fhir.UNSIGNED_INT)
  String size;

  @Pattern(regexp = Fhir.BASE64)
  String hash;

  @Pattern(regexp = Fhir.STRING)
  String title;

  @Pattern(regexp = Fhir.DATETIME)
  String creation;
}
