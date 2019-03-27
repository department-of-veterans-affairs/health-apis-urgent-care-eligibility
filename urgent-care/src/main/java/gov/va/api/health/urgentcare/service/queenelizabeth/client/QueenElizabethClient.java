package gov.va.api.health.urgentcare.service.queenelizabeth.client;

public interface QueenElizabethClient {
  /** Returns a deserialized result of the QueenElizabeth EE search. */
  <T> T search(Query<T> query);

  /** Generic Queen Elizabeth exception. */
  class QueenElizabethServiceException extends RuntimeException {
    QueenElizabethServiceException(Query<?> query) {
      super(query.toQueryString());
    }
  }

  /** Request Malformed. example: Missing required id parameter. */
  class BadRequest extends QueenElizabethServiceException {
    public BadRequest(Query<?> query) {
      super(query);
    }
  }

  /** Not found by Queen Elizabeth in EE. */
  class NotFound extends QueenElizabethServiceException {
    public NotFound(Query<?> query) {
      super(query);
    }
  }

  /** Bad Things happened when performing the search. */
  class SearchFailed extends QueenElizabethServiceException {
    public SearchFailed(Query<?> query) {
      super(query);
    }
  }
}
