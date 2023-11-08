
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for noFixedFacet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="noFixedFacet">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}facet">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
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
@XmlType(name = "noFixedFacet", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlSeeAlso({
    Pattern.class
})
public class NoFixedFacet
    extends Facet
{


}
