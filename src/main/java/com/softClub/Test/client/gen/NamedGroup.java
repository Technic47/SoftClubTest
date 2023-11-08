
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for namedGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="namedGroup">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}realGroup">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <choice>
 *           <element name="all">
 *             <complexType>
 *               <complexContent>
 *                 <restriction base="{http://www.w3.org/2001/XMLSchema}all">
 *                   <group ref="{http://www.w3.org/2001/XMLSchema}allModel"/>
 *                   <anyAttribute processContents='lax' namespace='##other'/>
 *                 </restriction>
 *               </complexContent>
 *             </complexType>
 *           </element>
 *           <element name="choice" type="{http://www.w3.org/2001/XMLSchema}simpleExplicitGroup"/>
 *           <element name="sequence" type="{http://www.w3.org/2001/XMLSchema}simpleExplicitGroup"/>
 *         </choice>
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
@XmlType(name = "namedGroup", namespace = "http://www.w3.org/2001/XMLSchema")
public class NamedGroup
    extends RealGroup
{


}
