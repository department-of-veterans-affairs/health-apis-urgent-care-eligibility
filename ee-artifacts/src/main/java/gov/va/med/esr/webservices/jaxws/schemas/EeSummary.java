
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eeSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eeSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="associations" type="{http://jaxws.webservices.esr.med.va.gov/schemas}associationCollection" minOccurs="0"/>
 *         &lt;element name="deathRecond" type="{http://jaxws.webservices.esr.med.va.gov/schemas}deathRecondInfo" minOccurs="0"/>
 *         &lt;element name="demographics" type="{http://jaxws.webservices.esr.med.va.gov/schemas}demographicInfo" minOccurs="0"/>
 *         &lt;element name="eligibilityVerificationInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityVerificationInfo" minOccurs="0"/>
 *         &lt;element name="employmentInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}employmentInfo" minOccurs="0"/>
 *         &lt;element name="enrollmentDeterminationInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}enrollmentDeterminationInfo" minOccurs="0"/>
 *         &lt;element name="feeBasisList" type="{http://jaxws.webservices.esr.med.va.gov/schemas}feeBasisCollection" minOccurs="0"/>
 *         &lt;element name="financialsInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}financialsInfo" minOccurs="0"/>
 *         &lt;element name="incompetenceRulingInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incompetenceRulingInfo" minOccurs="0"/>
 *         &lt;element name="insuranceList" type="{http://jaxws.webservices.esr.med.va.gov/schemas}insuranceCollection" minOccurs="0"/>
 *         &lt;element name="militaryServiceInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}militaryServiceInfo" minOccurs="0"/>
 *         &lt;element name="prisonerOfWarInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}prisonerOfWarInfo" minOccurs="0"/>
 *         &lt;element name="purpleHeart" type="{http://jaxws.webservices.esr.med.va.gov/schemas}purpleHeartInfo" minOccurs="0"/>
 *         &lt;element name="relations" type="{http://jaxws.webservices.esr.med.va.gov/schemas}relationCollection" minOccurs="0"/>
 *         &lt;element name="sensitivityInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}sensitivityInfo" minOccurs="0"/>
 *         &lt;element name="spinalCordInjuryInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}spinalCordInjuryInfo" minOccurs="0"/>
 *         &lt;element name="personInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}personInfo" minOccurs="0"/>
 *         &lt;element name="consentInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}consentInfo" minOccurs="0"/>
 *         &lt;element name="communityCareEligibilityInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}communityCareEligibilityInfo" minOccurs="0"/>
 *         &lt;element name="healthBenefitPlans" type="{http://jaxws.webservices.esr.med.va.gov/schemas}healthBenefitPlanCollection" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eeSummary", propOrder = {

})
public class EeSummary {

    protected AssociationCollection associations;
    protected DeathRecondInfo deathRecond;
    protected DemographicInfo demographics;
    protected EligibilityVerificationInfo eligibilityVerificationInfo;
    protected EmploymentInfo employmentInfo;
    protected EnrollmentDeterminationInfo enrollmentDeterminationInfo;
    protected FeeBasisCollection feeBasisList;
    protected FinancialsInfo financialsInfo;
    protected IncompetenceRulingInfo incompetenceRulingInfo;
    protected InsuranceCollection insuranceList;
    protected MilitaryServiceInfo militaryServiceInfo;
    protected PrisonerOfWarInfo prisonerOfWarInfo;
    protected PurpleHeartInfo purpleHeart;
    protected RelationCollection relations;
    protected SensitivityInfo sensitivityInfo;
    protected SpinalCordInjuryInfo spinalCordInjuryInfo;
    protected PersonInfo personInfo;
    protected ConsentInfo consentInfo;
    protected CommunityCareEligibilityInfo communityCareEligibilityInfo;
    protected HealthBenefitPlanCollection healthBenefitPlans;

    /**
     * Gets the value of the associations property.
     * 
     * @return
     *     possible object is
     *     {@link AssociationCollection }
     *     
     */
    public AssociationCollection getAssociations() {
        return associations;
    }

