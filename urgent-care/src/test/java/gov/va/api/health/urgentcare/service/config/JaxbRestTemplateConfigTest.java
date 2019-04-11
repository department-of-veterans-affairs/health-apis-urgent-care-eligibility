package gov.va.api.health.urgentcare.service.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import gov.va.api.health.autoconfig.configuration.SecureRestTemplateConfig;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class JaxbRestTemplateConfigTest {
  @Test
  public void jaxbSupportIsAdded() {
    RestTemplate rt = mock(RestTemplate.class);
    RestTemplateBuilder rtb = mock(RestTemplateBuilder.class);
    SecureRestTemplateConfig secureConfig = mock(SecureRestTemplateConfig.class);

    JaxbRestTemplateConfig config = new JaxbRestTemplateConfig(secureConfig);

    when(secureConfig.restTemplate(rtb)).thenReturn(rt);
    RestTemplate actual = config.jaxbRestTemplate(rtb);

    assertThat(actual).isSameAs(rt);

    verify(rt).getMessageConverters();
  }
}
