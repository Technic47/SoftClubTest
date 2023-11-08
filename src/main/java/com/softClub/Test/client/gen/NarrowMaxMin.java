
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * restricted max/min
 * 
 * <p>Java class for narrowMaxMin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="narrowMaxMin">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}localElement">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <choice minOccurs="0">
 *           <element name="simpleType" type="{http://www.w3.org/2001/XMLSchema}localSimpleType"/>
 *           <element name="complexType" type="{http://www.w3.org/2001/XMLSchema}localComplexType"/>
 *         </choice>
 *         <group ref="{http://www.w3.org/2001/XMLSchema}identityConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="minOccurs" default="1">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *             <enumeration value="0"/>
 *             <enumeration value="1"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="maxOccurs" default="1">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}allNNI">
 *             <enumeration value="0"/>
 *             <enumeration value="1"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "narrowMaxMin", namespace = "http://www.w3.org/2001/XMLSchema")
public class NarrowMaxMin
    extends LocalElement
{


}
