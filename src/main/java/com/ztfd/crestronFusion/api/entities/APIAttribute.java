//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.17 at 01:58:06 PM EDT 
//


package com.ztfd.crestronFusion.api.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for API_Attribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="API_Attribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttributeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttributeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttributeType" type="{http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities}API_Enum_AttributeType" minOccurs="0"/>
 *         &lt;element name="ButtonChangeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ButtonOffText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ButtonOnText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DefaultIOMask" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DefaultJoin" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DefaultMaxValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DefaultMinValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DefaultSlot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GraphicSetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LogDB" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LogNTEvent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LogRules" type="{http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities}ArrayOfAPI_AlertRule" minOccurs="0"/>
 *         &lt;element name="LogicOperator" type="{http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities}API_Enum_LogicalOperator" minOccurs="0"/>
 *         &lt;element name="Reserved" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="XmlName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "API_Attribute", propOrder = {
    "assetID",
    "attributeID",
    "attributeName",
    //"currentValue",
    "attributeType",
    "buttonChangeText",
    "buttonOffText",
    "buttonOnText",
    "_default",
    "defaultIOMask",
    "defaultJoin",
    "defaultMaxValue",
    "defaultMinValue",
    "defaultSlot",
    "graphicSetID",
    "lastModified",
    "logDB",
    "logNTEvent",
    "logRules",
    "logicOperator",
    "reserved",
    "xmlName"
})
@XmlRootElement(name="API_Attribute")
public class APIAttribute {

