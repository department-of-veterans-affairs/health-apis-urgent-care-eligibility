package gov.va.api.health.urgentcare.service.controller;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

/** Utility methods for transforming CDW results to Argonaut. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Transformers {
  /** Throw a MissingPayload exception if the value is null. */
  public static <T> T hasPayload(T value) {
    if (value == null) {
      throw new MissingPayload();
    }
    return value;
  }

  /**
   * Indicates the CDW payload is missing, but no errors were reported. This exception indicates
   * there is a bug in CDW, Mr. Anderson, or the Mr. Anderson client.
   */
  static class MissingPayload extends TransformationException {
    MissingPayload() {
      super(
          "Payload is missing, but no errors reported by Mr. Anderson."
              + " This can occur when the resource is registered with the identity service"
              + " but the database returns an empty search result.");
    }
  }

  /** Base exception for controller errors. */
  static class TransformationException extends RuntimeException {
    @SuppressWarnings("SameParameterValue")
    TransformationException(String message) {
      super(message);
    }
  }
}
