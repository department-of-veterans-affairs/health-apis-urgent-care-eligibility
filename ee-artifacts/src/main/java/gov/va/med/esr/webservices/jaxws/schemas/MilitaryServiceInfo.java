
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for militaryServiceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="militaryServiceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="combatEpisodes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}combatEpisodeCollection" minOccurs="0"/>
 *         &lt;element name="combatVeteranEligibilityEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="disabilityRetirementIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dischargeDueToDisability" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="militaryServiceSiteRecords" type="{http://jaxws.webservices.esr.med.va.gov/schemas}militaryServiceSiteRecordCollection" minOccurs="0"/>
 *         &lt;element name="shadIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="medalofHonorIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="eligibleForClassIIDental" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="classIIDentalApplicationDueBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "militaryServiceInfo", propOrder = {

})
public class MilitaryServiceInfo {

    protected CombatEpisodeCollection combatEpisodes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar combatVeteranEligibilityEndDate;
    protected Boolean disabilityRetirementIndicator;
    protected Boolean dischargeDueToDisability;
    protected MilitaryServiceSiteRecordCollection militaryServiceSiteRecords;
    protected Boolean shadIndicator;
    protected Boolean medalofHonorIndicator;
    protected Boolean eligibleForClassIIDental;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar classIIDentalApplicationDueBefore;

    /**
     * Gets the value of the combatEpisodes property.
     * 
     * @return
     *     possible object is
     *     {@link CombatEpisodeCollection }
     *     
     */
    public CombatEpisodeCollection getCombatEpisodes() {
        return combatEpisodes;
    }

    /**
     * Sets the value of the combatEpisodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CombatEpisodeCollection }
     *     
     */
    public void setCombatEpisodes(CombatEpisodeCollection value) {
        this.combatEpisodes = value;
    }

    /**
     * Gets the value of the combatVeteranEligibilityEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCombatVeteranEligibilityEndDate() {
        return combatVeteranEligibilityEndDate;
    }

    /**
     * Sets the value of the combatVeteranEligibilityEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCombatVeteranEligibilityEndDate(XMLGregorianCalendar value) {
        this.combatVeteranEligibilityEndDate = value;
    }

    /**
     * Gets the value of the disabilityRetirementIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisabilityRetirementIndicator() {
        return disabilityRetirementIndicator;
    }

    /**
     * Sets the value of the disabilityRetirementIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisabilityRetirementIndicator(Boolean value) {
        this.disabilityRetirementIndicator = value;
    }

    /**
     * Gets the value of the dischargeDueToDisability property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDischargeDueToDisability() {
        return dischargeDueToDisability;
    }

    /**
     * Sets the value of the dischargeDueToDisability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDischargeDueToDisability(Boolean value) {
        this.dischargeDueToDisability = value;
    }

    /**
     * Gets the value of the militaryServiceSiteRecords property.
     * 
     * @return
     *     possible object is
     *     {@link MilitaryServiceSiteRecordCollection }
     *     
     */
    public MilitaryServiceSiteRecordCollection getMilitaryServiceSiteRecords() {
        return militaryServiceSiteRecords;
    }

    /**
     * Sets the value of the militaryServiceSiteRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link MilitaryServiceSiteRecordCollection }
     *     
     */
    public void setMilitaryServiceSiteRecords(MilitaryServiceSiteRecordCollection value) {
        this.militaryServiceSiteRecords = value;
    }

    /**
     * Gets the value of the shadIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShadIndicator() {
        return shadIndicator;
    }

    /**
     * Sets the value of the shadIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShadIndicator(Boolean value) {
        this.shadIndicator = value;
    }

    /**
     * Gets the value of the medalofHonorIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMedalofHonorIndicator() {
        return medalofHonorIndicator;
    }

    /**
     * Sets the value of the medalofHonorIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMedalofHonorIndicator(Boolean value) {
        this.medalofHonorIndicator = value;
    }

    /**
     * Gets the value of the eligibleForClassIIDental property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEligibleForClassIIDental() {
        return eligibleForClassIIDental;
    }

    /**
     * Sets the value of the eligibleForClassIIDental property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEligibleForClassIIDental(Boolean value) {
        this.eligibleForClassIIDental = value;
    }

    /**
     * Gets the value of the classIIDentalApplicationDueBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClassIIDentalApplicationDueBefore() {
        return classIIDentalApplicationDueBefore;
    }

    /**
     * Sets the value of the classIIDentalApplicationDueBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClassIIDentalApplicationDueBefore(XMLGregorianCalendar value) {
        this.classIIDentalApplicationDueBefore = value;
    }

}
