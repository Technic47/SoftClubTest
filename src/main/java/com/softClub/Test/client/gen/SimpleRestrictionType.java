
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpleRestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="simpleRestrictionType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}restrictionType">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <choice minOccurs="0">
 *           <group ref="{http://www.w3.org/2001/XMLSchema}simpleRestrictionModel"/>
 *         </choice>
 *         <group ref="{http://www.w3.org/2001/XMLSchema}attrDecls"/>
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
@XmlType(name = "simpleRestrictionType", namespace = "http://www.w3.org/2001/XMLSchema")
public class SimpleRestrictionType
    extends RestrictionType
{


}