    /**
     * Sets the value of the associations property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociationCollection }
     *     
     */
    public void setAssociations(AssociationCollection value) {
        this.associations = value;
    }

    /**
     * Gets the value of the deathRecond property.
     * 
     * @return
     *     possible object is
     *     {@link DeathRecondInfo }
     *     
     */
    public DeathRecondInfo getDeathRecond() {
        return deathRecond;
    }

    /**
     * Sets the value of the deathRecond property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeathRecondInfo }
     *     
     */
    public void setDeathRecond(DeathRecondInfo value) {
        this.deathRecond = value;
    }

    /**
     * Gets the value of the demographics property.
     * 
     * @return
     *     possible object is
     *     {@link DemographicInfo }
     *     
     */
    public DemographicInfo getDemographics() {
        return demographics;
    }

    /**
     * Sets the value of the demographics property.
     * 
     * @param value
     *     allowed object is
     *     {@link DemographicInfo }
     *     
     */
    public void setDemographics(DemographicInfo value) {
        this.demographics = value;
    }

    /**
     * Gets the value of the eligibilityVerificationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityVerificationInfo }
     *     
     */
    public EligibilityVerificationInfo getEligibilityVerificationInfo() {
        return eligibilityVerificationInfo;
    }

    /**
     * Sets the value of the eligibilityVerificationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityVerificationInfo }
     *     
     */
    public void setEligibilityVerificationInfo(EligibilityVerificationInfo value) {
        this.eligibilityVerificationInfo = value;
    }

    /**
     * Gets the value of the employmentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EmploymentInfo }
     *     
     */
    public EmploymentInfo getEmploymentInfo() {
        return employmentInfo;
    }

    /**
     * Sets the value of the employmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmploymentInfo }
     *     
     */
    public void setEmploymentInfo(EmploymentInfo value) {
        this.employmentInfo = value;
    }

    /**
     * Gets the value of the enrollmentDeterminationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EnrollmentDeterminationInfo }
     *     
     */
    public EnrollmentDeterminationInfo getEnrollmentDeterminationInfo() {
        return enrollmentDeterminationInfo;
    }

    /**
     * Sets the value of the enrollmentDeterminationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnrollmentDeterminationInfo }
     *     
     */
    public void setEnrollmentDeterminationInfo(EnrollmentDeterminationInfo value) {
        this.enrollmentDeterminationInfo = value;
    }

    /**
     * Gets the value of the feeBasisList property.
     * 
     * @return
     *     possible object is
     *     {@link FeeBasisCollection }
     *     
     */
    public FeeBasisCollection getFeeBasisList() {
        return feeBasisList;
    }

    /**
     * Sets the value of the feeBasisList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeBasisCollection }
     *     
     */
    public void setFeeBasisList(FeeBasisCollection value) {
        this.feeBasisList = value;
    }

    /**
     * Gets the value of the financialsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialsInfo }
     *     
     */
    public FinancialsInfo getFinancialsInfo() {
        return financialsInfo;
    }

    /**
     * Sets the value of the financialsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialsInfo }
     *     
     */
    public void setFinancialsInfo(FinancialsInfo value) {
        this.financialsInfo = value;
    }

    /**
     * Gets the value of the incompetenceRulingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IncompetenceRulingInfo }
     *     
     */
    public IncompetenceRulingInfo getIncompetenceRulingInfo() {
        return incompetenceRulingInfo;
    }

    /**
     * Sets the value of the incompetenceRulingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncompetenceRulingInfo }
     *     
     */
    public void setIncompetenceRulingInfo(IncompetenceRulingInfo value) {
        this.incompetenceRulingInfo = value;
    }

    /**
     * Gets the value of the insuranceList property.
     * 
     * @return
     *     possible object is
     *     {@link InsuranceCollection }
     *     
     */
    public InsuranceCollection getInsuranceList() {
        return insuranceList;
    }

    /**
     * Sets the value of the insuranceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuranceCollection }
     *     
     */
    public void setInsuranceList(InsuranceCollection value) {
        this.insuranceList = value;
    }

