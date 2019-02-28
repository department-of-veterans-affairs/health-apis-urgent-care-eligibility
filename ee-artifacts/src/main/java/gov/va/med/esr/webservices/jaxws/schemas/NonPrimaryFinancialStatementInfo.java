
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for nonPrimaryFinancialStatementInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonPrimaryFinancialStatementInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="facilityVisitedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outpatientDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastVisitDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="vamcReportDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonPrimaryFinancialStatementInfo", propOrder = {
    "incomeYear",
    "facilityVisitedCode",
    "inpatientDays",
    "outpatientDays",
    "lastVisitDate",
    "vamcReportDate"
})
public class NonPrimaryFinancialStatementInfo {

    protected Integer incomeYear;
    protected String facilityVisitedCode;
    protected Integer inpatientDays;
    protected Integer outpatientDays;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastVisitDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vamcReportDate;

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
     * Gets the value of the facilityVisitedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityVisitedCode() {
        return facilityVisitedCode;
    }

    /**
     * Sets the value of the facilityVisitedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityVisitedCode(String value) {
        this.facilityVisitedCode = value;
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
