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
 * <p>Java class for API_Symbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="API_Symbol">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConnectInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IPID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LastModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="NodeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NodeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Signals" type="{http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities}ArrayOfAPI_Signal" minOccurs="0"/>
 *         &lt;element name="SymbolID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SymbolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseSSL" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "API_Symbol", propOrder = {
    "connectInfo",
    "ipid",
    "lastModified",
    "nodeID",
    "nodeText",
    "password",
    "processorID",
    "processorName",
    "roomID",
    "signals",
    "symbolID",
    "symbolName",
    "useSSL",
    "userName",
    "version"
})

@XmlRootElement(name="API_Symbol")
public class APISymbol {

    @XmlElementRef(name = "ConnectInfo", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> connectInfo;
    @XmlElementRef(name = "IPID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> ipid;
    @XmlElementRef(name = "LastModified", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastModified;
    @XmlElementRef(name = "NodeID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeID;
    @XmlElementRef(name = "NodeText", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeText;
    @XmlElementRef(name = "Password", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "ProcessorID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processorID;
    @XmlElementRef(name = "ProcessorName", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processorName;
    @XmlElementRef(name = "RoomID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> roomID;
    @XmlElementRef(name = "Signals", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAPISignal> signals;
    @XmlElementRef(name = "SymbolID", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolID;
    @XmlElementRef(name = "SymbolName", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> symbolName;
    @XmlElementRef(name = "UseSSL", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> useSSL;
    @XmlElementRef(name = "UserName", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userName;
    @XmlElementRef(name = "Version", namespace = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> version;

    /**
     * Gets the value of the connectInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConnectInfo() {
        return connectInfo;
    }

    /**
     * Sets the value of the connectInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConnectInfo(JAXBElement<String> value) {
        this.connectInfo = value;
    }

    /**
     * Gets the value of the ipid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIPID() {
        return ipid;
    }

    /**
     * Sets the value of the ipid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIPID(JAXBElement<Integer> value) {
        this.ipid = value;
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
     * Gets the value of the nodeID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeID() {
        return nodeID;
    }

    /**
     * Sets the value of the nodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeID(JAXBElement<String> value) {
        this.nodeID = value;
    }

    /**
     * Gets the value of the nodeText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeText() {
        return nodeText;
    }

    /**
     * Sets the value of the nodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeText(JAXBElement<String> value) {
        this.nodeText = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassword(JAXBElement<String> value) {
        this.password = value;
    }

    /**
     * Gets the value of the processorID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessorID() {
        return processorID;
    }

    /**
     * Sets the value of the processorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessorID(JAXBElement<String> value) {
        this.processorID = value;
    }

    /**
     * Gets the value of the processorName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessorName() {
        return processorName;
    }

    /**
     * Sets the value of the processorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessorName(JAXBElement<String> value) {
        this.processorName = value;
    }

    /**
     * Gets the value of the roomID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoomID() {
        return roomID;
    }

    /**
     * Sets the value of the roomID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoomID(JAXBElement<String> value) {
        this.roomID = value;
    }

    /**
     * Gets the value of the signals property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAPISignal }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAPISignal> getSignals() {
        return signals;
    }

    /**
     * Sets the value of the signals property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAPISignal }{@code >}
     *     
     */
    public void setSignals(JAXBElement<ArrayOfAPISignal> value) {
        this.signals = value;
    }

    /**
     * Gets the value of the symbolID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolID() {
        return symbolID;
    }

    /**
     * Sets the value of the symbolID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolID(JAXBElement<String> value) {
        this.symbolID = value;
    }

    /**
     * Gets the value of the symbolName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSymbolName() {
        return symbolName;
    }

    /**
     * Sets the value of the symbolName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSymbolName(JAXBElement<String> value) {
        this.symbolName = value;
    }

    /**
     * Gets the value of the useSSL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getUseSSL() {
        return useSSL;
    }

    /**
     * Sets the value of the useSSL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setUseSSL(JAXBElement<Boolean> value) {
        this.useSSL = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserName(JAXBElement<String> value) {
        this.userName = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersion(JAXBElement<String> value) {
        this.version = value;
    }

}
