package gov.va.api.health.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.api.Fhir;
import gov.va.api.health.urgentcare.api.elements.Element;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.validation.ZeroOrOneOf;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#DataRequirement")
@ZeroOrOneOf(fields = {"subjectCodeableConcept", "subjectReference"})
public class DataRequirement implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.CODE)
  @NotBlank
  String type;

  List<@Pattern(regexp = Fhir.URI) String> profile;

  @Valid CodeableConcept subjectCodeableConcept;

  @Valid Reference subjectReference;

  List<@Pattern(regexp = Fhir.STRING) String> mustSupport;

  @Valid List<CodeFilter> codeFilter;

  @Valid List<DateFilter> dateFilter;

  @Pattern(regexp = Fhir.POSITIVE_INT)
  String limit;

  @Valid List<Sort> sort;

  public enum SortDirection {
    ascending,
    descending
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "DataRequirementCodeFilter")
  public static class CodeFilter implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.STRING)
    String path;

    @Pattern(regexp = Fhir.STRING)
    String searchParam;

    @Pattern(regexp = Fhir.URI)
    String valueSet;

    @Valid List<Coding> code;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "DataRequirementDateFilter")
  @ZeroOrOneOf(fields = {"valueDateTime", "valuePeriod", "valueDuration"})
  public static class DateFilter implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.STRING)
    String path;

    @Pattern(regexp = Fhir.STRING)
    String searchParam;

    @Pattern(regexp = Fhir.DATETIME)
    String valueDateTime;

    @Valid Period valuePeriod;

    @Valid Duration valueDuration;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(description = "DataRequirementSort")
  public static class Sort implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.STRING)
    @NotBlank
    String path;

    @NotNull SortDirection direction;
  }
}
