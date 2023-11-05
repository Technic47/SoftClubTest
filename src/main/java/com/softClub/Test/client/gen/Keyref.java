
package com.softClub.Test.client.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}keybase"&gt;
 *       &lt;attribute name="refer" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "keyref", namespace = "http://www.w3.org/2001/XMLSchema")
public class Keyref
    extends Keybase
{

    @XmlAttribute(name = "refer", required = true)
    protected QName refer;

    /**
     * Gets the value of the refer property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRefer() {
        return refer;
    }

    /**
     * Sets the value of the refer property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRefer(QName value) {
        this.refer = value;
    }

}