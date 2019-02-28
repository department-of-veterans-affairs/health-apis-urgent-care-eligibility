
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eligibilityCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eligibilityCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eligibility" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eligibilityCollection", propOrder = {
    "eligibility"
})
public class EligibilityCollection {

    @XmlElement(nillable = true)
    protected List<EligibilityInfo> eligibility;

    /**
     * Gets the value of the eligibility property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eligibility property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEligibility().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EligibilityInfo }
     * 
     * 
     */
    public List<EligibilityInfo> getEligibility() {
        if (eligibility == null) {
            eligibility = new ArrayList<EligibilityInfo>();
        }
        return this.eligibility;
    }

}
