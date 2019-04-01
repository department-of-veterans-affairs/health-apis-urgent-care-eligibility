package gov.va.api.health.urgentcare.service.controller;

import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import gov.va.api.health.urgentcare.api.bundle.BundleLink.LinkRelation;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    List<BundleLink> links = new LinkedList<>();
    links.add(context.first());
    links.add(context.self());
    links.add(context.last());
    return links;
  }

  /** This context wraps the link state to allow link creation to be clearly described. */
  @RequiredArgsConstructor
  private class LinkContext {
    private final LinkConfig config;

    BundleLink first() {
      return BundleLink.builder().relation(LinkRelation.first).url(toUrl()).build();
    }

    BundleLink last() {
      return BundleLink.builder().relation(LinkRelation.last).url(toUrl()).build();
    }

    BundleLink self() {
      return BundleLink.builder().relation(LinkRelation.self).url(toUrl()).build();
    }

    private String toUrl() {
      StringBuilder msg = new StringBuilder(baseUrl).append('/').append(basePath).append('/');
      msg.append(config.path()).append("?patient=").append(config.icn());
      return msg.toString();
    }
  }
}
