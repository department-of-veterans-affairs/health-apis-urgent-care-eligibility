package gov.va.api.health.urgentcare.service.controller;

import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * This provides paging links for bundles. It will create links for first, self, and last always. It
 * will conditionally create previous and next links.
 */
public interface PageLinks {
  /** Create a list of parameters that will contain 3 to 5 values. */
  List<BundleLink> create(LinkConfig config);

  @Data
  @Builder
  class LinkConfig {
    /** The resource path without the base URL or port. */
    private final String path;

    private final String icn;
  }
}
