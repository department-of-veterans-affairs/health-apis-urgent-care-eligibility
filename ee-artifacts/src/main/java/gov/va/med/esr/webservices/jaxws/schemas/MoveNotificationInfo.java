
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moveNotificationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moveNotificationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DFN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromVPID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toVPID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveNotificationInfo", propOrder = {

})
public class MoveNotificationInfo {

    @XmlElement(name = "DFN", required = true)
    protected String dfn;
    @XmlElement(required = true)
    protected String stationNumber;
    @XmlElement(required = true)
    protected String fromVPID;
    @XmlElement(required = true)
    protected String toVPID;

    /**
     * Gets the value of the dfn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFN() {
        return dfn;
    }

    /**
     * Sets the value of the dfn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFN(String value) {
        this.dfn = value;
    }

    /**
     * Gets the value of the stationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationNumber() {
        return stationNumber;
    }

    /**
     * Sets the value of the stationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationNumber(String value) {
        this.stationNumber = value;
    }

    /**
     * Gets the value of the fromVPID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromVPID() {
        return fromVPID;
    }

    /**
     * Sets the value of the fromVPID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromVPID(String value) {
        this.fromVPID = value;
    }

    /**
     * Gets the value of the toVPID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToVPID() {
        return toVPID;
    }

    /**
     * Sets the value of the toVPID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToVPID(String value) {
        this.toVPID = value;
    }

}
