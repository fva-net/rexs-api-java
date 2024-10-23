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
 *       &lt;attribute name="componentId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nameEn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nameDe" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="databaseId" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "component")
public class Component {

    @XmlAttribute(name = "componentId", required = true)
    protected String componentId;
    @XmlAttribute(name = "nameEn", required = true)
    protected String nameEn;
    @XmlAttribute(name = "nameDe", required = true)
    protected String nameDe;
    @XmlAttribute(name = "databaseId")
    protected int databaseId;

    /**
     * Ruft den Wert der componentId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComponentId() {
        return componentId;
    }

    /**
     * Legt den Wert der componentId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComponentId(String value) {
        this.componentId = value;
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
