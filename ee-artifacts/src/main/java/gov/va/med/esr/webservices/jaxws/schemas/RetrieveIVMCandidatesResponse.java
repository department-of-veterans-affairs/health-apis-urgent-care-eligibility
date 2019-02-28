
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
 *         &lt;element name="candidates" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ivmCandidateCollection" minOccurs="0"/>
 *         &lt;element name="numberOfCandidates" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "candidates",
    "numberOfCandidates",
    "eesVersion0020",
    "invocationDate0020"
})
@XmlRootElement(name = "retrieveIVMCandidatesResponse")
public class RetrieveIVMCandidatesResponse {

    protected IvmCandidateCollection candidates;
    protected int numberOfCandidates;
    @XmlElement(name = "eesVersion ", required = true)
    protected String eesVersion0020;
    @XmlElement(name = "invocationDate ", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar invocationDate0020;

    /**
     * Gets the value of the candidates property.
     * 
     * @return
     *     possible object is
     *     {@link IvmCandidateCollection }
     *     
     */
    public IvmCandidateCollection getCandidates() {
        return candidates;
    }

    /**
     * Sets the value of the candidates property.
     * 
     * @param value
     *     allowed object is
     *     {@link IvmCandidateCollection }
     *     
     */
    public void setCandidates(IvmCandidateCollection value) {
        this.candidates = value;
    }

    /**
     * Gets the value of the numberOfCandidates property.
     * 
     */
    public int getNumberOfCandidates() {
        return numberOfCandidates;
    }

    /**
     * Sets the value of the numberOfCandidates property.
     * 
     */
    public void setNumberOfCandidates(int value) {
        this.numberOfCandidates = value;
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
