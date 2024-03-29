//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.17 at 01:58:06 PM EDT 
//


package com.ztfd.crestronFusion.api.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for API_PresetField complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="API_PresetField">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FieldLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FieldSlot" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FieldValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaximumFields" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "API_PresetField", propOrder = {
    "fieldLabel",
    "fieldSlot",
    "fieldValue",
    "maximumFields"
})
public class APIPresetField {

    @XmlElementRef(name = "FieldLabel", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fieldLabel;
    @XmlElementRef(name = "FieldSlot", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> fieldSlot;
    @XmlElementRef(name = "FieldValue", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fieldValue;
    @XmlElementRef(name = "MaximumFields", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> maximumFields;

    /**
     * Gets the value of the fieldLabel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFieldLabel() {
        return fieldLabel;
    }

    /**
     * Sets the value of the fieldLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFieldLabel(JAXBElement<String> value) {
        this.fieldLabel = value;
    }

    /**
     * Gets the value of the fieldSlot property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getFieldSlot() {
        return fieldSlot;
    }

    /**
     * Sets the value of the fieldSlot property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setFieldSlot(JAXBElement<Integer> value) {
        this.fieldSlot = value;
    }

    /**
     * Gets the value of the fieldValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFieldValue() {
        return fieldValue;
    }

    /**
     * Sets the value of the fieldValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFieldValue(JAXBElement<String> value) {
        this.fieldValue = value;
    }

    /**
     * Gets the value of the maximumFields property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMaximumFields() {
        return maximumFields;
    }

    /**
     * Sets the value of the maximumFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMaximumFields(JAXBElement<Integer> value) {
        this.maximumFields = value;
    }

}
