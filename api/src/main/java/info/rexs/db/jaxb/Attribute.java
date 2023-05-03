//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2023.05.03 um 12:26:12 PM CEST
//


package info.rexs.db.jaxb;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}enumValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numericId" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="attributeId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="valueType" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="unit" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="symbol" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nameEn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nameDe" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rangeMin" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="rangeMinIntervalOpen" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="rangeMax" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="rangeMaxIntervalOpen" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="databaseId" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enumValues"
})
@XmlRootElement(name = "attribute")
public class Attribute {

    protected EnumValues enumValues;
    @XmlAttribute(name = "numericId", required = true)
    protected BigInteger numericId;
    @XmlAttribute(name = "attributeId", required = true)
    protected String attributeId;
    @XmlAttribute(name = "valueType", required = true)
    protected BigInteger valueType;
    @XmlAttribute(name = "unit", required = true)
    protected BigInteger unit;
    @XmlAttribute(name = "symbol")
    protected String symbol;
    @XmlAttribute(name = "nameEn", required = true)
    protected String nameEn;
    @XmlAttribute(name = "nameDe", required = true)
    protected String nameDe;
    @XmlAttribute(name = "rangeMin")
    protected BigDecimal rangeMin;
    @XmlAttribute(name = "rangeMinIntervalOpen")
    protected Boolean rangeMinIntervalOpen;
    @XmlAttribute(name = "rangeMax")
    protected BigDecimal rangeMax;
    @XmlAttribute(name = "rangeMaxIntervalOpen")
    protected Boolean rangeMaxIntervalOpen;
    @XmlAttribute(name = "databaseId")
    protected BigInteger databaseId;

    /**
     * Ruft den Wert der enumValues-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link EnumValues }
     *
     */
    public EnumValues getEnumValues() {
        return enumValues;
    }

    /**
     * Legt den Wert der enumValues-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link EnumValues }
     *
     */
    public void setEnumValues(EnumValues value) {
        this.enumValues = value;
    }

    /**
     * Ruft den Wert der numericId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumericId() {
        return numericId;
    }

    /**
     * Legt den Wert der numericId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumericId(BigInteger value) {
        this.numericId = value;
    }

    /**
     * Ruft den Wert der attributeId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAttributeId() {
        return attributeId;
    }

    /**
     * Legt den Wert der attributeId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAttributeId(String value) {
        this.attributeId = value;
    }

    /**
     * Ruft den Wert der valueType-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getValueType() {
        return valueType;
    }

    /**
     * Legt den Wert der valueType-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setValueType(BigInteger value) {
        this.valueType = value;
    }

    /**
     * Ruft den Wert der unit-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getUnit() {
        return unit;
    }

    /**
     * Legt den Wert der unit-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setUnit(BigInteger value) {
        this.unit = value;
    }

    /**
     * Ruft den Wert der symbol-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Legt den Wert der symbol-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    /**
     * Ruft den Wert der nameEn-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * Legt den Wert der nameEn-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNameEn(String value) {
        this.nameEn = value;
    }

    /**
     * Ruft den Wert der nameDe-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNameDe() {
        return nameDe;
    }

    /**
     * Legt den Wert der nameDe-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNameDe(String value) {
        this.nameDe = value;
    }

    /**
     * Ruft den Wert der rangeMin-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getRangeMin() {
        return rangeMin;
    }

    /**
     * Legt den Wert der rangeMin-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setRangeMin(BigDecimal value) {
        this.rangeMin = value;
    }

    /**
     * Ruft den Wert der rangeMinIntervalOpen-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isRangeMinIntervalOpen() {
        return rangeMinIntervalOpen;
    }

    /**
     * Legt den Wert der rangeMinIntervalOpen-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRangeMinIntervalOpen(Boolean value) {
        this.rangeMinIntervalOpen = value;
    }

    /**
     * Ruft den Wert der rangeMax-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getRangeMax() {
        return rangeMax;
    }

    /**
     * Legt den Wert der rangeMax-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setRangeMax(BigDecimal value) {
        this.rangeMax = value;
    }

    /**
     * Ruft den Wert der rangeMaxIntervalOpen-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isRangeMaxIntervalOpen() {
        return rangeMaxIntervalOpen;
    }

    /**
     * Legt den Wert der rangeMaxIntervalOpen-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRangeMaxIntervalOpen(Boolean value) {
        this.rangeMaxIntervalOpen = value;
    }

    /**
     * Ruft den Wert der databaseId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getDatabaseId() {
        return databaseId;
    }

    /**
     * Legt den Wert der databaseId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setDatabaseId(BigInteger value) {
        this.databaseId = value;
    }

}
