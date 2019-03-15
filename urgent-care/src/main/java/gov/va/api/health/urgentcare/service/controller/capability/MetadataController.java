package gov.va.api.health.urgentcare.service.controller.capability;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.ContactDetail;
import gov.va.api.health.urgentcare.api.datatypes.ContactPoint;
import gov.va.api.health.urgentcare.api.datatypes.ContactPoint.ContactPointSystem;
import gov.va.api.health.urgentcare.api.elements.Extension;
import gov.va.api.health.urgentcare.api.resources.Capability;
import gov.va.api.health.urgentcare.api.resources.Capability.CapabilityResource;
import gov.va.api.health.urgentcare.api.resources.Capability.Kind;
import gov.va.api.health.urgentcare.api.resources.Capability.ResourceInteraction;
import gov.va.api.health.urgentcare.api.resources.Capability.Rest;
import gov.va.api.health.urgentcare.api.resources.Capability.RestMode;
import gov.va.api.health.urgentcare.api.resources.Capability.SearchParamType;
import gov.va.api.health.urgentcare.api.resources.Capability.Security;
import gov.va.api.health.urgentcare.api.resources.Capability.Software;
import gov.va.api.health.urgentcare.api.resources.Capability.TypeRestfulInteraction;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
  value = {"/api/metadata"},
  produces = {"application/json", "application/json+fhir", "application/fhir+json"}
)
@AllArgsConstructor(onConstructor = @__({@Autowired}))
class MetadataController {

  private static final String COVERAGE_HTML = "https://www.hl7.org/fhir/R4/coverage.html";

  private final CapabilityStatementProperties properties;

  private List<ContactDetail> contact() {
    return singletonList(
        ContactDetail.builder()
            .name(properties.getContact().getName())
            .telecom(
                singletonList(
                    ContactPoint.builder()
                        .system(ContactPointSystem.email)
                        .value(properties.getContact().getEmail())
                        .build()))
            .build());
  }

  @GetMapping
  Capability read() {
    return Capability.builder()
        .resourceType("Capability")
        .id(properties.getId())
        .version(properties.getVersion())
        .status(properties.getStatus())
        .name(properties.getName())
        .publisher(properties.getPublisher())
        .contact(contact())
        .date(properties.getDate())
        .description(properties.getDescription())
        .kind(Kind.capability)
        .software(software())
        .fhirVersion(properties.getFhirVersion())
        .format(asList("application/json+fhir", "application/json", "application/fhir+json"))
        .rest(rest())
        .build();
  }

  private List<CapabilityResource> resources() {
    return Stream.of(
            support("Coverage").documentation(COVERAGE_HTML).searchBy(SearchParam.PATIENT).build())
        .map(SupportedResource::asResource)
        .collect(Collectors.toList());
  }

  private List<Rest> rest() {
    return singletonList(
        Rest.builder()
            .mode(RestMode.server)
            .security(restSecurity())
            .resource(resources())
            .build());
  }

  private Security restSecurity() {
    return Security.builder()
        .extension(
            singletonList(
                Extension.builder()
                    .url("http://fhir-registry.smarthealthit.org/StructureDefinition/oauth-uris")
                    .extension(
                        asList(
                            Extension.builder()
                                .url("token")
                                .valueUri(properties.getSecurity().getTokenEndpoint())
                                .build(),
                            Extension.builder()
                                .url("authorize")
                                .valueUri(properties.getSecurity().getAuthorizeEndpoint())
                                .build()))
                    .build()))
        .cors("true")
        .service(singletonList(smartOnFhirCodeableConcept()))
        .description(properties.getSecurity().getDescription())
        .build();
  }

  private CodeableConcept smartOnFhirCodeableConcept() {
    return CodeableConcept.builder()
        .coding(
            singletonList(
                Coding.builder()
                    .system("https://www.hl7.org/fhir/valueset-restful-security-service.html")
                    .code("SMART-on-FHIR")
                    .display("SMART-on-FHIR")
                    .build()))
        .build();
  }

  private Software software() {
    return Software.builder().name(properties.getSoftwareName()).build();
  }

  private SupportedResource.SupportedResourceBuilder support(String type) {
    return SupportedResource.builder().properties(properties).type(type);
  }

  @Getter
  @AllArgsConstructor
  enum SearchParam {
    PATIENT("patient", SearchParamType.reference);

    private final String param;

    private final SearchParamType type;
  }

  @Value
  @Builder
  private static class SupportedResource {

    String type;

    String documentation;

    @Singular("searchBy")
    Set<SearchParam> search;

    CapabilityStatementProperties properties;

    CapabilityResource asResource() {
      return CapabilityResource.builder()
          .type(type)
          .interaction(interactions())
          .searchParam(searchParams())
          .profile(documentation)
          .build();
    }

    private List<ResourceInteraction> interactions() {
      return asList(searchable(), readable());
    }

    private ResourceInteraction readable() {
      return ResourceInteraction.builder()
          .code(TypeRestfulInteraction.read)
          .documentation(properties.getResourceDocumentation())
          .build();
    }

    private List<Capability.SearchParam> searchParams() {
      return search
          .stream()
          .map(s -> Capability.SearchParam.builder().name(s.param()).type(s.type()).build())
          .collect(Collectors.toList());
    }

    private ResourceInteraction searchable() {
      return ResourceInteraction.builder()
          .code(TypeRestfulInteraction.search_type)
          .documentation(properties.getResourceDocumentation())
          .build();
    }
  }
}
