
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for localElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="localElement">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}element">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <choice minOccurs="0">
 *           <element name="simpleType" type="{http://www.w3.org/2001/XMLSchema}localSimpleType"/>
 *           <element name="complexType" type="{http://www.w3.org/2001/XMLSchema}localComplexType"/>
 *         </choice>
 *         <group ref="{http://www.w3.org/2001/XMLSchema}identityConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localElement", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlSeeAlso({
    NarrowMaxMin.class
})
public class LocalElement
    extends Element
{


}
