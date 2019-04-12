package gov.va.api.health.urgentcare.service.queenelizabeth.client;

import gov.va.api.health.ids.api.IdentityService;
import lombok.Builder;
import lombok.Value;

/**
 * Type safe model for searching Queen Elizabeth.
 *
 * <pre>
 *   Query.forType(GetEESummaryResponse.class)
 *     .id(1010101010V666666)
 *     .build();
 * </pre>
 */
@Value
@Builder(toBuilder = true)
public class Query<T> {

  String id;

  Class<T> type;

  /** Start a builder chain to query for a given type. */
  public static <R> QueryBuilder<R> forType(Class<R> forType) {
    return Query.<R>builder().type(forType);
  }

  String getIcnFromIdentityService(IdentityService identityService) {
    return IdentityParameterReplacer.builder()
        .identityService(identityService)
        .icn(id)
        .build()
        .lookupIcn();
  }

  /**
   * Returns a Queen Elizabeth formatted query string. Queen Elizabeth only gets a single query
   * parameter, an id. example: ?id=1010101010V666666
   */
  String toQueryString(IdentityService identityService) {
    StringBuilder queryString = new StringBuilder();
    queryString.append("?id=").append(getIcnFromIdentityService(identityService));
    return queryString.toString();
  }

  /** We won't do a lookup in the id service if its an exception. */
  String toQueryString() {
    StringBuilder queryString = new StringBuilder();
    queryString.append("?id=").append(id);
    return queryString.toString();
  }
}
