////
//
// File:    SendAttribute.java
// Purpose: Sending signals to rooms and assets
// Created: 05 May 2012
//
// Copyright 2012 Crestron Electronics, Inc.
// 
////

package com.ztfd.crestronFusion.helpers;

public class SendAttribute {
    
    protected Boolean IsRoom;
    protected String Id;
    protected String AttributeID;
    protected String Value;

    public Boolean getIsRoom() {
        return IsRoom;
    }
    
    public void setIsRoom(Boolean value) {
        this.IsRoom = value;
    }
    
    public String getId() {
        return Id;
    }
    
    public void setId(String value) {
        this.Id = value;
    }
    
    public String getAttributeID() {
        return AttributeID;
    }
    
    public void setAttributeID(String value) {
        this.AttributeID = value;
    }
    
    public String getValue() {
        return Value;
    }
    
    public void setValue(String value) {
        this.Value = value;
    }
}
