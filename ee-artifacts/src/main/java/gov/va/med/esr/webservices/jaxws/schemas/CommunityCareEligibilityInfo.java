
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for communityCareEligibilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="communityCareEligibilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="eligibilities" type="{http://jaxws.webservices.esr.med.va.gov/schemas}vceEligibilityCollection" minOccurs="0"/>
 *         &lt;element name="vceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vceDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vceEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="censusURHCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="censusURHCodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="censusURHCodeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clinicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communityCareEligibilityInfo", propOrder = {

})
public class CommunityCareEligibilityInfo {

    protected VceEligibilityCollection eligibilities;
    @XmlElement(required = true)
    protected String vceCode;
    @XmlElement(required = true)
    protected String vceDescription;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vceEffectiveDate;
    protected String censusURHCode;
    protected String censusURHCodeName;
    protected String censusURHCodeDescription;
    protected String clinicName;

    /**
     * Gets the value of the eligibilities property.
     * 
     * @return
     *     possible object is
     *     {@link VceEligibilityCollection }
     *     
     */
    public VceEligibilityCollection getEligibilities() {
        return eligibilities;
    }

    /**
     * Sets the value of the eligibilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link VceEligibilityCollection }
     *     
     */
    public void setEligibilities(VceEligibilityCollection value) {
        this.eligibilities = value;
    }

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

    /**
     * Gets the value of the censusURHCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCensusURHCode() {
        return censusURHCode;
    }

    /**
     * Sets the value of the censusURHCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCensusURHCode(String value) {
        this.censusURHCode = value;
    }

    /**
     * Gets the value of the censusURHCodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCensusURHCodeName() {
        return censusURHCodeName;
    }

    /**
     * Sets the value of the censusURHCodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCensusURHCodeName(String value) {
        this.censusURHCodeName = value;
    }

    /**
     * Gets the value of the censusURHCodeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCensusURHCodeDescription() {
        return censusURHCodeDescription;
    }

    /**
     * Sets the value of the censusURHCodeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCensusURHCodeDescription(String value) {
        this.censusURHCodeDescription = value;
    }

    /**
     * Gets the value of the clinicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicName() {
        return clinicName;
    }

    /**
     * Sets the value of the clinicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicName(String value) {
        this.clinicName = value;
    }

}
