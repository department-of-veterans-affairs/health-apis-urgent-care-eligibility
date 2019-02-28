
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for serviceConnectionAwardInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceConnectionAwardInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="awardDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="combinedServiceConnectedPercentageEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permanentAndTotal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="permanentAndTotalEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ratedDisabilities" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ratedDisabilityCollection" minOccurs="0"/>
 *         &lt;element name="serviceConnectedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="serviceConnectedPercentage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="unemployable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="scReportDate " type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceConnectionAwardInfo", propOrder = {

})
public class ServiceConnectionAwardInfo {

    protected String awardDate;
    protected String combinedServiceConnectedPercentageEffectiveDate;
    protected Boolean permanentAndTotal;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar permanentAndTotalEffectiveDate;
    protected RatedDisabilityCollection ratedDisabilities;
    protected Boolean serviceConnectedIndicator;
    protected Integer serviceConnectedPercentage;
    protected Boolean unemployable;
    @XmlElement(name = "scReportDate ")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scReportDate0020;

    /**
     * Gets the value of the awardDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardDate() {
        return awardDate;
    }

    /**
     * Sets the value of the awardDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardDate(String value) {
        this.awardDate = value;
    }

    /**
     * Gets the value of the combinedServiceConnectedPercentageEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombinedServiceConnectedPercentageEffectiveDate() {
        return combinedServiceConnectedPercentageEffectiveDate;
    }

    /**
     * Sets the value of the combinedServiceConnectedPercentageEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombinedServiceConnectedPercentageEffectiveDate(String value) {
        this.combinedServiceConnectedPercentageEffectiveDate = value;
    }

    /**
     * Gets the value of the permanentAndTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPermanentAndTotal() {
        return permanentAndTotal;
    }

    /**
     * Sets the value of the permanentAndTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPermanentAndTotal(Boolean value) {
        this.permanentAndTotal = value;
    }

    /**
     * Gets the value of the permanentAndTotalEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPermanentAndTotalEffectiveDate() {
        return permanentAndTotalEffectiveDate;
    }

    /**
     * Sets the value of the permanentAndTotalEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPermanentAndTotalEffectiveDate(XMLGregorianCalendar value) {
        this.permanentAndTotalEffectiveDate = value;
    }

    /**
     * Gets the value of the ratedDisabilities property.
     * 
     * @return
     *     possible object is
     *     {@link RatedDisabilityCollection }
     *     
     */
    public RatedDisabilityCollection getRatedDisabilities() {
        return ratedDisabilities;
    }

    /**
     * Sets the value of the ratedDisabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatedDisabilityCollection }
     *     
     */
    public void setRatedDisabilities(RatedDisabilityCollection value) {
        this.ratedDisabilities = value;
    }

    /**
     * Gets the value of the serviceConnectedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServiceConnectedIndicator() {
        return serviceConnectedIndicator;
    }

    /**
     * Sets the value of the serviceConnectedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServiceConnectedIndicator(Boolean value) {
        this.serviceConnectedIndicator = value;
    }

    /**
     * Gets the value of the serviceConnectedPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServiceConnectedPercentage() {
        return serviceConnectedPercentage;
    }

    /**
     * Sets the value of the serviceConnectedPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceConnectedPercentage(Integer value) {
        this.serviceConnectedPercentage = value;
    }

    /**
     * Gets the value of the unemployable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnemployable() {
        return unemployable;
    }

    /**
     * Sets the value of the unemployable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnemployable(Boolean value) {
        this.unemployable = value;
    }

    /**
     * Gets the value of the scReportDate0020 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getScReportDate_0020() {
        return scReportDate0020;
    }

    /**
     * Sets the value of the scReportDate0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setScReportDate_0020(XMLGregorianCalendar value) {
        this.scReportDate0020 = value;
    }

}
