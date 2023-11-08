
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for namedAttributeGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="namedAttributeGroup">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}attributeGroup">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <group ref="{http://www.w3.org/2001/XMLSchema}attrDecls"/>
 *       </sequence>
 *       <attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "namedAttributeGroup", namespace = "http://www.w3.org/2001/XMLSchema")
public class NamedAttributeGroup
    extends AttributeGroup
{


}
