
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseFinancialInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseFinancialInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="assets" type="{http://jaxws.webservices.esr.med.va.gov/schemas}assetCollection" minOccurs="0"/>
 *         &lt;element name="debits" type="{http://jaxws.webservices.esr.med.va.gov/schemas}debitInfo" minOccurs="0"/>
 *         &lt;element name="expenses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}expenseCollection" minOccurs="0"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="incomes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeCollection" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseFinancialInfo", propOrder = {

})
public abstract class BaseFinancialInfo {

    protected AssetCollection assets;
    protected DebitInfo debits;
    protected ExpenseCollection expenses;
    protected Integer incomeYear;
    protected IncomeCollection incomes;

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

}
