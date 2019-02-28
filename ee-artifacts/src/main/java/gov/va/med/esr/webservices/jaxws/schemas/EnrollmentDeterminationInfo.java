
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for enrollmentDeterminationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrollmentDeterminationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="applicationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="calculationSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelDeclineInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cancelDeclineInfo" minOccurs="0"/>
 *         &lt;element name="catastrophicDisabilityInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}catastrophicDisabilityInfo" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="eligibleForMedicaid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="medicaidLastModifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enrollmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enrollmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="facilityReceived" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enrollmentCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ineligibilityFactor" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ineligibilityFactorInfo" minOccurs="0"/>
 *         &lt;element name="militarySexualTraumaInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}militarySexualTraumaInfo" minOccurs="0"/>
 *         &lt;element name="monetaryBenefitAwardInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}monetaryBenefitAwardInfo" minOccurs="0"/>
 *         &lt;element name="noseThroatRadiumInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}noseThroatRadiumInfo" minOccurs="0"/>
 *         &lt;element name="otherEligibilities" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityCollection" minOccurs="0"/>
 *         &lt;element name="primaryEligibility" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityInfo" minOccurs="0"/>
 *         &lt;element name="priorityGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prioritySubGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secondaryEligibilities" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityCollection" minOccurs="0"/>
 *         &lt;element name="serviceConnectionAward" type="{http://jaxws.webservices.esr.med.va.gov/schemas}serviceConnectionAwardInfo" minOccurs="0"/>
 *         &lt;element name="specialFactors" type="{http://jaxws.webservices.esr.med.va.gov/schemas}specialFactorsInfo" minOccurs="0"/>
 *         &lt;element name="userEnrolleeSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userEnrolleeValidThrough" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="veteran" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="recordCreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="recordModifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrollmentDeterminationInfo", propOrder = {

})
public class EnrollmentDeterminationInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applicationDate;
    protected String calculationSource;
    protected CancelDeclineInfo cancelDeclineInfo;
    protected CatastrophicDisabilityInfo catastrophicDisabilityInfo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    protected Boolean eligibleForMedicaid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar medicaidLastModifiedDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enrollmentDate;
    protected String enrollmentStatus;
    protected String facilityReceived;
    protected String enrollmentCategoryName;
    protected IneligibilityFactorInfo ineligibilityFactor;
    protected MilitarySexualTraumaInfo militarySexualTraumaInfo;
    protected MonetaryBenefitAwardInfo monetaryBenefitAwardInfo;
    protected NoseThroatRadiumInfo noseThroatRadiumInfo;
    protected EligibilityCollection otherEligibilities;
    protected EligibilityInfo primaryEligibility;
    protected String priorityGroup;
    protected String prioritySubGroup;
    protected EligibilityCollection secondaryEligibilities;
    protected ServiceConnectionAwardInfo serviceConnectionAward;
    protected SpecialFactorsInfo specialFactors;
    protected String userEnrolleeSite;
    protected Integer userEnrolleeValidThrough;
    protected Boolean veteran;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar recordCreatedDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar recordModifiedDate;

    /**
     * Gets the value of the applicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets the value of the applicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDate(XMLGregorianCalendar value) {
        this.applicationDate = value;
    }

    /**
     * Gets the value of the calculationSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalculationSource() {
        return calculationSource;
    }

    /**
     * Sets the value of the calculationSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalculationSource(String value) {
        this.calculationSource = value;
    }

    /**
     * Gets the value of the cancelDeclineInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CancelDeclineInfo }
     *     
     */
    public CancelDeclineInfo getCancelDeclineInfo() {
        return cancelDeclineInfo;
    }

    /**
     * Sets the value of the cancelDeclineInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelDeclineInfo }
     *     
     */
    public void setCancelDeclineInfo(CancelDeclineInfo value) {
        this.cancelDeclineInfo = value;
    }

    /**
     * Gets the value of the catastrophicDisabilityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CatastrophicDisabilityInfo }
     *     
     */
    public CatastrophicDisabilityInfo getCatastrophicDisabilityInfo() {
        return catastrophicDisabilityInfo;
    }

    /**
     * Sets the value of the catastrophicDisabilityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatastrophicDisabilityInfo }
     *     
     */
    public void setCatastrophicDisabilityInfo(CatastrophicDisabilityInfo value) {
        this.catastrophicDisabilityInfo = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the eligibleForMedicaid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEligibleForMedicaid() {
        return eligibleForMedicaid;
    }

    /**
     * Sets the value of the eligibleForMedicaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEligibleForMedicaid(Boolean value) {
        this.eligibleForMedicaid = value;
    }

    /**
     * Gets the value of the medicaidLastModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMedicaidLastModifiedDate() {
        return medicaidLastModifiedDate;
    }

    /**
     * Sets the value of the medicaidLastModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMedicaidLastModifiedDate(XMLGregorianCalendar value) {
        this.medicaidLastModifiedDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the enrollmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * Sets the value of the enrollmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnrollmentDate(XMLGregorianCalendar value) {
        this.enrollmentDate = value;
    }

    /**
     * Gets the value of the enrollmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    /**
     * Sets the value of the enrollmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollmentStatus(String value) {
        this.enrollmentStatus = value;
    }

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
     * Gets the value of the enrollmentCategoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollmentCategoryName() {
        return enrollmentCategoryName;
    }

    /**
     * Sets the value of the enrollmentCategoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollmentCategoryName(String value) {
        this.enrollmentCategoryName = value;
    }

    /**
     * Gets the value of the ineligibilityFactor property.
     * 
     * @return
     *     possible object is
     *     {@link IneligibilityFactorInfo }
     *     
     */
    public IneligibilityFactorInfo getIneligibilityFactor() {
        return ineligibilityFactor;
    }

    /**
     * Sets the value of the ineligibilityFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link IneligibilityFactorInfo }
     *     
     */
    public void setIneligibilityFactor(IneligibilityFactorInfo value) {
        this.ineligibilityFactor = value;
    }

    /**
     * Gets the value of the militarySexualTraumaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MilitarySexualTraumaInfo }
     *     
     */
    public MilitarySexualTraumaInfo getMilitarySexualTraumaInfo() {
        return militarySexualTraumaInfo;
    }

    /**
     * Sets the value of the militarySexualTraumaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MilitarySexualTraumaInfo }
     *     
     */
    public void setMilitarySexualTraumaInfo(MilitarySexualTraumaInfo value) {
        this.militarySexualTraumaInfo = value;
    }

    /**
     * Gets the value of the monetaryBenefitAwardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryBenefitAwardInfo }
     *     
     */
    public MonetaryBenefitAwardInfo getMonetaryBenefitAwardInfo() {
        return monetaryBenefitAwardInfo;
    }

    /**
     * Sets the value of the monetaryBenefitAwardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryBenefitAwardInfo }
     *     
     */
    public void setMonetaryBenefitAwardInfo(MonetaryBenefitAwardInfo value) {
        this.monetaryBenefitAwardInfo = value;
    }

    /**
     * Gets the value of the noseThroatRadiumInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NoseThroatRadiumInfo }
     *     
     */
    public NoseThroatRadiumInfo getNoseThroatRadiumInfo() {
        return noseThroatRadiumInfo;
    }

    /**
     * Sets the value of the noseThroatRadiumInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoseThroatRadiumInfo }
     *     
     */
    public void setNoseThroatRadiumInfo(NoseThroatRadiumInfo value) {
        this.noseThroatRadiumInfo = value;
    }

    /**
     * Gets the value of the otherEligibilities property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityCollection }
     *     
     */
    public EligibilityCollection getOtherEligibilities() {
        return otherEligibilities;
    }

    /**
     * Sets the value of the otherEligibilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityCollection }
     *     
     */
    public void setOtherEligibilities(EligibilityCollection value) {
        this.otherEligibilities = value;
    }

    /**
     * Gets the value of the primaryEligibility property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityInfo }
     *     
     */
    public EligibilityInfo getPrimaryEligibility() {
        return primaryEligibility;
    }

    /**
     * Sets the value of the primaryEligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityInfo }
     *     
     */
    public void setPrimaryEligibility(EligibilityInfo value) {
        this.primaryEligibility = value;
    }

    /**
     * Gets the value of the priorityGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriorityGroup() {
        return priorityGroup;
    }

    /**
     * Sets the value of the priorityGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriorityGroup(String value) {
        this.priorityGroup = value;
    }

    /**
     * Gets the value of the prioritySubGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrioritySubGroup() {
        return prioritySubGroup;
    }

    /**
     * Sets the value of the prioritySubGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrioritySubGroup(String value) {
        this.prioritySubGroup = value;
    }

    /**
     * Gets the value of the secondaryEligibilities property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityCollection }
     *     
     */
    public EligibilityCollection getSecondaryEligibilities() {
        return secondaryEligibilities;
    }

    /**
     * Sets the value of the secondaryEligibilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityCollection }
     *     
     */
    public void setSecondaryEligibilities(EligibilityCollection value) {
        this.secondaryEligibilities = value;
    }

    /**
     * Gets the value of the serviceConnectionAward property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceConnectionAwardInfo }
     *     
     */
    public ServiceConnectionAwardInfo getServiceConnectionAward() {
        return serviceConnectionAward;
    }

    /**
     * Sets the value of the serviceConnectionAward property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceConnectionAwardInfo }
     *     
     */
    public void setServiceConnectionAward(ServiceConnectionAwardInfo value) {
        this.serviceConnectionAward = value;
    }

    /**
     * Gets the value of the specialFactors property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialFactorsInfo }
     *     
     */
    public SpecialFactorsInfo getSpecialFactors() {
        return specialFactors;
    }

    /**
     * Sets the value of the specialFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialFactorsInfo }
     *     
     */
    public void setSpecialFactors(SpecialFactorsInfo value) {
        this.specialFactors = value;
    }

    /**
     * Gets the value of the userEnrolleeSite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserEnrolleeSite() {
        return userEnrolleeSite;
    }

    /**
     * Sets the value of the userEnrolleeSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserEnrolleeSite(String value) {
        this.userEnrolleeSite = value;
    }

    /**
     * Gets the value of the userEnrolleeValidThrough property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserEnrolleeValidThrough() {
        return userEnrolleeValidThrough;
    }

    /**
     * Sets the value of the userEnrolleeValidThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserEnrolleeValidThrough(Integer value) {
        this.userEnrolleeValidThrough = value;
    }

    /**
     * Gets the value of the veteran property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVeteran() {
        return veteran;
    }

    /**
     * Sets the value of the veteran property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVeteran(Boolean value) {
        this.veteran = value;
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

    /**
     * Gets the value of the recordModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRecordModifiedDate() {
        return recordModifiedDate;
    }

    /**
     * Sets the value of the recordModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRecordModifiedDate(XMLGregorianCalendar value) {
        this.recordModifiedDate = value;
    }

}
