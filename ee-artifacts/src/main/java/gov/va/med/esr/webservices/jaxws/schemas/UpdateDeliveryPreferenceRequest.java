
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateDeliveryPreferenceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDeliveryPreferenceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryPreferenceInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}deliveryPreferenceInfo"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDeliveryPreferenceRequest", propOrder = {

})
public class UpdateDeliveryPreferenceRequest {

    @XmlElement(required = true)
    protected String key;
    protected String keyType;
    @XmlElement(required = true)
    protected DeliveryPreferenceInfo deliveryPreferenceInfo;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the keyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * Sets the value of the keyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyType(String value) {
        this.keyType = value;
    }

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
