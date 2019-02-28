
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spinalCordInjuryInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spinalCordInjuryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="determinationFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spinalCordInjuryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spinalCordInjuryInfo", propOrder = {

})
public class SpinalCordInjuryInfo {

    protected String determinationFacility;
    protected String spinalCordInjuryType;

    /**
     * Gets the value of the determinationFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeterminationFacility() {
        return determinationFacility;
    }

    /**
     * Sets the value of the determinationFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeterminationFacility(String value) {
        this.determinationFacility = value;
    }

    /**
     * Gets the value of the spinalCordInjuryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpinalCordInjuryType() {
        return spinalCordInjuryType;
    }

    /**
     * Sets the value of the spinalCordInjuryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpinalCordInjuryType(String value) {
        this.spinalCordInjuryType = value;
    }

}
