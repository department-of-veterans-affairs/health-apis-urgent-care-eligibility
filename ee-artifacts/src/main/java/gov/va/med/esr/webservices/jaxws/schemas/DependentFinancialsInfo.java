
package gov.va.med.esr.webservices.jaxws.schemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dependentFinancialsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dependentFinancialsInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="assets" type="{http://jaxws.webservices.esr.med.va.gov/schemas}assetCollection" minOccurs="0"/>
 *         &lt;element name="debits" type="{http://jaxws.webservices.esr.med.va.gov/schemas}debitInfo" minOccurs="0"/>
 *         &lt;element name="expenses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}expenseCollection" minOccurs="0"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="incomes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeCollection" minOccurs="0"/>
 *         &lt;element name="livedWithPatient" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="inpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="validDependent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="amountContributedToSupport" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="attendedSchool" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="contributedToSupport" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dependentInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}dependentInfo" minOccurs="0"/>
 *         &lt;element name="hasIncome" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="incapableOfSelfSupport" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="incomeAvailableToPatient" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dependentFinancialsInfo", propOrder = {

})
public class DependentFinancialsInfo {

    protected AssetCollection assets;
    protected DebitInfo debits;
    protected ExpenseCollection expenses;
    protected Integer incomeYear;
    protected IncomeCollection incomes;
    protected Boolean livedWithPatient;
    protected Integer inpatientDays;
    protected Integer outpatientDays;
    protected Boolean validDependent;
    protected BigDecimal amountContributedToSupport;
    protected Boolean attendedSchool;
    protected Boolean contributedToSupport;
    protected DependentInfo dependentInfo;
    protected Boolean hasIncome;
    protected Boolean incapableOfSelfSupport;
    protected Boolean incomeAvailableToPatient;

    /**
     * Gets the value of the assets property.
     * 
     * @return
     *     possible object is
     *     {@link AssetCollection }
     *     
     */
    public AssetCollection getAssets() {
        return assets;
    }

    /**
     * Sets the value of the assets property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetCollection }
     *     
     */
    public void setAssets(AssetCollection value) {
        this.assets = value;
    }

    /**
     * Gets the value of the debits property.
     * 
     * @return
     *     possible object is
     *     {@link DebitInfo }
     *     
     */
    public DebitInfo getDebits() {
        return debits;
    }

    /**
     * Sets the value of the debits property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitInfo }
     *     
     */
    public void setDebits(DebitInfo value) {
        this.debits = value;
    }

    /**
     * Gets the value of the expenses property.
     * 
     * @return
     *     possible object is
     *     {@link ExpenseCollection }
     *     
     */
    public ExpenseCollection getExpenses() {
        return expenses;
    }

    /**
     * Sets the value of the expenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpenseCollection }
     *     
     */
    public void setExpenses(ExpenseCollection value) {
        this.expenses = value;
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
     * Gets the value of the incomes property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeCollection }
     *     
     */
    public IncomeCollection getIncomes() {
        return incomes;
    }

    /**
     * Sets the value of the incomes property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeCollection }
     *     
     */
    public void setIncomes(IncomeCollection value) {
        this.incomes = value;
    }

    /**
     * Gets the value of the livedWithPatient property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLivedWithPatient() {
        return livedWithPatient;
    }

    /**
     * Sets the value of the livedWithPatient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLivedWithPatient(Boolean value) {
        this.livedWithPatient = value;
    }

    /**
     * Gets the value of the inpatientDays property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInpatientDays() {
        return inpatientDays;
    }

    /**
     * Sets the value of the inpatientDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInpatientDays(Integer value) {
        this.inpatientDays = value;
    }

    /**
     * Gets the value of the outpatientDays property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOutpatientDays() {
        return outpatientDays;
    }

    /**
     * Sets the value of the outpatientDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOutpatientDays(Integer value) {
        this.outpatientDays = value;
    }

    /**
     * Gets the value of the validDependent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidDependent() {
        return validDependent;
    }

    /**
     * Sets the value of the validDependent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidDependent(Boolean value) {
        this.validDependent = value;
    }

    /**
     * Gets the value of the amountContributedToSupport property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountContributedToSupport() {
        return amountContributedToSupport;
    }

    /**
     * Sets the value of the amountContributedToSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountContributedToSupport(BigDecimal value) {
        this.amountContributedToSupport = value;
    }

    /**
     * Gets the value of the attendedSchool property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttendedSchool() {
        return attendedSchool;
    }

    /**
     * Sets the value of the attendedSchool property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttendedSchool(Boolean value) {
        this.attendedSchool = value;
    }

    /**
     * Gets the value of the contributedToSupport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContributedToSupport() {
        return contributedToSupport;
    }

    /**
     * Sets the value of the contributedToSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContributedToSupport(Boolean value) {
        this.contributedToSupport = value;
    }

    /**
     * Gets the value of the dependentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DependentInfo }
     *     
     */
    public DependentInfo getDependentInfo() {
        return dependentInfo;
    }

    /**
     * Sets the value of the dependentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DependentInfo }
     *     
     */
    public void setDependentInfo(DependentInfo value) {
        this.dependentInfo = value;
    }

    /**
     * Gets the value of the hasIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasIncome() {
        return hasIncome;
    }

    /**
     * Sets the value of the hasIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasIncome(Boolean value) {
        this.hasIncome = value;
    }

    /**
     * Gets the value of the incapableOfSelfSupport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncapableOfSelfSupport() {
        return incapableOfSelfSupport;
    }

    /**
     * Sets the value of the incapableOfSelfSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncapableOfSelfSupport(Boolean value) {
        this.incapableOfSelfSupport = value;
    }

    /**
     * Gets the value of the incomeAvailableToPatient property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncomeAvailableToPatient() {
        return incomeAvailableToPatient;
    }

    /**
     * Sets the value of the incomeAvailableToPatient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncomeAvailableToPatient(Boolean value) {
        this.incomeAvailableToPatient = value;
    }

}
