
package gov.va.med.esr.webservices.jaxws.schemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for incomeTestInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="incomeTestInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="adjudicationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="agreesToPayDeductible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cadAdjusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="childIncomeExclusionThreshold" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateMTNoLongerRequired" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deductibleExpenses" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="discloseFinancialInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="futureTest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="gmtAddressInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}addressInfo" minOccurs="0"/>
 *         &lt;element name="gmtThresholdAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="hardShipReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hardshipInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}hardshipInfo" minOccurs="0"/>
 *         &lt;element name="incomeTestType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeTestsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeVerificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incomeVerificationStatusDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ivmTestCompletionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ivmConversionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="incomeTestReportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="netIncome" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="netWorth" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="networthThreshold" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="pensionThreshold" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="previousYearThresholdApplies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="primaryIncomeTest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reasonMTNoLongerRequired" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="refusedToSign" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sendForAdjudication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="siteConductingTest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statuses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeTestStatusCollection" minOccurs="0"/>
 *         &lt;element name="thresholdA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalIncome" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalNumberOfDependents" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="priorityGroup8Relaxation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ivmCaseStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incomeTestInfo", propOrder = {

})
public class IncomeTestInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar adjudicationDate;
    protected Boolean agreesToPayDeductible;
    protected Boolean cadAdjusted;
    protected BigDecimal childIncomeExclusionThreshold;
    protected String comments;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateMTNoLongerRequired;
    protected BigDecimal deductibleExpenses;
    protected Boolean discloseFinancialInformation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    protected Boolean futureTest;
    protected AddressInfo gmtAddressInfo;
    protected BigDecimal gmtThresholdAmount;
    protected String hardShipReason;
    protected HardshipInfo hardshipInfo;
    protected String incomeTestType;
    protected String incomeTestsource;
    protected String incomeVerificationStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar incomeVerificationStatusDate;
    protected Integer incomeYear;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ivmTestCompletionDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ivmConversionDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar incomeTestReportDate;
    protected BigDecimal netIncome;
    protected BigDecimal netWorth;
    protected BigDecimal networthThreshold;
    protected BigDecimal pensionThreshold;
    protected Boolean previousYearThresholdApplies;
    protected Boolean primaryIncomeTest;
    protected BigDecimal reasonMTNoLongerRequired;
    protected Boolean refusedToSign;
    protected Boolean sendForAdjudication;
    protected String siteConductingTest;
    protected IncomeTestStatusCollection statuses;
    protected BigDecimal thresholdA;
    protected BigDecimal totalIncome;
    protected Integer totalNumberOfDependents;
    protected Boolean priorityGroup8Relaxation;
    protected String ivmCaseStatus;

    /**
     * Gets the value of the adjudicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAdjudicationDate() {
        return adjudicationDate;
    }

    /**
     * Sets the value of the adjudicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAdjudicationDate(XMLGregorianCalendar value) {
        this.adjudicationDate = value;
    }

    /**
     * Gets the value of the agreesToPayDeductible property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAgreesToPayDeductible() {
        return agreesToPayDeductible;
    }

    /**
     * Sets the value of the agreesToPayDeductible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAgreesToPayDeductible(Boolean value) {
        this.agreesToPayDeductible = value;
    }

    /**
     * Gets the value of the cadAdjusted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCadAdjusted() {
        return cadAdjusted;
    }

    /**
     * Sets the value of the cadAdjusted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCadAdjusted(Boolean value) {
        this.cadAdjusted = value;
    }

    /**
     * Gets the value of the childIncomeExclusionThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChildIncomeExclusionThreshold() {
        return childIncomeExclusionThreshold;
    }

    /**
     * Sets the value of the childIncomeExclusionThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChildIncomeExclusionThreshold(BigDecimal value) {
        this.childIncomeExclusionThreshold = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the dateMTNoLongerRequired property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateMTNoLongerRequired() {
        return dateMTNoLongerRequired;
    }

    /**
     * Sets the value of the dateMTNoLongerRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateMTNoLongerRequired(XMLGregorianCalendar value) {
        this.dateMTNoLongerRequired = value;
    }

    /**
     * Gets the value of the deductibleExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeductibleExpenses() {
        return deductibleExpenses;
    }

    /**
     * Sets the value of the deductibleExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeductibleExpenses(BigDecimal value) {
        this.deductibleExpenses = value;
    }

    /**
     * Gets the value of the discloseFinancialInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscloseFinancialInformation() {
        return discloseFinancialInformation;
    }

    /**
     * Sets the value of the discloseFinancialInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscloseFinancialInformation(Boolean value) {
        this.discloseFinancialInformation = value;
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
     * Gets the value of the futureTest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFutureTest() {
        return futureTest;
    }

    /**
     * Sets the value of the futureTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFutureTest(Boolean value) {
        this.futureTest = value;
    }

    /**
     * Gets the value of the gmtAddressInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AddressInfo }
     *     
     */
    public AddressInfo getGmtAddressInfo() {
        return gmtAddressInfo;
    }

    /**
     * Sets the value of the gmtAddressInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressInfo }
     *     
     */
    public void setGmtAddressInfo(AddressInfo value) {
        this.gmtAddressInfo = value;
    }

    /**
     * Gets the value of the gmtThresholdAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGmtThresholdAmount() {
        return gmtThresholdAmount;
    }

    /**
     * Sets the value of the gmtThresholdAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGmtThresholdAmount(BigDecimal value) {
        this.gmtThresholdAmount = value;
    }

    /**
     * Gets the value of the hardShipReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardShipReason() {
        return hardShipReason;
    }

    /**
     * Sets the value of the hardShipReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardShipReason(String value) {
        this.hardShipReason = value;
    }

    /**
     * Gets the value of the hardshipInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HardshipInfo }
     *     
     */
    public HardshipInfo getHardshipInfo() {
        return hardshipInfo;
    }

    /**
     * Sets the value of the hardshipInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HardshipInfo }
     *     
     */
    public void setHardshipInfo(HardshipInfo value) {
        this.hardshipInfo = value;
    }

    /**
     * Gets the value of the incomeTestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeTestType() {
        return incomeTestType;
    }

    /**
     * Sets the value of the incomeTestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeTestType(String value) {
        this.incomeTestType = value;
    }

    /**
     * Gets the value of the incomeTestsource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeTestsource() {
        return incomeTestsource;
    }

    /**
     * Sets the value of the incomeTestsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeTestsource(String value) {
        this.incomeTestsource = value;
    }

    /**
     * Gets the value of the incomeVerificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeVerificationStatus() {
        return incomeVerificationStatus;
    }

    /**
     * Sets the value of the incomeVerificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeVerificationStatus(String value) {
        this.incomeVerificationStatus = value;
    }

    /**
     * Gets the value of the incomeVerificationStatusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIncomeVerificationStatusDate() {
        return incomeVerificationStatusDate;
    }

    /**
     * Sets the value of the incomeVerificationStatusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIncomeVerificationStatusDate(XMLGregorianCalendar value) {
        this.incomeVerificationStatusDate = value;
    }

    /**
     * Gets the value of the incomeYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIncomeYear() {
        return incomeYear;
    }

    /**
     * Sets the value of the incomeYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIncomeYear(Integer value) {
        this.incomeYear = value;
    }

    /**
     * Gets the value of the ivmTestCompletionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIvmTestCompletionDate() {
        return ivmTestCompletionDate;
    }

    /**
     * Sets the value of the ivmTestCompletionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIvmTestCompletionDate(XMLGregorianCalendar value) {
        this.ivmTestCompletionDate = value;
    }

    /**
     * Gets the value of the ivmConversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIvmConversionDate() {
        return ivmConversionDate;
    }

    /**
     * Sets the value of the ivmConversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIvmConversionDate(XMLGregorianCalendar value) {
        this.ivmConversionDate = value;
    }

    /**
     * Gets the value of the incomeTestReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIncomeTestReportDate() {
        return incomeTestReportDate;
    }

    /**
     * Sets the value of the incomeTestReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIncomeTestReportDate(XMLGregorianCalendar value) {
        this.incomeTestReportDate = value;
    }

    /**
     * Gets the value of the netIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetIncome() {
        return netIncome;
    }

    /**
     * Sets the value of the netIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetIncome(BigDecimal value) {
        this.netIncome = value;
    }

    /**
     * Gets the value of the netWorth property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetWorth() {
        return netWorth;
    }

    /**
     * Sets the value of the netWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetWorth(BigDecimal value) {
        this.netWorth = value;
    }

    /**
     * Gets the value of the networthThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetworthThreshold() {
        return networthThreshold;
    }

    /**
     * Sets the value of the networthThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetworthThreshold(BigDecimal value) {
        this.networthThreshold = value;
    }

    /**
     * Gets the value of the pensionThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPensionThreshold() {
        return pensionThreshold;
    }

    /**
     * Sets the value of the pensionThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPensionThreshold(BigDecimal value) {
        this.pensionThreshold = value;
    }

    /**
     * Gets the value of the previousYearThresholdApplies property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreviousYearThresholdApplies() {
        return previousYearThresholdApplies;
    }

    /**
     * Sets the value of the previousYearThresholdApplies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreviousYearThresholdApplies(Boolean value) {
        this.previousYearThresholdApplies = value;
    }

    /**
     * Gets the value of the primaryIncomeTest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrimaryIncomeTest() {
        return primaryIncomeTest;
    }

    /**
     * Sets the value of the primaryIncomeTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrimaryIncomeTest(Boolean value) {
        this.primaryIncomeTest = value;
    }

    /**
     * Gets the value of the reasonMTNoLongerRequired property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReasonMTNoLongerRequired() {
        return reasonMTNoLongerRequired;
    }

    /**
     * Sets the value of the reasonMTNoLongerRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReasonMTNoLongerRequired(BigDecimal value) {
        this.reasonMTNoLongerRequired = value;
    }

    /**
     * Gets the value of the refusedToSign property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRefusedToSign() {
        return refusedToSign;
    }

    /**
     * Sets the value of the refusedToSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRefusedToSign(Boolean value) {
        this.refusedToSign = value;
    }

    /**
     * Gets the value of the sendForAdjudication property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSendForAdjudication() {
        return sendForAdjudication;
    }

    /**
     * Sets the value of the sendForAdjudication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSendForAdjudication(Boolean value) {
        this.sendForAdjudication = value;
    }

    /**
     * Gets the value of the siteConductingTest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteConductingTest() {
        return siteConductingTest;
    }

    /**
     * Sets the value of the siteConductingTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteConductingTest(String value) {
        this.siteConductingTest = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeTestStatusCollection }
     *     
     */
    public IncomeTestStatusCollection getStatuses() {
        return statuses;
    }

    /**
     * Sets the value of the statuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeTestStatusCollection }
     *     
     */
    public void setStatuses(IncomeTestStatusCollection value) {
        this.statuses = value;
    }

    /**
     * Gets the value of the thresholdA property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getThresholdA() {
        return thresholdA;
    }

    /**
     * Sets the value of the thresholdA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setThresholdA(BigDecimal value) {
        this.thresholdA = value;
    }

    /**
     * Gets the value of the totalIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    /**
     * Sets the value of the totalIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalIncome(BigDecimal value) {
        this.totalIncome = value;
    }

    /**
     * Gets the value of the totalNumberOfDependents property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalNumberOfDependents() {
        return totalNumberOfDependents;
    }

    /**
     * Sets the value of the totalNumberOfDependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalNumberOfDependents(Integer value) {
        this.totalNumberOfDependents = value;
    }

    /**
     * Gets the value of the priorityGroup8Relaxation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPriorityGroup8Relaxation() {
        return priorityGroup8Relaxation;
    }

    /**
     * Sets the value of the priorityGroup8Relaxation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPriorityGroup8Relaxation(Boolean value) {
        this.priorityGroup8Relaxation = value;
    }

    /**
     * Gets the value of the ivmCaseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmCaseStatus() {
        return ivmCaseStatus;
    }

    /**
     * Sets the value of the ivmCaseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmCaseStatus(String value) {
        this.ivmCaseStatus = value;
    }

}
