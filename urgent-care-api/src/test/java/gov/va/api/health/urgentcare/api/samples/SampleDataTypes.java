package gov.va.api.health.urgentcare.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.HttpVerb;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.Request;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.Response;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.Search;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Identifier.IdentifierUse;
import gov.va.api.health.urgentcare.api.datatypes.Money;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.datatypes.Quantity;
import gov.va.api.health.urgentcare.api.datatypes.Ratio;
import gov.va.api.health.urgentcare.api.datatypes.Signature;
import gov.va.api.health.urgentcare.api.datatypes.SimpleQuantity;
import gov.va.api.health.urgentcare.api.datatypes.SimpleResource;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.elements.Meta;
import gov.va.api.health.urgentcare.api.elements.Narrative;
import gov.va.api.health.urgentcare.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.resources.OperationOutcome.Issue;
import gov.va.api.health.urgentcare.api.resources.OperationOutcome.Issue.IssueSeverity;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "get")
public class SampleDataTypes {

  /*public Address address() {
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
  }*/

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

  /*public ContactPoint contactPoint() {
    return ContactPoint.builder()
        .system(ContactPointSystem.other)
        .value("HelloValue")
        .use(ContactPointUse.home)
        .rank("1")
        .period(period())
        .build();
  }*/

  /*public Count count() {
    return Count.builder().value("19").unit("HelloUnit").system("Y").code("1").build();
  }

  public Duration duration() {
    return Duration.builder()
        .value("11.11")
        .unit("HelloUnit")
        .system("Y")
        .code("2000-01-01T00:00:00-00:00")
        .build();
  }*/

  public CodeableConcept details() {
    return CodeableConcept.builder().coding(singletonList(coding())).text("HelloText").build();
  }

  public Extension extension() {
    return Extension.builder().url("http://HelloUrl.com").valueCoding(coding()).build();
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

  /*public HumanName humanName() {
    return HumanName.builder()
        .use(NameUse.anonymous)
        .text("HelloText")
        .family("HelloFamily")
        .given(singletonList("HelloGiven"))
        .prefix(singletonList("HelloPrefix"))
        .suffix(singletonList("HelloSuffix"))
        .period(period())
        .build();
  }*/

  public Identifier identifier() {
    return Identifier.builder()
        .id("5678")
        .use(IdentifierUse.official)
        .use(Identifier.IdentifierUse.official)
        .extension(singletonList(extension()))
        .build();
  }

  public Issue issue() {
    return Issue.builder()
        .severity(IssueSeverity.error)
        .code("HelloCode")
        .details(details())
        .diagnostics("HelloDiagnostics")
        .location(singletonList("HelloLocation"))
        .expression(singletonList("HelloExpression"))
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

  /*public Range range() {
    return Range.builder().low(simpleQuantity()).high(simpleQuantity()).build();
  }

  public Ratio ratio() {
    return Ratio.builder().numerator(quantity()).denominator(quantity()).build();
  }*/

  public Reference reference() {
    return Reference.builder().reference("HelloReference").display("HelloDisplay").build();
  }

  public Request request() {
    return Request.builder()
        .id("request1")
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .method(HttpVerb.GET)
        .url("http://example.com")
        .ifNoneMatch("ok")
        .ifModifiedSince("also ok")
        .ifMatch("really ok")
        .ifNoneExist("meh, ok.")
        .build();
  }

  public SimpleResource resource() {
    return SimpleResource.builder()
        .id("1111")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .build();
  }

  public Response response() {
    return Response.builder()
        .id("response1")
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .status("single")
        .location("http://example.com")
        .etag("you're it")
        .lastModified("2005-01-21T07:57:00Z")
        .build();
  }

  /*public SampledData sampledData() {
    return SampledData.builder()
        .origin(simpleQuantity())
        .period("11.11")
        .factor("11.11")
        .lowerLimit("11.11")
        .upperLimit("11.11")
        .dimensions("1")
        .data("HelloText")
        .build();
  }*/

  public Search search() {
    return Search.builder()
        .id("search1")
        .mode(SearchMode.match)
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .score("0.5")
        .build();
  }

  public Signature signature() {
    return Signature.builder()
        .type(singletonList(coding()))
        .when("now")
        .who(reference())
        .onBehalfOf(reference())
        .targetFormat("YO")
        .sigFormat("YO")
        .data("00000")
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
