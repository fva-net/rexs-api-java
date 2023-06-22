//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.08.04 um 12:41:51 PM CEST 
//


package info.rexs.model.jaxb;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für codeType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
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
