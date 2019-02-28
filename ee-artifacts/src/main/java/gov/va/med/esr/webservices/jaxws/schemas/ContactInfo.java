
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contactInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="addresses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}addressCollection" minOccurs="0"/>
 *         &lt;element name="emails" type="{http://jaxws.webservices.esr.med.va.gov/schemas}emailCollection" minOccurs="0"/>
 *         &lt;element name="phones" type="{http://jaxws.webservices.esr.med.va.gov/schemas}phoneCollection" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactInfo", propOrder = {

})
public class ContactInfo {

    protected AddressCollection addresses;
    protected EmailCollection emails;
    protected PhoneCollection phones;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link AddressCollection }
     *     
     */
    public AddressCollection getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressCollection }
     *     
     */
    public void setAddresses(AddressCollection value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the emails property.
     * 
     * @return
     *     possible object is
     *     {@link EmailCollection }
     *     
     */
    public EmailCollection getEmails() {
        return emails;
    }

    /**
     * Sets the value of the emails property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailCollection }
     *     
     */
    public void setEmails(EmailCollection value) {
        this.emails = value;
    }

    /**
     * Gets the value of the phones property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneCollection }
     *     
     */
    public PhoneCollection getPhones() {
        return phones;
    }

    /**
     * Sets the value of the phones property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneCollection }
     *     
     */
    public void setPhones(PhoneCollection value) {
        this.phones = value;
    }

}
