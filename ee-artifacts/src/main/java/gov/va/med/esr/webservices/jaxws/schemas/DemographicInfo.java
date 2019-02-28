
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for demographicInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="demographicInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="appointmentRequestDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="appointmentRequestResponse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="claimFolderLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claimFolderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}contactInfo" minOccurs="0"/>
 *         &lt;element name="ethnicity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preferredFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="unassignmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="races" type="{http://jaxws.webservices.esr.med.va.gov/schemas}raceCollection" minOccurs="0"/>
 *         &lt;element name="religion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preferredFacilities" type="{http://jaxws.webservices.esr.med.va.gov/schemas}preferredFacilityCollection" minOccurs="0"/>
 *         &lt;element name="acaIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="preferredLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preferredLanguageEntryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demographicInfo", propOrder = {

})
public class DemographicInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar appointmentRequestDate;
    protected Boolean appointmentRequestResponse;
    protected String claimFolderLocation;
    protected String claimFolderNumber;
    protected ContactInfo contactInfo;
    protected String ethnicity;
    protected String maritalStatus;
    protected String preferredFacility;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assignmentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar unassignmentDate;
    protected RaceCollection races;
    protected String religion;
    protected PreferredFacilityCollection preferredFacilities;
    protected Boolean acaIndicator;
    protected String preferredLanguage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar preferredLanguageEntryDate;

    /**
     * Gets the value of the appointmentRequestDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppointmentRequestDate() {
        return appointmentRequestDate;
    }

    /**
     * Sets the value of the appointmentRequestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppointmentRequestDate(XMLGregorianCalendar value) {
        this.appointmentRequestDate = value;
    }

    /**
     * Gets the value of the appointmentRequestResponse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAppointmentRequestResponse() {
        return appointmentRequestResponse;
    }

    /**
     * Sets the value of the appointmentRequestResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAppointmentRequestResponse(Boolean value) {
        this.appointmentRequestResponse = value;
    }

    /**
     * Gets the value of the claimFolderLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimFolderLocation() {
        return claimFolderLocation;
    }

    /**
     * Sets the value of the claimFolderLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimFolderLocation(String value) {
        this.claimFolderLocation = value;
    }

    /**
     * Gets the value of the claimFolderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimFolderNumber() {
        return claimFolderNumber;
    }

    /**
     * Sets the value of the claimFolderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimFolderNumber(String value) {
        this.claimFolderNumber = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicity(String value) {
        this.ethnicity = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the preferredFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredFacility() {
        return preferredFacility;
    }

    /**
     * Sets the value of the preferredFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredFacility(String value) {
        this.preferredFacility = value;
    }

    /**
     * Gets the value of the assignmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssignmentDate() {
        return assignmentDate;
    }

    /**
     * Sets the value of the assignmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssignmentDate(XMLGregorianCalendar value) {
        this.assignmentDate = value;
    }

    /**
     * Gets the value of the unassignmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUnassignmentDate() {
        return unassignmentDate;
    }

    /**
     * Sets the value of the unassignmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUnassignmentDate(XMLGregorianCalendar value) {
        this.unassignmentDate = value;
    }

    /**
     * Gets the value of the races property.
     * 
     * @return
     *     possible object is
     *     {@link RaceCollection }
     *     
     */
    public RaceCollection getRaces() {
        return races;
    }

    /**
     * Sets the value of the races property.
     * 
     * @param value
     *     allowed object is
     *     {@link RaceCollection }
     *     
     */
    public void setRaces(RaceCollection value) {
        this.races = value;
    }

    /**
     * Gets the value of the religion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Sets the value of the religion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReligion(String value) {
        this.religion = value;
    }

    /**
     * Gets the value of the preferredFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link PreferredFacilityCollection }
     *     
     */
    public PreferredFacilityCollection getPreferredFacilities() {
        return preferredFacilities;
    }

    /**
     * Sets the value of the preferredFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredFacilityCollection }
     *     
     */
    public void setPreferredFacilities(PreferredFacilityCollection value) {
        this.preferredFacilities = value;
    }

    /**
     * Gets the value of the acaIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAcaIndicator() {
        return acaIndicator;
    }

    /**
     * Sets the value of the acaIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcaIndicator(Boolean value) {
        this.acaIndicator = value;
    }

    /**
     * Gets the value of the preferredLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    /**
     * Sets the value of the preferredLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredLanguage(String value) {
        this.preferredLanguage = value;
    }

    /**
     * Gets the value of the preferredLanguageEntryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPreferredLanguageEntryDate() {
        return preferredLanguageEntryDate;
    }

    /**
     * Sets the value of the preferredLanguageEntryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPreferredLanguageEntryDate(XMLGregorianCalendar value) {
        this.preferredLanguageEntryDate = value;
    }

}
