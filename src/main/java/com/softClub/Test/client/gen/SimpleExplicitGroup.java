
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpleExplicitGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="simpleExplicitGroup">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}explicitGroup">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <group ref="{http://www.w3.org/2001/XMLSchema}nestedParticle" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "simpleExplicitGroup", namespace = "http://www.w3.org/2001/XMLSchema")
public class SimpleExplicitGroup
    extends ExplicitGroup
{


}
