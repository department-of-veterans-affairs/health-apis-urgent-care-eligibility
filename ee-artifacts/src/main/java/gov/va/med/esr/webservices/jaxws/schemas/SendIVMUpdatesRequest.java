
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vpid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="incomeYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="btFinancialInd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sendIVMInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="spouse" type="{http://jaxws.webservices.esr.med.va.gov/schemas}spouseInfo" minOccurs="0"/>
 *                   &lt;element name="dependents" type="{http://jaxws.webservices.esr.med.va.gov/schemas}dependentCollection" minOccurs="0"/>
 *                   &lt;element name="incomeTest" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeTestInfo" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ivmLetterInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ivmCaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ivmLetterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ivmConversionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ivmActionCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vpid",
    "incomeYear",
    "btFinancialInd",
    "sendIVMInfo",
    "ivmLetterInfo",
    "ivmActionCode"
})
@XmlRootElement(name = "sendIVMUpdatesRequest")
public class SendIVMUpdatesRequest {

    @XmlElement(required = true)
    protected String vpid;
    protected int incomeYear;
    protected Boolean btFinancialInd;
    @XmlElement(required = true)
    protected SendIVMUpdatesRequest.SendIVMInfo sendIVMInfo;
    @XmlElement(required = true)
    protected SendIVMUpdatesRequest.IvmLetterInfo ivmLetterInfo;
    @XmlElement(required = true)
    protected String ivmActionCode;

    /**
     * Gets the value of the vpid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVpid() {
        return vpid;
    }

    /**
     * Sets the value of the vpid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVpid(String value) {
        this.vpid = value;
    }

    /**
     * Gets the value of the incomeYear property.
     * 
     */
    public int getIncomeYear() {
        return incomeYear;
    }

    /**
     * Sets the value of the incomeYear property.
     * 
     */
    public void setIncomeYear(int value) {
        this.incomeYear = value;
    }

    /**
     * Gets the value of the btFinancialInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBtFinancialInd() {
        return btFinancialInd;
    }

    /**
     * Sets the value of the btFinancialInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBtFinancialInd(Boolean value) {
        this.btFinancialInd = value;
    }

    /**
     * Gets the value of the sendIVMInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SendIVMUpdatesRequest.SendIVMInfo }
     *     
     */
    public SendIVMUpdatesRequest.SendIVMInfo getSendIVMInfo() {
        return sendIVMInfo;
    }

    /**
     * Sets the value of the sendIVMInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendIVMUpdatesRequest.SendIVMInfo }
     *     
     */
    public void setSendIVMInfo(SendIVMUpdatesRequest.SendIVMInfo value) {
        this.sendIVMInfo = value;
    }

    /**
     * Gets the value of the ivmLetterInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SendIVMUpdatesRequest.IvmLetterInfo }
     *     
     */
    public SendIVMUpdatesRequest.IvmLetterInfo getIvmLetterInfo() {
        return ivmLetterInfo;
    }

    /**
     * Sets the value of the ivmLetterInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendIVMUpdatesRequest.IvmLetterInfo }
     *     
     */
    public void setIvmLetterInfo(SendIVMUpdatesRequest.IvmLetterInfo value) {
        this.ivmLetterInfo = value;
    }

    /**
     * Gets the value of the ivmActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvmActionCode() {
        return ivmActionCode;
    }

    /**
     * Sets the value of the ivmActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvmActionCode(String value) {
        this.ivmActionCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ivmCaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ivmLetterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ivmConversionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ivmCaseNumber",
        "ivmLetterCode",
        "ivmConversionDate"
    })
    public static class IvmLetterInfo {

        protected String ivmCaseNumber;
        protected String ivmLetterCode;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar ivmConversionDate;

        /**
         * Gets the value of the ivmCaseNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIvmCaseNumber() {
            return ivmCaseNumber;
        }

        /**
         * Sets the value of the ivmCaseNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIvmCaseNumber(String value) {
            this.ivmCaseNumber = value;
        }

        /**
         * Gets the value of the ivmLetterCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIvmLetterCode() {
            return ivmLetterCode;
        }

        /**
         * Sets the value of the ivmLetterCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIvmLetterCode(String value) {
            this.ivmLetterCode = value;
        }

        /**
         * Gets the value of the ivmConversionDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getIvmConversionDate() {
            return ivmConversionDate;
        }

        /**
         * Sets the value of the ivmConversionDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setIvmConversionDate(XMLGregorianCalendar value) {
            this.ivmConversionDate = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="spouse" type="{http://jaxws.webservices.esr.med.va.gov/schemas}spouseInfo" minOccurs="0"/>
     *         &lt;element name="dependents" type="{http://jaxws.webservices.esr.med.va.gov/schemas}dependentCollection" minOccurs="0"/>
     *         &lt;element name="incomeTest" type="{http://jaxws.webservices.esr.med.va.gov/schemas}incomeTestInfo" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "spouse",
        "dependents",
        "incomeTest"
    })
    public static class SendIVMInfo {

        protected SpouseInfo spouse;
        protected DependentCollection dependents;
        protected IncomeTestInfo incomeTest;

        /**
         * Gets the value of the spouse property.
         * 
         * @return
         *     possible object is
         *     {@link SpouseInfo }
         *     
         */
        public SpouseInfo getSpouse() {
            return spouse;
        }

        /**
         * Sets the value of the spouse property.
         * 
         * @param value
         *     allowed object is
         *     {@link SpouseInfo }
         *     
         */
        public void setSpouse(SpouseInfo value) {
            this.spouse = value;
        }

        /**
         * Gets the value of the dependents property.
         * 
         * @return
         *     possible object is
         *     {@link DependentCollection }
         *     
         */
        public DependentCollection getDependents() {
            return dependents;
        }

        /**
         * Sets the value of the dependents property.
         * 
         * @param value
         *     allowed object is
         *     {@link DependentCollection }
         *     
         */
        public void setDependents(DependentCollection value) {
            this.dependents = value;
        }

        /**
         * Gets the value of the incomeTest property.
         * 
         * @return
         *     possible object is
         *     {@link IncomeTestInfo }
         *     
         */
        public IncomeTestInfo getIncomeTest() {
            return incomeTest;
        }

        /**
         * Sets the value of the incomeTest property.
         * 
         * @param value
         *     allowed object is
         *     {@link IncomeTestInfo }
         *     
         */
        public void setIncomeTest(IncomeTestInfo value) {
            this.incomeTest = value;
        }

    }

}
