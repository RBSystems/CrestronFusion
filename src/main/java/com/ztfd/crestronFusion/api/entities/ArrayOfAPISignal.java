//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.17 at 01:58:06 PM EDT 
//


package com.ztfd.crestronFusion.api.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAPI_Signal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAPI_Signal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="API_Signal" type="{http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities}API_Signal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAPI_Signal", propOrder = {
    "apiSignal"
})
public class ArrayOfAPISignal {

    @XmlElement(name = "API_Signal", nillable = true)
    protected List<APISignal> apiSignal;

    /**
     * Gets the value of the apiSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAPISignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APISignal }
     * 
     * 
     */
    public List<APISignal> getAPISignal() {
        if (apiSignal == null) {
            apiSignal = new ArrayList<APISignal>();
        }
        return this.apiSignal;
    }

}
