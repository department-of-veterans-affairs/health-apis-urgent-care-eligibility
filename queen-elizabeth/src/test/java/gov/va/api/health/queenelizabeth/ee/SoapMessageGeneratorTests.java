package gov.va.api.health.queenelizabeth.ee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.junit.Test;

public class SoapMessageGeneratorTests {

  @Test
  public void createGetEeSummarySoapRequest() throws SOAPException {
    SoapMessageGenerator soapMessageGenerator = soapMessageGenerator();
    SOAPEnvelope xml =
        soapMessageGenerator.createGetEeSummarySoapRequest().getSOAPPart().getEnvelope();
    XPath xpath = XPathFactory.newInstance().newXPath();
    try {
      /*  Check the SOAP Header Elements are correct. */
      assertThat(
          xpath
              .compile(
                  "/*[local-name()='Envelope']/*[local-name()='Header']/*[local-name()='Security']/*[local-name()='UsernameToken']/*[local-name()='Username']")
              .evaluate(xml),
          is("eeTestUsername"));
      assertThat(
          xpath
              .compile(
                  "/*[local-name()='Envelope']/*[local-name()='Header']/*[local-name()='Security']/*[local-name()='UsernameToken']/*[local-name()='Password']")
              .evaluate(xml),
          is("eeTestPassword"));
      /*  Check the SOAP Body Elements are correct.   */
      assertThat(
          xpath
              .compile(
                  "/*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='getEESummaryRequest']/*[local-name()='key']")
              .evaluate(xml),
          is("1010101010V666666"));
      assertThat(
          xpath
              .compile(
                  "/*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='getEESummaryRequest']/*[local-name()='requestName']")
              .evaluate(xml),
          is("eeTestRequestName"));
    } catch (XPathExpressionException e) {
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
}
