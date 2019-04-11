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
    List<BundleLink> actual = links.create(linkConfig());
    assertThat(actual)
        .containsExactlyInAnyOrder(
            link(LinkRelation.first), link(LinkRelation.self), link(LinkRelation.last));
  }

  private BundleLink link(LinkRelation relation) {
    return BundleLink.builder()
        .relation(relation)
        .url("https://awesome.com/api/Whatever?patient=1234")
        .build();
  }

  private LinkConfig linkConfig() {
    return LinkConfig.builder().path("Whatever").icn("1234").build();
  }
}
