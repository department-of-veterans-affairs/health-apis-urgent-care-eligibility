
package gov.va.med.esr.webservices.jaxws.schemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for financialStatementInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialStatementInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="assets" type="{http://jaxws.webservices.esr.med.va.gov/schemas}assetCollection" minOccurs="0"/>
 *         &lt;element name="debits" type="{http://jaxws.webservices.esr.med.va.gov/schemas}debitInfo" minOccurs="0"/>
 *         &lt;element name="expenses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}expenseCollection" minOccurs="0"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="incomes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeCollection" minOccurs="0"/>
 *         &lt;element name="contributionToSpouse" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="dependentFinancialsList" type="{http://jaxws.webservices.esr.med.va.gov/schemas}dependentFinancialsCollection" minOccurs="0"/>
 *         &lt;element name="marriedLastCalendarYear" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numberOfDependentChildren" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="spouseFinancialsList" type="{http://jaxws.webservices.esr.med.va.gov/schemas}spouseFinancialsCollection" minOccurs="0"/>
 *         &lt;element name="inpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastVisitDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="vamcReportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialStatementInfo", propOrder = {

})
public class FinancialStatementInfo {

    protected AssetCollection assets;
    protected DebitInfo debits;
    protected ExpenseCollection expenses;
    protected Integer incomeYear;
    protected IncomeCollection incomes;
    protected BigDecimal contributionToSpouse;
    protected DependentFinancialsCollection dependentFinancialsList;
    protected Boolean marriedLastCalendarYear;
    protected Integer numberOfDependentChildren;
    protected SpouseFinancialsCollection spouseFinancialsList;
    protected Integer inpatientDays;
    protected Integer outpatientDays;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastVisitDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vamcReportDate;

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
     * Gets the value of the contributionToSpouse property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContributionToSpouse() {
        return contributionToSpouse;
    }

    /**
     * Sets the value of the contributionToSpouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContributionToSpouse(BigDecimal value) {
        this.contributionToSpouse = value;
    }

    /**
     * Gets the value of the dependentFinancialsList property.
     * 
     * @return
     *     possible object is
     *     {@link DependentFinancialsCollection }
     *     
     */
    public DependentFinancialsCollection getDependentFinancialsList() {
        return dependentFinancialsList;
    }

    /**
     * Sets the value of the dependentFinancialsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DependentFinancialsCollection }
     *     
     */
    public void setDependentFinancialsList(DependentFinancialsCollection value) {
        this.dependentFinancialsList = value;
    }

    /**
     * Gets the value of the marriedLastCalendarYear property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarriedLastCalendarYear() {
        return marriedLastCalendarYear;
    }

    /**
     * Sets the value of the marriedLastCalendarYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarriedLastCalendarYear(Boolean value) {
        this.marriedLastCalendarYear = value;
    }

    /**
     * Gets the value of the numberOfDependentChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfDependentChildren() {
        return numberOfDependentChildren;
    }

    /**
     * Sets the value of the numberOfDependentChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfDependentChildren(Integer value) {
        this.numberOfDependentChildren = value;
    }

    /**
     * Gets the value of the spouseFinancialsList property.
     * 
     * @return
     *     possible object is
     *     {@link SpouseFinancialsCollection }
     *     
     */
    public SpouseFinancialsCollection getSpouseFinancialsList() {
        return spouseFinancialsList;
    }

    /**
     * Sets the value of the spouseFinancialsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpouseFinancialsCollection }
     *     
     */
    public void setSpouseFinancialsList(SpouseFinancialsCollection value) {
        this.spouseFinancialsList = value;
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
     * Gets the value of the lastVisitDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastVisitDate() {
        return lastVisitDate;
    }

    /**
     * Sets the value of the lastVisitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastVisitDate(XMLGregorianCalendar value) {
        this.lastVisitDate = value;
    }

    /**
     * Gets the value of the vamcReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVamcReportDate() {
        return vamcReportDate;
    }

    /**
     * Sets the value of the vamcReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVamcReportDate(XMLGregorianCalendar value) {
        this.vamcReportDate = value;
    }

}
