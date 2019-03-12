package gov.va.api.health.eeclient.ee.impl;

import gov.va.api.health.eeclient.ee.Eligibilities;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import lombok.Builder;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XmlResponseValidator {
    private final SoapMessageGenerator soapMessageGenerator;
    private final Document response;

    @Builder
    private XmlResponseValidator(SoapMessageGenerator soapMessageGenerator, Document response) {
        this.soapMessageGenerator = soapMessageGenerator;
        this.response = response;
    }

    void validate() {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            xPath.compile("/getEESummaryResponse").evaluate(response);
        } catch(XPathExpressionException e) {
            throw new Eligibilities.RequestFailed(soapMessageGenerator, "Don't Understand XML, getEESummaryResponse is Missing");
        }
    }
}
