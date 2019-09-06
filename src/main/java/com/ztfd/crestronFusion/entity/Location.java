package com.ztfd.crestronFusion.entity;

public class Location {
    private String displayName;
    private String entryIsEmpty;
    private String lastModified;
    private String locationTypeID;
    private String manualEntry;
    private String nodeID;
    private String nodeText;
    private String parentLocationTypeID;
    private String value;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEntryIsEmpty() {
        return entryIsEmpty;
    }

    public void setEntryIsEmpty(String entryIsEmpty) {
        this.entryIsEmpty = entryIsEmpty;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLocationTypeID() {
        return locationTypeID;
    }

    public void setLocationTypeID(String locationTypeID) {
        this.locationTypeID = locationTypeID;
    }

    public String getManualEntry() {
        return manualEntry;
    }

    public void setManualEntry(String manualEntry) {
        this.manualEntry = manualEntry;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeText() {
        return nodeText;
    }

    public void setNodeText(String nodeText) {
        this.nodeText = nodeText;
    }

    public String getParentLocationTypeID() {
        return parentLocationTypeID;
    }

    public void setParentLocationTypeID(String parentLocationTypeID) {
        this.parentLocationTypeID = parentLocationTypeID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
