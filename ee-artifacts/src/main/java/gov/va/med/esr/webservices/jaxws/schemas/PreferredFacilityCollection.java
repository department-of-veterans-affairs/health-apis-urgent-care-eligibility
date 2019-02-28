
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preferredFacilityCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preferredFacilityCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preferredFacilityInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}preferredFacilityInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preferredFacilityCollection", propOrder = {
    "preferredFacilityInfo"
})
public class PreferredFacilityCollection {

    @XmlElement(nillable = true)
    protected List<PreferredFacilityInfo> preferredFacilityInfo;

    /**
     * Gets the value of the preferredFacilityInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preferredFacilityInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreferredFacilityInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreferredFacilityInfo }
     * 
     * 
     */
    public List<PreferredFacilityInfo> getPreferredFacilityInfo() {
        if (preferredFacilityInfo == null) {
            preferredFacilityInfo = new ArrayList<PreferredFacilityInfo>();
        }
        return this.preferredFacilityInfo;
    }

}
