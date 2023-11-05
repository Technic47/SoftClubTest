
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetLatestDateSeldResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getLatestDateSeldResult"
})
@XmlRootElement(name = "GetLatestDateSeldResponse")
public class GetLatestDateSeldResponse {

    @XmlElement(name = "GetLatestDateSeldResult")
    protected String getLatestDateSeldResult;

    /**
     * Gets the value of the getLatestDateSeldResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetLatestDateSeldResult() {
        return getLatestDateSeldResult;
    }

    /**
     * Sets the value of the getLatestDateSeldResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetLatestDateSeldResult(String value) {
        this.getLatestDateSeldResult = value;
    }

}