    @XmlElementRef(name = "AssetID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetID;
    @XmlElementRef(name = "AttributeID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> attributeID;
    //@XmlElementRef(name = "CurrentValue", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
   // protected JAXBElement<String> currentValue;
    @XmlElementRef(name = "AttributeName", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> attributeName;
    @XmlElement(name = "AttributeType")
    protected APIEnumAttributeType attributeType;
    @XmlElementRef(name = "ButtonChangeText", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buttonChangeText;
    @XmlElementRef(name = "ButtonOffText", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buttonOffText;
    @XmlElementRef(name = "ButtonOnText", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buttonOnText;
    @XmlElementRef(name = "Default", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> _default;
    @XmlElementRef(name = "DefaultIOMask", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> defaultIOMask;
    @XmlElementRef(name = "DefaultJoin", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> defaultJoin;
    @XmlElementRef(name = "DefaultMaxValue", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> defaultMaxValue;
    @XmlElementRef(name = "DefaultMinValue", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> defaultMinValue;
    @XmlElementRef(name = "DefaultSlot", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultSlot;
    @XmlElementRef(name = "GraphicSetID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> graphicSetID;
    @XmlElementRef(name = "LastModified", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastModified;
    @XmlElementRef(name = "LogDB", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> logDB;
    @XmlElementRef(name = "LogNTEvent", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> logNTEvent;
    @XmlElementRef(name = "LogRules", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAPIAlertRule> logRules;
    @XmlElement(name = "LogicOperator")
    protected APIEnumLogicalOperator logicOperator;
    @XmlElementRef(name = "Reserved", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> reserved;
    @XmlElementRef(name = "XmlName", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> xmlName;

    /**
     * Gets the value of the assetID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetID() {
        return assetID;
    }
    /**
     * Sets the value of the assetID property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAssetID(JAXBElement<String> value) {
        this.assetID = value;
    }

   /* *//**
     * Sets the value of the assetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     *//*
    public void setCurrentValue(JAXBElement<String> value) {
        this.currentValue = value;
    }
    *//**
     * Gets the value of the assetID property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     *//*
    public JAXBElement<String> getCurrentValue() {
        return currentValue;
    }
*/

    /**
     * Gets the value of the attributeID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAttributeID() {
        return attributeID;
    }

    /**
     * Sets the value of the attributeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttributeID(JAXBElement<String> value) {
        this.attributeID = value;
    }

    /**
     * Gets the value of the attributeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the value of the attributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttributeName(JAXBElement<String> value) {
        this.attributeName = value;
    }

    /**
     * Gets the value of the attributeType property.
     * 
     * @return
     *     possible object is
     *     {@link APIEnumAttributeType }
     *     
     */
    public APIEnumAttributeType getAttributeType() {
        return attributeType;
    }

    /**
     * Sets the value of the attributeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link APIEnumAttributeType }
     *     
     */
    public void setAttributeType(APIEnumAttributeType value) {
        this.attributeType = value;
    }

    /**
     * Gets the value of the buttonChangeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getButtonChangeText() {
        return buttonChangeText;
    }

    /**
     * Sets the value of the buttonChangeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setButtonChangeText(JAXBElement<String> value) {
        this.buttonChangeText = value;
    }

    /**
     * Gets the value of the buttonOffText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getButtonOffText() {
        return buttonOffText;
    }

    /**
     * Sets the value of the buttonOffText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setButtonOffText(JAXBElement<String> value) {
        this.buttonOffText = value;
    }

    /**
     * Gets the value of the buttonOnText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getButtonOnText() {
        return buttonOnText;
    }

    /**
     * Sets the value of the buttonOnText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setButtonOnText(JAXBElement<String> value) {
        this.buttonOnText = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDefault(JAXBElement<Boolean> value) {
        this._default = value;
    }

    /**
     * Gets the value of the defaultIOMask property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDefaultIOMask() {
        return defaultIOMask;
    }

    /**
     * Sets the value of the defaultIOMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDefaultIOMask(JAXBElement<Integer> value) {
        this.defaultIOMask = value;
    }

    /**
     * Gets the value of the defaultJoin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDefaultJoin() {
        return defaultJoin;
    }

    /**
     * Sets the value of the defaultJoin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDefaultJoin(JAXBElement<Integer> value) {
        this.defaultJoin = value;
    }

    /**
     * Gets the value of the defaultMaxValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDefaultMaxValue() {
        return defaultMaxValue;
    }

    /**
     * Sets the value of the defaultMaxValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDefaultMaxValue(JAXBElement<Integer> value) {
        this.defaultMaxValue = value;
    }

    /**
     * Gets the value of the defaultMinValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDefaultMinValue() {
        return defaultMinValue;
    }

    /**
     * Sets the value of the defaultMinValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDefaultMinValue(JAXBElement<Integer> value) {
        this.defaultMinValue = value;
    }

    /**
     * Gets the value of the defaultSlot property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultSlot() {
        return defaultSlot;
    }

    /**
     * Sets the value of the defaultSlot property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultSlot(JAXBElement<String> value) {
        this.defaultSlot = value;
    }

    /**
     * Gets the value of the graphicSetID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGraphicSetID() {
        return graphicSetID;
    }

    /**
     * Sets the value of the graphicSetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGraphicSetID(JAXBElement<String> value) {
        this.graphicSetID = value;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastModified(JAXBElement<XMLGregorianCalendar> value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the logDB property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLogDB() {
        return logDB;
    }

    /**
     * Sets the value of the logDB property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLogDB(JAXBElement<Boolean> value) {
        this.logDB = value;
    }

    /**
     * Gets the value of the logNTEvent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLogNTEvent() {
        return logNTEvent;
    }

    /**
     * Sets the value of the logNTEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLogNTEvent(JAXBElement<Boolean> value) {
        this.logNTEvent = value;
    }

    /**
     * Gets the value of the logRules property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAPIAlertRule }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAPIAlertRule> getLogRules() {
        return logRules;
    }

    /**
     * Sets the value of the logRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAPIAlertRule }{@code >}
     *     
     */
    public void setLogRules(JAXBElement<ArrayOfAPIAlertRule> value) {
        this.logRules = value;
    }

    /**
     * Gets the value of the logicOperator property.
     * 
     * @return
     *     possible object is
     *     {@link APIEnumLogicalOperator }
     *     
     */
    public APIEnumLogicalOperator getLogicOperator() {
        return logicOperator;
    }

    /**
     * Sets the value of the logicOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link APIEnumLogicalOperator }
     *     
     */
    public void setLogicOperator(APIEnumLogicalOperator value) {
        this.logicOperator = value;
    }

    /**
     * Gets the value of the reserved property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getReserved() {
        return reserved;
    }

    /**
     * Sets the value of the reserved property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setReserved(JAXBElement<Boolean> value) {
        this.reserved = value;
    }

    /**
     * Gets the value of the xmlName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getXmlName() {
        return xmlName;
    }

    /**
     * Sets the value of the xmlName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setXmlName(JAXBElement<String> value) {
        this.xmlName = value;
    }

}
