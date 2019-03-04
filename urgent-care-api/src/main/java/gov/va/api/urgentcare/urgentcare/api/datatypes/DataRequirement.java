package gov.va.api.urgentcare.urgentcare.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.urgentcare.urgentcare.api.Fhir;
import gov.va.api.urgentcare.urgentcare.api.elements.Element;
import gov.va.api.urgentcare.urgentcare.api.elements.Extension;
import gov.va.api.urgentcare.urgentcare.api.elements.Reference;
import gov.va.api.urgentcare.urgentcare.api.validation.ZeroOrOneOf;
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
@Schema(description = "https://www.hl7.org/fhir/R4/metadatatypes.html#DataRequirement")
@ZeroOrOneOf(fields = {"subjectCodeableConcept", "subjectReference"})
public class DataRequirement implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.CODE)
  @NotNull
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
  public class CodeFilter implements Element {
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
  public class DateFilter implements Element {
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
  public class Sort implements Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.STRING)
    @NotNull
    String path;

    @NotNull DataRequirement.SortDirection direction;
  }
}
