
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for financialsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialsInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="beneficiaryTravels" type="{http://jaxws.webservices.esr.med.va.gov/schemas}beneficiaryTravelCollection" minOccurs="0"/>
 *         &lt;element name="financialStatement" type="{http://jaxws.webservices.esr.med.va.gov/schemas}financialStatementInfo" minOccurs="0"/>
 *         &lt;element name="incomeTest" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeTestInfo" minOccurs="0"/>
 *         &lt;element name="nonPrimaryFinancialsInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}nonPrimaryFinancialStatementCollection" minOccurs="0"/>
 *         &lt;element name="reportSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialsInfo", propOrder = {

})
public class FinancialsInfo {

    protected BeneficiaryTravelCollection beneficiaryTravels;
    protected FinancialStatementInfo financialStatement;
    protected IncomeTestInfo incomeTest;
    protected NonPrimaryFinancialStatementCollection nonPrimaryFinancialsInfo;
    protected String reportSite;

    /**
     * Gets the value of the beneficiaryTravels property.
     * 
     * @return
     *     possible object is
     *     {@link BeneficiaryTravelCollection }
     *     
     */
    public BeneficiaryTravelCollection getBeneficiaryTravels() {
        return beneficiaryTravels;
    }

    /**
     * Sets the value of the beneficiaryTravels property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeneficiaryTravelCollection }
     *     
     */
    public void setBeneficiaryTravels(BeneficiaryTravelCollection value) {
        this.beneficiaryTravels = value;
    }

    /**
     * Gets the value of the financialStatement property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialStatementInfo }
     *     
     */
    public FinancialStatementInfo getFinancialStatement() {
        return financialStatement;
    }

    /**
     * Sets the value of the financialStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialStatementInfo }
     *     
     */
    public void setFinancialStatement(FinancialStatementInfo value) {
        this.financialStatement = value;
    }

    /**
     * Gets the value of the incomeTest property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeTestInfo }
     *     
     */
    public IncomeTestInfo getIncomeTest() {
        return incomeTest;
    }

    /**
     * Sets the value of the incomeTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeTestInfo }
     *     
     */
    public void setIncomeTest(IncomeTestInfo value) {
        this.incomeTest = value;
    }

    /**
     * Gets the value of the nonPrimaryFinancialsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NonPrimaryFinancialStatementCollection }
     *     
     */
    public NonPrimaryFinancialStatementCollection getNonPrimaryFinancialsInfo() {
        return nonPrimaryFinancialsInfo;
    }

    /**
     * Sets the value of the nonPrimaryFinancialsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonPrimaryFinancialStatementCollection }
     *     
     */
    public void setNonPrimaryFinancialsInfo(NonPrimaryFinancialStatementCollection value) {
        this.nonPrimaryFinancialsInfo = value;
    }

    /**
     * Gets the value of the reportSite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportSite() {
        return reportSite;
    }

    /**
     * Sets the value of the reportSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportSite(String value) {
        this.reportSite = value;
    }

}
