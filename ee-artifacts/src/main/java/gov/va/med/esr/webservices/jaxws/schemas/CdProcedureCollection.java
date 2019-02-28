
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cdProcedureCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cdProcedureCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdProcedure" type="{http://jaxws.webservices.esr.med.va.gov/schemas}cdProcedureInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cdProcedureCollection", propOrder = {
    "cdProcedure"
})
public class CdProcedureCollection {

    @XmlElement(nillable = true)
    protected List<CdProcedureInfo> cdProcedure;

    /**
     * Gets the value of the cdProcedure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdProcedure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdProcedure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CdProcedureInfo }
     * 
     * 
     */
    public List<CdProcedureInfo> getCdProcedure() {
        if (cdProcedure == null) {
            cdProcedure = new ArrayList<CdProcedureInfo>();
        }
        return this.cdProcedure;
    }

}
