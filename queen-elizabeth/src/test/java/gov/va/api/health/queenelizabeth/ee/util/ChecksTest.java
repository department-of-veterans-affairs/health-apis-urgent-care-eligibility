package gov.va.api.health.queenelizabeth.ee.util;

import gov.va.api.health.queenelizabeth.util.Checks;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChecksTest {

  @Test
  public void argumentMatchesReturnsMatchingValue() {
    assertThat(Checks.argumentMatches("yes", "yes")).isEqualTo("yes");
  }

  @Test(expected = IllegalArgumentException.class)
  public void argumentMatchesThrowsExceptionForNoMatch() {
    Checks.argumentMatches("no", "yes");
  }

  @Test(expected = IllegalArgumentException.class)
  public void argumentMatchesThrowsExceptionForNullValue() {
    Checks.argumentMatches(null, ".*");
  }

  @SuppressWarnings("ObviousNullCheck")
  @Test
  public void notNullReturnsNonNullValue() {
    assertThat(Checks.notNull("something")).isEqualTo("something");
  }

  @Test(expected = IllegalStateException.class)
  public void notNullThrowsExceptionForNullValue() {
    Checks.notNull(null);
  }
}
