
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 *    Only elements allowed inside
 * 
 * <p>Java class for all complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="all">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}explicitGroup">
 *       <group ref="{http://www.w3.org/2001/XMLSchema}allModel"/>
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
@XmlType(name = "all", namespace = "http://www.w3.org/2001/XMLSchema")
public class All
    extends ExplicitGroup
{


}
