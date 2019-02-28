
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ssnInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ssnInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="pseudoSSNReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceOfChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssaMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssaReceivedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ssaSentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ssaVerificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ssaVerificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssnText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ssnInfo", propOrder = {

})
public class SsnInfo {

    protected String pseudoSSNReason;
    protected String sourceOfChange;
    protected String ssaMessage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ssaReceivedDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ssaSentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ssaVerificationDate;
    protected String ssaVerificationStatus;
    protected String ssnText;
    protected String type;

    /**
     * Gets the value of the pseudoSSNReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudoSSNReason() {
        return pseudoSSNReason;
    }

    /**
     * Sets the value of the pseudoSSNReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudoSSNReason(String value) {
        this.pseudoSSNReason = value;
    }

    /**
     * Gets the value of the sourceOfChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOfChange() {
        return sourceOfChange;
    }

    /**
     * Sets the value of the sourceOfChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOfChange(String value) {
        this.sourceOfChange = value;
    }

    /**
     * Gets the value of the ssaMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsaMessage() {
        return ssaMessage;
    }

    /**
     * Sets the value of the ssaMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsaMessage(String value) {
        this.ssaMessage = value;
    }

    /**
     * Gets the value of the ssaReceivedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSsaReceivedDate() {
        return ssaReceivedDate;
    }

    /**
     * Sets the value of the ssaReceivedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSsaReceivedDate(XMLGregorianCalendar value) {
        this.ssaReceivedDate = value;
    }

    /**
     * Gets the value of the ssaSentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSsaSentDate() {
        return ssaSentDate;
    }

    /**
     * Sets the value of the ssaSentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSsaSentDate(XMLGregorianCalendar value) {
        this.ssaSentDate = value;
    }

    /**
     * Gets the value of the ssaVerificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSsaVerificationDate() {
        return ssaVerificationDate;
    }

    /**
     * Sets the value of the ssaVerificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSsaVerificationDate(XMLGregorianCalendar value) {
        this.ssaVerificationDate = value;
    }

    /**
     * Gets the value of the ssaVerificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsaVerificationStatus() {
        return ssaVerificationStatus;
    }

    /**
     * Sets the value of the ssaVerificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsaVerificationStatus(String value) {
        this.ssaVerificationStatus = value;
    }

    /**
     * Gets the value of the ssnText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsnText() {
        return ssnText;
    }

    /**
     * Sets the value of the ssnText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsnText(String value) {
        this.ssnText = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
