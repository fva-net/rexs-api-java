//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v2.3.7 generiert
// Siehe https://eclipse-ee4j.github.io/jaxb-ri
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2023.05.03 um 12:26:13 PM CEST
//


package info.rexs.model.jaxb;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für codeType.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <pre>
 * &lt;simpleType name="codeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="int32"/&gt;
 *     &lt;enumeration value="float64"/&gt;
 *     &lt;enumeration value="float32"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "codeType")
@XmlEnum
public enum CodeType {

    @XmlEnumValue("int32")
    INT_32("int32"),
    @XmlEnumValue("float64")
    FLOAT_64("float64"),
    @XmlEnumValue("float32")
    FLOAT_32("float32");
    private final String value;

    CodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CodeType fromValue(String v) {
        for (CodeType c: CodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
