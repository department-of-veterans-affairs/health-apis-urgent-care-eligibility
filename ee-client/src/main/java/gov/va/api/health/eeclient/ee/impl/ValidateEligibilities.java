package gov.va.api.health.eeclient.ee.impl;

import gov.va.api.health.eeclient.ee.Eligibilities;
import gov.va.api.health.eeclient.ee.EligibilityInfo;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import gov.va.api.health.eeclient.util.XmlDocuments;
import javax.xml.soap.SOAPException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

/** Combines EE requesting and response validation. */
@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ValidateEligibilities implements Eligibilities {

  private final EligibilityInfo eligibilityInfo;

  private Document parse(SoapMessageGenerator soapMessageGenerator, String xml)
      throws SOAPException {
    try {
      return XmlDocuments.create().parse(xml);
    } catch (XmlDocuments.ParseFailed e) {
      log.error("Couldn't parse EE response: {} ", e.getMessage());
      throw new RequestFailed(soapMessageGenerator, e);
    }
  }

  @Override
  @SneakyThrows
  public String request(final SoapMessageGenerator originalSoapMessage) {
    /* TODO Swap ICN for a Public ID of some kind */
    log.info("Request {} ", originalSoapMessage);
    validate(originalSoapMessage);
    String originalXml =
        eligibilityInfo.executeSoapCall(originalSoapMessage.createGetEeSummarySoapRequest());
    Document xml = parse(originalSoapMessage, originalXml);
    XmlResponseValidator.builder()
        .soapMessageGenerator(originalSoapMessage)
        .response(xml)
        .build()
        .validate();
    return write(originalSoapMessage, xml);
  }

  private void validate(SoapMessageGenerator soapMessageGenerator) throws SOAPException {
    if (soapMessageGenerator.getId().isEmpty()) {
      throw new MissingIcnValue(soapMessageGenerator);
    }
  }

  private String write(SoapMessageGenerator soapMessageGenerator, Document xml)
      throws SOAPException {
    try {
      return XmlDocuments.create().write(xml);
    } catch (XmlDocuments.WriteFailed e) {
      log.error("Couldn't write XML: {} ", e.getMessage());
      throw new RequestFailed(soapMessageGenerator, e);
    }
  }
}
