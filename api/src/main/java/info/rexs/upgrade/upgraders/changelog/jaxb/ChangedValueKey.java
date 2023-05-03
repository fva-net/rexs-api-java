//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2023.05.03 um 12:26:13 PM CEST
//


package info.rexs.upgrade.upgraders.changelog.jaxb;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für changedValueKey.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <pre>
 * &lt;simpleType name="changedValueKey"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="componentId"/&gt;
 *     &lt;enumeration value="attributeId"/&gt;
 *     &lt;enumeration value="numericId"/&gt;
 *     &lt;enumeration value="valuetype"/&gt;
 *     &lt;enumeration value="unit"/&gt;
 *     &lt;enumeration value="symbol"/&gt;
 *     &lt;enumeration value="range"/&gt;
 *     &lt;enumeration value="rangeMin"/&gt;
 *     &lt;enumeration value="rangeMinIntervalOpen"/&gt;
 *     &lt;enumeration value="rangeMax"/&gt;
 *     &lt;enumeration value="rangeMaxIntervalOpen"/&gt;
 *     &lt;enumeration value="enumvalues"/&gt;
 *     &lt;enumeration value="value"/&gt;
 *     &lt;enumeration value="name"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "changedValueKey")
@XmlEnum
public enum ChangedValueKey {

    @XmlEnumValue("componentId")
    COMPONENT_ID("componentId"),
    @XmlEnumValue("attributeId")
    ATTRIBUTE_ID("attributeId"),
    @XmlEnumValue("numericId")
    NUMERIC_ID("numericId"),
    @XmlEnumValue("valuetype")
    VALUETYPE("valuetype"),
    @XmlEnumValue("unit")
    UNIT("unit"),
    @XmlEnumValue("symbol")
    SYMBOL("symbol"),
    @XmlEnumValue("range")
    RANGE("range"),
    @XmlEnumValue("rangeMin")
    RANGE_MIN("rangeMin"),
    @XmlEnumValue("rangeMinIntervalOpen")
    RANGE_MIN_INTERVAL_OPEN("rangeMinIntervalOpen"),
    @XmlEnumValue("rangeMax")
    RANGE_MAX("rangeMax"),
    @XmlEnumValue("rangeMaxIntervalOpen")
    RANGE_MAX_INTERVAL_OPEN("rangeMaxIntervalOpen"),
    @XmlEnumValue("enumvalues")
    ENUMVALUES("enumvalues"),
    @XmlEnumValue("value")
    VALUE("value"),
    @XmlEnumValue("name")
    NAME("name");
    private final String value;

    ChangedValueKey(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChangedValueKey fromValue(String v) {
        for (ChangedValueKey c: ChangedValueKey.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
