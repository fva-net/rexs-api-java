//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2024.05.06 um 08:21:36 AM CEST
//


package info.rexs.db.jaxb;

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
 *         &lt;element ref="{}units" minOccurs="0"/&gt;
 *         &lt;element ref="{}valueTypes" minOccurs="0"/&gt;
 *         &lt;element ref="{}components" minOccurs="0"/&gt;
 *         &lt;element ref="{}attributes" minOccurs="0"/&gt;
 *         &lt;element ref="{}componentAttributeMappings" minOccurs="0"/&gt;
 *         &lt;element ref="{}relations" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="status" use="required" type="{}versionStatusType" /&gt;
 *       &lt;attribute name="createdDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="provider" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "units",
    "valueTypes",
    "components",
    "attributes",
    "componentAttributeMappings",
    "relations"
})
@XmlRootElement(name = "rexsModel")
public class RexsModel {

    protected Units units;
    protected ValueTypes valueTypes;
    protected Components components;
    protected Attributes attributes;
    protected ComponentAttributeMappings componentAttributeMappings;
    protected Relations relations;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "status", required = true)
    protected VersionStatusType status;
    @XmlAttribute(name = "createdDate", required = true)
    protected String createdDate;
    @XmlAttribute(name = "provider")
    protected String provider;

    /**
     * Ruft den Wert der units-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Units }
     *
     */
    public Units getUnits() {
        return units;
    }

    /**
     * Legt den Wert der units-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Units }
     *
     */
    public void setUnits(Units value) {
        this.units = value;
    }

    /**
     * Ruft den Wert der valueTypes-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link ValueTypes }
     *
     */
    public ValueTypes getValueTypes() {
        return valueTypes;
    }

    /**
     * Legt den Wert der valueTypes-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link ValueTypes }
     *
     */
    public void setValueTypes(ValueTypes value) {
        this.valueTypes = value;
    }

    /**
     * Ruft den Wert der components-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Components }
     *
     */
    public Components getComponents() {
        return components;
    }

    /**
     * Legt den Wert der components-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Components }
     *
     */
    public void setComponents(Components value) {
        this.components = value;
    }

    /**
     * Ruft den Wert der attributes-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Attributes }
     *
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Legt den Wert der attributes-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Attributes }
     *
     */
    public void setAttributes(Attributes value) {
        this.attributes = value;
    }

    /**
     * Ruft den Wert der componentAttributeMappings-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link ComponentAttributeMappings }
     *
     */
    public ComponentAttributeMappings getComponentAttributeMappings() {
        return componentAttributeMappings;
    }

    /**
     * Legt den Wert der componentAttributeMappings-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link ComponentAttributeMappings }
     *
     */
    public void setComponentAttributeMappings(ComponentAttributeMappings value) {
        this.componentAttributeMappings = value;
    }

    /**
     * Ruft den Wert der relations-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Relations }
     *
     */
    public Relations getRelations() {
        return relations;
    }

    /**
     * Legt den Wert der relations-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Relations }
     *
     */
    public void setRelations(Relations value) {
        this.relations = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Ruft den Wert der status-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link VersionStatusType }
     *
     */
    public VersionStatusType getStatus() {
        return status;
    }

    /**
     * Legt den Wert der status-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link VersionStatusType }
     *
     */
    public void setStatus(VersionStatusType value) {
        this.status = value;
    }

    /**
     * Ruft den Wert der createdDate-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Legt den Wert der createdDate-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreatedDate(String value) {
        this.createdDate = value;
    }

    /**
     * Ruft den Wert der provider-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Legt den Wert der provider-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProvider(String value) {
        this.provider = value;
    }

}
