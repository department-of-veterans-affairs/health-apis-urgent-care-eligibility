package gov.va.api.health.queenelizabeth.ee.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;

import gov.va.api.health.queenelizabeth.Samples;
import gov.va.api.health.queenelizabeth.ee.SoapMessageGenerator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SoapRequesterTests {

  @Mock SOAPConnectionFactory soapConnectionFactory;

  @Mock SOAPConnection soapConnection;

  @Mock HttpsURLConnection mockHttpsURLConnection;

  private SoapRequester soapRequester;

  @SneakyThrows
  private void mockResults(String exampleXml) {
    InputStream is = new ByteArrayInputStream(exampleXml.getBytes());
    SOAPMessage response = MessageFactory.newInstance().createMessage(null, is);
    Mockito.when(soapConnection.call(any(SOAPMessage.class), anyString())).thenReturn(response);
  }

  @Before
  @SneakyThrows
  public void setup() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(soapConnectionFactory.createConnection()).thenReturn(soapConnection);
    soapRequester =
        new SoapRequester(
            "https://ee.va.gov:9334/getEESummary/",
            "src/test/resources/test-truststore.jks",
            "test");
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
  public void successfulResponseShouldReturnWhenGoodIcn() {
    mockResults(Samples.create().getEeSummaryResponse());
    String xmlResponse =
        soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
    assertThat(Samples.create().getEeSummaryResponse()).contains(xmlResponse);
  }
}
