
package com.softClub.Test.client.gen;

import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for simpleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}annotated"&gt;
 *       &lt;group ref="{http://www.w3.org/2001/XMLSchema}simpleDerivation"/&gt;
 *       &lt;attribute name="final" type="{http://www.w3.org/2001/XMLSchema}simpleDerivationSet" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleType", namespace = "http://www.w3.org/2001/XMLSchema", propOrder = {
    "restriction",
    "list",
    "union"
})
@XmlSeeAlso({
    TopLevelSimpleType.class,
    LocalSimpleType.class
})
public abstract class SimpleType
    extends Annotated
{

    protected Restriction restriction;
    protected com.softClub.Test.client.gen.List list;
    protected Union union;
    @XmlAttribute(name = "final")
    @XmlSchemaType(name = "simpleDerivationSet")
    protected java.util.List<String> _final;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the restriction property.
     * 
     * @return
     *     possible object is
     *     {@link Restriction }
     *     
     */
    public Restriction getRestriction() {
        return restriction;
    }

    /**
     * Sets the value of the restriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restriction }
     *     
     */
    public void setRestriction(Restriction value) {
        this.restriction = value;
    }

    /**
     * Gets the value of the list property.
     * 
     * @return
     *     possible object is
     *     {@link com.softClub.Test.client.gen.List }
     *     
     */
    public com.softClub.Test.client.gen.List getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.softClub.Test.client.gen.List }
     *     
     */
    public void setList(com.softClub.Test.client.gen.List value) {
        this.list = value;
    }

    /**
     * Gets the value of the union property.
     * 
     * @return
     *     possible object is
     *     {@link Union }
     *     
     */
    public Union getUnion() {
        return union;
    }

    /**
     * Sets the value of the union property.
     * 
     * @param value
     *     allowed object is
     *     {@link Union }
     *     
     */
    public void setUnion(Union value) {
        this.union = value;
    }

    /**
     * Gets the value of the final property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the final property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public java.util.List<String> getFinal() {
        if (_final == null) {
            _final = new ArrayList<String>();
        }
        return this._final;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
