
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ivmLetterCandidateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ivmLetterCandidateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vpid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ivmCaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ivmLetterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ivmLetterMailedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ivmLetterStatuses" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ivmLetterStatusCollection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ivmLetterCandidateInfo", propOrder = {
    "vpid",
    "ivmCaseNumber",
    "ivmLetterCode",
    "ivmLetterMailedDate",
    "ivmLetterStatuses"
})
public class IvmLetterCandidateInfo {

    protected String vpid;
    protected String ivmCaseNumber;
    protected String ivmLetterCode;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ivmLetterMailedDate;
    protected IvmLetterStatusCollection ivmLetterStatuses;

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
     * Gets the value of the ivmCaseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmCaseNumber() {
        return ivmCaseNumber;
    }

    /**
     * Sets the value of the ivmCaseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmCaseNumber(String value) {
        this.ivmCaseNumber = value;
    }

    /**
     * Gets the value of the ivmLetterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmLetterCode() {
        return ivmLetterCode;
    }

    /**
     * Sets the value of the ivmLetterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmLetterCode(String value) {
        this.ivmLetterCode = value;
    }

    /**
     * Gets the value of the ivmLetterMailedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIvmLetterMailedDate() {
        return ivmLetterMailedDate;
    }

    /**
     * Sets the value of the ivmLetterMailedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIvmLetterMailedDate(XMLGregorianCalendar value) {
        this.ivmLetterMailedDate = value;
    }

    /**
     * Gets the value of the ivmLetterStatuses property.
     * 
     * @return
     *     possible object is
     *     {@link IvmLetterStatusCollection }
     *     
     */
    public IvmLetterStatusCollection getIvmLetterStatuses() {
        return ivmLetterStatuses;
    }

    /**
     * Sets the value of the ivmLetterStatuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link IvmLetterStatusCollection }
     *     
     */
    public void setIvmLetterStatuses(IvmLetterStatusCollection value) {
        this.ivmLetterStatuses = value;
    }

}
