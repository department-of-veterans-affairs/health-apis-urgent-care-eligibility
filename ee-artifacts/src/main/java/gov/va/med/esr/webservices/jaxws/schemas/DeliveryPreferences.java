
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deliveryPreferences complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deliveryPreferences">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="deliveryPreferenceInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}deliveryPreferenceInfo" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deliveryPreferences", propOrder = {

})
public class DeliveryPreferences {

    protected DeliveryPreferenceInfo deliveryPreferenceInfo;

    /**
     * Gets the value of the deliveryPreferenceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryPreferenceInfo }
     *     
     */
    public DeliveryPreferenceInfo getDeliveryPreferenceInfo() {
        return deliveryPreferenceInfo;
    }

    /**
     * Sets the value of the deliveryPreferenceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryPreferenceInfo }
     *     
     */
    public void setDeliveryPreferenceInfo(DeliveryPreferenceInfo value) {
        this.deliveryPreferenceInfo = value;
    }

}
