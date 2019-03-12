package gov.va.api.health.urgentcare.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.urgentcare.api.Fhir;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Money;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.datatypes.SimpleQuantity;
import gov.va.api.health.urgentcare.api.datatypes.SimpleResource;
import gov.va.api.health.urgentcare.api.elements.BackboneElement;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.elements.Meta;
import gov.va.api.health.urgentcare.api.elements.Narrative;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.validation.ExactlyOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
@JsonAutoDetect(
  fieldVisibility = JsonAutoDetect.Visibility.ANY,
  isGetterVisibility = JsonAutoDetect.Visibility.NONE
)
@Schema(
  description = "https://www.hl7.org/fhir/R4/coverage.html",
  example = "SWAGGER_EXAMPLE_COVERAGE"
)
public class Coverage implements Resource {
  // Anscestor -- Resource
  @Pattern(regexp = Fhir.ID)
  String id;

  @NotBlank String resourceType;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  // Ancestor -- DomainResource
  @Valid Narrative text;
  @Valid List<SimpleResource> contained;
  @Valid List<Extension> extension;
  @Valid List<Extension> modifierExtension;

  // Coverage Resource
  @Valid List<Identifier> identifier;
  @NotNull Status status;
  @Valid CodeableConcept type;
  @Valid Reference policyHolder;
  @Valid Reference subscriber;

  @Pattern(regexp = Fhir.STRING)
  String subscriberId;

  @NotNull @Valid Reference beneficiary;

  @Pattern(regexp = Fhir.STRING)
  String dependent;

  @Valid CodeableConcept relationship;
  @Valid Period period;
  @NotEmpty List<Reference> payor;

  @JsonProperty("class")
  List<CoverageClass> coverageClass;

  @Pattern(regexp = Fhir.POSITIVE_INT)
  String order;

  @Pattern(regexp = Fhir.STRING)
  String network;

  @Valid List<CostToBeneficiary> costToBeneficiary;

  @Pattern(regexp = Fhir.BOOLEAN)
  String subrogation;

  @Valid List<Reference> contract;

  @SuppressWarnings("unused")
  public enum Status {
    active,
    cancelled,
    draft,
    @JsonProperty("entered-in-error")
    entered_in_error
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "CoverageCostToBeneficiary")
  @ExactlyOneOf(
    fields = {"valueQuantity", "valueMoney"},
    message = "valueQuantity or valueMoney, but not both"
  )
  public static class CostToBeneficiary implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @Valid CodeableConcept type;
    @Valid SimpleQuantity valueQuantity;
    @Valid Money valueMoney;
    @Valid List<Exception> exception;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "CoverageClass")
  public static class CoverageClass implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotNull CodeableConcept type;

    @Pattern(regexp = Fhir.STRING)
    @NotNull
    String value;

    @Pattern(regexp = Fhir.STRING)
    String name;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "CostToBeneficiaryException")
  public static class Exception implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotNull CodeableConcept type;
    @Valid Period period;
  }
}
