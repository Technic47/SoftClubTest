
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for realGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="realGroup">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}group">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *         <choice minOccurs="0">
 *           <element ref="{http://www.w3.org/2001/XMLSchema}all"/>
 *           <element ref="{http://www.w3.org/2001/XMLSchema}choice"/>
 *           <element ref="{http://www.w3.org/2001/XMLSchema}sequence"/>
 *         </choice>
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
@XmlType(name = "realGroup", namespace = "http://www.w3.org/2001/XMLSchema")
@XmlSeeAlso({
    NamedGroup.class,
    GroupRef.class
})
public class RealGroup
    extends Group
{


}