    /**
     * Gets the value of the militaryServiceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MilitaryServiceInfo }
     *     
     */
    public MilitaryServiceInfo getMilitaryServiceInfo() {
        return militaryServiceInfo;
    }

    /**
     * Sets the value of the militaryServiceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MilitaryServiceInfo }
     *     
     */
    public void setMilitaryServiceInfo(MilitaryServiceInfo value) {
        this.militaryServiceInfo = value;
    }

    /**
     * Gets the value of the prisonerOfWarInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PrisonerOfWarInfo }
     *     
     */
    public PrisonerOfWarInfo getPrisonerOfWarInfo() {
        return prisonerOfWarInfo;
    }

    /**
     * Sets the value of the prisonerOfWarInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrisonerOfWarInfo }
     *     
     */
    public void setPrisonerOfWarInfo(PrisonerOfWarInfo value) {
        this.prisonerOfWarInfo = value;
    }

    /**
     * Gets the value of the purpleHeart property.
     * 
     * @return
     *     possible object is
     *     {@link PurpleHeartInfo }
     *     
     */
    public PurpleHeartInfo getPurpleHeart() {
        return purpleHeart;
    }

    /**
     * Sets the value of the purpleHeart property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurpleHeartInfo }
     *     
     */
    public void setPurpleHeart(PurpleHeartInfo value) {
        this.purpleHeart = value;
    }

    /**
     * Gets the value of the relations property.
     * 
     * @return
     *     possible object is
     *     {@link RelationCollection }
     *     
     */
    public RelationCollection getRelations() {
        return relations;
    }

    /**
     * Sets the value of the relations property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationCollection }
     *     
     */
    public void setRelations(RelationCollection value) {
        this.relations = value;
    }

    /**
     * Gets the value of the sensitivityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SensitivityInfo }
     *     
     */
    public SensitivityInfo getSensitivityInfo() {
        return sensitivityInfo;
    }

    /**
     * Sets the value of the sensitivityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitivityInfo }
     *     
     */
    public void setSensitivityInfo(SensitivityInfo value) {
        this.sensitivityInfo = value;
    }

    /**
     * Gets the value of the spinalCordInjuryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SpinalCordInjuryInfo }
     *     
     */
    public SpinalCordInjuryInfo getSpinalCordInjuryInfo() {
        return spinalCordInjuryInfo;
    }

    /**
     * Sets the value of the spinalCordInjuryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpinalCordInjuryInfo }
     *     
     */
    public void setSpinalCordInjuryInfo(SpinalCordInjuryInfo value) {
        this.spinalCordInjuryInfo = value;
    }

    /**
     * Gets the value of the personInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PersonInfo }
     *     
     */
    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    /**
     * Sets the value of the personInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonInfo }
     *     
     */
    public void setPersonInfo(PersonInfo value) {
        this.personInfo = value;
    }

    /**
     * Gets the value of the consentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentInfo }
     *     
     */
    public ConsentInfo getConsentInfo() {
        return consentInfo;
    }

    /**
     * Sets the value of the consentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentInfo }
     *     
     */
    public void setConsentInfo(ConsentInfo value) {
        this.consentInfo = value;
    }

    /**
     * Gets the value of the communityCareEligibilityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CommunityCareEligibilityInfo }
     *     
     */
    public CommunityCareEligibilityInfo getCommunityCareEligibilityInfo() {
        return communityCareEligibilityInfo;
    }

    /**
     * Sets the value of the communityCareEligibilityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunityCareEligibilityInfo }
     *     
     */
    public void setCommunityCareEligibilityInfo(CommunityCareEligibilityInfo value) {
        this.communityCareEligibilityInfo = value;
    }

    /**
     * Gets the value of the healthBenefitPlans property.
     * 
     * @return
     *     possible object is
     *     {@link HealthBenefitPlanCollection }
     *     
     */
    public HealthBenefitPlanCollection getHealthBenefitPlans() {
        return healthBenefitPlans;
    }

    /**
     * Sets the value of the healthBenefitPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthBenefitPlanCollection }
     *     
     */
    public void setHealthBenefitPlans(HealthBenefitPlanCollection value) {
        this.healthBenefitPlans = value;
    }

}
