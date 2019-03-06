package gov.va.api.health.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.urgentcare.api.Fhir;
import gov.va.api.health.urgentcare.api.elements.Element;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.validation.ZeroOrOneOf;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#TriggerDefinition")
@ZeroOrOneOf(fields = {"timingTiming", "timingReference", "timingDate", "timingDateTime"})
public class TriggerDefinition implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid @NotNull TriggerDefinition.Type type;

  @Pattern(regexp = Fhir.STRING)
  String name;

  @Valid Timing timingTiming;

  @Valid Reference timingReference;

  @Pattern(regexp = Fhir.DATE)
  String timingDate;

  @Pattern(regexp = Fhir.DATETIME)
  String timingDateTime;

  @Valid List<DataRequirement> data;

  @Valid Expression condition;

  @SuppressWarnings("unused")
  public enum Type {
    @JsonProperty("named-event")
    named_event,
    periodic,
    @JsonProperty("data-changed")
    data_changed,
    @JsonProperty("data-added")
    data_added,
    @JsonProperty("data-modified")
    data_modified,
    @JsonProperty("data-removed")
    data_removed,
    @JsonProperty("data-accessed")
    data_accessed,
    @JsonProperty("data-access-ended")
    data_access_ended
  }
}
