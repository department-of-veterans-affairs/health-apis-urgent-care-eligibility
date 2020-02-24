package gov.va.api.health.urgentcare.service.controller;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ConfigurableBaseUrlPageLinksTest {
  private ConfigurableBaseUrlPageLinks links;

  @Before
  public void _init() {
    links = new ConfigurableBaseUrlPageLinks("https://awesome.com", "api");
  }

  @Test
  public void allLinksPresent() {
    LinkConfig linkConfig = linkConfig();
    List<BundleLink> actual = links.create(linkConfig);
    assertThat(actual)
        .containsExactlyInAnyOrder(
            link(LinkRelation.first), link(LinkRelation.self), link(LinkRelation.last));
  }

  private BundleLink link(LinkRelation relation) {
    return BundleLink.builder()
        .relation(relation)
        .url("https://awesome.com/api/Whatever?patient=1234&page=1&_count=15")
        .build();
  }

  private LinkConfig linkConfig() {
    return LinkConfig.builder()
        .path("Whatever")
        .queryParams(
            Parameters.builder()
                .add("patient", "1234")
                .add("page", String.valueOf(1))
                .add("_count", String.valueOf(15))
                .build())
        .page(1)
        .recordsPerPage(15)
        .totalRecords(1)
        .build();
  }
}
