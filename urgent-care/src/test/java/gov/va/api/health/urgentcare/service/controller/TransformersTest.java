package gov.va.api.health.urgentcare.service.controller;

import static gov.va.api.health.urgentcare.service.controller.Transformers.asDateTimeString;
import static gov.va.api.health.urgentcare.service.controller.Transformers.convertAll;
import static gov.va.api.health.urgentcare.service.controller.Transformers.ifPresent;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.SneakyThrows;
import org.junit.Test;

public class TransformersTest {
  @Test
  public void allBlank() {
    assertThat(Transformers.allBlank()).isTrue();
    assertThat(Transformers.allBlank(null, null, null, null)).isTrue();
    assertThat(Transformers.allBlank(null, "", " ")).isTrue();
    assertThat(Transformers.allBlank(null, 1, null, null)).isFalse();
    assertThat(Transformers.allBlank(1, "x", "z", 2.0)).isFalse();
  }

  @Test
  public void asDateTimeStringReturnsNullWhenCalendarIsNull() {
    assertThat(asDateTimeString(null)).isNull();
  }

  @SneakyThrows
  @Test
  public void asDateTimeStringReturnsStringWhenCalendarIsNotNull() {
    XMLGregorianCalendar time =
        DatatypeFactory.newInstance().newXMLGregorianCalendar(2005, 1, 21, 7, 57, 0, 0, 0);
    assertThat(asDateTimeString(time)).isEqualTo("2005-01-21T07:57:00.000Z");
  }

  @Test
  public void convertAllReturnsConvertedWhenListIsPopulated() {
    assertThat(convertAll(Arrays.asList(1, 2, 3), o -> "x" + o))
        .isEqualTo(Arrays.asList("x1", "x2", "x3"));
  }

  @Test
  public void convertAllReturnsNullWhenListConvertsToToNull() {
    assertThat(convertAll(Arrays.asList(1, 2, 3), o -> null)).isNull();
  }

  @Test
  public void convertAllReturnsNullWhenListIsEmpty() {
    assertThat(convertAll(Collections.emptyList(), o -> "x" + o)).isNull();
  }

  @Test
  public void convertAllReturnsNullWhenListIsNull() {
    assertThat(convertAll(null, o -> "x" + o)).isNull();
  }

  @Test
  public void ifPresentReturnsExtractWhenObjectIsNull() {
    Function<Object, String> extract = (o) -> "x" + o;
    assertThat(ifPresent("a", extract)).isEqualTo("xa");
  }

  @Test
  public void ifPresentReturnsNullWhenObjectIsNull() {
    Function<Object, String> extract = (o) -> "x" + o;
    assertThat(ifPresent(null, extract)).isNull();
  }
}
