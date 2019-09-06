////
//
// File:    API_Constants.java
// Purpose: Storing many commonly-used constants for the project
// Created: 21 May 2012
//
// Copyright 2012 Crestron Electronics, Inc.
// 
////
package com.ztfd.crestronFusion.helpers;

public final class API_Constants {

    //public static final String SampleDataFilePath     = "SampleData\\API_Entities_TestData.xml";
    public static final String SampleDataFilePath = "http://localhost:8080/ApiTestHarnessJava/SampleData/API_Entities_TestData.xml";
    public static final String NodeNodePath = "/API_Entities/Nodes/API_Node";											//Node data path in sample xml file.
    public static final String RoomNodePath = "/API_Entities/Rooms/API_Room";											//Room data path in sample xml file.
    public static final String AssetNodePath = "/API_Entities/Assets/API_Asset";										//Asset data path in sample xml file.
    public static final String ActionNodePath = "/API_Entities/Actions/API_Action";										//Action data path in sample xml file.
    public static final String AppointmentNodePath = "/API_Entities/Appointments/API_Appointment";								//Appoinemtnt data path in sample xml file.
    public static final String SendAttributeNodePath = "/API_Entities/SendAttributes/SendAttribute";								//Send Attribute data path in sample xml file.
    public static final String Xmlns = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities";
    public static final String XmlIn = "XML IN";
    public static final String XmlOut = "XML OUT";
    public static final String JsonIn = "JSON IN";
    public static final String JsonOut = "JSON OUT";
    public static final String WebRequestContentTypeXml = "application/xml";
    public static final String WebRequestContentTypeJson = "application/json";
    public static final String Success = "Success";
    public static final String Fail = "Fail";
    public static final String Http = "http";
    public static final String Localhost = "localhost";
    public static final Integer Port = 10001;
    public static final String NamespaceURI = "http://schemas.datacontract.org/2004/07/Crestron.Fusion.API.Entities";
    public static final String LogFilePath = "D:\\API_Log\\";
    public static final String LogFileName = "FusionAPIJavaClientLog.txt";
}
