//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.08.19 um 03:16:48 PM CEST
//


package info.rexs.model.jaxb;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}relations" minOccurs="0"/&gt;
 *         &lt;element ref="{}components" minOccurs="0"/&gt;
 *         &lt;element ref="{}load_spectrum" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="applicationId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="applicationVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="applicationLanguage" use="optional" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "relations",
    "components",
    "loadSpectrum"
})
@XmlRootElement(name = "model")
public class Model {

    protected Relations relations;
    protected Components components;
    @XmlElement(name = "load_spectrum")
    protected List<LoadSpectrum> loadSpectrum;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "applicationId", required = true)
    protected String applicationId;
    @XmlAttribute(name = "applicationVersion", required = true)
    protected String applicationVersion;
    @XmlAttribute(name = "date", required = true)
    protected String date;
    @XmlAttribute(name = "applicationLanguage", required = false)
    protected String applicationLanguage;

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
     * Gets the value of the loadSpectrum property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadSpectrum property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadSpectrum().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoadSpectrum }
     *
     *
     */
    public List<LoadSpectrum> getLoadSpectrum() {
        if (loadSpectrum == null) {
            loadSpectrum = new ArrayList<>();
        }
        return this.loadSpectrum;
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
     * Ruft den Wert der applicationId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Legt den Wert der applicationId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplicationId(String value) {
        this.applicationId = value;
    }

    /**
     * Ruft den Wert der applicationVersion-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplicationVersion() {
        return applicationVersion;
    }

    /**
     * Legt den Wert der applicationVersion-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplicationVersion(String value) {
        this.applicationVersion = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der applicationLanguage-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplicationLanguage() {
        return applicationLanguage;
    }

    /**
     * Legt den Wert der applicationLanguage-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplicationLanguage(String value) {
        this.applicationLanguage = value;
    }

	public void setLoadSpectrum(LoadSpectrum loadSpectrum) {
		this.loadSpectrum = new ArrayList<>();
		this.loadSpectrum.add(loadSpectrum);
	}
}
