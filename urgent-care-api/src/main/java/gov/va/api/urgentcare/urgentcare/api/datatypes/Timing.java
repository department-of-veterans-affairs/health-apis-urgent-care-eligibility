package gov.va.api.urgentcare.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.urgentcare.urgentcare.api.Fhir;
import gov.va.api.urgentcare.urgentcare.api.elements.BackboneElement;
import gov.va.api.urgentcare.urgentcare.api.elements.Element;
import gov.va.api.urgentcare.urgentcare.api.elements.Extension;
import gov.va.api.urgentcare.urgentcare.api.validation.ZeroOrOneOf;
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
@Schema(description = "https://www.hl7.org/fhir/R4/datatypes.html#Timing")
public class Timing implements BackboneElement {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid List<Extension> modifierExtension;

  List<@Pattern(regexp = Fhir.DATETIME) String> event;

  @Valid Repeat repeat;

  @Valid CodeableConcept code;

  @SuppressWarnings("unused")
  public enum EventTiming {
    HS,
    WAKE,
    C,
    CM,
    CD,
    CV,
    AC,
    ACM,
    ACD,
    ACV,
    PC,
    PCM,
    PCD,
    PCV
  }

  @SuppressWarnings("unused")
  public enum UnitsOfTime {
    s,
    min,
    h,
    d,
    wk,
    mo,
    a
  }

  @SuppressWarnings("unused")
  public enum DaysOfWeek {
    mon,
    tue,
    wed,
    thu,
    fri,
    sat,
    sun
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @ZeroOrOneOf(fields = {"boundsDuration", "boundsRange", "boundsPeriod"})
  public static class Repeat implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid Duration boundsDuration;
    @Valid Range boundsRange;
    @Valid Period boundsPeriod;

    @Pattern(regexp = Fhir.POSITIVE_INT)
    String count;

    @Pattern(regexp = Fhir.POSITIVE_INT)
    String countMax;

    @Pattern(regexp = Fhir.DECIMAL)
    String duration;

    @Pattern(regexp = Fhir.DECIMAL)
    String durationMax;

    @Valid UnitsOfTime durationUnit;

    @Pattern(regexp = Fhir.POSITIVE_INT)
    String frequency;

    @Pattern(regexp = Fhir.POSITIVE_INT)
    Integer frequencyMax;

    @Pattern(regexp = Fhir.DECIMAL)
    String period;

    @Pattern(regexp = Fhir.DECIMAL)
    String periodMax;

    @Valid UnitsOfTime periodUnit;

    @Valid List<DaysOfWeek> dayOfWeek;

    List<@Pattern(regexp = Fhir.TIME) String> timeOfDay;

    EventTiming when;

    @Pattern(regexp = Fhir.UNSIGNED_INT)
    String offset;
  }
}
