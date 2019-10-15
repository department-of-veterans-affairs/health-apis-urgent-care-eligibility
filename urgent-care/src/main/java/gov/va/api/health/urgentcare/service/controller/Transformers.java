package gov.va.api.health.urgentcare.service.controller;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/** Utility methods for transforming EE results to R4. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Transformers {

  /**
   * Return false if at least one value in the given list is a non-blank string, or a non-null
   * object.
   */
  public static boolean allBlank(Object... values) {
    for (Object v : values) {
      if (!isBlank(v)) {
        return false;
      }
    }
    return true;
  }

  /** Return null if the date is null, otherwise return an ISO-8601 date time. */
  public static String asDateTimeString(XMLGregorianCalendar maybeDateTime) {
    if (maybeDateTime == null) {
      return null;
    }
    return maybeDateTime.toString();
  }

  /**
   * Return null if the source list is null or empty, otherwise convert the items in the list and
   * return a new one.
   */
  public static <T, R> List<R> convertAll(List<T> source, Function<T, R> mapper) {
    if (source == null || source.isEmpty()) {
      return null;
    }
    List<R> probablyItems =
        source.stream().map(mapper).filter(Objects::nonNull).collect(Collectors.toList());
    return probablyItems.isEmpty() ? null : probablyItems;
  }

  /**
   * Return the result of the given extractor function if the given object is present. The object
   * will be passed to the apply method of the extractor function.
   *
   * <p>Consider this example:
   *
   * <pre>
   * ifPresent(patient.getGender(), gender -> Patient.Gender.valueOf(gender.value()))
   * </pre>
   *
   * This is equivalent to this standard Java code.
   *
   * <pre>
   * Gender gender = patient.getGender();
   * if (gender == null) {
   *   return null;
   * } else {
   *   return Patient.Gender.valueOf(gender.value());
   * }
   * </pre>
   */
  public static <T, R> R ifPresent(T object, Function<T, R> extract) {
    if (object == null) {
      return null;
    }
    return extract.apply(object);
  }

  /** Return true if the value is a blank string, or any other object that is null. */
  public static boolean isBlank(Object value) {
    if (value instanceof CharSequence) {
      return StringUtils.isBlank((CharSequence) value);
    }
    return value == null;
  }
}
