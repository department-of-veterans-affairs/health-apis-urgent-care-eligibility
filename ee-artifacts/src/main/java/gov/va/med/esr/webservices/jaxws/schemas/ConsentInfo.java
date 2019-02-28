
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for consentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consentAuthCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consentImagingSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consentImageIndexNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consentReportDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="consentLastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consentInfo", propOrder = {
    "consentAuthCode",
    "consentImagingSite",
    "consentImageIndexNumber",
    "consentReportDate",
    "consentLastUpdateDate"
})
public class ConsentInfo {

    protected String consentAuthCode;
    protected String consentImagingSite;
    protected String consentImageIndexNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar consentReportDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar consentLastUpdateDate;

    /**
     * Gets the value of the consentAuthCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentAuthCode() {
        return consentAuthCode;
    }

    /**
     * Sets the value of the consentAuthCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentAuthCode(String value) {
        this.consentAuthCode = value;
    }

    /**
     * Gets the value of the consentImagingSite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentImagingSite() {
        return consentImagingSite;
    }

    /**
     * Sets the value of the consentImagingSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentImagingSite(String value) {
        this.consentImagingSite = value;
    }

    /**
     * Gets the value of the consentImageIndexNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentImageIndexNumber() {
        return consentImageIndexNumber;
    }

    /**
     * Sets the value of the consentImageIndexNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentImageIndexNumber(String value) {
        this.consentImageIndexNumber = value;
    }

    /**
     * Gets the value of the consentReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConsentReportDate() {
        return consentReportDate;
    }

    /**
     * Sets the value of the consentReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConsentReportDate(XMLGregorianCalendar value) {
        this.consentReportDate = value;
    }

    /**
     * Gets the value of the consentLastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConsentLastUpdateDate() {
        return consentLastUpdateDate;
    }

    /**
     * Sets the value of the consentLastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConsentLastUpdateDate(XMLGregorianCalendar value) {
        this.consentLastUpdateDate = value;
    }

}
