
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}numFacet">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "totalDigits", namespace = "http://www.w3.org/2001/XMLSchema")
public class TotalDigits
    extends NumFacet
{


}
