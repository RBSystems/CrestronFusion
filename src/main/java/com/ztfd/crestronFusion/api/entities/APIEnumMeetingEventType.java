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
 * <p>Java class for API_Enum_MeetingEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="API_Enum_MeetingEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Booked"/>
 *     &lt;enumeration value="Changed"/>
 *     &lt;enumeration value="Removed"/>
 *     &lt;enumeration value="Warning"/>
 *     &lt;enumeration value="MediaJobCompleted"/>
 *     &lt;enumeration value="MediaJobFailed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "API_Enum_MeetingEventType")
@XmlEnum
public enum APIEnumMeetingEventType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Booked")
    BOOKED("Booked"),
    @XmlEnumValue("Changed")
    CHANGED("Changed"),
    @XmlEnumValue("Removed")
    REMOVED("Removed"),
    @XmlEnumValue("Warning")
    WARNING("Warning"),
    @XmlEnumValue("MediaJobCompleted")
    MEDIA_JOB_COMPLETED("MediaJobCompleted"),
    @XmlEnumValue("MediaJobFailed")
    MEDIA_JOB_FAILED("MediaJobFailed");
    private final String value;

    APIEnumMeetingEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static APIEnumMeetingEventType fromValue(String v) {
        for (APIEnumMeetingEventType c: APIEnumMeetingEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
