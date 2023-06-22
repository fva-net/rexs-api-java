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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}load_case" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}accumulation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loadCase",
    "accumulation"
})
@XmlRootElement(name = "load_spectrum")
public class LoadSpectrum {

    @XmlElement(name = "load_case", required = true)
    protected List<LoadCase> loadCase;
    protected Accumulation accumulation;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(IntegerAdapter .class)
    @XmlSchemaType(name = "integer")
    protected Integer id;

    /**
     * Gets the value of the loadCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoadCase }
     * 
     * 
     */
    public List<LoadCase> getLoadCase() {
        if (loadCase == null) {
            loadCase = new ArrayList<LoadCase>();
        }
        return this.loadCase;
    }

    /**
     * Ruft den Wert der accumulation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Accumulation }
     *     
     */
    public Accumulation getAccumulation() {
        return accumulation;
    }

    /**
     * Legt den Wert der accumulation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Accumulation }
     *     
     */
    public void setAccumulation(Accumulation value) {
        this.accumulation = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

}
