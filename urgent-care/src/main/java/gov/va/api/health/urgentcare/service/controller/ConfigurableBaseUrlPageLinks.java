package gov.va.api.health.urgentcare.service.controller;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/** This implementation uses a configurable base URL (urgent-care.url) for the links. */
@Service
public class ConfigurableBaseUrlPageLinks implements PageLinks {
  /**
   * The published URL for urgent care, which is likely not the hostname of the machine running this
   * application.
   */
  private final String baseUrl;

  /** These base path for resources, e.g. api */
  private String basePath;

  @Autowired
  public ConfigurableBaseUrlPageLinks(
      @Value("${urgent-care.url}") String baseUrl,
      @Value("${urgent-care.base-path}") String basePath) {
    this.baseUrl = baseUrl;
    this.basePath = basePath;
  }

  @Override
  public List<BundleLink> create(LinkConfig config) {
    LinkContext context = new LinkContext(config);
    List<BundleLink> links = new ArrayList<>();
    links.add(context.first());
    links.add(context.self());
    links.add(context.last());
    return links;
  }

  /** This context wraps the link state to allow link creation to be clearly described. */
  @RequiredArgsConstructor
  private class LinkContext {
    // There is only ever one page returned and therefore the first and last page will always be 1.
    private static final int pageFirstLast = 1;

    private final LinkConfig config;

    BundleLink first() {
      return BundleLink.builder().relation(LinkRelation.first).url(toUrl(pageFirstLast)).build();
    }

    BundleLink last() {
      return BundleLink.builder().relation(LinkRelation.last).url(toUrl(pageFirstLast)).build();
    }

    BundleLink self() {
      return BundleLink.builder().relation(LinkRelation.self).url(toUrl(config.page())).build();
    }

    private Stream<String> toKeyValueString(Map.Entry<String, List<String>> entry) {
      return entry.getValue().stream().map((value) -> entry.getKey() + '=' + value);
    }

    private String toUrl(int page) {
      MultiValueMap<String, String> mutableParams = new LinkedMultiValueMap<>(config.queryParams());
      mutableParams.remove("page");
      mutableParams.remove("_count");
      StringBuilder msg = new StringBuilder(baseUrl).append('/').append(basePath).append('/');
      msg.append(config.path()).append("?");
      String params =
          mutableParams.entrySet().stream()
              .sorted(Comparator.comparing(Map.Entry::getKey))
              .flatMap(this::toKeyValueString)
              .collect(Collectors.joining("&"));
      if (!params.isEmpty()) {
        msg.append(params).append("&");
      }
      msg.append("page=")
          .append(page)
          .append("&_count=")
          .append(config.queryParams().getFirst("_count"));
      return msg.toString();
    }
  }
}
