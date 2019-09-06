package com.ztfd.crestronFusion.entity;

public class Node {
    private String hasChildren;
    private String lastModified;
    private String nodeID;
    private String nodeName;
    private String nodeType;
    private String parentNodeID;
    private String treeNodeChildren;

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getParentNodeID() {
        return parentNodeID;
    }

    public void setParentNodeID(String parentNodeID) {
        this.parentNodeID = parentNodeID;
    }

    public String getTreeNodeChildren() {
        return treeNodeChildren;
    }

    public void setTreeNodeChildren(String treeNodeChildren) {
        this.treeNodeChildren = treeNodeChildren;
    }
}
