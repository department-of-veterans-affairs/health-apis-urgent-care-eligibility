
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for insuranceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insuranceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enrolledInPartA" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enrolledInPartB" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insAddress" type="{http://jaxws.webservices.esr.med.va.gov/schemas}addressInfo" minOccurs="0"/>
 *         &lt;element name="insurancePhones" type="{http://jaxws.webservices.esr.med.va.gov/schemas}phoneCollection" minOccurs="0"/>
 *         &lt;element name="insuranceSiteUploadStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insuredRelationship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insuranceMappingTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastEditedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="partAEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partBEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preadmitCertification" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reasonInsuranceNotUploaded" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insuranceInfo", propOrder = {

})
public class InsuranceInfo {

    protected String companyName;
    protected Boolean enrolledInPartA;
    protected Boolean enrolledInPartB;
    protected String groupName;
    protected String groupNumber;
    protected AddressInfo insAddress;
    protected PhoneCollection insurancePhones;
    protected String insuranceSiteUploadStatus;
    protected String insuredRelationship;
    protected String insuranceMappingTypeName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastEditedDate;
    protected String partAEffectiveDate;
    protected String partBEffectiveDate;
    protected String planType;
    protected String policyEffectiveDate;
    protected String policyExpirationDate;
    protected String policyHolderName;
    protected String policyNumber;
    protected Boolean preadmitCertification;
    protected String reasonInsuranceNotUploaded;
    protected String subscriber;

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the enrolledInPartA property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnrolledInPartA() {
        return enrolledInPartA;
    }

    /**
     * Sets the value of the enrolledInPartA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnrolledInPartA(Boolean value) {
        this.enrolledInPartA = value;
    }

    /**
     * Gets the value of the enrolledInPartB property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnrolledInPartB() {
        return enrolledInPartB;
    }

    /**
     * Sets the value of the enrolledInPartB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnrolledInPartB(Boolean value) {
        this.enrolledInPartB = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the groupNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     * Sets the value of the groupNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupNumber(String value) {
        this.groupNumber = value;
    }

    /**
     * Gets the value of the insAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressInfo }
     *     
     */
    public AddressInfo getInsAddress() {
        return insAddress;
    }

    /**
     * Sets the value of the insAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressInfo }
     *     
     */
    public void setInsAddress(AddressInfo value) {
        this.insAddress = value;
    }

    /**
     * Gets the value of the insurancePhones property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneCollection }
     *     
     */
    public PhoneCollection getInsurancePhones() {
        return insurancePhones;
    }

    /**
     * Sets the value of the insurancePhones property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneCollection }
     *     
     */
    public void setInsurancePhones(PhoneCollection value) {
        this.insurancePhones = value;
    }

    /**
     * Gets the value of the insuranceSiteUploadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceSiteUploadStatus() {
        return insuranceSiteUploadStatus;
    }

    /**
     * Sets the value of the insuranceSiteUploadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceSiteUploadStatus(String value) {
        this.insuranceSiteUploadStatus = value;
    }

    /**
     * Gets the value of the insuredRelationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuredRelationship() {
        return insuredRelationship;
    }

    /**
     * Sets the value of the insuredRelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuredRelationship(String value) {
        this.insuredRelationship = value;
    }

    /**
     * Gets the value of the insuranceMappingTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceMappingTypeName() {
        return insuranceMappingTypeName;
    }

    /**
     * Sets the value of the insuranceMappingTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceMappingTypeName(String value) {
        this.insuranceMappingTypeName = value;
    }

    /**
     * Gets the value of the lastEditedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastEditedDate() {
        return lastEditedDate;
    }

    /**
     * Sets the value of the lastEditedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastEditedDate(XMLGregorianCalendar value) {
        this.lastEditedDate = value;
    }

    /**
     * Gets the value of the partAEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartAEffectiveDate() {
        return partAEffectiveDate;
    }

    /**
     * Sets the value of the partAEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartAEffectiveDate(String value) {
        this.partAEffectiveDate = value;
    }

    /**
     * Gets the value of the partBEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartBEffectiveDate() {
        return partBEffectiveDate;
    }

    /**
     * Sets the value of the partBEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartBEffectiveDate(String value) {
        this.partBEffectiveDate = value;
    }

    /**
     * Gets the value of the planType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * Sets the value of the planType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanType(String value) {
        this.planType = value;
    }

    /**
     * Gets the value of the policyEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    /**
     * Sets the value of the policyEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyEffectiveDate(String value) {
        this.policyEffectiveDate = value;
    }

    /**
     * Gets the value of the policyExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    /**
     * Sets the value of the policyExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyExpirationDate(String value) {
        this.policyExpirationDate = value;
    }

    /**
     * Gets the value of the policyHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyHolderName() {
        return policyHolderName;
    }

    /**
     * Sets the value of the policyHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyHolderName(String value) {
        this.policyHolderName = value;
    }

    /**
     * Gets the value of the policyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the value of the policyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNumber(String value) {
        this.policyNumber = value;
    }

    /**
     * Gets the value of the preadmitCertification property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreadmitCertification() {
        return preadmitCertification;
    }

    /**
     * Sets the value of the preadmitCertification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreadmitCertification(Boolean value) {
        this.preadmitCertification = value;
    }

    /**
     * Gets the value of the reasonInsuranceNotUploaded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonInsuranceNotUploaded() {
        return reasonInsuranceNotUploaded;
    }

    /**
     * Sets the value of the reasonInsuranceNotUploaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonInsuranceNotUploaded(String value) {
        this.reasonInsuranceNotUploaded = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriber(String value) {
        this.subscriber = value;
    }

}
