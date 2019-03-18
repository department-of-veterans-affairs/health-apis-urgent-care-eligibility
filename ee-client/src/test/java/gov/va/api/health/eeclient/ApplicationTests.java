package gov.va.api.health.eeclient;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
  properties = {
    "ee.header.username=eeTestUsername",
    "ee.header.password=eeTestPassword",
    "ee.request.name=eeTestRequestName"
  }
)
public class ApplicationTests {

  @Test
  public void contextLoads() {
    /* Verifies that the application starts. */
    assertTrue(true);
  }
}
