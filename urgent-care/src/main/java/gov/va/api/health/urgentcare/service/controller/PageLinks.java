package gov.va.api.health.urgentcare.service.controller;

import gov.va.api.health.r4.api.bundle.BundleLink;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * This provides paging links for bundles. It will create links for first, self, and last always.
 * Will not create next and previous links because they will always be the same as first and last.
 */
public interface PageLinks {
  /** Create with ICN parameter. */
  List<BundleLink> create(LinkConfig config);

  @Data
  @Builder
  class LinkConfig {
    /** The resource path without the base URL or port. */
    private final String path;

    private final String icn;
  }
}
