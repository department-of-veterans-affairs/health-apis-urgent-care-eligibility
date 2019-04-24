package gov.va.api.health.urgentcare.service.queenelizabeth.client;

import gov.va.api.health.ids.api.IdentityService;
import gov.va.api.health.ids.api.ResourceIdentity;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;

/**
 * Receives the id value given to Urgent Care and gets the corresponding ICN from Identity Service.
 * Urgent Care doesn't need to replace any other references using the Identity Service as Queen
 * Elizabeth doesn't return any references.
 */
public class IdentityParameterReplacer {

  private final IdentityService identityService;

  private final String icn;

  @Builder
  private IdentityParameterReplacer(IdentityService identityService, String icn) {
    this.identityService = identityService;
    this.icn = icn;
  }

  private Boolean isSystem(@NonNull ResourceIdentity resourceIdentity) {
    return "CDW".equals(resourceIdentity.system());
  }

  /** Lookup an ICN using the Identity Service. */
  public String lookupIcn() {
    List<ResourceIdentity> identities = identityService.lookup(icn);
    return identities
        .stream()
        .filter(this::isSystem)
        .map(ResourceIdentity::identifier)
        .findFirst()
        .orElse(icn);
  }
}
