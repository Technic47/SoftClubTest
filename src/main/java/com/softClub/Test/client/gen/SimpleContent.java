
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
 *     <extension base="{http://www.w3.org/2001/XMLSchema}annotated">
 *       <choice>
 *         <element name="restriction" type="{http://www.w3.org/2001/XMLSchema}simpleRestrictionType"/>
 *         <element name="extension" type="{http://www.w3.org/2001/XMLSchema}simpleExtensionType"/>
 *       </choice>
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "restriction",
    "extension"
})
@XmlRootElement(name = "simpleContent", namespace = "http://www.w3.org/2001/XMLSchema")
public class SimpleContent
    extends Annotated
{

    @XmlElement(namespace = "http://www.w3.org/2001/XMLSchema")
    protected SimpleRestrictionType restriction;
    @XmlElement(namespace = "http://www.w3.org/2001/XMLSchema")
    protected SimpleExtensionType extension;

    /**
     * Gets the value of the restriction property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleRestrictionType }
     *     
     */
    public SimpleRestrictionType getRestriction() {
        return restriction;
    }

    /**
     * Sets the value of the restriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleRestrictionType }
     *     
     */
    public void setRestriction(SimpleRestrictionType value) {
        this.restriction = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleExtensionType }
     *     
     */
    public SimpleExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleExtensionType }
     *     
     */
    public void setExtension(SimpleExtensionType value) {
        this.extension = value;
    }

}
