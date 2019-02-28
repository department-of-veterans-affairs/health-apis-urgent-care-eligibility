
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ivmCandidateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ivmCandidateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vpid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ivmCandidateInfo", propOrder = {
    "vpid",
    "transactionId",
    "incomeYear"
})
public class IvmCandidateInfo {

    @XmlElement(required = true)
    protected String vpid;
    @XmlElement(required = true)
    protected String transactionId;
    protected int incomeYear;

    /**
     * Gets the value of the vpid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVpid() {
        return vpid;
    }

    /**
     * Sets the value of the vpid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVpid(String value) {
        this.vpid = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the incomeYear property.
     * 
     */
    public int getIncomeYear() {
        return incomeYear;
    }

    /**
     * Sets the value of the incomeYear property.
     * 
     */
    public void setIncomeYear(int value) {
        this.incomeYear = value;
    }

}
