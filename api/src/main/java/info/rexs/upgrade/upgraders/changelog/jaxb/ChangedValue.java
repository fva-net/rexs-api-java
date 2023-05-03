//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2023.05.03 um 12:26:13 PM CEST
//


package info.rexs.upgrade.upgraders.changelog.jaxb;

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
 *         &lt;element ref="{}enumValueChanges" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="oldValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="newValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enumValueChanges"
})
@XmlRootElement(name = "changedValue")
public class ChangedValue {

    protected EnumValueChanges enumValueChanges;
    @XmlAttribute(name = "key", required = true)
    protected String key;
    @XmlAttribute(name = "lang")
    protected String lang;
    @XmlAttribute(name = "oldValue")
    protected String oldValue;
    @XmlAttribute(name = "newValue")
    protected String newValue;

    /**
     * Ruft den Wert der enumValueChanges-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link EnumValueChanges }
     *
     */
    public EnumValueChanges getEnumValueChanges() {
        return enumValueChanges;
    }

    /**
     * Legt den Wert der enumValueChanges-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link EnumValueChanges }
     *
     */
    public void setEnumValueChanges(EnumValueChanges value) {
        this.enumValueChanges = value;
    }

    /**
     * Ruft den Wert der key-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKey() {
        return key;
    }

    /**
     * Legt den Wert der key-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Ruft den Wert der lang-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLang() {
        return lang;
    }

    /**
     * Legt den Wert der lang-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Ruft den Wert der oldValue-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Legt den Wert der oldValue-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOldValue(String value) {
        this.oldValue = value;
    }

    /**
     * Ruft den Wert der newValue-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Legt den Wert der newValue-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNewValue(String value) {
        this.newValue = value;
    }

}
