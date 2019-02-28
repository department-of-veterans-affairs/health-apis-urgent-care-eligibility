
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for personInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="middleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssnText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dob" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssaVerificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssaVerificationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="vamcData" type="{http://jaxws.webservices.esr.med.va.gov/schemas}vamcDataCollection" minOccurs="0"/>
 *         &lt;element name="names" type="{http://jaxws.webservices.esr.med.va.gov/schemas}nameCollection" minOccurs="0"/>
 *         &lt;element name="mothersMaidenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placeOfBirthCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placeOfBirthState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personInfo", propOrder = {
    "firstName",
    "middleName",
    "lastName",
    "prefix",
    "suffix",
    "ssnText",
    "gender",
    "dob",
    "ssaVerificationStatus",
    "ssaVerificationDate",
    "vamcData",
    "names",
    "mothersMaidenName",
    "placeOfBirthCity",
    "placeOfBirthState"
})
public class PersonInfo {

    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String prefix;
    protected String suffix;
    protected String ssnText;
    protected String gender;
    protected String dob;
    protected String ssaVerificationStatus;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ssaVerificationDate;
    protected VamcDataCollection vamcData;
    protected NameCollection names;
    protected String mothersMaidenName;
    protected String placeOfBirthCity;
    protected String placeOfBirthState;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the ssnText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsnText() {
        return ssnText;
    }

    /**
     * Sets the value of the ssnText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsnText(String value) {
        this.ssnText = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDob(String value) {
        this.dob = value;
    }

    /**
     * Gets the value of the ssaVerificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsaVerificationStatus() {
        return ssaVerificationStatus;
    }

    /**
     * Sets the value of the ssaVerificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsaVerificationStatus(String value) {
        this.ssaVerificationStatus = value;
    }

    /**
     * Gets the value of the ssaVerificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSsaVerificationDate() {
        return ssaVerificationDate;
    }

    /**
     * Sets the value of the ssaVerificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSsaVerificationDate(XMLGregorianCalendar value) {
        this.ssaVerificationDate = value;
    }

    /**
     * Gets the value of the vamcData property.
     * 
     * @return
     *     possible object is
     *     {@link VamcDataCollection }
     *     
     */
    public VamcDataCollection getVamcData() {
        return vamcData;
    }

    /**
     * Sets the value of the vamcData property.
     * 
     * @param value
     *     allowed object is
     *     {@link VamcDataCollection }
     *     
     */
    public void setVamcData(VamcDataCollection value) {
        this.vamcData = value;
    }

    /**
     * Gets the value of the names property.
     * 
     * @return
     *     possible object is
     *     {@link NameCollection }
     *     
     */
    public NameCollection getNames() {
        return names;
    }

    /**
     * Sets the value of the names property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameCollection }
     *     
     */
    public void setNames(NameCollection value) {
        this.names = value;
    }

    /**
     * Gets the value of the mothersMaidenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    /**
     * Sets the value of the mothersMaidenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMothersMaidenName(String value) {
        this.mothersMaidenName = value;
    }

    /**
     * Gets the value of the placeOfBirthCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfBirthCity() {
        return placeOfBirthCity;
    }

    /**
     * Sets the value of the placeOfBirthCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfBirthCity(String value) {
        this.placeOfBirthCity = value;
    }

    /**
     * Gets the value of the placeOfBirthState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfBirthState() {
        return placeOfBirthState;
    }

    /**
     * Sets the value of the placeOfBirthState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfBirthState(String value) {
        this.placeOfBirthState = value;
    }

}
