package gov.va.api.health.urgentcare.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.api.Fhir;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Money;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.datatypes.Quantity;
import gov.va.api.health.urgentcare.api.datatypes.Ratio;
import gov.va.api.health.urgentcare.api.datatypes.Signature;
import gov.va.api.health.urgentcare.api.validation.ZeroOrOneOf;
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
@Schema(description = "http://hl7.org/fhir/R4/extensibility.html#extension")
@ZeroOrOneOf(
  fields = {
    // "valueBase64Binary",
    "valueBoolean",
    // "valueCanonical",
    "valueCode",
    // "valueDate",
    "valueDateTime",
    // "valueDecimal",
    "valueId",
    "valueInstant",
    /*"valueInteger",
    "valueMarkdown",
    "valueOid",*/
    "valuePositiveInt",
    "valueString",
    // "valueTime",
    "valueUnsignedInt",
    "valueUri",
    /*"valueUrl",
    "valueUuid",
    "valueAddress",
    "valueAge",
    "valueAnnotation",
    "valueAttachment"*/
    "valueCodeableConcept",
    "valueCoding",
    /*"valueContactPoint",
    "valueCount",
    "valueDistance",
    "valueDuration",
    "valueHumanName",*/
    "valueIdentifier",
    "valueMoney",
    "valuePeriod",
    "valueQuantity",
    /*"valueRange",*/
    "valueRatio",
    "valueReference",
    /*"valueSampledData",
    "valueSignature",
    "valueTiming",
    "valueContactDetail",
    "valueContributor",
    "valueDataRequirement",
    "valueExpression",
    "valueParameterDefinition",
    "valueRelatedArtifact",
    "valueTriggerDefinition",
    "valueUsageContext",
    "valueDosage"*/
  },
  message = "Only one value type may be specified"
)
public class Extension implements Element {

  @Pattern(regexp = Fhir.ID)
  String id;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Valid List<Extension> extension;

  /*@Pattern(regexp = Fhir.BASE64)
  String valueBase64Binary;*/

  @Pattern(regexp = Fhir.BOOLEAN)
  String valueBoolean;

  /*@Pattern(regexp = Fhir.URI)
  String valueCanonical;*/

  @Pattern(regexp = Fhir.CODE)
  String valueCode;

  /*@Pattern(regexp = Fhir.DATE)
  String valueDate;*/

  @Pattern(regexp = Fhir.DATETIME)
  String valueDateTime;

  /*@Pattern(regexp = Fhir.DECIMAL)
  Double valueDecimal;*/

  @Pattern(regexp = Fhir.ID)
  String valueId;

  @Pattern(regexp = Fhir.INSTANT)
  String valueInstant;

  @Pattern(regexp = Fhir.INTEGER)
  Integer valueInteger;

  /*@Pattern(regexp = Fhir.MARKDOWN)
  String valueMarkdown;

  @Pattern(regexp = Fhir.OID)
  String valueOid;*/

  @Pattern(regexp = Fhir.POSITIVE_INT)
  String valuePositiveInt;

  @Pattern(regexp = Fhir.STRING)
  String valueString;

  /*@Pattern(regexp = Fhir.TIME)
  String valueTime;*/

  @Pattern(regexp = Fhir.UNSIGNED_INT)
  String valueUnsignedInt;

  @Pattern(regexp = Fhir.URI)
  String valueUri;

  /*@Pattern(regexp = Fhir.URI)
  String valueUrl;

  @Pattern(regexp = Fhir.URI)
  String valueUuid;

  @Valid Address valueAddress;

  @Valid Age valueAge;

  @Valid Annotation valueAnnotation;

  @Valid Attachment valueAttachment;*/

  @Valid CodeableConcept valueCodeableConcept;

  @Valid Coding valueCoding;

  /*@Valid ContactPoint valueContactPoint;

  @Valid Count valueCount;

  @Valid Distance valueDistance;

  @Valid Duration valueDuration;

  @Valid HumanName valueHumanName;*/

  @Valid Identifier valueIdentifier;

  @Valid Money valueMoney;

  @Valid Period valuePeriod;

  @Valid Quantity valueQuantity;

  /*@Valid Range valueRange;*/

  @Valid Ratio valueRatio;

  @Valid Reference valueReference;

  /*@Valid SampledData valueSampledData;*/

  @Valid Signature valueSignature;

  /*@Valid Timing valueTiming;

  @Valid ContactDetail valueContactDetail;

  @Valid Contributor valueContributor;

  @Valid DataRequirement valueDataRequirement;

  @Valid Expression valueExpression;

  @Valid ParameterDefinition valueParameterDefinition;

  @Valid RelatedArtifact valueRelatedArtifact;

  @Valid TriggerDefinition valueTriggerDefinition;

  @Valid UsageContext valueUsageContext;

  @Valid Dosage valueDosage;*/
}
