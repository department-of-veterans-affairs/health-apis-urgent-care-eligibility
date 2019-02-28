
package gov.va.med.esr.webservices.jaxws.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nonPrimaryFinancialStatementCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonPrimaryFinancialStatementCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nonPrimaryFinancialStatement" type="{http://jaxws.webservices.esr.med.va.gov/schemas}nonPrimaryFinancialStatementInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonPrimaryFinancialStatementCollection", propOrder = {
    "nonPrimaryFinancialStatement"
})
public class NonPrimaryFinancialStatementCollection {

    @XmlElement(required = true)
    protected List<NonPrimaryFinancialStatementInfo> nonPrimaryFinancialStatement;

    /**
     * Gets the value of the nonPrimaryFinancialStatement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonPrimaryFinancialStatement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonPrimaryFinancialStatement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonPrimaryFinancialStatementInfo }
     * 
     * 
     */
    public List<NonPrimaryFinancialStatementInfo> getNonPrimaryFinancialStatement() {
        if (nonPrimaryFinancialStatement == null) {
            nonPrimaryFinancialStatement = new ArrayList<NonPrimaryFinancialStatementInfo>();
        }
        return this.nonPrimaryFinancialStatement;
    }

}
