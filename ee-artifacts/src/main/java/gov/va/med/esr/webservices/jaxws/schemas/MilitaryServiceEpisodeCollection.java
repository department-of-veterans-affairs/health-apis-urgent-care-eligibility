
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for militaryServiceEpisodeCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="militaryServiceEpisodeCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="militaryServiceEpisode" type="{http://jaxws.webservices.esr.med.va.gov/schemas}militaryServiceEpisodeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "militaryServiceEpisodeCollection", propOrder = {
    "militaryServiceEpisode"
})
public class MilitaryServiceEpisodeCollection {

    @XmlElement(nillable = true)
    protected List<MilitaryServiceEpisodeInfo> militaryServiceEpisode;

    /**
     * Gets the value of the militaryServiceEpisode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the militaryServiceEpisode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMilitaryServiceEpisode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MilitaryServiceEpisodeInfo }
     * 
     * 
     */
    public List<MilitaryServiceEpisodeInfo> getMilitaryServiceEpisode() {
        if (militaryServiceEpisode == null) {
            militaryServiceEpisode = new ArrayList<MilitaryServiceEpisodeInfo>();
        }
        return this.militaryServiceEpisode;
    }

}
