
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prisonerOfWarInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prisonerOfWarInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="episodes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}powEpisodeCollection" minOccurs="0"/>
 *         &lt;element name="powIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prisonerOfWarInfo", propOrder = {

})
public class PrisonerOfWarInfo {

    protected PowEpisodeCollection episodes;
    protected String powIndicator;

    /**
     * Gets the value of the episodes property.
     * 
     * @return
     *     possible object is
     *     {@link PowEpisodeCollection }
     *     
     */
    public PowEpisodeCollection getEpisodes() {
        return episodes;
    }

    /**
     * Sets the value of the episodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowEpisodeCollection }
     *     
     */
    public void setEpisodes(PowEpisodeCollection value) {
        this.episodes = value;
    }

    /**
     * Gets the value of the powIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPowIndicator() {
        return powIndicator;
    }

    /**
     * Sets the value of the powIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPowIndicator(String value) {
        this.powIndicator = value;
    }

}
