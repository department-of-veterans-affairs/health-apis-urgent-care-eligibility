package gov.va.api.health.eeclient.ee.impl;

import gov.va.api.health.eeclient.Samples;
import gov.va.api.health.eeclient.ee.Eligibilities;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import gov.va.api.health.eeclient.util.XmlDocuments;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.junit.Test;
import org.w3c.dom.Document;

public class XmlResponseValidatorTests {

  @Test
  public void noErrorsForGetEeSummaryFound() {
    parse(Samples.create().getEeSummaryResponse());
  }

  private void parse(String sample) {
    try {
      InputStream is = new ByteArrayInputStream(sample.getBytes());
      SOAPMessage response = MessageFactory.newInstance().createMessage(null, is);
      sample = XmlDocuments.getSoapBodyAsString(response);
    } catch (SOAPException | IOException e) {
      e.printStackTrace();
    }
    Document document = XmlDocuments.create().parse(sample);
    XmlResponseValidator xmlResponseValidator =
        XmlResponseValidator.builder()
            .soapMessageGenerator(soapMessageGenerator())
            .response(document)
            .build();
    xmlResponseValidator.validate();
  }

  @Test(expected = Eligibilities.RequestFailed.class)
  public void requestFailedForEeFault() {
    parse(Samples.create().eeFault());
  }

  private SoapMessageGenerator soapMessageGenerator() {
    return SoapMessageGenerator.builder()
        .eeUsername("eeTestUsername")
        .eePassword("eeTestPassword")
        .eeRequestName("eeTestRequestName")
        .id("1010101010V666666")
        .build();
  }
}