
package com.softClub.Test.client.gen;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="GetLatestDateTimeResult" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getLatestDateTimeResult"
})
@XmlRootElement(name = "GetLatestDateTimeResponse")
public class GetLatestDateTimeResponse {

    @XmlElement(name = "GetLatestDateTimeResult", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar getLatestDateTimeResult;

    /**
     * Gets the value of the getLatestDateTimeResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGetLatestDateTimeResult() {
        return getLatestDateTimeResult;
    }

    /**
     * Sets the value of the getLatestDateTimeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGetLatestDateTimeResult(XMLGregorianCalendar value) {
        this.getLatestDateTimeResult = value;
    }

}
