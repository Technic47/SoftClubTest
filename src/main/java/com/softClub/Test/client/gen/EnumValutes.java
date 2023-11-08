
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Seld" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "seld"
})
@XmlRootElement(name = "EnumValutes")
public class EnumValutes {

    @XmlElement(name = "Seld")
    protected boolean seld;

    /**
     * Gets the value of the seld property.
     * 
     */
    public boolean isSeld() {
        return seld;
    }

    /**
     * Sets the value of the seld property.
     * 
     */
    public void setSeld(boolean value) {
        this.seld = value;
    }

}
