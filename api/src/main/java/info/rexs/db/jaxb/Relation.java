//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2024.05.06 um 08:21:36 AM CEST
//


package info.rexs.db.jaxb;

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
 *         &lt;element ref="{}roles" minOccurs="0"/&gt;
 *         &lt;element ref="{}allowedCombinations" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numericId" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="relationId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="orderRequired" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
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
    "roles",
    "allowedCombinations"
})
@XmlRootElement(name = "relation")
public class Relation {

    protected Roles roles;
    protected AllowedCombinations allowedCombinations;
    @XmlAttribute(name = "numericId", required = true)
    protected BigInteger numericId;
    @XmlAttribute(name = "relationId", required = true)
    protected String relationId;
    @XmlAttribute(name = "orderRequired", required = true)
    protected boolean orderRequired;
    @XmlAttribute(name = "databaseId")
    protected BigInteger databaseId;

    /**
     * Ruft den Wert der roles-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link Roles }
     *
     */
    public Roles getRoles() {
        return roles;
    }

    /**
     * Legt den Wert der roles-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link Roles }
     *
     */
    public void setRoles(Roles value) {
        this.roles = value;
    }

    /**
     * Ruft den Wert der allowedCombinations-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link AllowedCombinations }
     *
     */
    public AllowedCombinations getAllowedCombinations() {
        return allowedCombinations;
    }

    /**
     * Legt den Wert der allowedCombinations-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link AllowedCombinations }
     *
     */
    public void setAllowedCombinations(AllowedCombinations value) {
        this.allowedCombinations = value;
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
     * Ruft den Wert der relationId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * Legt den Wert der relationId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRelationId(String value) {
        this.relationId = value;
    }

    /**
     * Ruft den Wert der orderRequired-Eigenschaft ab.
     *
     */
    public boolean isOrderRequired() {
        return orderRequired;
    }

    /**
     * Legt den Wert der orderRequired-Eigenschaft fest.
     *
     */
    public void setOrderRequired(boolean value) {
        this.orderRequired = value;
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
