//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.08.01 at 10:29:01 AM CEST 
//


package info.rexs.upgrade.upgraders.changelog.jaxb;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the main.java.info.rexs.upgrade.upgraders.changelog.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: main.java.info.rexs.upgrade.upgraders.changelog.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RexsChangelog }
     * 
     */
    public RexsChangelog createRexsChangelog() {
        return new RexsChangelog();
    }

    /**
     * Create an instance of {@link ComponentChanges }
     * 
     */
    public ComponentChanges createComponentChanges() {
        return new ComponentChanges();
    }

    /**
     * Create an instance of {@link ComponentChange }
     * 
     */
    public ComponentChange createComponentChange() {
        return new ComponentChange();
    }

    /**
     * Create an instance of {@link ChangedValues }
     * 
     */
    public ChangedValues createChangedValues() {
        return new ChangedValues();
    }

    /**
     * Create an instance of {@link ChangedValue }
     * 
     */
    public ChangedValue createChangedValue() {
        return new ChangedValue();
    }

    /**
     * Create an instance of {@link EnumValueChanges }
     * 
     */
    public EnumValueChanges createEnumValueChanges() {
        return new EnumValueChanges();
    }

    /**
     * Create an instance of {@link EnumValueChange }
     * 
     */
    public EnumValueChange createEnumValueChange() {
        return new EnumValueChange();
    }

    /**
     * Create an instance of {@link AttributeChanges }
     * 
     */
    public AttributeChanges createAttributeChanges() {
        return new AttributeChanges();
    }

    /**
     * Create an instance of {@link AttributeChange }
     * 
     */
    public AttributeChange createAttributeChange() {
        return new AttributeChange();
    }

    /**
     * Create an instance of {@link MappingChanges }
     * 
     */
    public MappingChanges createMappingChanges() {
        return new MappingChanges();
    }

    /**
     * Create an instance of {@link MappingChange }
     * 
     */
    public MappingChange createMappingChange() {
        return new MappingChange();
    }

}
