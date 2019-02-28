
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ineligibilityFactorInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ineligibilityFactorInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="facilityReceived" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ineligibleDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="varoDecision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordCreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ineligibilityFactorInfo", propOrder = {

})
public class IneligibilityFactorInfo {

    protected String facilityReceived;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ineligibleDate;
    protected String reason;
    protected String varoDecision;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar recordCreatedDate;

    /**
     * Gets the value of the facilityReceived property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityReceived() {
        return facilityReceived;
    }

    /**
     * Sets the value of the facilityReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityReceived(String value) {
        this.facilityReceived = value;
    }

    /**
     * Gets the value of the ineligibleDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIneligibleDate() {
        return ineligibleDate;
    }

    /**
     * Sets the value of the ineligibleDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIneligibleDate(XMLGregorianCalendar value) {
        this.ineligibleDate = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the varoDecision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVaroDecision() {
        return varoDecision;
    }

    /**
     * Sets the value of the varoDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVaroDecision(String value) {
        this.varoDecision = value;
    }

    /**
     * Gets the value of the recordCreatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRecordCreatedDate() {
        return recordCreatedDate;
    }

    /**
     * Sets the value of the recordCreatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRecordCreatedDate(XMLGregorianCalendar value) {
        this.recordCreatedDate = value;
    }

}
