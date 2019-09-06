////
//
// File:    API_Helper.java
// Purpose: Contains a large number of methods used by various classes
// Created: 24 May 2012
//
// Copyright 2012 Crestron Electronics, Inc.
// 
////

package com.ztfd.crestronFusion.helpers;


import com.ztfd.crestronFusion.api.entities.*;
import com.ztfd.crestronFusion.servlet.ApiLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.json.XML;
import sun.misc.BASE64Encoder;

public class API_Helper {

    /**
     * HTML Encode passed string
     *
     * @param s String to Encode
     * @return Encoded String
     */
    public static String EncodeHTML(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>') {
                out.append("&#" + (int) c + ";");
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    /**
     * Returns list of APIRoom generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APIRoom
     */
    public static ArrayList<APIRoom> GetRoomsFromSampleData(String nodeFilePath, String nodePath, Boolean getFullRoom, Boolean getAllRooms) {
        ArrayList<APIRoom> API_Rooms = new ArrayList<APIRoom>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {

                APIRoom API_Room = new APIRoom();

                API_Room.setAlias("".equals(node.valueOf("Alias")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Alias"), "".getClass(),
                        node.valueOf("Alias")));

                API_Room.setRoomID("".equals(node.valueOf("RoomID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomID"), "".getClass(),
                        node.valueOf("RoomID")));

                API_Room.setRoomName("".equals(node.valueOf("RoomName")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomName"), "".getClass(),
                        node.valueOf("RoomName")));

                API_Room.setDescription("".equals(node.valueOf("Description")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Description"), "".getClass(),
                        node.valueOf("Description")));

                API_Room.setLocation("".equals(node.valueOf("Location")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Location"), "".getClass(),
                        node.valueOf("Location")));

                API_Room.setDistributionGroupID("".equals(node.valueOf("DistributionGroupID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "DistributionGroupID"), "".getClass(),
                        node.valueOf("DistributionGroupID")));

                API_Room.setParentNodeID("".equals(node.valueOf("ParentNodeID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "ParentNodeID"), "".getClass(),
                        node.valueOf("ParentNodeID")));

                API_Room.setLastModified("".equals(node.valueOf("LastModified")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(node.valueOf("LastModified"))));

                API_Room.setTimeZoneID("".equals(node.valueOf("TimeZoneID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "TimeZoneID"), "".getClass(),
                        node.valueOf("TimeZoneID")));

                API_Room.setEControlLink("".equals(node.valueOf("EControlLink")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "EControlLink"), "".getClass(),
                        node.valueOf("EControlLink")));

                API_Room.setGroupwarePassword("".equals(node.valueOf("GroupwarePassword")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GroupwarePassword"), "".getClass(),
                        node.valueOf("GroupwarePassword")));

                API_Room.setGroupwareProviderType("".equals(node.valueOf("GroupwareProviderType")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GroupwareProviderType"), "".getClass(),
                        node.valueOf("GroupwareProviderType")));

                API_Room.setGroupwareURL("".equals(node.valueOf("GroupwareURL")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GroupwareURL"), "".getClass(),
                        node.valueOf("GroupwareURL")));

                API_Room.setGroupwareUserDomain("".equals(node.valueOf("GroupwareUserDomain")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GroupwareUserDomain"), "".getClass(),
                        node.valueOf("GroupwareUserDomain")));

                API_Room.setGroupwareUsername("".equals(node.valueOf("GroupwareUsername")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GroupwareUsername"), "".getClass(),
                        node.valueOf("GroupwareUsername")));

                API_Room.setSMTPAddress("".equals(node.valueOf("SMTPAddress")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "SMTPAddress"), "".getClass(),
                        node.valueOf("SMTPAddress")));

                API_Room.setWebCamLink("".equals(node.valueOf("WebCamLink")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "WebCamLink"), "".getClass(),
                        node.valueOf("WebCamLink")));

                if (getFullRoom) {
                    API_Room.setAssets(GetAssetsListFromNodeList(node));
                    API_Room.setPersons(GetPersonsListFromNodeList(node));
                    API_Room.setProcessors(GetProcessorsListFromNodeList(node));
                }
                API_Rooms.add(API_Room);
                if (!getAllRooms) {
                    break;
                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Rooms;
    }

    /**
     * Returns list of APIAssets generated From passed room node.
     *
     * @param node - Room Node
     * @return Array of APIAssets
     */
    private static JAXBElement<ArrayOfAPIAsset> GetAssetsListFromNodeList(Node node) {
        //Asset
        JAXBElement<ArrayOfAPIAsset> assets = null;

        try {
            List assetsList = node.selectNodes("Assets");

            if (assetsList.size() > 0) {
                Node assetsNode = (Node) assetsList.get(0);

                List childNodes = assetsNode.selectNodes("API_Asset");

                if (childNodes.size() > 0) {

                    ArrayOfAPIAsset arrAssets = new ArrayOfAPIAsset();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIAsset API_Asset = GetAssetFromNode(childNode);

                        arrAssets.getAPIAsset().add(API_Asset);
                    }

                    assets = new JAXBElement<ArrayOfAPIAsset>(
                            new QName(API_Constants.NamespaceURI, "Assets"), ArrayOfAPIAsset.class, arrAssets);
                    assets.setValue(arrAssets);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return assets;
    }

    /**
     * Returns Asset object created from sample data xml node
     *
     * @param childNode - xml data node
     * @return APIAsset
     */
    private static APIAsset GetAssetFromNode(Node childNode) {
        APIAsset API_Asset = new APIAsset();
        try {
            API_Asset.setAssetID("".equals(childNode.valueOf("AssetID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetID"), "".getClass(),
                    childNode.valueOf("AssetID")));

            API_Asset.setAssetName("".equals(childNode.valueOf("AssetName")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetName"), "".getClass(),
                    childNode.valueOf("AssetName")));

            API_Asset.setAssetTag("".equals(childNode.valueOf("AssetTag")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetTag"), "".getClass(),
                    childNode.valueOf("AssetTag")));

            API_Asset.setAssetTypeID("".equals(childNode.valueOf("AssetTypeID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetTypeID"), "".getClass(),
                    childNode.valueOf("AssetTypeID")));

            API_Asset.setConnType("".equals(childNode.valueOf("ConnType")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnType"), APIEnumAssetConnectionType.class,
                    APIEnumAssetConnectionType.valueOf(APIEnumAssetConnectionType.fromValue(childNode.valueOf("ConnType")).toString())));

            API_Asset.setDateOfPurchase("".equals(childNode.valueOf("DateOfPurchase")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "DateOfPurchase"), XMLGregorianCalendar.class,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("DateOfPurchase"))));

            API_Asset.setDriverID("".equals(childNode.valueOf("DriverID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "DriverID"), "".getClass(),
                    childNode.valueOf("DriverID")));

            API_Asset.setIPAddress("".equals(childNode.valueOf("IPAddress")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPAddress"), "".getClass(),
                    childNode.valueOf("IPAddress")));

            API_Asset.setIPID("".equals(childNode.valueOf("IPID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPID"), Integer.class,
                    Integer.parseInt(childNode.valueOf("IPID"))));

            API_Asset.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));

            API_Asset.setLastService("".equals(childNode.valueOf("LastService")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastService"), XMLGregorianCalendar.class,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastService"))));

            API_Asset.setLifeSpanYears("".equals(childNode.valueOf("LifeSpanYears")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "LifeSpanYears"), Integer.class,
                    Integer.parseInt(childNode.valueOf("LifeSpanYears"))));

            API_Asset.setMACAddress("".equals(childNode.valueOf("MACAddress")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "MACAddress"), "".getClass(),
                    childNode.valueOf("MACAddress")));

