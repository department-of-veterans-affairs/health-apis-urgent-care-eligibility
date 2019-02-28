
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conflictExperienceCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conflictExperienceCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conflictExperience" type="{http://jaxws.webservices.esr.med.va.gov/schemas}conflictExperienceInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conflictExperienceCollection", propOrder = {
    "conflictExperience"
})
public class ConflictExperienceCollection {

    @XmlElement(nillable = true)
    protected List<ConflictExperienceInfo> conflictExperience;

    /**
     * Gets the value of the conflictExperience property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conflictExperience property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConflictExperience().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConflictExperienceInfo }
     * 
     * 
     */
    public List<ConflictExperienceInfo> getConflictExperience() {
        if (conflictExperience == null) {
            conflictExperience = new ArrayList<ConflictExperienceInfo>();
        }
        return this.conflictExperience;
    }

}
