//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2024.05.06 um 08:21:36 AM CEST
//


package info.rexs.upgrade.upgraders.changelog.jaxb;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}relationChange" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "relationChange"
})
@XmlRootElement(name = "relationChanges")
public class RelationChanges {

    protected List<RelationChange> relationChange;

    /**
     * Gets the value of the relationChange property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationChange property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationChange().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelationChange }
     *
     *
     */
    public List<RelationChange> getRelationChange() {
        if (relationChange == null) {
            relationChange = new ArrayList<RelationChange>();
        }
        return this.relationChange;
    }

}