            API_Asset.setMaintenanceContractID("".equals(childNode.valueOf("MaintenanceContractID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "MaintenanceContractID"), "".getClass(),
                    childNode.valueOf("MaintenanceContractID")));

            API_Asset.setMake("".equals(childNode.valueOf("Make")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Make"), "".getClass(),
                    childNode.valueOf("Make")));

            API_Asset.setModel("".equals(childNode.valueOf("Model")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Model"), "".getClass(),
                    childNode.valueOf("Model")));

            API_Asset.setNotes("".equals(childNode.valueOf("Notes")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Notes"), "".getClass(),
                    childNode.valueOf("Notes")));

            API_Asset.setPassword("".equals(childNode.valueOf("Password")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Password"), "".getClass(),
                    childNode.valueOf("Password")));

            API_Asset.setPort("".equals(childNode.valueOf("Port")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Port"), Integer.class,
                    Integer.parseInt(childNode.valueOf("Port"))));

            API_Asset.setRoomID("".equals(childNode.valueOf("RoomID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomID"), "".getClass(),
                    childNode.valueOf("RoomID")));

            API_Asset.setSSL("".equals(childNode.valueOf("SSL")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "SSL"), Boolean.class,
                    Boolean.parseBoolean(childNode.valueOf("SSL"))));

