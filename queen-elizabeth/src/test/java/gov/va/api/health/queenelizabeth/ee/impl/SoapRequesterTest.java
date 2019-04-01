package gov.va.api.health.queenelizabeth.ee.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;

import gov.va.api.health.queenelizabeth.Samples;
import gov.va.api.health.queenelizabeth.ee.Eligibilities;
import gov.va.api.health.queenelizabeth.ee.SoapMessageGenerator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SoapRequesterTest {

  @Mock URL url;

  @Mock InetAddress inetAddress;

  @Mock HttpsURLConnection httpsUrlConnection;

  @Mock SOAPConnection soapConnection;

  @Spy
  SoapRequester soapRequester =
      new SoapRequester("https://ee.va.gov:9334/getEESummary/", "test-truststore.jks", "secret");

  @Before
  @SneakyThrows
  public void _init() {
    MockitoAnnotations.initMocks(this);
    /* URL */
    Mockito.doReturn(url).when(soapRequester).getNewUrl(Mockito.anyString());

    /* HttpsUrlConnection */
    Mockito.when(url.openConnection()).thenReturn(httpsUrlConnection);
    Mockito.doNothing().when(httpsUrlConnection).connect();

    /* SOAPConnection */
    Mockito.doReturn(soapConnection).when(soapRequester).getSoapConnectionFromFactory();
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  public void badUrlProtocolGetsRequestFailed() {
    Mockito.when(url.getProtocol()).thenReturn("http");
    soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  @SneakyThrows
  public void localhostGetsRequestFailed() {
    Mockito.when(url.getProtocol()).thenReturn("https");
    Mockito.when(url.getHost()).thenReturn("localhost");
    soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
  }

  @SneakyThrows
  private void mockResults(String exampleXml) {
    InputStream is = new ByteArrayInputStream(exampleXml.getBytes());
    SOAPMessage soapResponse = MessageFactory.newInstance().createMessage(null, is);
    /* SOAPConnection */
    Mockito.when(soapRequester.getSoapConnectionFromFactory()).thenReturn(soapConnection);
    Mockito.when(soapConnection.call(Mockito.any(), Mockito.any())).thenReturn(soapResponse);
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  @SneakyThrows
  public void soapConnectionFailGetsRequestFailed() {
    Mockito.when(url.getProtocol()).thenReturn("https");
    Mockito.when(soapRequester.getInetAddressByName(any())).thenReturn(inetAddress);
    Mockito.when(soapRequester.getSoapConnectionFromFactory()).thenThrow(SOAPException.class);
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
    Mockito.when(url.getProtocol()).thenReturn("https");
    Mockito.when(soapRequester.getInetAddressByName(Mockito.any())).thenReturn(inetAddress);
    mockResults(Samples.create().getEeSummaryResponse());
    String expected = Samples.create().getEeSummaryResponseBody();
    String result =
        soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
    assertThat(expected).contains(result);
  }
}
