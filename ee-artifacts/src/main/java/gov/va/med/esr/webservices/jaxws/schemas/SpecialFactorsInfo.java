
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for specialFactorsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="specialFactorsInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="agentOrangeInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="agentOrangeLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="envContaminantsInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="campLejeuneInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="radiationExposureInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="radiationExposureMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "specialFactorsInfo", propOrder = {

})
public class SpecialFactorsInfo {

    protected Boolean agentOrangeInd;
    protected String agentOrangeLocation;
    protected Boolean envContaminantsInd;
    protected Boolean campLejeuneInd;
    protected Boolean radiationExposureInd;
    protected String radiationExposureMethod;

    /**
     * Gets the value of the agentOrangeInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAgentOrangeInd() {
        return agentOrangeInd;
    }

    /**
     * Sets the value of the agentOrangeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAgentOrangeInd(Boolean value) {
        this.agentOrangeInd = value;
    }

    /**
     * Gets the value of the agentOrangeLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentOrangeLocation() {
        return agentOrangeLocation;
    }

    /**
     * Sets the value of the agentOrangeLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentOrangeLocation(String value) {
        this.agentOrangeLocation = value;
    }

    /**
     * Gets the value of the envContaminantsInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnvContaminantsInd() {
        return envContaminantsInd;
    }

    /**
     * Sets the value of the envContaminantsInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnvContaminantsInd(Boolean value) {
        this.envContaminantsInd = value;
    }

    /**
     * Gets the value of the campLejeuneInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCampLejeuneInd() {
        return campLejeuneInd;
    }

    /**
     * Sets the value of the campLejeuneInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCampLejeuneInd(Boolean value) {
        this.campLejeuneInd = value;
    }

    /**
     * Gets the value of the radiationExposureInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRadiationExposureInd() {
        return radiationExposureInd;
    }

    /**
     * Sets the value of the radiationExposureInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRadiationExposureInd(Boolean value) {
        this.radiationExposureInd = value;
    }

    /**
     * Gets the value of the radiationExposureMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRadiationExposureMethod() {
        return radiationExposureMethod;
    }

    /**
     * Sets the value of the radiationExposureMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRadiationExposureMethod(String value) {
        this.radiationExposureMethod = value;
    }

}
