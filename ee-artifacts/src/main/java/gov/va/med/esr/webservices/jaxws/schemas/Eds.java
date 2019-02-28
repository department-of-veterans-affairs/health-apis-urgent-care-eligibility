
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eds complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eds">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="eligibilityStatusInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityStatusInfo" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eds", propOrder = {

})
public class Eds {

    protected EligibilityStatusInfo eligibilityStatusInfo;

    /**
     * Gets the value of the eligibilityStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityStatusInfo }
     *     
     */
    public EligibilityStatusInfo getEligibilityStatusInfo() {
        return eligibilityStatusInfo;
    }

    /**
     * Sets the value of the eligibilityStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityStatusInfo }
     *     
     */
    public void setEligibilityStatusInfo(EligibilityStatusInfo value) {
        this.eligibilityStatusInfo = value;
    }

}
