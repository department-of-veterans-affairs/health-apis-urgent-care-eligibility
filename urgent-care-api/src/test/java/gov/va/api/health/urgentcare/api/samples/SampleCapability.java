package gov.va.api.health.urgentcare.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.resources.Capability;
import gov.va.api.health.urgentcare.api.resources.Capability.CapabilityResource;
import gov.va.api.health.urgentcare.api.resources.Capability.ConditionalDelete;
import gov.va.api.health.urgentcare.api.resources.Capability.ConditionalRead;
import gov.va.api.health.urgentcare.api.resources.Capability.Document;
import gov.va.api.health.urgentcare.api.resources.Capability.DocumentMode;
import gov.va.api.health.urgentcare.api.resources.Capability.Implementation;
import gov.va.api.health.urgentcare.api.resources.Capability.Kind;
import gov.va.api.health.urgentcare.api.resources.Capability.Messaging;
import gov.va.api.health.urgentcare.api.resources.Capability.MessagingEndpoint;
import gov.va.api.health.urgentcare.api.resources.Capability.Operation;
import gov.va.api.health.urgentcare.api.resources.Capability.ReferencePolicy;
import gov.va.api.health.urgentcare.api.resources.Capability.ResourceInteraction;
import gov.va.api.health.urgentcare.api.resources.Capability.Rest;
import gov.va.api.health.urgentcare.api.resources.Capability.RestInteraction;
import gov.va.api.health.urgentcare.api.resources.Capability.RestMode;
import gov.va.api.health.urgentcare.api.resources.Capability.SearchParam;
import gov.va.api.health.urgentcare.api.resources.Capability.SearchParamType;
import gov.va.api.health.urgentcare.api.resources.Capability.Security;
import gov.va.api.health.urgentcare.api.resources.Capability.Software;
import gov.va.api.health.urgentcare.api.resources.Capability.Status;
import gov.va.api.health.urgentcare.api.resources.Capability.SupportedMessage;
import gov.va.api.health.urgentcare.api.resources.Capability.SupportedMessageMode;
import gov.va.api.health.urgentcare.api.resources.Capability.SystemRestfulInteraction;
import gov.va.api.health.urgentcare.api.resources.Capability.TypeRestfulInteraction;
import gov.va.api.health.urgentcare.api.resources.Capability.Versioning;
import java.util.Collections;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCapability {

  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Capability capability() {
    return Capability.builder()
        .id("c1")
        .resourceType("Conformance")
        .implicitRules("https://example.com")
        .language("en")
        .text(narrative())
        .contained(singletonList(resource()))
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .url("http://example.com")
        .version("1")
        .name("conformin' norman")
        .title("urgent care capability")
        .status(Status.active)
        .experimental("true")
        .date("2000-01-01T00:00:00-00:00")
        .publisher("random house")
        .contact(singletonList(contactDetail()))
        .description("words words")
        .useContext(singletonList(usageContext()))
        .jurisdiction(singletonList(codeableConcept()))
        .purpose("words words")
        .copyright("Alphonso, Lord of the Mangos")
        .kind(Kind.capability)
        .instantiates(singletonList("http://example.com"))
        .imports(singletonList("http://example.com"))
        .software(software())
        .implementation(implementation())
        .fhirVersion("R4")
        .format(singletonList("R4"))
        .patchFormat(singletonList("R4"))
        .rest(singletonList(rest()))
        .messaging(singletonList(messaging()))
        .document(singletonList(document()))
        .build();
  }

  public CapabilityResource capabilityResource() {
    return CapabilityResource.builder()
        .type("CODE")
        .profile("http://example.com")
        .supportedProfile(singletonList("http://example.com"))
        .documentation("words words")
        .interaction(singletonList(resourceInteraction()))
        .versioning(Versioning.no_version)
        .readHistory("true")
        .updateCreate("false")
        .conditionalCreate("true")
        .conditionalRead(ConditionalRead.not_supported)
        .conditionalUpdate("false")
        .conditionalDelete(ConditionalDelete.not_supported)
        .referencePolicy(singletonList(ReferencePolicy.enforced))
        .searchInclude(singletonList("indlude dem"))
        .searchRevInclude(singletonList("include dem too"))
        .searchParam(singletonList(searchParam()))
        .operation(singletonList(operation()))
        .build();
  }

  public Document document() {
    return Document.builder()
        .mode(DocumentMode.consumer)
        .documentation("words words")
        .profile("http://example.com")
        .build();
  }

  public MessagingEndpoint endpoint() {
    return MessagingEndpoint.builder()
        .protocol(coding())
        .address("")
        .build();
  }

  public Implementation implementation() {
    return Implementation.builder()
        .description("words words")
        .url("http://example.com")
        .custodian(reference())
        .build();
  }

  public Messaging messaging() {
    return Messaging.builder()
        .endpoint(singletonList(endpoint()))
        .reliableCache("0")
        .documentation("words words")
        .supportedMessage(singletonList(supportedMessage()))
        .build();
  }

  public Operation operation() {
    return Operation.builder()
        .name("Jimmy")
        .definition("http://example.com")
        .documentation("words words")
        .build();
  }

  public ResourceInteraction resourceInteraction() {
    return ResourceInteraction.builder()
        .code(TypeRestfulInteraction.patch)
        .documentation("words words")
        .build();
  }

  public Rest rest() {
    return Rest.builder()
        .mode(RestMode.client)
        .documentation("words words")
        .security(security())
        .resource(capabilityResource())
        .interaction(singletonList(restInteraction()))
        .searchParam(searchParam())
        .operation(operation())
        .compartment("words words")
        .build();
  }

  public RestInteraction restInteraction() {
    return RestInteraction.builder()
        .code(SystemRestfulInteraction.batch)
        .documentation("words words")
        .build();
  }

  public SearchParam searchParam() {
    return SearchParam.builder()
        .name("Jimmy")
        .definition("http://example.com")
        .type(SearchParamType.composite)
        .documentation("words words")
        .build();
  }

  public Security security() {
    return Security.builder()
        .cors("true")
        .service(singletonList(codeableConcept()))
        .description("words words")
        .build();
  }

  public Software software() {
    return Software.builder()
        .name("Jimmy")
        .version("1")
        .releaseDate("2000-01-01T00:00:00-00:00")
        .build();
  }

  public SupportedMessage supportedMessage() {
    return SupportedMessage.builder()
        .mode(SupportedMessageMode.receiver)
        .definition("http://example.com")
        .build();
  }
}
