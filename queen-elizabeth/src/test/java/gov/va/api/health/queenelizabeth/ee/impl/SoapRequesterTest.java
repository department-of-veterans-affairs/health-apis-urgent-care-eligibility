package gov.va.api.health.queenelizabeth.ee.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;

import gov.va.api.health.queenelizabeth.Samples;
import gov.va.api.health.queenelizabeth.ee.Eligibilities;
import gov.va.api.health.queenelizabeth.ee.SoapMessageGenerator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.soap.*;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SoapRequester.class, SOAPConnectionFactory.class})
@PowerMockIgnore("javax.net.ssl.*")
public class SoapRequesterTest {

  @Mock URL url;

  @Mock InetAddress inetAddress;

  @Mock HttpsURLConnection httpsUrlConnection;

  @Mock SOAPConnectionFactory soapConnectionFactory;

  @Mock SOAPConnection soapConnection;

  private SoapRequester soapRequester;

  @Before
  @SneakyThrows
  public void _init() {
    MockitoAnnotations.initMocks(this);
    soapRequester =
        new SoapRequester("https://ee.va.gov:9334/getEESummary/", "test-truststore.jks", "secret");
    /* URL */
    PowerMockito.whenNew(URL.class).withArguments(anyString()).thenReturn(url);
    /* Inet Address */
    PowerMockito.mockStatic(InetAddress.class);
    /* HttpsUrlConnection */
    PowerMockito.when(url.openConnection()).thenReturn(httpsUrlConnection);
    PowerMockito.doNothing().when(httpsUrlConnection).connect();
    /* SOAPConnection */
    PowerMockito.mockStatic(SOAPConnectionFactory.class);
    PowerMockito.when(SOAPConnectionFactory.newInstance()).thenReturn(soapConnectionFactory);
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  public void badUrlProtocolGetsRequestFailed() {
    PowerMockito.when(url.getProtocol()).thenReturn("http");
    soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  @SneakyThrows
  public void localhostGetsRequestFailed() {
    PowerMockito.when(url.getProtocol()).thenReturn("https");
    PowerMockito.when(url.getHost()).thenReturn("localhost");
    PowerMockito.when(soapConnectionFactory.createConnection()).thenThrow(SOAPException.class);
    soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
  }

  @SneakyThrows
  private void mockResults(String exampleXml) {
    InputStream is = new ByteArrayInputStream(exampleXml.getBytes());
    SOAPMessage soapResponse = MessageFactory.newInstance().createMessage(null, is);
    /* SOAPConnection */
    PowerMockito.when(soapConnectionFactory.createConnection()).thenReturn(soapConnection);
    PowerMockito.when(soapConnection.call(any(), any())).thenReturn(soapResponse);
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  @SneakyThrows
  public void soapConnectionFailGetsRequestFailed() {
    PowerMockito.when(url.getProtocol()).thenReturn("https");
    PowerMockito.when(InetAddress.getByName(any())).thenReturn(inetAddress);
    PowerMockito.when(soapConnectionFactory.createConnection()).thenThrow(SOAPException.class);
    soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
  }

  private SoapMessageGenerator soapMessageGenerator() {
    return SoapMessageGenerator.builder()
        .eeUsername("eeTestUsername")
        .eePassword("eeTestPassword")
        .eeRequestName("eeTestRequestName")
        .id("1010101010V666666")
        .build();
  }

  @Test
  @SneakyThrows
  public void successfulResponseShouldReturnWhenGoodIcn() {
    PowerMockito.when(url.getProtocol()).thenReturn("https");
    PowerMockito.when(InetAddress.getByName(any())).thenReturn(inetAddress);
    mockResults(Samples.create().getEeSummaryResponse());
    String expected = Samples.create().getEeSummaryResponseBody();
    String result =
        soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
    assertThat(expected).contains(result);
  }
}
