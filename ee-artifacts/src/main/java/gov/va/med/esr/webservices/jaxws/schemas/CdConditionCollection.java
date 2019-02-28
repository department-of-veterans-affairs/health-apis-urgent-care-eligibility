
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cdConditionCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cdConditionCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdCondition" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cdConditionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cdConditionCollection", propOrder = {
    "cdCondition"
})
public class CdConditionCollection {

    @XmlElement(nillable = true)
    protected List<CdConditionInfo> cdCondition;

    /**
     * Gets the value of the cdCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CdConditionInfo }
     * 
     * 
     */
    public List<CdConditionInfo> getCdCondition() {
        if (cdCondition == null) {
            cdCondition = new ArrayList<CdConditionInfo>();
        }
        return this.cdCondition;
    }

}
