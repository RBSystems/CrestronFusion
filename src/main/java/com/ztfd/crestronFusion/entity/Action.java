package com.ztfd.crestronFusion.entity;

public class Action {
    private String actionDescription;
    private String actionID;
    private String actionName;
    private String isOverride;
    private String lastModified;
    private String offsetMinutes;
    private String overriddenActionID;
    private String stepList;

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getIsOverride() {
        return isOverride;
    }

    public void setIsOverride(String isOverride) {
        this.isOverride = isOverride;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getOffsetMinutes() {
        return offsetMinutes;
    }

    public void setOffsetMinutes(String offsetMinutes) {
        this.offsetMinutes = offsetMinutes;
    }

    public String getOverriddenActionID() {
        return overriddenActionID;
    }

    public void setOverriddenActionID(String overriddenActionID) {
        this.overriddenActionID = overriddenActionID;
    }

    public String getStepList() {
        return stepList;
    }

    public void setStepList(String stepList) {
        this.stepList = stepList;
    }
}
