package gov.va.api.health.urgentcare.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.datatypes.Address;
import gov.va.api.health.urgentcare.api.datatypes.Address.AddressType;
import gov.va.api.health.urgentcare.api.datatypes.Address.AddressUse;
import gov.va.api.health.urgentcare.api.datatypes.Age;
import gov.va.api.health.urgentcare.api.datatypes.Attachment;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.ContactPoint;
import gov.va.api.health.urgentcare.api.datatypes.ContactPoint.ContactPointSystem;
import gov.va.api.health.urgentcare.api.datatypes.ContactPoint.ContactPointUse;
import gov.va.api.health.urgentcare.api.datatypes.Count;
import gov.va.api.health.urgentcare.api.datatypes.Duration;
import gov.va.api.health.urgentcare.api.datatypes.HumanName;
import gov.va.api.health.urgentcare.api.datatypes.HumanName.NameUse;
import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Identifier.IdentifierUse;
import gov.va.api.health.urgentcare.api.datatypes.Money;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.datatypes.Quantity;
import gov.va.api.health.urgentcare.api.datatypes.Range;
import gov.va.api.health.urgentcare.api.datatypes.Ratio;
import gov.va.api.health.urgentcare.api.datatypes.SampledData;
import gov.va.api.health.urgentcare.api.datatypes.SimpleQuantity;
import gov.va.api.health.urgentcare.api.datatypes.SimpleResource;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.elements.Meta;
import gov.va.api.health.urgentcare.api.elements.Narrative;
import gov.va.api.health.urgentcare.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.urgentcare.api.elements.Reference;
import java.util.Arrays;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "get")
public class SampleDataTypes {

  public Address address() {
    return Address.builder()
        .id("1234")
        .extension(singletonList(extension()))
        .use(AddressUse.home)
        .type(AddressType.both)
        .text("Hello")
        .line(Arrays.asList("hello", "goodbye"))
        .city("Hello City")
        .district("Hello District")
        .state("Hello State")
        .postalCode("12345")
        .country("Hello Country")
        .period(period())
        .build();
  }

  public Age age() {
    return Age.builder()
        .value("19")
        .unit("HelloUnit")
        .system("Y")
        .code("2000-01-01T00:00:00-00:00")
        .build();
  }

  public Attachment attachment() {
    return Attachment.builder()
        .contentType("HelloType")
        .language("HelloLanguage")
        .data("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .url("http://HelloUrl.com")
        .size("1")
        .hash("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .title("HelloTitle")
        .creation("2000-01-01T00:00:00-00:00")
        .build();
  }

  public CodeableConcept codeableConcept() {
    return CodeableConcept.builder().coding(singletonList(coding())).text("code text test").build();
  }

  public Coding coding() {
    return Coding.builder()
        .system("http://HelloSystem.com")
        .version("Hello Version")
        .code("Hello Code")
        .display("Hello Display")
        .userSelected("true")
        .build();
  }

  public ContactPoint contactPoint() {
    return ContactPoint.builder()
        .system(ContactPointSystem.other)
        .value("HelloValue")
        .use(ContactPointUse.home)
        .rank("1")
        .period(period())
        .build();
  }

  public Count count() {
    return Count.builder().value("19").unit("HelloUnit").system("Y").code("1").build();
  }

  public Duration duration() {
    return Duration.builder()
        .value("11.11")
        .unit("HelloUnit")
        .system("Y")
        .code("2000-01-01T00:00:00-00:00")
        .build();
  }

  public Extension extension() {
    return Extension.builder().url("http://HelloUrl.com").valueInteger(1).build();
  }

  public Extension extensionWithQuantity() {
    return Extension.builder()
        .url("http://HelloUrl.com")
        .valueQuantity(
            Quantity.builder()
                .code("Q")
                .comparator(">=")
                .id("Q1")
                .unit("things")
                .system("http://example.com")
                .value("1.0")
                .build())
        .build();
  }

  public Extension extensionWithRatio() {
    return Extension.builder()
        .url("http://HelloUrl.com")
        .valueRatio(
            Ratio.builder()
                .id("R1")
                .denominator(Quantity.builder().value("1.0").build())
                .numerator(Quantity.builder().value("2.0").build())
                .build())
        .build();
  }

  public HumanName humanName() {
    return HumanName.builder()
        .use(NameUse.anonymous)
        .text("HelloText")
        .family("HelloFamily")
        .given(singletonList("HelloGiven"))
        .prefix(singletonList("HelloPrefix"))
        .suffix(singletonList("HelloSuffix"))
        .period(period())
        .build();
  }

  public Identifier identifier() {
    return Identifier.builder()
        .id("5678")
        .use(IdentifierUse.official)
        .use(Identifier.IdentifierUse.official)
        .extension(singletonList(extension()))
        .build();
  }

  public Meta meta() {
    return Meta.builder()
        .versionId("1111")
        .lastUpdated("2000-01-01T00:00:00-00:00")
        .profile(singletonList("http://HelloProfile.com"))
        .security(singletonList(coding()))
        .tag(singletonList(coding()))
        .build();
  }

  public Money money() {
    return Money.builder().value("11.11").currency("USD").build();
  }

  public Narrative narrative() {
    return Narrative.builder().status(NarrativeStatus.additional).div("<p>HelloDiv<p>").build();
  }

  public Period period() {
    return Period.builder()
        .id("5678")
        .extension(
            singletonList(Extension.builder().url("http://example.com").valueInteger(1).build()))
        .start("2000-01-01T00:00:00-00:00")
        .end("2001-01-01T00:00:00-00:00")
        .build();
  }

  public Quantity quantity() {
    return Quantity.builder().value("11.11").unit("HelloUnit").build();
  }

  public Range range() {
    return Range.builder().low(simpleQuantity()).high(simpleQuantity()).build();
  }

  public Ratio ratio() {
    return Ratio.builder().numerator(quantity()).denominator(quantity()).build();
  }

  public Reference reference() {
    return Reference.builder().reference("HelloReference").display("HelloDisplay").build();
  }

  public SimpleResource resource() {
    return SimpleResource.builder()
        .id("1111")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .build();
  }

  public SampledData sampledData() {
    return SampledData.builder()
        .origin(simpleQuantity())
        .period("11.11")
        .factor("11.11")
        .lowerLimit("11.11")
        .upperLimit("11.11")
        .dimensions("1")
        .data("HelloText")
        .build();
  }

  public SimpleQuantity simpleQuantity() {
    return SimpleQuantity.builder()
        .value("11.11")
        .unit("HelloUnit")
        .system("http://example.com")
        .build();
  }
}
