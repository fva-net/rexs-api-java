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
 *         &lt;element ref="{}componentChanges" minOccurs="0"/&gt;
 *         &lt;element ref="{}attributeChanges" minOccurs="0"/&gt;
 *         &lt;element ref="{}mappingChanges" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="fromVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="toVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "componentChanges",
    "attributeChanges",
    "mappingChanges"
})
@XmlRootElement(name = "rexsChangelog")
public class RexsChangelog {

    protected ComponentChanges componentChanges;
    protected AttributeChanges attributeChanges;
    protected MappingChanges mappingChanges;
    @XmlAttribute(name = "fromVersion", required = true)
    protected String fromVersion;
    @XmlAttribute(name = "toVersion", required = true)
    protected String toVersion;

    /**
     * Ruft den Wert der componentChanges-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link ComponentChanges }
     *
     */
    public ComponentChanges getComponentChanges() {
        return componentChanges;
    }

    /**
     * Legt den Wert der componentChanges-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link ComponentChanges }
     *
     */
    public void setComponentChanges(ComponentChanges value) {
        this.componentChanges = value;
    }

    /**
     * Ruft den Wert der attributeChanges-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link AttributeChanges }
     *
     */
    public AttributeChanges getAttributeChanges() {
        return attributeChanges;
    }

    /**
     * Legt den Wert der attributeChanges-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link AttributeChanges }
     *
     */
    public void setAttributeChanges(AttributeChanges value) {
        this.attributeChanges = value;
    }

    /**
     * Ruft den Wert der mappingChanges-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link MappingChanges }
     *
     */
    public MappingChanges getMappingChanges() {
        return mappingChanges;
    }

    /**
     * Legt den Wert der mappingChanges-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link MappingChanges }
     *
     */
    public void setMappingChanges(MappingChanges value) {
        this.mappingChanges = value;
    }

    /**
     * Ruft den Wert der fromVersion-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFromVersion() {
        return fromVersion;
    }

    /**
     * Legt den Wert der fromVersion-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFromVersion(String value) {
        this.fromVersion = value;
    }

    /**
     * Ruft den Wert der toVersion-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getToVersion() {
        return toVersion;
    }

    /**
     * Legt den Wert der toVersion-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setToVersion(String value) {
        this.toVersion = value;
    }

}
