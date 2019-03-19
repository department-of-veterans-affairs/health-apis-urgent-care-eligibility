package gov.va.api.health.eeclient.ee;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * Build a SOAP Message that will be sent as a request to the Eligibility and Enrollment Service.
 */
@lombok.Value
@Builder(toBuilder = true)
@Slf4j
public class SoapMessageGenerator {

  private final String eeUsername;

  private final String eePassword;

  private final String eeRequestName;

  String id;

  /**
   * Generates a Request to the Eligibility and Enrollment Service's getEESummary operation using
   * only ICN as a value.
   */
  public SOAPMessage createGetEeSummarySoapRequest() {

    SOAPMessage soapMessage = null;
    try {
      MessageFactory messageFactory = MessageFactory.newInstance();
      soapMessage = messageFactory.createMessage();

      SOAPPart soapPart = soapMessage.getSOAPPart();

      /* Set up the SOAP Request Envelope and Namespaces. */
      SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
      soapEnvelope.addNamespaceDeclaration(
          "wsse",
          "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
      soapEnvelope.addNamespaceDeclaration(
          "wsu",
          "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
      soapEnvelope.addNamespaceDeclaration(
          "sch", "http://jaxws.webservices.esr.med.va.gov/schemas");

      /* Set the headers of the SOAP Request Message.*/
      SOAPHeader soapHeader = soapEnvelope.getHeader();
      SOAPElement soapHeaderSecurityElement = soapHeader.addChildElement("Security", "wsse");
      SOAPElement soapHeaderSecurityAttribute =
          soapHeaderSecurityElement.addAttribute(
              soapEnvelope.createQName("mustUnderstand", "SOAP-ENV"), "1");
      SOAPElement soapHeaderUsernameTokenElement =
          soapHeaderSecurityElement.addChildElement("UsernameToken", "wsse");
      SOAPElement soapHeaderUsernameTokenAttribute =
          soapHeaderUsernameTokenElement.addAttribute(
              soapEnvelope.createQName("Id", "wsu"), "XWSSGID-1281117217796-43574433");
      SOAPElement soapHeaderUsernameTokenUserElement =
          soapHeaderUsernameTokenElement.addChildElement("Username", "wsse");
      soapHeaderUsernameTokenUserElement.addTextNode(eeUsername);
      SOAPElement soapHeaderUsernameTokenPasswordElement =
          soapHeaderUsernameTokenElement.addChildElement("Password", "wsse");
      soapHeaderUsernameTokenPasswordElement.addTextNode(eePassword);
      SOAPElement soapHeaderUsernameTokenPasswordAttribute =
          soapHeaderUsernameTokenPasswordElement.addAttribute(
              soapEnvelope.createName("Type"),
              "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

      /* Set the body of the SOAP Request Message. */
      SOAPBody soapBody = soapEnvelope.getBody();
      SOAPElement soapBodyRequestElement = soapBody.addChildElement("getEESummaryRequest", "sch");
      SOAPElement soapBodyElementKey = soapBodyRequestElement.addChildElement("key", "sch");
      soapBodyElementKey.addTextNode(id);

      SOAPElement soapBodyElementRequestName =
          soapBodyRequestElement.addChildElement("requestName", "sch");
      soapBodyElementRequestName.addTextNode(eeRequestName);

      soapMessage.saveChanges();

    } catch (SOAPException e) {
      throw new Eligibilities.RequestFailed(
          soapMessage, "Failed to generate SOAPMessage for getEESummaryRequest");
    }

    return soapMessage;
  }
}