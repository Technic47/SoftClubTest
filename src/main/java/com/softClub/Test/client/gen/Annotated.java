
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *        This type is extended by all types which allow annotation
 *        other than <schema> itself
 *      
 * 
 * <p>Java class for annotated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="annotated">
 *   <complexContent>
 *     <extension base="{http://www.w3.org/2001/XMLSchema}openAttrs">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annotated", namespace = "http://www.w3.org/2001/XMLSchema", propOrder = {
    "annotation"
})
@XmlSeeAlso({
    ExtensionType.class,
    Attribute.class,
    ComplexType.class,
    RestrictionType.class,
    Group.class,
    Element.class,
    AttributeGroup.class,
    SimpleType.class,
    Union.class,
    List.class,
    Facet.class,
    Restriction.class,
    Keybase.class,
    Field.class,
    Selector.class,
    Wildcard.class,
    SimpleContent.class,
    ComplexContent.class,
    Notation.class,
    Import.class,
    Include.class
})
public class Annotated
    extends OpenAttrs
{

    protected Annotation annotation;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
