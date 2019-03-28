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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SoapRequester.class)
public class SoapRequesterTests {

  @Mock SOAPConnectionFactory soapConnectionFactory;

  @Mock HttpsURLConnection httpsUrlConnection;

  @Mock SOAPConnection soapConnection;

  private SoapRequester soapRequester;

  private SoapRequester soapRequesterSpy;

  @Before
  @SneakyThrows
  public void _init() {
    MockitoAnnotations.initMocks(this);
    soapRequester =
        new SoapRequester(
            "https://ee.va.gov:9334/getEESummary/",
            "src/test/resources/test-truststore.jks",
            "secret");
    soapRequesterSpy = PowerMockito.spy(soapRequester);
    Mockito.when(soapConnectionFactory.createConnection()).thenReturn(soapConnection);
  }

  @SneakyThrows
  private void mockResults(String exampleXml) {
    InputStream is = new ByteArrayInputStream(exampleXml.getBytes());
    SOAPMessage response = MessageFactory.newInstance().createMessage(null, is);
    Mockito.when(soapConnection.call(any(SOAPMessage.class), anyString())).thenReturn(response);
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
    mockResults(Samples.create().getEeSummaryResponse());
    PowerMockito.doReturn(httpsUrlConnection).when(soapRequesterSpy, "openHttpsConnection");
    String xmlResponse =
        soapRequester.executeSoapCall(soapMessageGenerator().createGetEeSummarySoapRequest());
    assertThat(Samples.create().getEeSummaryResponse()).contains(xmlResponse);
  }
}
