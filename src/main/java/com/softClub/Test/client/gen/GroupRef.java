
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="groupRef">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}realGroup">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupRef", namespace = "http://www.w3.org/2001/XMLSchema")
public class GroupRef
    extends RealGroup
{


}
