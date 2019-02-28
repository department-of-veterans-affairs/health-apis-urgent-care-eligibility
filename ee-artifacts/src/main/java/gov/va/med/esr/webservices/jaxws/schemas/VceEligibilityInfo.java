
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for vceEligibilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vceEligibilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="vceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vceDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vceEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vceEligibilityInfo", propOrder = {

})
public class VceEligibilityInfo {

    @XmlElement(required = true)
    protected String vceCode;
    @XmlElement(required = true)
    protected String vceDescription;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vceEffectiveDate;

    /**
     * Gets the value of the vceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVceCode() {
        return vceCode;
    }

    /**
     * Sets the value of the vceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVceCode(String value) {
        this.vceCode = value;
    }

    /**
     * Gets the value of the vceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVceDescription() {
        return vceDescription;
    }

    /**
     * Sets the value of the vceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVceDescription(String value) {
        this.vceDescription = value;
    }

    /**
     * Gets the value of the vceEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVceEffectiveDate() {
        return vceEffectiveDate;
    }

    /**
     * Sets the value of the vceEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVceEffectiveDate(XMLGregorianCalendar value) {
        this.vceEffectiveDate = value;
    }

}
