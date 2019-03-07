package gov.va.api.health.eeclient.gov.va.api.health.eeclient.ee;

import gov.va.api.health.eeclient.util.EeSoapHeaders;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryRequest;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/** Build a SOAP Message that will be sent as a request to the Eligibility and Enrollment Service. */
public class SoapMessageBuilder {


    public static SOAPMessage createGetEESummarySoapRequest(GetEESummaryRequest eeRequestParams, EeSoapHeaders eeRequestHeaders) throws SOAPException {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();

        /* Set up the SOAP Request Envelope and Namespaces. */
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        soapEnvelope.addNamespaceDeclaration("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        soapEnvelope.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        soapEnvelope.addNamespaceDeclaration("sch", "http://jaxws.webservices.esr.med.va.gov/schemas");

        /* Set the headers of the SOAP Request Message.*/
        SOAPHeader soapHeader = soapEnvelope.getHeader();
        SOAPElement soapHeaderSecurityElement = soapHeader.addChildElement("Security", "wsse");
        SOAPElement soapHeaderSecurityAttribute = soapHeaderSecurityElement.addAttribute(soapEnvelope.createQName("mustUnderstand", "SOAP-ENV"), "1");
        SOAPElement soapHeaderUsernameTokenElement = soapHeaderSecurityElement.addChildElement("UsernameToken", "wsse");
        SOAPElement soapHeaderUsernameTokenAttribute = soapHeaderUsernameTokenElement.addAttribute(soapEnvelope.createQName("Id", "wsu"), eeRequestHeaders.getUsernameTokenId());
        SOAPElement soapHeaderUsernameTokenUserElement = soapHeaderUsernameTokenElement.addChildElement("Username", "wsse");
        soapHeaderUsernameTokenUserElement.addTextNode(eeRequestHeaders.getUsername());
        SOAPElement soapHeaderUsernameTokenPasswordElement = soapHeaderUsernameTokenElement.addChildElement("Password", "wsse");
        soapHeaderUsernameTokenPasswordElement.addTextNode(eeRequestHeaders.getPassword());
        SOAPElement soapHeaderUsernameTokenPasswordAttribute = soapHeaderUsernameTokenPasswordElement.addAttribute(soapEnvelope.createName("Type"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

        /* Set the body of the SOAP Request Message. */
        SOAPBody soapBody = soapEnvelope.getBody();
        SOAPElement soapBodyRequestElement = soapBody.addChildElement("getEESummaryRequest", "sch");
        SOAPElement soapBodyElementKey = soapBodyRequestElement.addChildElement("key", "sch");
        soapBodyElementKey.addTextNode(eeRequestParams.getKey());
        /* Key Type is an optional parameter. */
        if(eeRequestParams.getKeyType() != null) {
            SOAPElement soapBodyElementKeyType = soapBodyRequestElement.addChildElement("keyType", "sch");
            soapBodyElementKeyType.addTextNode(eeRequestParams.getKeyType());
        }
        SOAPElement soapBodyElementRequestName = soapBodyRequestElement.addChildElement("requestName", "sch");
        soapBodyElementRequestName.addTextNode(eeRequestParams.getRequestName());
        /* Income Year is an optional parameter. */
        if(eeRequestParams.getIncomeYear() != null) {
            SOAPElement soapBodyElementIncomeYear = soapBodyRequestElement.addChildElement("incomeYear", "sch");
            soapBodyElementIncomeYear.addTextNode(eeRequestParams.getIncomeYear().toString());
        }

        soapMessage.saveChanges();

        return soapMessage;
    }
}

