import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.service.api.Fhir;
import gov.va.api.health.urgentcare.service.api.elements.Element;
import gov.va.api.health.urgentcare.service.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#Contributor")
public class Contributor implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @NotNull Type type;

  @Pattern(regexp = Fhir.STRING)
  @NotBlank
  String name;

  @Valid List<ContactDetail> contact;

  public enum Type {
    author,
    editor,
    reviewer,
    endorser
  }
}
