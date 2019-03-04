package gov.va.api.urgentcare.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.urgentcare.urgentcare.api.Fhir;
import gov.va.api.urgentcare.urgentcare.api.elements.BackboneElement;
import gov.va.api.urgentcare.urgentcare.api.elements.Element;
import gov.va.api.urgentcare.urgentcare.api.elements.Extension;
import gov.va.api.urgentcare.urgentcare.api.validation.ZeroOrOneOf;
import gov.va.api.urgentcare.urgentcare.api.validation.ZeroOrOneOfs;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://www.hl7.org/fhir/R4/dosage.html")
@ZeroOrOneOf(fields = {"asNeededBoolean", "asNeededCodeableConcept"})
public class Dosage implements BackboneElement {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid List<Extension> modifierExtension;

  @Pattern(regexp = Fhir.INTEGER)
  String sequence;

  @Pattern(regexp = Fhir.STRING)
  String text;

  @Valid List<CodeableConcept> additionalInstruction;

  @Pattern(regexp = Fhir.STRING)
  String patientInstruction;

  @Valid Timing timing;

  @Pattern(regexp = Fhir.BOOLEAN)
  String asNeededBoolean;

  @Valid CodeableConcept asNeededCodeableConcept;

  @Valid CodeableConcept site;

  @Valid CodeableConcept route;

  @Valid CodeableConcept method;

  @Valid List<DoseAndRate> doseAndRate;

  @Valid Ratio maxDosePerPeriod;

  @Valid SimpleQuantity maxDosePerAdministration;

  @Valid SimpleQuantity maxDosePerLifetime;

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(description = "DosageDoseAndRate")
  @ZeroOrOneOfs({
    @ZeroOrOneOf(
      fields = {"doseRange", "doseQuantity"},
      message = "Only one dose type can be specifiec"
    ),
    @ZeroOrOneOf(
      fields = {"rateRatio", "rateRange", "rateQuantity"},
      message = "Only one rate type can be specified"
    )
  })
  public static class DoseAndRate implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid Range doseRange;

    @Valid SimpleQuantity doseQuantity;

    @Valid Ratio rateRatio;

    @Valid Range rateRange;

    @Valid SimpleQuantity rateQuantity;
  }
}
