//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.17 at 01:58:06 PM EDT 
//


package com.ztfd.crestronFusion.api.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for API_Enum_LogicalOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="API_Enum_LogicalOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Cat"/>
 *     &lt;enumeration value="Last"/>
 *     &lt;enumeration value="And"/>
 *     &lt;enumeration value="Or"/>
 *     &lt;enumeration value="Xor"/>
 *     &lt;enumeration value="Sum"/>
 *     &lt;enumeration value="Avg"/>
 *     &lt;enumeration value="Min"/>
 *     &lt;enumeration value="Max"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "API_Enum_LogicalOperator")
@XmlEnum
public enum APIEnumLogicalOperator {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Cat")
    CAT("Cat"),
    @XmlEnumValue("Last")
    LAST("Last"),
    @XmlEnumValue("And")
    AND("And"),
    @XmlEnumValue("Or")
    OR("Or"),
    @XmlEnumValue("Xor")
    XOR("Xor"),
    @XmlEnumValue("Sum")
    SUM("Sum"),
    @XmlEnumValue("Avg")
    AVG("Avg"),
    @XmlEnumValue("Min")
    MIN("Min"),
    @XmlEnumValue("Max")
    MAX("Max");
    private final String value;

    APIEnumLogicalOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static APIEnumLogicalOperator fromValue(String v) {
        for (APIEnumLogicalOperator c: APIEnumLogicalOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}