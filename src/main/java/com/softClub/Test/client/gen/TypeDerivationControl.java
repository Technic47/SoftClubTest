
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeDerivationControl.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="typeDerivationControl">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}derivationControl">
 *     <enumeration value="extension"/>
 *     <enumeration value="restriction"/>
 *     <enumeration value="list"/>
 *     <enumeration value="union"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "typeDerivationControl", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlEnum(DerivationControl.class)
public enum TypeDerivationControl {

    @XmlEnumValue("extension")
    EXTENSION(DerivationControl.EXTENSION),
    @XmlEnumValue("restriction")
    RESTRICTION(DerivationControl.RESTRICTION),
    @XmlEnumValue("list")
    LIST(DerivationControl.LIST),
    @XmlEnumValue("union")
    UNION(DerivationControl.UNION);
    private final DerivationControl value;

    TypeDerivationControl(DerivationControl v) {
        value = v;
    }

    public DerivationControl value() {
        return value;
    }

    public static TypeDerivationControl fromValue(DerivationControl v) {
        for (TypeDerivationControl c: TypeDerivationControl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
