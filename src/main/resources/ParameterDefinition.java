import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.service.api.Fhir;
import gov.va.api.health.urgentcare.service.api.elements.Element;
import gov.va.api.health.urgentcare.service.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#ParameterDefinition")
public class ParameterDefinition implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.CODE)
  String name;

  @NotNull Use use;

  @Pattern(regexp = Fhir.INTEGER)
  String min;

  @Pattern(regexp = Fhir.STRING)
  String max;

  @Pattern(regexp = Fhir.STRING)
  String documentation;

  @Pattern(regexp = Fhir.CODE)
  String type;

  @Pattern(regexp = Fhir.URI)
  String profile;

  public enum Use {
    in,
    out
  }
}
