
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for catastrophicDisabilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="catastrophicDisabilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="catastrophicallyDisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cdConditions" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cdConditionCollection" minOccurs="0"/>
 *         &lt;element name="cdProcedures" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cdProcedureCollection" minOccurs="0"/>
 *         &lt;element name="decisionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="determinationFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="determinationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="determinedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diagnoses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cdDiagnosisCollection" minOccurs="0"/>
 *         &lt;element name="facilityInitiatedCDReviewDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reviewDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="veteranRequestedCDReviewDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="veteranWasNotifiedCDDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catastrophicDisabilityInfo", propOrder = {

})
public class CatastrophicDisabilityInfo {

    protected Boolean catastrophicallyDisabled;
    protected CdConditionCollection cdConditions;
    protected CdProcedureCollection cdProcedures;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar decisionDate;
    protected String determinationFacility;
    protected String determinationMethod;
    protected String determinedBy;
    protected CdDiagnosisCollection diagnoses;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar facilityInitiatedCDReviewDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reviewDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar veteranRequestedCDReviewDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar veteranWasNotifiedCDDate;

    /**
     * Gets the value of the catastrophicallyDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCatastrophicallyDisabled() {
        return catastrophicallyDisabled;
    }

    /**
     * Sets the value of the catastrophicallyDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCatastrophicallyDisabled(Boolean value) {
        this.catastrophicallyDisabled = value;
    }

    /**
     * Gets the value of the cdConditions property.
     * 
     * @return
     *     possible object is
     *     {@link CdConditionCollection }
     *     
     */
    public CdConditionCollection getCdConditions() {
        return cdConditions;
    }

    /**
     * Sets the value of the cdConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CdConditionCollection }
     *     
     */
    public void setCdConditions(CdConditionCollection value) {
        this.cdConditions = value;
    }

    /**
     * Gets the value of the cdProcedures property.
     * 
     * @return
     *     possible object is
     *     {@link CdProcedureCollection }
     *     
     */
    public CdProcedureCollection getCdProcedures() {
        return cdProcedures;
    }

    /**
     * Sets the value of the cdProcedures property.
     * 
     * @param value
     *     allowed object is
     *     {@link CdProcedureCollection }
     *     
     */
    public void setCdProcedures(CdProcedureCollection value) {
        this.cdProcedures = value;
    }

    /**
     * Gets the value of the decisionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDecisionDate() {
        return decisionDate;
    }

    /**
     * Sets the value of the decisionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDecisionDate(XMLGregorianCalendar value) {
        this.decisionDate = value;
    }

    /**
     * Gets the value of the determinationFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeterminationFacility() {
        return determinationFacility;
    }

    /**
     * Sets the value of the determinationFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeterminationFacility(String value) {
        this.determinationFacility = value;
    }

    /**
     * Gets the value of the determinationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeterminationMethod() {
        return determinationMethod;
    }

    /**
     * Sets the value of the determinationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeterminationMethod(String value) {
        this.determinationMethod = value;
    }

    /**
     * Gets the value of the determinedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeterminedBy() {
        return determinedBy;
    }

    /**
     * Sets the value of the determinedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeterminedBy(String value) {
        this.determinedBy = value;
    }

    /**
     * Gets the value of the diagnoses property.
     * 
     * @return
     *     possible object is
     *     {@link CdDiagnosisCollection }
     *     
     */
    public CdDiagnosisCollection getDiagnoses() {
        return diagnoses;
    }

    /**
     * Sets the value of the diagnoses property.
     * 
     * @param value
     *     allowed object is
     *     {@link CdDiagnosisCollection }
     *     
     */
    public void setDiagnoses(CdDiagnosisCollection value) {
        this.diagnoses = value;
    }

    /**
     * Gets the value of the facilityInitiatedCDReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFacilityInitiatedCDReviewDate() {
        return facilityInitiatedCDReviewDate;
    }

    /**
     * Sets the value of the facilityInitiatedCDReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFacilityInitiatedCDReviewDate(XMLGregorianCalendar value) {
        this.facilityInitiatedCDReviewDate = value;
    }

    /**
     * Gets the value of the reviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReviewDate() {
        return reviewDate;
    }

    /**
     * Sets the value of the reviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReviewDate(XMLGregorianCalendar value) {
        this.reviewDate = value;
    }

    /**
     * Gets the value of the veteranRequestedCDReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVeteranRequestedCDReviewDate() {
        return veteranRequestedCDReviewDate;
    }

    /**
     * Sets the value of the veteranRequestedCDReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVeteranRequestedCDReviewDate(XMLGregorianCalendar value) {
        this.veteranRequestedCDReviewDate = value;
    }

    /**
     * Gets the value of the veteranWasNotifiedCDDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVeteranWasNotifiedCDDate() {
        return veteranWasNotifiedCDDate;
    }

    /**
     * Sets the value of the veteranWasNotifiedCDDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVeteranWasNotifiedCDDate(XMLGregorianCalendar value) {
        this.veteranWasNotifiedCDDate = value;
    }

}
