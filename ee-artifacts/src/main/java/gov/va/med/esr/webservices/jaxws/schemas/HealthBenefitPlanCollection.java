
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for healthBenefitPlanCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="healthBenefitPlanCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="healthBenefitPlan" type="{http://jaxws.webservices.esr.med.va.gov/schemas}healthBenefitPlanInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthBenefitPlanCollection", propOrder = {
    "healthBenefitPlan"
})
public class HealthBenefitPlanCollection {

    @XmlElement(nillable = true)
    protected List<HealthBenefitPlanInfo> healthBenefitPlan;

    /**
     * Gets the value of the healthBenefitPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthBenefitPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthBenefitPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HealthBenefitPlanInfo }
     * 
     * 
     */
    public List<HealthBenefitPlanInfo> getHealthBenefitPlan() {
        if (healthBenefitPlan == null) {
            healthBenefitPlan = new ArrayList<HealthBenefitPlanInfo>();
        }
        return this.healthBenefitPlan;
    }

}
