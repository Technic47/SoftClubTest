
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
 *         <element name="GetLatestDateTimeSeldResult" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "getLatestDateTimeSeldResult"
})
@XmlRootElement(name = "GetLatestDateTimeSeldResponse")
public class GetLatestDateTimeSeldResponse {

    @XmlElement(name = "GetLatestDateTimeSeldResult", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar getLatestDateTimeSeldResult;

    /**
     * Gets the value of the getLatestDateTimeSeldResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGetLatestDateTimeSeldResult() {
        return getLatestDateTimeSeldResult;
    }

    /**
     * Sets the value of the getLatestDateTimeSeldResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGetLatestDateTimeSeldResult(XMLGregorianCalendar value) {
        this.getLatestDateTimeSeldResult = value;
    }

}
