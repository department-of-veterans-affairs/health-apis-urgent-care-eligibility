
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ssnCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ssnCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ssn" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ssnInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ssnCollection", propOrder = {
    "ssn"
})
public class SsnCollection {

    @XmlElement(nillable = true)
    protected List<SsnInfo> ssn;

    /**
     * Gets the value of the ssn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ssn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSsn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SsnInfo }
     * 
     * 
     */
    public List<SsnInfo> getSsn() {
        if (ssn == null) {
            ssn = new ArrayList<SsnInfo>();
        }
        return this.ssn;
    }

}
