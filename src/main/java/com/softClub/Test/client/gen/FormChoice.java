
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for formChoice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="formChoice">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     <enumeration value="qualified"/>
 *     <enumeration value="unqualified"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "formChoice", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlEnum
public enum FormChoice {

    @XmlEnumValue("qualified")
    QUALIFIED("qualified"),
    @XmlEnumValue("unqualified")
    UNQUALIFIED("unqualified");
    private final String value;

    FormChoice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FormChoice fromValue(String v) {
        for (FormChoice c: FormChoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
