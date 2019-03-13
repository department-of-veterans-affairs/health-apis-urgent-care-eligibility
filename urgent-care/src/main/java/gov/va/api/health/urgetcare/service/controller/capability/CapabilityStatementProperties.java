package gov.va.api.health.urgetcare.service.controller.capability;

import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("DefaultAnnotationParam")
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("conformance")
@Data
@Accessors(fluent = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapabilityStatementProperties {
  private String id;
  private String version;
  private String name;
  private Status status;
  private String experimental;
  private String date;
  private String publisher;
  private String description;
  private String fhirVersion;
  private String softwareName;
  private String resourceDocumentation;
  private ContactProperties contact;

  @Data
  @Accessors(fluent = false)
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class ContactProperties {
    private String name;
    private String email;
  }
}
