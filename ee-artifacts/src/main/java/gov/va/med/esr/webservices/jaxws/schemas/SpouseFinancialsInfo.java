
package gov.va.med.esr.webservices.jaxws.schemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spouseFinancialsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spouseFinancialsInfo">
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
 *         &lt;element name="spouse" type="{http://jaxws.webservices.esr.med.va.gov/schemas}spouseInfo" minOccurs="0"/>
 *         &lt;element name="contributionToSpouseAmt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="contributedToSpouseInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spouseFinancialsInfo", propOrder = {

})
public class SpouseFinancialsInfo {

    protected AssetCollection assets;
    protected DebitInfo debits;
    protected ExpenseCollection expenses;
    protected Integer incomeYear;
    protected IncomeCollection incomes;
    protected Boolean livedWithPatient;
    protected Integer inpatientDays;
    protected Integer outpatientDays;
    protected Boolean validDependent;
    protected SpouseInfo spouse;
    protected BigDecimal contributionToSpouseAmt;
    protected Boolean contributedToSpouseInd;

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
     * Gets the value of the spouse property.
     * 
     * @return
     *     possible object is
     *     {@link SpouseInfo }
     *     
     */
    public SpouseInfo getSpouse() {
        return spouse;
    }

    /**
     * Sets the value of the spouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpouseInfo }
     *     
     */
    public void setSpouse(SpouseInfo value) {
        this.spouse = value;
    }

    /**
     * Gets the value of the contributionToSpouseAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContributionToSpouseAmt() {
        return contributionToSpouseAmt;
    }

    /**
     * Sets the value of the contributionToSpouseAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContributionToSpouseAmt(BigDecimal value) {
        this.contributionToSpouseAmt = value;
    }

    /**
     * Gets the value of the contributedToSpouseInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContributedToSpouseInd() {
        return contributedToSpouseInd;
    }

    /**
     * Sets the value of the contributedToSpouseInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContributedToSpouseInd(Boolean value) {
        this.contributedToSpouseInd = value;
    }

}
