package gov.va.api.health.urgentcare.service.queenelizabeth.client;

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

  /** We won't do a lookup in the id service if its an exception. */
  String toQueryString() {
    StringBuilder queryString = new StringBuilder();
    queryString.append("?id=").append(id);
    return queryString.toString();
  }
}
