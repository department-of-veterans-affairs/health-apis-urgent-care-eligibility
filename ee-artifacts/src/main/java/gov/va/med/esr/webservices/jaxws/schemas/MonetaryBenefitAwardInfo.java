
package gov.va.med.esr.webservices.jaxws.schemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for monetaryBenefitAwardInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="monetaryBenefitAwardInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="checkAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monetaryBenefits" type="{http://jaxws.webservices.esr.med.va.gov/schemas}monetaryBenefitCollection" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monetaryBenefitAwardInfo", propOrder = {

})
public class MonetaryBenefitAwardInfo {

    protected BigDecimal checkAmount;
    protected MonetaryBenefitCollection monetaryBenefits;

    /**
     * Gets the value of the checkAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCheckAmount() {
        return checkAmount;
    }

    /**
     * Sets the value of the checkAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCheckAmount(BigDecimal value) {
        this.checkAmount = value;
    }

    /**
     * Gets the value of the monetaryBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryBenefitCollection }
     *     
     */
    public MonetaryBenefitCollection getMonetaryBenefits() {
        return monetaryBenefits;
    }

    /**
     * Sets the value of the monetaryBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryBenefitCollection }
     *     
     */
    public void setMonetaryBenefits(MonetaryBenefitCollection value) {
        this.monetaryBenefits = value;
    }

}
