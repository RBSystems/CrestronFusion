package com.ztfd.crestronFusion.entity;

public class AlertRuleCriteria {
    private String lastModified;
    private String maxThreshold;
    private String minThreshold;
    private String operator;
    private String ruleCriteriaID;
    private String unit;

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(String maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public String getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(String minThreshold) {
        this.minThreshold = minThreshold;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRuleCriteriaID() {
        return ruleCriteriaID;
    }

    public void setRuleCriteriaID(String ruleCriteriaID) {
        this.ruleCriteriaID = ruleCriteriaID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
