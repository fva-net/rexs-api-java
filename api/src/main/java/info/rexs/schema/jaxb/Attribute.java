//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.08.19 um 03:16:47 PM CEST
//


package info.rexs.schema.jaxb;

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
    protected int numericId;
    @XmlAttribute(name = "attributeId", required = true)
    protected String attributeId;
    @XmlAttribute(name = "valueType", required = true)
    protected int valueType;
    @XmlAttribute(name = "unit", required = true)
    protected int unit;
    @XmlAttribute(name = "symbol")
    protected String symbol;
    @XmlAttribute(name = "nameEn", required = true)
    protected String nameEn;
    @XmlAttribute(name = "nameDe", required = true)
    protected String nameDe;
    @XmlAttribute(name = "rangeMin")
    protected double rangeMin;
    @XmlAttribute(name = "rangeMinIntervalOpen")
    protected Boolean rangeMinIntervalOpen;
    @XmlAttribute(name = "rangeMax")
    protected double rangeMax;
    @XmlAttribute(name = "rangeMaxIntervalOpen")
    protected Boolean rangeMaxIntervalOpen;
    @XmlAttribute(name = "databaseId")
    protected int databaseId;

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
     *     {@code int}
     *
     */
    public int getNumericId() {
        return numericId;
    }

    /**
     * Legt den Wert der numericId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code int}
     *
     */
    public void setNumericId(int value) {
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
     *     {@code int}
     *
     */
    public int getValueType() {
        return valueType;
    }

    /**
     * Legt den Wert der valueType-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code int}
     *
     */
    public void setValueType(int value) {
        this.valueType = value;
    }

    /**
     * Ruft den Wert der unit-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@code int}
     *
     */
    public int getUnit() {
        return unit;
    }

    /**
     * Legt den Wert der unit-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code int}
     *
     */
    public void setUnit(int value) {
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
     *     {@code double}
     *
     */
    public double getRangeMin() {
        return rangeMin;
    }

    /**
     * Legt den Wert der rangeMin-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code double}
     *
     */
    public void setRangeMin(double value) {
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
     *     {@code double}
     *
     */
    public double getRangeMax() {
        return rangeMax;
    }

    /**
     * Legt den Wert der rangeMax-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code double}
     *
     */
    public void setRangeMax(double value) {
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
     *     {@code int}
     *
     */
    public int getDatabaseId() {
        return databaseId;
    }

    /**
     * Legt den Wert der databaseId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@code int}
     *
     */
    public void setDatabaseId(int value) {
        this.databaseId = value;
    }

}
