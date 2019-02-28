
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ivmLetterStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ivmLetterStatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ivmLetterCommStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ivmLetterCommId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordModifiedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ivmLetterStatusInfo", propOrder = {
    "ivmLetterCommStatus",
    "ivmLetterCommId",
    "recordModifiedDate"
})
public class IvmLetterStatusInfo {

    protected String ivmLetterCommStatus;
    protected String ivmLetterCommId;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar recordModifiedDate;

    /**
     * Gets the value of the ivmLetterCommStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmLetterCommStatus() {
        return ivmLetterCommStatus;
    }

    /**
     * Sets the value of the ivmLetterCommStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmLetterCommStatus(String value) {
        this.ivmLetterCommStatus = value;
    }

    /**
     * Gets the value of the ivmLetterCommId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmLetterCommId() {
        return ivmLetterCommId;
    }

    /**
     * Sets the value of the ivmLetterCommId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmLetterCommId(String value) {
        this.ivmLetterCommId = value;
    }

    /**
     * Gets the value of the recordModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRecordModifiedDate() {
        return recordModifiedDate;
    }

    /**
     * Sets the value of the recordModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRecordModifiedDate(XMLGregorianCalendar value) {
        this.recordModifiedDate = value;
    }

}
