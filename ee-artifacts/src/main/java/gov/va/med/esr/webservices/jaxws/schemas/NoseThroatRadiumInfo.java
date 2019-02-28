
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for noseThroatRadiumInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="noseThroatRadiumInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="determinationFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diagnosedWithCancer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="diagnosisVerifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fromAviatorServiceBefore1955" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fromSubmarinerServiceBefore1965" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="receivingTreatment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="verificationFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verificationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noseThroatRadiumInfo", propOrder = {

})
public class NoseThroatRadiumInfo {

    protected String determinationFacility;
    protected Boolean diagnosedWithCancer;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar diagnosisVerifiedDate;
    protected Boolean fromAviatorServiceBefore1955;
    protected Boolean fromSubmarinerServiceBefore1965;
    protected String receivingTreatment;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar verificationDate;
    protected String verificationFacility;
    protected String verificationMethod;

    /**
     * Gets the value of the determinationFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeterminationFacility() {
        return determinationFacility;
    }

    /**
     * Sets the value of the determinationFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeterminationFacility(String value) {
        this.determinationFacility = value;
    }

    /**
     * Gets the value of the diagnosedWithCancer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiagnosedWithCancer() {
        return diagnosedWithCancer;
    }

    /**
     * Sets the value of the diagnosedWithCancer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiagnosedWithCancer(Boolean value) {
        this.diagnosedWithCancer = value;
    }

    /**
     * Gets the value of the diagnosisVerifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDiagnosisVerifiedDate() {
        return diagnosisVerifiedDate;
    }

    /**
     * Sets the value of the diagnosisVerifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDiagnosisVerifiedDate(XMLGregorianCalendar value) {
        this.diagnosisVerifiedDate = value;
    }

    /**
     * Gets the value of the fromAviatorServiceBefore1955 property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFromAviatorServiceBefore1955() {
        return fromAviatorServiceBefore1955;
    }

    /**
     * Sets the value of the fromAviatorServiceBefore1955 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFromAviatorServiceBefore1955(Boolean value) {
        this.fromAviatorServiceBefore1955 = value;
    }

    /**
     * Gets the value of the fromSubmarinerServiceBefore1965 property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFromSubmarinerServiceBefore1965() {
        return fromSubmarinerServiceBefore1965;
    }

    /**
     * Sets the value of the fromSubmarinerServiceBefore1965 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFromSubmarinerServiceBefore1965(Boolean value) {
        this.fromSubmarinerServiceBefore1965 = value;
    }

    /**
     * Gets the value of the receivingTreatment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceivingTreatment() {
        return receivingTreatment;
    }

    /**
     * Sets the value of the receivingTreatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceivingTreatment(String value) {
        this.receivingTreatment = value;
    }

    /**
     * Gets the value of the verificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVerificationDate() {
        return verificationDate;
    }

    /**
     * Sets the value of the verificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVerificationDate(XMLGregorianCalendar value) {
        this.verificationDate = value;
    }

    /**
     * Gets the value of the verificationFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationFacility() {
        return verificationFacility;
    }

    /**
     * Sets the value of the verificationFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationFacility(String value) {
        this.verificationFacility = value;
    }

    /**
     * Gets the value of the verificationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationMethod() {
        return verificationMethod;
    }

    /**
     * Sets the value of the verificationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationMethod(String value) {
        this.verificationMethod = value;
    }

}
