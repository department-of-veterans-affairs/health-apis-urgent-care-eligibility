
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ratedDisabilityCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ratedDisabilityCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ratedDisability" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ratedDisabilityInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ratedDisabilityCollection", propOrder = {
    "ratedDisability"
})
public class RatedDisabilityCollection {

    @XmlElement(nillable = true)
    protected List<RatedDisabilityInfo> ratedDisability;

    /**
     * Gets the value of the ratedDisability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratedDisability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatedDisability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RatedDisabilityInfo }
     * 
     * 
     */
    public List<RatedDisabilityInfo> getRatedDisability() {
        if (ratedDisability == null) {
            ratedDisability = new ArrayList<RatedDisabilityInfo>();
        }
        return this.ratedDisability;
    }

}
