
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ivmLetterCandidates" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ivmLetterCandidateCollection" minOccurs="0"/>
 *         &lt;element name="eesVersion " type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invocationDate " type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ivmLetterCandidates",
    "eesVersion0020",
    "invocationDate0020"
})
@XmlRootElement(name = "getIVMLetterStatusesResponse")
public class GetIVMLetterStatusesResponse {

    protected IvmLetterCandidateCollection ivmLetterCandidates;
    @XmlElement(name = "eesVersion ", required = true)
    protected String eesVersion0020;
    @XmlElement(name = "invocationDate ", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar invocationDate0020;

    /**
     * Gets the value of the ivmLetterCandidates property.
     * 
     * @return
     *     possible object is
     *     {@link IvmLetterCandidateCollection }
     *     
     */
    public IvmLetterCandidateCollection getIvmLetterCandidates() {
        return ivmLetterCandidates;
    }

    /**
     * Sets the value of the ivmLetterCandidates property.
     * 
     * @param value
     *     allowed object is
     *     {@link IvmLetterCandidateCollection }
     *     
     */
    public void setIvmLetterCandidates(IvmLetterCandidateCollection value) {
        this.ivmLetterCandidates = value;
    }

    /**
     * Gets the value of the eesVersion0020 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEesVersion_0020() {
        return eesVersion0020;
    }

    /**
     * Sets the value of the eesVersion0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEesVersion_0020(String value) {
        this.eesVersion0020 = value;
    }

    /**
     * Gets the value of the invocationDate0020 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvocationDate_0020() {
        return invocationDate0020;
    }

    /**
     * Sets the value of the invocationDate0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvocationDate_0020(XMLGregorianCalendar value) {
        this.invocationDate0020 = value;
    }

}
