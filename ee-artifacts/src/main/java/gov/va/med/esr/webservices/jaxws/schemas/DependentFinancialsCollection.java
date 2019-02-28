
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dependentFinancialsCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dependentFinancialsCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dependentFinancials" type="{http://jaxws.webservices.esr.med.va.gov/schemas}dependentFinancialsInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dependentFinancialsCollection", propOrder = {
    "dependentFinancials"
})
public class DependentFinancialsCollection {

    @XmlElement(nillable = true)
    protected List<DependentFinancialsInfo> dependentFinancials;

    /**
     * Gets the value of the dependentFinancials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentFinancials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentFinancials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DependentFinancialsInfo }
     * 
     * 
     */
    public List<DependentFinancialsInfo> getDependentFinancials() {
        if (dependentFinancials == null) {
            dependentFinancials = new ArrayList<DependentFinancialsInfo>();
        }
        return this.dependentFinancials;
    }

}
