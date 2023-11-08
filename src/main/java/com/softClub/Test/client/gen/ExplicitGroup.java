
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 *    group type for the three kinds of group
 * 
 * <p>Java class for explicitGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="explicitGroup">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}group">
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
@XmlType(name = "explicitGroup", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlSeeAlso({
    All.class,
    SimpleExplicitGroup.class
})
public class ExplicitGroup
    extends Group
{


}
