package gov.va.api.health.eeclient.ee.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import gov.va.api.health.eeclient.Samples;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.*;

public class SoapRequesterTests {

  @InjectMocks
  HttpsURLConnection httpsUrlConnection;

  @Mock SOAPConnectionFactory soapConnectionFactory;

  @Mock SOAPConnection soapConnection;

  @Mock URL url;

  private String endpointUrl = "https://ee.va.gov:9334/getEESummary/";

  private SoapRequester soapRequester;

  @Before
  @SneakyThrows
  public void _init() {
    MockitoAnnotations.initMocks(this);
    when(soapConnectionFactory.createConnection()).thenReturn(soapConnection);
    PowerMockito.when(url.openConnection()).thenReturn(httpsUrlConnection);
    doNothing().when(httpsUrlConnection).connect();
    soapRequester = new SoapRequester(endpointUrl);
  }

  private void mockResults(String exampleXml) {
    try {
      InputStream is = new ByteArrayInputStream(exampleXml.getBytes());
      SOAPMessage response = MessageFactory.newInstance().createMessage(null, is);
      when(soapConnection.call(soapMessageGenerator().createGetEeSummarySoapRequest(), endpointUrl))
          .thenReturn(response);
    } catch (SOAPException | IOException e) {
      e.printStackTrace();
    }
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
