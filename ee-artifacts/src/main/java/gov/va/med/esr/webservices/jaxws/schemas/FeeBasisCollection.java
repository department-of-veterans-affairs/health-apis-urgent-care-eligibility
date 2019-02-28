
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for feeBasisCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="feeBasisCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feeBasis" type="{http://jaxws.webservices.esr.med.va.gov/schemas}feeBasisInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feeBasisCollection", propOrder = {
    "feeBasis"
})
public class FeeBasisCollection {

    @XmlElement(nillable = true)
    protected List<FeeBasisInfo> feeBasis;

    /**
     * Gets the value of the feeBasis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeBasis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeBasis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeBasisInfo }
     * 
     * 
     */
    public List<FeeBasisInfo> getFeeBasis() {
        if (feeBasis == null) {
            feeBasis = new ArrayList<FeeBasisInfo>();
        }
        return this.feeBasis;
    }

}