            API_Asset.setSerialNumber("".equals(childNode.valueOf("SerialNumber")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "SerialNumber"), "".getClass(),
                    childNode.valueOf("SerialNumber")));

            API_Asset.setServiceInterval("".equals(childNode.valueOf("ServiceInterval")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ServiceInterval"), Integer.class,
                    Integer.parseInt(childNode.valueOf("ServiceInterval"))));

            API_Asset.setServiceIntervalIncrement("".equals(childNode.valueOf("ServiceIntervalIncrement")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ServiceIntervalIncrement"), "".getClass(),
                    childNode.valueOf("ServiceIntervalIncrement")));

            API_Asset.setStatus("".equals(childNode.valueOf("Status")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "Status"), APIEnumAssetStatus.class,
                    APIEnumAssetStatus.valueOf(APIEnumAssetStatus.fromValue(childNode.valueOf("Status")).toString())));

            API_Asset.setWarrantyExpiration("".equals(childNode.valueOf("WarrantyExpiration")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "WarrantyExpiration"), XMLGregorianCalendar.class,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("WarrantyExpiration"))));
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Asset;
    }

    /**
     * Returns list of APIPerson generated From passed room node.
     *
     * @param node - Room Node
     * @return Array of APIPerson
     */
    private static JAXBElement<ArrayOfAPIPerson> GetPersonsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIPerson> persons = null;

        try {
            List personsList = node.selectNodes("Persons");

            if (personsList.size() > 0) {
                Node personsNode = (Node) personsList.get(0);

                List childNodes = personsNode.selectNodes("API_Person");

                if (childNodes.size() > 0) {

                    ArrayOfAPIPerson arrPersons = new ArrayOfAPIPerson();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIPerson API_Person = new APIPerson();

                        API_Person.setName("".equals(childNode.valueOf("Name")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Name"), "".getClass(),
                                childNode.valueOf("Name")));
                        API_Person.setRole("".equals(childNode.valueOf("Role")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Role"), "".getClass(),
                                childNode.valueOf("Role")));
                        API_Person.setRoleID("".equals(childNode.valueOf("RoleID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoleID"), "".getClass(),
                                childNode.valueOf("RoleID")));
                        API_Person.setUserID("".equals(childNode.valueOf("UserID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "UserID"), "".getClass(),
                                childNode.valueOf("UserID")));

                        arrPersons.getAPIPerson().add(API_Person);
                    }

                    persons = new JAXBElement<ArrayOfAPIPerson>(
                            new QName(API_Constants.NamespaceURI, "Persons"), ArrayOfAPIPerson.class, arrPersons);
                    persons.setValue(arrPersons);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return persons;
    }

    /**
     * Returns list of APIProcessor generated From passed room node.
     *
     * @param node - Room Node
     * @return Array of APIProcessor
     */
    private static JAXBElement<ArrayOfAPIProcessor> GetProcessorsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIProcessor> processors = null;

        try {
            List processorsList = node.selectNodes("Processors");

            if (processorsList.size() > 0) {
                Node processorsNode = (Node) processorsList.get(0);

                List childNodes = processorsNode.selectNodes("API_Processor");

                if (childNodes.size() > 0) {

                    ArrayOfAPIProcessor arrProcessors = new ArrayOfAPIProcessor();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);
                        APIProcessor API_Processor = new APIProcessor();

                        API_Processor.setProcessorID("".equals(childNode.valueOf("ProcessorID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ProcessorID"), "".getClass(),
                                childNode.valueOf("ProcessorID")));
                        API_Processor.setProcessorName("".equals(childNode.valueOf("ProcessorName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ProcessorName"), "".getClass(),
                                childNode.valueOf("ProcessorName")));
                        API_Processor.setIPID("".equals(childNode.valueOf("IPID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPID"), Integer.class,
                                Integer.parseInt(childNode.valueOf("IPID"))));
                        API_Processor.setPort("".equals(childNode.valueOf("Port")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Port"), Integer.class,
                                Integer.parseInt(childNode.valueOf("Port"))));
                        API_Processor.setSecurePort("".equals(childNode.valueOf("SecurePort")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SecurePort"), Integer.class,
                                Integer.parseInt(childNode.valueOf("SecurePort"))));
                        API_Processor.setUsername("".equals(childNode.valueOf("Username")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Username"), "".getClass(),
                                childNode.valueOf("Username")));
                        API_Processor.setPassword("".equals(childNode.valueOf("Password")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Password"), "".getClass(),
                                childNode.valueOf("Password")));
                        API_Processor.setAutodiscover(childNode.valueOf("Autodiscover") == null
                                ? new JAXBElement(new QName(API_Constants.NamespaceURI, "Autodiscover"), Boolean.class, Boolean.FALSE)
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Autodiscover"), Boolean.class, Boolean.parseBoolean(childNode.valueOf("Autodiscover"))));
                        API_Processor.setConnected(childNode.valueOf("Connected") == null
                                ? new JAXBElement(new QName(API_Constants.NamespaceURI, "Connected"), Boolean.class, Boolean.FALSE)
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Connected"), Boolean.class, Boolean.parseBoolean(childNode.valueOf("Connected"))));
                        API_Processor.setConnectInfo("".equals(childNode.valueOf("ConnectInfo")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnectInfo"), "".getClass(),
                                childNode.valueOf("ConnectInfo")));
                        API_Processor.setConnectSSL(childNode.valueOf("ConnectSSL") == null
                                ? new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnectSSL"), Boolean.class, Boolean.FALSE)
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnectSSL"), Boolean.class, Boolean.parseBoolean(childNode.valueOf("ConnectSSL"))));
                        API_Processor.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));
                        API_Processor.setLocation("".equals(childNode.valueOf("Location")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Location"), "".getClass(),
                                childNode.valueOf("Location")));
                        API_Processor.setParentID("".equals(childNode.valueOf("ParentID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ParentID"), "".getClass(),
                                childNode.valueOf("ParentID")));

                        API_Processor.setSymbols(GetSymbolsListFromNodeList(childNode));

                        arrProcessors.getAPIProcessor().add(API_Processor);
                    }

                    processors = new JAXBElement<ArrayOfAPIProcessor>(
                            new QName(API_Constants.NamespaceURI, "Processors"), ArrayOfAPIProcessor.class, arrProcessors);
                    processors.setValue(arrProcessors);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return processors;
    }

    /**
     * Returns list of APISymbol generated From passed processor node.
     *
     * @param node - Processor Node
     * @return Array of APISymbol
     */
    private static JAXBElement<ArrayOfAPISymbol> GetSymbolsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPISymbol> symbols = null;

        try {
            List symbolsList = node.selectNodes("Symbols");

            if (symbolsList.size() > 0) {
                Node symbolsNode = (Node) symbolsList.get(0);

                List childNodes = symbolsNode.selectNodes("API_Symbol");

                if (childNodes.size() > 0) {

                    ArrayOfAPISymbol arrSymbols = new ArrayOfAPISymbol();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);
                        APISymbol API_Symbol = new APISymbol();
                        API_Symbol.setSymbolID("".equals(childNode.valueOf("SymbolID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SymbolID"), "".getClass(),
                                childNode.valueOf("SymbolID")));
                        API_Symbol.setSymbolName("".equals(childNode.valueOf("SymbolName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SymbolName"), "".getClass(),
                                childNode.valueOf("SymbolName")));
                        API_Symbol.setVersion("".equals(childNode.valueOf("Version")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Version"), "".getClass(),
                                childNode.valueOf("Version")));
                        API_Symbol.setIPID("".equals(childNode.valueOf("IPID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPID"), Integer.class,
                                Integer.parseInt(childNode.valueOf("IPID"))));
                        API_Symbol.setUseSSL(childNode.valueOf("chkSymUseSSL") == null
                                ? new JAXBElement(new QName(API_Constants.NamespaceURI, "UseSSL"), Boolean.class, Boolean.FALSE)
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "UseSSL"), Boolean.class, Boolean.TRUE));
                        API_Symbol.setConnectInfo("".equals(childNode.valueOf("ConnectInfo")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnectInfo"), "".getClass(),
                                childNode.valueOf("ConnectInfo")));
                        API_Symbol.setNodeID("".equals(childNode.valueOf("NodeID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "NodeID"), "".getClass(),
                                childNode.valueOf("NodeID")));
                        API_Symbol.setNodeText("".equals(childNode.valueOf("NodeText")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "NodeText"), "".getClass(),
                                childNode.valueOf("NodeText")));
                        API_Symbol.setPassword("".equals(childNode.valueOf("Password")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Password"), "".getClass(),
                                childNode.valueOf("Password")));
                        API_Symbol.setProcessorID("".equals(childNode.valueOf("ProcessorID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ProcessorID"), "".getClass(),
                                childNode.valueOf("ProcessorID")));
                        API_Symbol.setProcessorName("".equals(childNode.valueOf("ProcessorName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ProcessorName"), "".getClass(),
                                childNode.valueOf("ProcessorName")));
                        API_Symbol.setRoomID("".equals(childNode.valueOf("RoomID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomID"), "".getClass(),
                                childNode.valueOf("RoomID")));
                        API_Symbol.setUserName("".equals(childNode.valueOf("UserName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "UserName"), "".getClass(),
                                childNode.valueOf("UserName")));
                        API_Symbol.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));

                        API_Symbol.setSignals(GetSignalsListFromNodeList(childNode));

                        arrSymbols.getAPISymbol().add(API_Symbol);
                    }

                    symbols = new JAXBElement<ArrayOfAPISymbol>(
                            new QName(API_Constants.NamespaceURI, "Symbols"), ArrayOfAPISymbol.class, arrSymbols);
                    symbols.setValue(arrSymbols);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return symbols;
    }

    /**
     * Returns list of APISignal generated From passed Symbol node.
     *
     * @param node - Symbol Node
     * @return Array of APISignal
     */
    private static JAXBElement<ArrayOfAPISignal> GetSignalsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPISignal> signals = null;

        try {
            List signalsList = node.selectNodes("Signals");

            if (signalsList.size() > 0) {
                Node signalsNode = (Node) signalsList.get(0);

                List childNodes = signalsNode.selectNodes("API_Signal");

                if (childNodes.size() > 0) {

                    ArrayOfAPISignal arrSignals = new ArrayOfAPISignal();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);
                        APISignal API_Signal = new APISignal();

                        //Set all other properties
                        API_Signal.setAttributeID("".equals(childNode.valueOf("AttributeID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AttributeID"), "".getClass(),
                                childNode.valueOf("AttributeID")));

                        API_Signal.setAttributeName("".equals(childNode.valueOf("AttributeName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AttributeName"), "".getClass(),
                                childNode.valueOf("AttributeName")));
                        arrSignals.getAPISignal().add(API_Signal);
                    }

                    signals = new JAXBElement<ArrayOfAPISignal>(
                            new QName(API_Constants.NamespaceURI, "Signals"), ArrayOfAPISignal.class, arrSignals);
                    signals.setValue(arrSignals);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return signals;
    }

    /**
     * Returns security token generated as per passed parameters
     *
     * @param securityLevel - 0 = no security; 1 = security w/o encryption, 2 =
     * with encryption
     * @param userid - user id
     * @param apiPasscode - api passcode
     * @return security token string
     */
    public static String GetSecuredToken(Integer securityLevel, String userid, String apiPasscode) {
        System.out.println("GetSecuredToken.....");
        String returnVal = "auth=";
        try {
            if (securityLevel == 2) {
                returnVal += API_Helper.Encrypt(
                        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ").format(new Date())
                        + " " + userid,
                        apiPasscode);
            } else if (securityLevel == 1) {
                returnVal += apiPasscode
                        + " " + userid;
            } else {
                returnVal = "";
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        System.out.println(returnVal);
        return returnVal;
    }

    //Need FIX - Not Working
    public static String Encrypt(String inputText, String key) {
        String retVal = "";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] keyBytes = new byte[16];
            byte[] b = key.getBytes();
            int len = b.length;
            if (len > keyBytes.length) {
                len = keyBytes.length;
            }
            System.arraycopy(b, 0, keyBytes, 0, len);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            BASE64Encoder _64e = new BASE64Encoder();
            byte[] encryptedData = cipher.doFinal(inputText.getBytes());
            retVal = _64e.encode(encryptedData);

        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return retVal;
    }

    /**
     * Returns HttpURLConnection instance setup with passed parameters.
     *
     * @param queryString - QueryString for URL
     * @param path - Resource path - Rooms/Assets etc..
     * @param xmlJson - Request/Response type for the communication - xml or
     * json
     * @param requestMethod - Put/Post/Delete/Get
     * @return HttpURLConnection
     */
    public static HttpURLConnection GetHttpURLConnection(String serviceUrl, String queryString, String path, String xmlJson, String requestMethod) {
        HttpURLConnection httpConn = null;
        String urlAddress = String.valueOf(serviceUrl + path + "?" + queryString).replace(" ", "%20");
        try {
            System.out.println(urlAddress);
            URL url = new URL(urlAddress);

            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setInstanceFollowRedirects(false);
            httpConn.setRequestProperty("Content-Type", xmlJson);
            httpConn.setRequestProperty("Accept", xmlJson);
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod(requestMethod);
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        ApiLog.One.WriteText("HttpRequest ::" + urlAddress);
        return httpConn;
    }

    /**
     * Extracts details from APIResult inputstream.
     *
     * @param  inStream
     * @return String - Details (Status + Message) extracted from APIResult
     * inputstream
     */
    public static String ExtractAPIResultDetails(InputStream inStream) {
        String apiResult = "";
        try {
            String inputLine = "", apiReturnResult = "";
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inStream));

            while ((inputLine = in.readLine()) != null) {
                apiReturnResult += inputLine;
            }
            if (apiReturnResult.contains("API_Result")) {
                JAXBContext jabxContext = JAXBContext.newInstance(APIResult.class);
                Unmarshaller unmarshaller = jabxContext.createUnmarshaller();
                JAXBElement<APIResult> elemApi_Result = null;
                InputStream is = new ByteArrayInputStream(apiReturnResult.getBytes());

                elemApi_Result = (JAXBElement<APIResult>) unmarshaller.unmarshal(is);
                APIResult api_Result = elemApi_Result.getValue();
                if (api_Result.getStatus() != null) {
                    apiResult = api_Result.getStatus().getValue();
                }
                if (api_Result.getMessage() != null) {
                    apiResult = apiResult + " :: " + api_Result.getMessage().getValue();
                }
            } else {
                JSONPacker jsonPacker = new JSONPacker(apiReturnResult);
                apiResult = jsonPacker.getResult().getMessage().getValue();
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return apiResult;
    }

    /**
     * Converts local time to UTC
     *
     * @param localDateTime - Local Date
     * @return String - utc date
     * @throws Exception
     */
    public static String ConvertLocalTimeToUTC(String localDateTime) throws Exception {
        String returnVal = "";
        try {
            DateFormat dfParse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            dfParse.setTimeZone(Calendar.getInstance().getTimeZone());

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date dateTime;

            dateTime = dfParse.parse(localDateTime);
            returnVal = df.format(dateTime);
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
            returnVal = localDateTime;
        }
        return returnVal;
    }

    /**
     * Converts UTC time to local
     *
     * @param utcDateTime - UTC Date
     * @return String - local date
     * @throws Exception
     */
    public static String ConvertUTCtoLocalTime(String utcDateTime) throws Exception {

        String returnVal = "";
        try {
            DateFormat dfParse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            dfParse.setTimeZone(TimeZone.getTimeZone("UTC"));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            df.setTimeZone(Calendar.getInstance().getTimeZone());

            Date dateTime;

            dateTime = dfParse.parse(utcDateTime);
            returnVal = df.format(dateTime);
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
            returnVal = utcDateTime;
        }
        return returnVal;
    }

    /**
     * Returns APIAsset object by assigning all user entered values, that are
     * coming in request
     *
     * @param request- Request from room and asset jsp pages
     * @return APIAsset
     * @throws Exception
     */
    public static APIAsset GetAPIAsset(HttpServletRequest request) throws Exception {

        //Assign values from textboxes/controls to Asset resource, and return Asset

        APIAsset API_Asset = new APIAsset();

        API_Asset.setAssetID("".equals(request.getParameter("txtAssetID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetID"), "".getClass(),
                request.getParameter("txtAssetID")));

        API_Asset.setAssetName("".equals(request.getParameter("txtAssetName")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetName"), "".getClass(),
                request.getParameter("txtAssetName")));

        API_Asset.setAssetTag("".equals(request.getParameter("txtAssetTag")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetTag"), "".getClass(),
                request.getParameter("txtAssetTag")));

        API_Asset.setAssetTypeID("".equals(request.getParameter("txtAssetTypeID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AssetTypeID"), "".getClass(),
                request.getParameter("txtAssetTypeID")));

        API_Asset.setConnType("".equals(request.getParameter("txtConnType")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ConnType"), APIEnumAssetConnectionType.class,
                APIEnumAssetConnectionType.valueOf(APIEnumAssetConnectionType.fromValue(request.getParameter("txtConnType")).toString())));

        API_Asset.setDateOfPurchase("".equals(request.getParameter("txtDateOfPurchase")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "DateOfPurchase"), XMLGregorianCalendar.class,
                DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("txtDateOfPurchase"))));

        API_Asset.setDriverID("".equals(request.getParameter("txtDriverID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "DriverID"), "".getClass(),
                request.getParameter("txtDriverID")));

        API_Asset.setIPAddress("".equals(request.getParameter("txtIPAddress")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPAddress"), "".getClass(),
                request.getParameter("txtIPAddress")));

        API_Asset.setIPID("".equals(request.getParameter("txtIPID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IPID"), Integer.class,
                Integer.parseInt(request.getParameter("txtIPID"))));

        API_Asset.setLastModified("".equals(request.getParameter("txtLastModified")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("txtLastModified"))));

        API_Asset.setLastService("".equals(request.getParameter("txtLastService")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastService"), XMLGregorianCalendar.class,
                DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("txtLastService"))));

        API_Asset.setLifeSpanYears("".equals(request.getParameter("txtLifeSpanYears")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LifeSpanYears"), Integer.class,
                Integer.parseInt(request.getParameter("txtLifeSpanYears"))));

        API_Asset.setMACAddress("".equals(request.getParameter("txtMACAddress")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "MACAddress"), "".getClass(),
                request.getParameter("txtMACAddress")));

        API_Asset.setMaintenanceContractID("".equals(request.getParameter("txtMaintenanceContractID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "MaintenanceContractID"), "".getClass(),
                request.getParameter("txtMaintenanceContractID")));

        API_Asset.setMake("".equals(request.getParameter("txtMake")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Make"), "".getClass(),
                request.getParameter("txtMake")));

        API_Asset.setModel("".equals(request.getParameter("txtModel")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Model"), "".getClass(),
                request.getParameter("txtModel")));

        API_Asset.setNotes("".equals(request.getParameter("txtNotes")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Notes"), "".getClass(),
                request.getParameter("txtNotes")));

        API_Asset.setPassword("".equals(request.getParameter("txtPassword")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Password"), "".getClass(),
                request.getParameter("txtPassword")));

        API_Asset.setPort("".equals(request.getParameter("txtPort")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Port"), Integer.class,
                Integer.parseInt(request.getParameter("txtPort"))));

        API_Asset.setRoomID("".equals(request.getParameter("txtRoomID")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomID"), "".getClass(),
                request.getParameter("txtRoomID")));

        API_Asset.setSSL("".equals(request.getParameter("txtSSL")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SSL"), Boolean.class,
                Boolean.parseBoolean(request.getParameter("txtSSL"))));

        API_Asset.setSerialNumber("".equals(request.getParameter("txtSerialNumber")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SerialNumber"), "".getClass(),
                request.getParameter("txtSerialNumber")));

        API_Asset.setServiceInterval("".equals(request.getParameter("txtServiceInterval")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ServiceInterval"), Integer.class,
                Integer.parseInt(request.getParameter("txtServiceInterval"))));

        API_Asset.setServiceIntervalIncrement("".equals(request.getParameter("txtServiceIntervalIncrement")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ServiceIntervalIncrement"), "".getClass(),
                request.getParameter("txtServiceIntervalIncrement")));

        API_Asset.setStatus("".equals(request.getParameter("txtStatus")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Status"), APIEnumAssetStatus.class,
                APIEnumAssetStatus.valueOf(APIEnumAssetStatus.fromValue(request.getParameter("txtStatus")).toString())));

        API_Asset.setWarrantyExpiration("".equals(request.getParameter("txtWarrantyExpiration")) ? null
                : new JAXBElement(new QName(API_Constants.NamespaceURI, "WarrantyExpiration"), XMLGregorianCalendar.class,
                DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("txtWarrantyExpiration"))));


        return API_Asset;

    }

    /**
     * Returns List of APIAttribute by invoking api service as per passed
     * querystring.
     *
     * @param queryString
     * @return List of APIAttribute
     */
    public static List<APIAttribute> GetAttributes(String serviceUrl, String queryString, String attributeId) {
        APIResult api_Result = null;
        String apiReturnResult = "";
        HttpURLConnection httpConn = null;
        JAXBContext jaxbContextResult = null;
        Unmarshaller unmarshaller = null;
        String path = "/attributes/";
        if (!"".equals(attributeId)) {
            path += attributeId;
        }

        String requestMethod = "GET";
        String xmlJson = API_Constants.WebRequestContentTypeXml;
        List<APIAttribute> lstApiAttributes = null;

        try {
            if (!"".equalsIgnoreCase(queryString)) {                                                                    //Proceed if querystring is not empty.
                httpConn = API_Helper.GetHttpURLConnection(serviceUrl, queryString, path, xmlJson, requestMethod);                  //Create HttpURLConnection with passed values

                ApiLog.One.WriteText("HttpRequest ::" + httpConn.getURL().toString());                                                //Also log the request

                BufferedReader in = new BufferedReader( //Get inputstream of http connection        
                        new InputStreamReader( //This will return stream for all GET/PUT/POST/DELETE operations.                        
                        httpConn.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {                                                           //Read and store in apiReturnResult   
                    apiReturnResult += inputLine;
                }

                ApiLog.One.WriteText("XmlJsonOut ::" + apiReturnResult);

                httpConn.disconnect();                                                                                   //Disconnect connection              
                Integer respsponseCode = httpConn.getResponseCode();

                //if (respCode.equals(new Integer(200)) || respCode.equals(new Integer(400))) 
                //Check for 200 -OK response

                try {

                    jaxbContextResult = JAXBContext.newInstance(APIResult.class);
                    unmarshaller = jaxbContextResult.createUnmarshaller();
                    JAXBElement<APIResult> elemApi_Result = null;

                    InputStream is = new ByteArrayInputStream(apiReturnResult.getBytes());
                    elemApi_Result = (JAXBElement<APIResult>) unmarshaller.unmarshal(is);
                    api_Result = elemApi_Result.getValue();
                    if (api_Result != null) {                                                                                                   //Check is the retured result from api call is null
                        if (api_Result.getAPIAttributes() != null) {                                                                                //If not - get the retured actions    
                            lstApiAttributes = api_Result.getAPIAttributes().getValue().getAPIAttribute();
                        }
                    }

                } catch (Exception ex) {
                    ApiLog.One.WriteException(ex);
                    String receivedResponse = "Server returned HTTP_RESPONSE_CODE ::" + respsponseCode;
                    ApiLog.One.WriteText(receivedResponse);
                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return lstApiAttributes;
    }

    /**
     * Returns list of APIAsset generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APIAsset
     */
    public static ArrayList<APIAsset> GetAssetsFromSampleData(String nodeFilePath, String nodePath) {
        ArrayList<APIAsset> API_Assets = new ArrayList<APIAsset>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {

                APIAsset API_Asset = GetAssetFromNode(node);
                API_Assets.add(API_Asset);

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Assets;
    }

    /**
     * Returns list of APIAction generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APIAction
     */
    public static ArrayList<APIAction> GetActionsFromSampleData(String nodeFilePath, String nodePath) {
        ArrayList<APIAction> API_Actions = new ArrayList<APIAction>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {
                API_Actions.add(GetAPIActionFromNode(node));

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Actions;
    }

    private static APIAction GetAPIActionFromNode(Node node) {
        APIAction API_Action = new APIAction();
        try {
            API_Action.setActionID("".equals(node.valueOf("ActionID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ActionID"), "".getClass(),
                    node.valueOf("ActionID")));

            API_Action.setActionName("".equals(node.valueOf("ActionName")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ActionName"), "".getClass(),
                    node.valueOf("ActionName")));

            API_Action.setActionDescription("".equals(node.valueOf("ActionDescription")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "ActionDescription"), "".getClass(),
                    node.valueOf("ActionDescription")));

            API_Action.setIsOverride("".equals(node.valueOf("IsOverride")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "IsOverride"), Boolean.class,
                    Boolean.parseBoolean(node.valueOf("IsOverride"))));

            API_Action.setLastModified("".equals(node.valueOf("LastModified")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(node.valueOf("LastModified"))));

            API_Action.setOffsetMinutes("".equals(node.valueOf("OffsetMinutes")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "OffsetMinutes"), Integer.class,
                    Integer.parseInt(node.valueOf("OffsetMinutes"))));

            API_Action.setOverriddenActionID("".equals(node.valueOf("OverriddenActionID")) ? null
                    : new JAXBElement(new QName(API_Constants.NamespaceURI, "OverriddenActionID"), "".getClass(),
                    node.valueOf("OverriddenActionID")));

            API_Action.setStepList(GetActionStepsListFromNodeList(node));
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Action;
    }

    /**
     * Returns list of APIActionSteps generated From passed action node.
     *
     * @param node - Action Node
     * @return Array of APIActionSteps
     */
    private static JAXBElement<ArrayOfAPIActionStep> GetActionStepsListFromNodeList(Node node) {
        //ActionStep
        JAXBElement<ArrayOfAPIActionStep> actionSteps = null;

        try {
            List actionStepsList = node.selectNodes("StepList");

            if (actionStepsList.size() > 0) {
                Node actionStepsNode = (Node) actionStepsList.get(0);

                List childNodes = actionStepsNode.selectNodes("API_ActionStep");

                if (childNodes.size() > 0) {

                    ArrayOfAPIActionStep arrActionSteps = new ArrayOfAPIActionStep();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIActionStep API_ActionStep = new APIActionStep();

                        API_ActionStep.setAttributeID("".equals(childNode.valueOf("AttributeID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AttributeID"), "".getClass(),
                                childNode.valueOf("AttributeID")));

                        API_ActionStep.setAttributeType("".equals(childNode.valueOf("AttributeType")) ? null
                                : APIEnumAttributeTypes.valueOf(APIEnumAttributeTypes.fromValue(childNode.valueOf("AttributeType")).toString()));

                        API_ActionStep.setAnalogValue("".equals(childNode.valueOf("AnalogValue")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "AnalogValue"), Integer.class,
                                Integer.parseInt(childNode.valueOf("AnalogValue"))));

                        API_ActionStep.setDigitalValue("".equals(childNode.valueOf("DigitalValue")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "DigitalValue"), Boolean.class,
                                Boolean.parseBoolean(childNode.valueOf("DigitalValue"))));

                        API_ActionStep.setSerialValue("".equals(childNode.valueOf("SerialValue")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SerialValue"), "".getClass(),
                                childNode.valueOf("SerialValue")));

                        API_ActionStep.setOrderIndex("".equals(childNode.valueOf("OrderIndex")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "OrderIndex"), Integer.class,
                                Integer.parseInt(childNode.valueOf("OrderIndex"))));

                        API_ActionStep.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));

                        arrActionSteps.getAPIActionStep().add(API_ActionStep);
                    }

                    actionSteps = new JAXBElement<ArrayOfAPIActionStep>(
                            new QName(API_Constants.NamespaceURI, "StepList"), ArrayOfAPIActionStep.class, arrActionSteps);
                    actionSteps.setValue(arrActionSteps);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return actionSteps;
    }

    /**
     * Returns list of SendAttribute generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APIAttribute
     */
    public static ArrayList<SendAttribute> GetAttributesFromSampleData(String nodeFilePath, String nodePath) {
        ArrayList<SendAttribute> SendAttributes = new ArrayList<SendAttribute>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {

                SendAttribute sendAttribute = new SendAttribute();

                sendAttribute.setIsRoom("".equals(node.valueOf("IsRoom")) ? null : Boolean.parseBoolean(node.valueOf("IsRoom")));
                sendAttribute.setId("".equals(node.valueOf("Id")) ? null : node.valueOf("Id"));
                sendAttribute.setAttributeID("".equals(node.valueOf("AttributeID")) ? null : node.valueOf("AttributeID"));
                sendAttribute.setValue("".equals(node.valueOf("Value")) ? null : node.valueOf("Value"));

                SendAttributes.add(sendAttribute);

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return SendAttributes;
    }

    /**
     * Returns list of APINode generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APINode
     */
    public static ArrayList<APINode> GetNodesFromSampleData(String nodeFilePath, String nodePath) {
        ArrayList<APINode> API_Nodes = new ArrayList<APINode>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {

                APINode API_Node = new APINode();

                API_Node.setNodeID("".equals(node.valueOf("NodeID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "NodeID"), "".getClass(),
                        node.valueOf("NodeID")));


                API_Nodes.add(API_Node);

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Nodes;
    }

    /**
     * Returns list of APIAppointment generated From Sample xml data.
     *
     * @param nodeFilePath - sample data file path
     * @param nodePath - node path to extract
     * @return Array List of APIAppointment
     */
    public static ArrayList<APIAppointment> GetAppointmentsFromSampleData(String nodeFilePath, String nodePath) {
        ArrayList<APIAppointment> API_Appointments = new ArrayList<APIAppointment>();

        try {
            // Get the SAXReader object        
            SAXReader reader = new SAXReader();
            // Get the xml document object by sax reader.        
            Document document = reader.read(nodeFilePath);
            List<Node> nodes = document.selectNodes(nodePath);

            // Read all the node inside xpath nodes and print the value of each        
            for (Node node : nodes) {

                APIAppointment API_Appointment = new APIAppointment();
                API_Appointment.setAltID("".equals(node.valueOf("AltID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "AltID"), "".getClass(),
                        node.valueOf("AltID")));
                API_Appointment.setAttendees("".equals(node.valueOf("Attendees")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Attendees"), "".getClass(),
                        node.valueOf("Attendees")));
                API_Appointment.setEnd("".equals(node.valueOf("End")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "End"), XMLGregorianCalendar.class,
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(API_Helper.ConvertLocalTimeToUTC(node.valueOf("End")))));
                API_Appointment.setEventOrMeeting("".equals(node.valueOf("EventOrMeeting")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "EventOrMeeting"), APIEnumEventOrMeeting.class,
                        APIEnumEventOrMeeting.valueOf(APIEnumEventOrMeeting.fromValue(node.valueOf("EventOrMeeting")).toString())));
                API_Appointment.setGWMeetingID("".equals(node.valueOf("GW_MeetingID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "GWMeetingID"), "".getClass(),
                        node.valueOf("GW_MeetingID")));
                API_Appointment.setIsPrivate("".equals(node.valueOf("IsPrivate")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "IsPrivate"), Boolean.class,
                        Boolean.parseBoolean(node.valueOf("IsPrivate"))));
                API_Appointment.setLastModified("".equals(node.valueOf("LastModified")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(node.valueOf("LastModified"))));
                API_Appointment.setLocation("".equals(node.valueOf("Location")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Location"), "".getClass(),
                        node.valueOf("Location")));
                API_Appointment.setMeetingComment("".equals(node.valueOf("MeetingComment")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "MeetingComment"), "".getClass(),
                        node.valueOf("MeetingComment")));
                API_Appointment.setMeetingSubject("".equals(node.valueOf("MeetingSubject")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "MeetingSubject"), "".getClass(),
                        node.valueOf("MeetingSubject")));
                API_Appointment.setMeetingType("".equals(node.valueOf("MeetingType")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "MeetingType"), APIEnumMeetingType.class,
                        APIEnumMeetingType.valueOf(APIEnumMeetingType.fromValue(node.valueOf("MeetingType")).toString())));
                API_Appointment.setNotifyAction("".equals(node.valueOf("NotifyAction")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "NotifyAction"), APIEnumPushNotifyAction.class,
                        APIEnumPushNotifyAction.valueOf(APIEnumPushNotifyAction.fromValue(node.valueOf("NotifyAction")).toString())));
                API_Appointment.setOrganizer("".equals(node.valueOf("Organizer")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Organizer"), "".getClass(),
                        node.valueOf("Organizer")));
                API_Appointment.setRRule("".equals(node.valueOf("RRule")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "RRule"), "".getClass(),
                        node.valueOf("RRule")));
                API_Appointment.setRVMeetingID("".equals(node.valueOf("RV_MeetingID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "RVMeetingID"), "".getClass(),
                        node.valueOf("RV_MeetingID")));
                API_Appointment.setRoomID("".equals(node.valueOf("RoomID")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoomID"), "".getClass(),
                        node.valueOf("RoomID")));
                API_Appointment.setStart("".equals(node.valueOf("Start")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Start"), XMLGregorianCalendar.class,
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(API_Helper.ConvertLocalTimeToUTC(node.valueOf("Start")))));

                API_Appointment.setActions(GetActionsListFromNodeList(node));
                API_Appointment.setPreset(GetPresetFromNodeList(node));
                API_Appointment.setRolesForMeeting(GetRolesForMeetingsListFromNodeList(node));

                API_Appointments.add(API_Appointment);
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return API_Appointments;
    }

    /**
     * Returns list of APIAction generated From passed room node.
     *
     * @param node - Appointment Node
     * @return Array of APIAction
     */
    private static JAXBElement<ArrayOfAPIAction> GetActionsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIAction> actions = null;

        try {
            List actionsList = node.selectNodes("Actions");

            if (actionsList.size() > 0) {
                Node actionsNode = (Node) actionsList.get(0);

                List childNodes = actionsNode.selectNodes("API_Action");

                if (childNodes.size() > 0) {

                    ArrayOfAPIAction arrActions = new ArrayOfAPIAction();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIAction API_Action = GetAPIActionFromNode(childNode);
                        if (API_Action != null) {
                            arrActions.getAPIAction().add(API_Action);
                        }
                    }
                    actions = new JAXBElement<ArrayOfAPIAction>(
                            new QName(API_Constants.NamespaceURI, "Actions"), ArrayOfAPIAction.class, arrActions);
                    actions.setValue(arrActions);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return actions;
    }

    /**
     * Returns list of APIPreset generated From passed room node.
     *
     * @param node - Appointment Node
     * @return Array of APIPreset
     */
    private static JAXBElement<APIPreset> GetPresetFromNodeList(Node node) {
        APIPreset API_Preset = new APIPreset();
        JAXBElement<APIPreset> preset = null;
        try {

            List childNodes = node.selectNodes("Preset");

            if (childNodes.size() > 0) {
                Node childNode = (Node) childNodes.get(0);
                API_Preset.setPresetName("".equals(childNode.valueOf("PresetName")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "PresetName"), "".getClass(),
                        childNode.valueOf("PresetName")));
                API_Preset.setPresetSlot("".equals(childNode.valueOf("PresetSlot")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "PresetSlot"), Integer.class,
                        Integer.parseInt(childNode.valueOf("PresetSlot"))));
                API_Preset.setEnabled("".equals(childNode.valueOf("Enabled")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "Enabled"), Boolean.class,
                        Boolean.parseBoolean(childNode.valueOf("Enabled"))));
                API_Preset.setImageSource1("".equals(childNode.valueOf("ImageSource1")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "ImageSource1"), "".getClass(),
                        childNode.valueOf("ImageSource1")));
                API_Preset.setImageSource2("".equals(childNode.valueOf("ImageSource2")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "ImageSource2"), "".getClass(),
                        childNode.valueOf("ImageSource2")));
                API_Preset.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));
                API_Preset.setMaximumPresets("".equals(childNode.valueOf("MaximumPresets")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "MaximumPresets"), Integer.class,
                        Integer.parseInt(childNode.valueOf("MaximumPresets"))));
                API_Preset.setWelcomeMessage("".equals(childNode.valueOf("WelcomeMessage")) ? null
                        : new JAXBElement(new QName(API_Constants.NamespaceURI, "WelcomeMessage"), "".getClass(),
                        childNode.valueOf("WelcomeMessage")));

                API_Preset.setPresetFields(GetPresetFieldsListFromNodeList(childNode));

                //Set Preset to Appointment
                preset = new JAXBElement<APIPreset>(
                        new QName(API_Constants.NamespaceURI, "Preset"), APIPreset.class, API_Preset);

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return preset;
    }

    /**
     * Returns list of APIPresetField generated From passed preset node.
     *
     * @param node - Preset Node
     * @return Array of APIPresetField
     */
    private static JAXBElement<ArrayOfAPIPresetField> GetPresetFieldsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIPresetField> presetFields = null;

        try {
            List presetFieldsList = node.selectNodes("PresetFields");

            if (presetFieldsList.size() > 0) {
                Node presetFieldsNode = (Node) presetFieldsList.get(0);

                List childNodes = presetFieldsNode.selectNodes("API_PresetField");

                if (childNodes.size() > 0) {

                    ArrayOfAPIPresetField arrPresetFields = new ArrayOfAPIPresetField();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIPresetField API_PresetField = new APIPresetField();

                        API_PresetField.setFieldLabel("".equals(childNode.valueOf("FieldLabel")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "FieldLabel"), "".getClass(),
                                childNode.valueOf("FieldLabel")));
                        API_PresetField.setFieldSlot("".equals(childNode.valueOf("FieldSlot")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "FieldSlot"), Integer.class,
                                Integer.parseInt(childNode.valueOf("FieldSlot"))));
                        API_PresetField.setFieldValue("".equals(childNode.valueOf("FieldValue")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "FieldValue"), "".getClass(),
                                childNode.valueOf("FieldValue")));
                        API_PresetField.setMaximumFields("".equals(childNode.valueOf("MaximumFields")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "MaximumFields"), Integer.class,
                                Integer.parseInt(childNode.valueOf("MaximumFields"))));

                        arrPresetFields.getAPIPresetField().add(API_PresetField);
                    }

                    presetFields = new JAXBElement<ArrayOfAPIPresetField>(
                            new QName(API_Constants.NamespaceURI, "PresetFields"), ArrayOfAPIPresetField.class, arrPresetFields);
                    presetFields.setValue(arrPresetFields);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return presetFields;
    }

    /**
     * Returns list of APIRole generated From passed appointment node.
     *
     * @param node - Appointment Node
     * @return Array of APIRole
     */
    private static JAXBElement<ArrayOfAPIRole> GetRolesForMeetingsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIRole> roles = null;

        try {
            List rolesList = node.selectNodes("RolesForMeeting");

            if (rolesList.size() > 0) {
                Node rolesNode = (Node) rolesList.get(0);

                List childNodes = rolesNode.selectNodes("API_Role");

                if (childNodes.size() > 0) {

                    ArrayOfAPIRole arrRoles = new ArrayOfAPIRole();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIRole API_Role = new APIRole();
                        API_Role.setIsBuiltIn("".equals(childNode.valueOf("IsBuiltIn")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IsBuiltIn"), Boolean.class,
                                Boolean.parseBoolean(childNode.valueOf("IsBuiltIn"))));
                        API_Role.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));
                        API_Role.setNodeID("".equals(childNode.valueOf("NodeID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "NodeID"), "".getClass(),
                                childNode.valueOf("NodeID")));
                        API_Role.setNodeText("".equals(childNode.valueOf("NodeText")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "NodeText"), "".getClass(),
                                childNode.valueOf("NodeText")));
                        API_Role.setRoleID("".equals(childNode.valueOf("RoleID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoleID"), "".getClass(),
                                childNode.valueOf("RoleID")));
                        API_Role.setRoleName("".equals(childNode.valueOf("RoleName")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "RoleName"), "".getClass(),
                                childNode.valueOf("RoleName")));

                        API_Role.setContacts(GetRoleContactsListFromNodeList(childNode));
                        API_Role.setOptions(GetRoleOptionsListFromNodeList(childNode));

                        arrRoles.getAPIRole().add(API_Role);
                    }

                    roles = new JAXBElement<ArrayOfAPIRole>(
                            new QName(API_Constants.NamespaceURI, "RolesForMeeting"), ArrayOfAPIRole.class, arrRoles);
                    roles.setValue(arrRoles);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return roles;
    }

    /**
     * Returns list of APIRoleContact generated From passed contact node.
     *
     * @param node - Contact Node
     * @return Array of APIRoleContact
     */
    private static JAXBElement<ArrayOfAPIRoleContact> GetRoleContactsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIRoleContact> roleContacts = null;

        try {
            List roleContactsList = node.selectNodes("Contacts");

            if (roleContactsList.size() > 0) {
                Node roleContactsNode = (Node) roleContactsList.get(0);

                List childNodes = roleContactsNode.selectNodes("API_RoleContact");

                if (childNodes.size() > 0) {

                    ArrayOfAPIRoleContact arrRoleContacts = new ArrayOfAPIRoleContact();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIRoleContact API_RoleContact = new APIRoleContact();
                        API_RoleContact.setContactID("".equals(childNode.valueOf("ContactID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "ContactID"), "".getClass(),
                                childNode.valueOf("ContactID")));
                        API_RoleContact.setIsRoomViewUser("".equals(childNode.valueOf("IsRoomViewUser")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "IsRoomViewUser"), Boolean.class,
                                Boolean.parseBoolean(childNode.valueOf("IsRoomViewUser"))));
                        API_RoleContact.setName("".equals(childNode.valueOf("Name")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Name"), "".getClass(),
                                childNode.valueOf("Name")));
                        API_RoleContact.setSmtpAddress("".equals(childNode.valueOf("SmtpAddress")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "SmtpAddress"), "".getClass(),
                                childNode.valueOf("SmtpAddress")));
                        API_RoleContact.setUseHtml("".equals(childNode.valueOf("UseHtml")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "UseHtml"), Boolean.class,
                                Boolean.parseBoolean(childNode.valueOf("UseHtml"))));
                        API_RoleContact.setUserID("".equals(childNode.valueOf("UserID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "UserID"), "".getClass(),
                                childNode.valueOf("UserID")));
                        API_RoleContact.setWebClientUserID("".equals(childNode.valueOf("WebClientUserID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "WebClientUserID"), "".getClass(),
                                childNode.valueOf("WebClientUserID")));

                        arrRoleContacts.getAPIRoleContact().add(API_RoleContact);
                    }

                    roleContacts = new JAXBElement<ArrayOfAPIRoleContact>(
                            new QName(API_Constants.NamespaceURI, "Contacts"), ArrayOfAPIRoleContact.class, arrRoleContacts);
                    roleContacts.setValue(arrRoleContacts);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return roleContacts;
    }

    /**
     * Returns list of APIRoleOption generated From passed contact node.
     *
     * @param node - Option Node
     * @return Array of APIRoleOption
     */
    private static JAXBElement<ArrayOfAPIRoleOption> GetRoleOptionsListFromNodeList(Node node) {
        JAXBElement<ArrayOfAPIRoleOption> roleOptions = null;

        try {
            List roleOptionsList = node.selectNodes("Options");

            if (roleOptionsList.size() > 0) {
                Node roleOptionsNode = (Node) roleOptionsList.get(0);

                List childNodes = roleOptionsNode.selectNodes("API_RoleOption");

                if (childNodes.size() > 0) {

                    ArrayOfAPIRoleOption arrRoleOptions = new ArrayOfAPIRoleOption();
                    for (int i = 0; i < childNodes.size(); i++) {

                        Node childNode = (Node) childNodes.get(i);

                        APIRoleOption API_RoleOption = new APIRoleOption();
                        API_RoleOption.setCreated("".equals(childNode.valueOf("Created")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "Created"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("Created"))));
                        API_RoleOption.setEmailTemplateID("".equals(childNode.valueOf("EmailTemplateID")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "EmailTemplateID"), "".getClass(),
                                childNode.valueOf("EmailTemplateID")));
                        API_RoleOption.setLastModified("".equals(childNode.valueOf("LastModified")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "LastModified"), XMLGregorianCalendar.class,
                                DatatypeFactory.newInstance().newXMLGregorianCalendar(childNode.valueOf("LastModified"))));
                        API_RoleOption.setMeetingNotificationOption("".equals(childNode.valueOf("MeetingNotificationOption")) ? null
                                : new JAXBElement(new QName(API_Constants.NamespaceURI, "MeetingNotificationOption"), APIEnumMeetingEventType.class,
                                APIEnumMeetingEventType.valueOf(APIEnumMeetingEventType.fromValue(childNode.valueOf("MeetingNotificationOption")).toString())));

                        arrRoleOptions.getAPIRoleOption().add(API_RoleOption);
                    }

                    roleOptions = new JAXBElement<ArrayOfAPIRoleOption>(
                            new QName(API_Constants.NamespaceURI, "Options"), ArrayOfAPIRoleOption.class, arrRoleOptions);
                    roleOptions.setValue(arrRoleOptions);

                }
            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return roleOptions;
    }

    /**
     * Convert passed string into json string - for PUT/POST operations
     * @param resourceString - string to convert
     * @return json resource string
     */
    public static String GetJSONString(String resourceString) {
        String retVal = "";
        resourceString = resourceString.replaceAll("<API_.*?>", "").replaceAll("</API_.*?>", "");
        try {
            String json = XML.toJSONObject(resourceString).toString();
            json = "{" + json.substring(1, json.length() - 1).replaceAll("\\{", "\\[{").replaceAll("\\}", "\\]}") + "}";
            retVal = json;
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);
        }
        return retVal;
    }
}
