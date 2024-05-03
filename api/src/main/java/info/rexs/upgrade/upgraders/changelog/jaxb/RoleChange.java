//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2024.05.06 um 08:21:36 AM CEST
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
 *         &lt;element ref="{}changedValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" use="required" type="{}changeType" /&gt;
 *       &lt;attribute name="roleId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "changedValues"
})
@XmlRootElement(name = "roleChange")
public class RoleChange {

    protected ChangedValues changedValues;
    @XmlAttribute(name = "type", required = true)
    protected ChangeType type;
    @XmlAttribute(name = "roleId", required = true)
    protected String roleId;

    /**
     * Ruft den Wert der changedValues-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link ChangedValues }
     *
     */
    public ChangedValues getChangedValues() {
        return changedValues;
    }

    /**
     * Legt den Wert der changedValues-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link ChangedValues }
     *
     */
    public void setChangedValues(ChangedValues value) {
        this.changedValues = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link ChangeType }
     *
     */
    public ChangeType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link ChangeType }
     *
     */
    public void setType(ChangeType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der roleId-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Legt den Wert der roleId-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRoleId(String value) {
        this.roleId = value;
    }

}
