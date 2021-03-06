package gov.va.api.health.urgentcare.service.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.resources.Resource;
import gov.va.api.health.urgentcare.service.controller.Bundler.BundleContext;
import gov.va.api.health.urgentcare.service.controller.PageLinks.LinkConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@SuppressWarnings("WeakerAccess")
public class BundlerTest {
  private static final Function<FugaziCdwRoot, FugaziUrgentCare> FUGAZIMUS_PRIME =
      x -> FugaziUrgentCare.of(x.id());

  @Mock PageLinks links;
  Bundler bundler;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
    bundler = new Bundler(links);
  }

  @Test
  public void bundlerBuildsGenericTypeBundle() {
    List<BundleLink> bundleLinks =
        Collections.singletonList(
            BundleLink.builder().relation(LinkRelation.self).url("http://whatever.com").build());
    when(this.links.create(Mockito.any())).thenReturn(bundleLinks);

    LinkConfig linkConfig = LinkConfig.builder().path("api/Fugazi").build();

    List<FugaziCdwRoot> xmlItems =
        Arrays.asList(FugaziCdwRoot.of(1), FugaziCdwRoot.of(2), FugaziCdwRoot.of(3));

    FugaziBundle expected = new FugaziBundle();
    expected.resourceType("Bundle");
    expected.type(BundleType.searchset);
    expected.total(1);
    expected.link(bundleLinks);
    expected.entry(
        Arrays.asList(
            FugaziEntry.of(FugaziUrgentCare.of(1)),
            FugaziEntry.of(FugaziUrgentCare.of(2)),
            FugaziEntry.of(FugaziUrgentCare.of(3))));

    Object actual =
        bundler.bundle(
            BundleContext.of(
                linkConfig, xmlItems, FUGAZIMUS_PRIME, FugaziEntry::new, FugaziBundle::new));

    assertThat(actual).isEqualTo(expected);
  }

  @Value
  @Builder
  private static class FugaziUrgentCare implements Resource {
    String id;
    Meta meta;
    String implicitRules;
    String language;

    private static FugaziUrgentCare of(int id) {
      return FugaziUrgentCare.builder().id("a" + id).build();
    }
  }

  private static class FugaziBundle extends AbstractBundle<FugaziEntry> {}

  @AllArgsConstructor(staticName = "of")
  @Getter
  private static class FugaziCdwRoot {
    int id;
  }

  private static class FugaziEntry extends AbstractEntry<FugaziUrgentCare> {
    private static FugaziEntry of(FugaziUrgentCare a) {
      FugaziEntry entry = new FugaziEntry();
      entry.resource(a);
      entry.search(Search.builder().mode(SearchMode.match).build());
      return entry;
    }
  }
}
