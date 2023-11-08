
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for derivationControl.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="derivationControl">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     <enumeration value="substitution"/>
 *     <enumeration value="extension"/>
 *     <enumeration value="restriction"/>
 *     <enumeration value="list"/>
 *     <enumeration value="union"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "derivationControl", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlEnum
public enum DerivationControl {

    @XmlEnumValue("substitution")
    SUBSTITUTION("substitution"),
    @XmlEnumValue("extension")
    EXTENSION("extension"),
    @XmlEnumValue("restriction")
    RESTRICTION("restriction"),
    @XmlEnumValue("list")
    LIST("list"),
    @XmlEnumValue("union")
    UNION("union");
    private final String value;

    DerivationControl(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DerivationControl fromValue(String v) {
        for (DerivationControl c: DerivationControl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
