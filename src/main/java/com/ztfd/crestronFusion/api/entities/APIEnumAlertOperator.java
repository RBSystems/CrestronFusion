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
 * <p>Java class for API_Enum_AlertOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="API_Enum_AlertOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Always"/>
 *     &lt;enumeration value="EqualTo"/>
 *     &lt;enumeration value="GreaterThan"/>
 *     &lt;enumeration value="GreaterThanEqualTo"/>
 *     &lt;enumeration value="InRange"/>
 *     &lt;enumeration value="LessThan"/>
 *     &lt;enumeration value="LessThanEqualTo"/>
 *     &lt;enumeration value="NotEqualTo"/>
 *     &lt;enumeration value="Off"/>
 *     &lt;enumeration value="On"/>
 *     &lt;enumeration value="OutRange"/>
 *     &lt;enumeration value="Regex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "API_Enum_AlertOperator")
@XmlEnum
public enum APIEnumAlertOperator {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Always")
    ALWAYS("Always"),
    @XmlEnumValue("EqualTo")
    EQUAL_TO("EqualTo"),
    @XmlEnumValue("GreaterThan")
    GREATER_THAN("GreaterThan"),
    @XmlEnumValue("GreaterThanEqualTo")
    GREATER_THAN_EQUAL_TO("GreaterThanEqualTo"),
    @XmlEnumValue("InRange")
    IN_RANGE("InRange"),
    @XmlEnumValue("LessThan")
    LESS_THAN("LessThan"),
    @XmlEnumValue("LessThanEqualTo")
    LESS_THAN_EQUAL_TO("LessThanEqualTo"),
    @XmlEnumValue("NotEqualTo")
    NOT_EQUAL_TO("NotEqualTo"),
    @XmlEnumValue("Off")
    OFF("Off"),
    @XmlEnumValue("On")
    ON("On"),
    @XmlEnumValue("OutRange")
    OUT_RANGE("OutRange"),
    @XmlEnumValue("Regex")
    REGEX("Regex");
    private final String value;

    APIEnumAlertOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static APIEnumAlertOperator fromValue(String v) {
        for (APIEnumAlertOperator c: APIEnumAlertOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
