package gov.va.api.health.eeclient.ee;

import org.springframework.stereotype.Component;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/** Takes Generated Soap Request and returns Eligibility Data from EE Service. */
@Component
public interface EligibilityInfo {

    /** Returns Eligibility Data in XML. */
    SOAPMessage executeSoapCall(SOAPMessage SoapRequestMessage);
}
