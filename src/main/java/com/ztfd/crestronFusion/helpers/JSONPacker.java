////
//
// File:    JSONPacker.java
// Purpose: Makes JSON strings into JAXB objects.
// Created: 21 May 2012
// 
// Notes:  1) Only works with existing API entities in this project
//
// Copyright 2012 Crestron Electronics, Inc.
// 
////

package com.ztfd.crestronFusion.helpers;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.ztfd.crestronFusion.api.entities.*;


public class JSONPacker
{
    private APIResult JSONResult = new APIResult();
    public JSONPacker(String jstring)
    {
        try
        {
            ObjectFactory fact = new ObjectFactory();
            JSONObject result = new JSONObject(jstring);
            Iterator resultIterator = result.keys();
            while(resultIterator.hasNext())
            {
                String resultItem = resultIterator.next().toString();
                switch(resultItem)
                {
                    case "API_Actions":
                        JSONResult.setAPIActions(jsonActions(new JSONArray(result.getString(resultItem))));
                        break;
                    case "API_Appointments":
                        JSONResult.setAPIAppointments(jsonAppointments(new JSONArray(result.getString(resultItem))));
                        break;
                    case "API_Assets":
                        JSONResult.setAPIAssets(jsonAssets(new JSONArray(result.getString(resultItem))));
                        break;
                    case "API_Attributes":
                        JSONResult.setAPIAttributes(jsonAttributes(new JSONArray(result.getString(resultItem))));
                        break;
                    case "API_Nodes":
                        JSONResult.setAPINodes(jsonNodes(new JSONArray(result.getString(resultItem))));
                        break;
                    case "API_Rooms":
                        JSONResult.setAPIRooms(jsonRooms(new JSONArray(result.getString(resultItem))));
                        break;
                    case "Message":
                        JSONResult.setMessage(fact.createAPIResultMessage(result.getString(resultItem)));
                        break;
                    case "PageNumber":
                        JSONResult.setPageNumber(result.getInt(resultItem));
                        break;
                    case "Source":
                        JSONResult.setSource(fact.createAPIResultSource(result.getString(resultItem)));
                        break;
                    case "StackTrace":
                        JSONResult.setStackTrace(fact.createAPIResultStackTrace(result.getString(resultItem)));
                        break;
                    case "Status":
                        JAXBElement<String> status = fact.createAPIRoomDescription(result.getString(resultItem));
                        JSONResult.setStatus(status);
                        break;
                    case "TotalRecords":
                        JSONResult.setTotalRecords(result.getInt(resultItem));
                        break;
                }
            }
        }
        catch (Exception e)
        {
                System.out.println("Result creation exception: "+e.toString());
        }
    }
    
    private JAXBElement<ArrayOfAPIRoom> jsonRooms (JSONArray rooms)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIRoom> roomArray = fact.createArrayOfAPIRoom(fact.createArrayOfAPIRoom());
        try
        {
            for(int i = 0; i < rooms.length(); i++)
            {  
                APIRoom jsonRoom = new APIRoom();
                JSONObject room = rooms.getJSONObject(i);
                Iterator roomIterator = room.keys();
                while(roomIterator.hasNext())
                {
                    String key = roomIterator.next().toString();
                    String value = room.getString(key);
                    switch(key)
                    {
                        case "Alias":
                            jsonRoom.setAlias(fact.createAPIRoomAlias(value));
                            break;
                        case "Assets":
                            JSONArray assetArray = new JSONArray(value);
                            jsonRoom.setAssets(jsonAssets(assetArray));
                            break;
                        case "CustomFields":
                            jsonRoom.setCustomFields(jsonRoomCustomFields(new JSONArray(value)));
                            break;
                        case "Description":
                            jsonRoom.setDescription(fact.createAPIRoomDescription(value));
                            break;
                        case "DistributionGroupID":
                            jsonRoom.setDistributionGroupID(fact.createAPIRoomDistributionGroupID(value));
                            break;
                        case "EControlLink":
                            jsonRoom.setEControlLink(fact.createAPIRoomEControlLink(value));
                            break;
                        case "GroupwarePassword":
                            jsonRoom.setGroupwarePassword(fact.createAPIRoomGroupwarePassword(value));
                            break;
                        case "GroupwareProviderType":
                            jsonRoom.setGroupwareProviderType(fact.createAPIRoomGroupwareProviderType(value));
                            break;
                        case "GroupwareURL":
                            jsonRoom.setGroupwareURL(fact.createAPIRoomGroupwareURL(value));
                            break;
                        case "GroupwareUserDomain":
                            jsonRoom.setGroupwareUserDomain(fact.createAPIRoomGroupwareUserDomain(value));
                            break;
                        case "GroupwareUsername":
                            jsonRoom.setGroupwareUsername(fact.createAPIRoomGroupwareUsername(value));
                            break;
                        case "LastModified":
                            jsonRoom.setLastModified(fact.createAPIRoomLastModified(jsonDate(value)));
                            break;
                        case "Location":
                            jsonRoom.setLocation(fact.createAPIRoomLocation(value));
                            break;
                        case "LocationMap":
                            jsonRoom.setLocationMap(jsonLocations(new JSONArray(value)));
                            break;
                        case "ParentNodeID":
                            jsonRoom.setParentNodeID(fact.createAPIRoomParentNodeID(value));
                            break;
                        case "Persons":
                            jsonRoom.setPersons(jsonPersons(new JSONArray(value)));
                            break;
                        case "Processors":
                            jsonRoom.setProcessors(jsonProcessors(new JSONArray(value)));
                            break;
                        case "RoomID":
                            jsonRoom.setRoomID(fact.createAPIRoomRoomID(value));
                            break;
                        case "RoomName":
                            jsonRoom.setRoomName(fact.createAPIRoomRoomName(value));
                            break;
                        case "SMTPAddress":
                            jsonRoom.setSMTPAddress(fact.createAPIRoomSMTPAddress(value));
                            break;
                        case "TimeZoneID":
                            jsonRoom.setTimeZoneID(fact.createAPIRoomTimeZoneID(value));
                            break;
                        case "WebCamLink":
                            jsonRoom.setWebCamLink(fact.createAPIRoomWebCamLink(value));
                            break;
                    }
                }
                roomArray.getValue().getAPIRoom().add(jsonRoom);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Room creation exception: "+e.toString());
        }
        return roomArray;
    }
    
    private JAXBElement<ArrayOfAPIAsset> jsonAssets(JSONArray assets)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAsset> assetArray = fact.createArrayOfAPIAsset(fact.createArrayOfAPIAsset());
        try
        {
            for(int i = 0; i < assets.length(); i++)
            {
                APIAsset jsonAsset = new APIAsset();
                JSONObject asset = assets.getJSONObject(i);
                Iterator assetIterator = asset.keys();
                
                while(assetIterator.hasNext())
                {
                    String key = assetIterator.next().toString();
                    String value = asset.getString(key);
                    switch(key)
                    {
                        case "AssetCustomFields":
                            jsonAsset.setAssetCustomFields(jsonAssetCustomFields(new JSONArray(value)));
                            break;
                        case "AssetID":
                            jsonAsset.setAssetID(fact.createAPIAssetAssetID(value));
                            break;
                        case "AssetName":
                            jsonAsset.setAssetName(fact.createAPIAssetAssetName(value));
                            break;
                        case "AssetTag":
                            jsonAsset.setAssetTag(fact.createAPIAssetAssetTag(value));
                            break;
                        case "AssetTypeID":
                            jsonAsset.setAssetTypeID(fact.createAPIAssetAssetTypeID(value));
                            break;
                        case "ConnType":
                            jsonAsset.setConnType(fact.createAPIAssetConnType(APIEnumAssetConnectionType.values()[asset.getInt(key)]));
                            break;
                        case "DateOfPurchase":
                            jsonAsset.setDateOfPurchase(fact.createAPIAssetDateOfPurchase(jsonDate(value)));
                            break;
                        case "DriverID":
                            jsonAsset.setDriverID(fact.createAPIAssetDriverID(value));
                            break;
                        case "IPAddress":
                            jsonAsset.setIPAddress(fact.createAPIAssetIPAddress(value));
                            break;
                        case "IPID":
                            jsonAsset.setIPID(fact.createAPIAssetIPID(asset.getInt(key)));
                            break;
                        case "LastModified":
                            jsonAsset.setLastModified(fact.createAPIAssetLastModified(jsonDate(value)));
                            break;
                        case "LifeSpanYears":
                            jsonAsset.setLifeSpanYears(fact.createAPIAssetLifeSpanYears(asset.getInt(key)));
                            break;
                        case "MACAddress":
                            jsonAsset.setMACAddress(fact.createAPIAssetMACAddress(value));
                            break;
                        case "MaintenanceContractID":
                            jsonAsset.setMaintenanceContractID(fact.createAPIAssetMaintenanceContractID(value));
                            break;
                        case "Make":
                            jsonAsset.setMake(fact.createAPIAssetMake(value));
                            break;
                        case "Model":
                            jsonAsset.setModel(fact.createAPIAssetModel(value));
                            break;
                        case "Notes":
                            jsonAsset.setNotes(fact.createAPIAssetNotes(value));
                            break;
                        case "Password":
                            jsonAsset.setPassword(fact.createAPIAssetPassword(value));
                            break;
                        case "Port":
                            jsonAsset.setPort(fact.createAPIAssetPort(asset.getInt(key)));
                            break;
                        case "RoomID":
                            jsonAsset.setRoomID(fact.createAPIAssetRoomID(value));
                            break;
                        case "SSL":
                            jsonAsset.setSSL(fact.createAPIAssetSSL(asset.getBoolean(key)));
                            break;
                        case "SerialNumber":
                            jsonAsset.setSerialNumber(fact.createAPIAssetSerialNumber(value));
                            break;
                        case "ServiceInterval":
                            jsonAsset.setServiceInterval(fact.createAPIAssetServiceInterval(asset.getInt(key)));
                            break;
                        case "ServiceIntervalIncrement":
                            jsonAsset.setServiceIntervalIncrement(fact.createAPIAssetServiceIntervalIncrement(value));
                            break;
                        case "Status":
                            jsonAsset.setStatus(fact.createAPIAssetStatus(APIEnumAssetStatus.values()[asset.getInt(key)]));
                            break;
                        case "WarrantyExpiration":
                            jsonAsset.setWarrantyExpiration(fact.createAPIAssetWarrantyExpiration(jsonDate(value)));
                            break;
                    }
                }
                assetArray.getValue().getAPIAsset().add(jsonAsset);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Asset creation exception: "+e.toString());
        }
        return assetArray;
    }
    
    private JAXBElement<ArrayOfAPIAttribute> jsonAttributes(JSONArray attributes)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAttribute> attributeArray = fact.createArrayOfAPIAttribute(fact.createArrayOfAPIAttribute());
        try
        {
            for(int i = 0; i < attributes.length(); i++)
            {
                APIAttribute jsonAttribute = new APIAttribute();
                JSONObject attribute = attributes.getJSONObject(i);
                Iterator attributeIterator = attribute.keys();
                
                while(attributeIterator.hasNext())
                {
                    String key = attributeIterator.next().toString();
                    String value = attribute.getString(key);
                    switch(key)
                    {
                        case "AssetID":
                            jsonAttribute.setAssetID(fact.createAPIAttributeAssetID(value));
                            break;
                        case "AttributeID":
                            jsonAttribute.setAttributeID(fact.createAPIAttributeAttributeID(value));
                            break;
                        case "AttributeName":
                            jsonAttribute.setAttributeName(fact.createAPIAttributeAttributeName(value));
                            break;
                        case "AttributeType":
                            jsonAttribute.setAttributeType(APIEnumAttributeType.values()[attribute.getInt(key)]);
                            break;
                        case "ButtonChangeText":
                            jsonAttribute.setButtonChangeText(fact.createAPIAttributeButtonChangeText(value));
                            break;
                        case "ButtonOffText":
                            jsonAttribute.setButtonOffText(fact.createAPIAttributeButtonOffText(value));
                            break;
                        case "ButtonOnText":
                            jsonAttribute.setButtonOnText(fact.createAPIAttributeButtonOnText(value));
                            break;
                        case "Default":
                            jsonAttribute.setDefault(fact.createAPIAttributeDefault(attribute.getBoolean(key)));
                            break;
                        case "DefaultIOMask":
                            jsonAttribute.setDefaultIOMask(fact.createAPIAttributeDefaultIOMask(attribute.getInt(key)));
                            break;
                        case "DefaultJoin":
                            jsonAttribute.setDefaultJoin(fact.createAPIAttributeDefaultJoin(attribute.getInt(key)));
                            break;
                        case "DefaultMaxValue":
                            jsonAttribute.setDefaultMaxValue(fact.createAPIAttributeDefaultMaxValue(attribute.getInt(key)));
                            break;
                        case "DefaultMinValue":
                            jsonAttribute.setDefaultMinValue(fact.createAPIAttributeDefaultMinValue(attribute.getInt(key)));
                            break;
                        case "DefaultSlot":
                            jsonAttribute.setDefaultSlot(fact.createAPIAttributeDefaultSlot(value));
                            break;
                        case "GraphicSetID":
                            jsonAttribute.setGraphicSetID(fact.createAPIAttributeGraphicSetID(value));
                            break;
                        case "LastModified":
                            jsonAttribute.setLastModified(fact.createAPIAttributeLastModified(jsonDate(value)));
                            break;
                        case "LogDB":
                            jsonAttribute.setLogDB(fact.createAPIAttributeLogDB(attribute.getBoolean(key)));
                            break;
                        case "LogNTEvent":
                            jsonAttribute.setLogNTEvent(fact.createAPIAttributeLogNTEvent(attribute.getBoolean(key)));
                            break;
                        case "LogRules":
                            jsonAttribute.setLogRules(jsonAlertRules(new JSONArray(value)));
                            break;
                        case "LogicOperator":
                            jsonAttribute.setLogicOperator(APIEnumLogicalOperator.values()[attribute.getInt(key)]);
                            break;
                        case "Reserved":
                            jsonAttribute.setReserved(fact.createAPIAttributeReserved(attribute.getBoolean(key)));
                            break;
                        case "XmlName":
                            jsonAttribute.setXmlName(fact.createAPIAttributeXmlName(value));
                            break;
                    }
                }
                attributeArray.getValue().getAPIAttribute().add(jsonAttribute);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Attribute creation exception: "+e.toString());
        }
        return attributeArray;
    }
    
    private JAXBElement<ArrayOfAPIAlertRule> jsonAlertRules(JSONArray alertrules)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAlertRule> alertruleArray = fact.createArrayOfAPIAlertRule(fact.createArrayOfAPIAlertRule());
        try
        {
            for(int i = 0; i < alertrules.length(); i++)
            {
                APIAlertRule jsonAlertRule = new APIAlertRule();
                JSONObject alertRule = alertrules.getJSONObject(i);
                Iterator alertruleIterator = alertRule.keys();
                
                while(alertruleIterator.hasNext())
                {
                    String key = alertruleIterator.next().toString();
                    String value = alertRule.getString(key);
                    switch(key)
                    {
                        case "AlertAlways":
                            jsonAlertRule.setAlertAlways(fact.createAPIAlertRuleAlertAlways(alertRule.getBoolean(key)));
                            break;
                        case "AlertOnce":
                            jsonAlertRule.setAlertOnce(fact.createAPIAlertRuleAlertOnce(alertRule.getBoolean(key)));
                            break;
                        case "AlertOperator":
                            jsonAlertRule.setAlertOperator(APIEnumAlertOperator.values()[alertRule.getInt(key)]);
                            break;
                        case "AlertRuleCriteria":
                            jsonAlertRule.setAlertRuleCriteria(jsonAlertRuleCriterias(new JSONArray(value)));
                            break;
                        case "AlertRuleID":
                            jsonAlertRule.setAlertRuleID(fact.createAPIAlertRuleAlertRuleID(value));
                            break;
                        case "AttributeID":
                            jsonAlertRule.setAttributeID(fact.createAPIAlertRuleAttributeID(value));
                            break;
                        case "LastModified":
                            jsonAlertRule.setLastModified(fact.createAPIAlertRuleLastModified(jsonDate(value)));
                            break;
                        case "LogAttributeInDatabase":
                            jsonAlertRule.setLogAttributeInDatabase(fact.createAPIAlertRuleLogAttributeInDatabase(alertRule.getBoolean(key)));
                            break;
                        case "LogAttributeInEventLog":
                            jsonAlertRule.setLogAttributeInEventLog(fact.createAPIAlertRuleLogAttributeInEventLog(alertRule.getBoolean(key)));
                            break;
                        case "NodeID":
                            jsonAlertRule.setNodeID(fact.createAPIAlertRuleNodeID(value));
                            break;
                        case "Value":
                            jsonAlertRule.setNodeText(fact.createAPIAlertRuleNodeText(value));
                            break;
                    }
                }
                alertruleArray.getValue().getAPIAlertRule().add(jsonAlertRule);
            }
        }
        catch(JSONException e)
        {
            System.out.println("AlertRule creation exception: "+e.toString());
        }
        return alertruleArray;
    }
    
    private JAXBElement<ArrayOfAPIAlertRuleCriteria> jsonAlertRuleCriterias(JSONArray alertrRuleCriterias)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAlertRuleCriteria> alertRuleCriteriaArray = fact.createArrayOfAPIAlertRuleCriteria(fact.createArrayOfAPIAlertRuleCriteria());
        try
        {
            for(int i = 0; i < alertrRuleCriterias.length(); i++)
            {
                APIAlertRuleCriteria jsonAlertRuleCriteria = new APIAlertRuleCriteria();
                JSONObject alertRuleCriteria = alertrRuleCriterias.getJSONObject(i);
                Iterator alertRuleCriteriaIterator = alertRuleCriteria.keys();
                
                while(alertRuleCriteriaIterator.hasNext())
                {
                    String key = alertRuleCriteriaIterator.next().toString();
                    String value = alertRuleCriteria.getString(key);
                    switch(key)
                    {
                        case "LastModified":
                            jsonAlertRuleCriteria.setLastModified(fact.createAPIAlertRuleCriteriaLastModified(jsonDate(value)));
                            break;
                        case "MaxThreshold":
                            jsonAlertRuleCriteria.setMaxThreshold(fact.createAPIAlertRuleCriteriaMaxThreshold(value));
                            break;
                        case "MinThreshold":
                            jsonAlertRuleCriteria.setMinThreshold(fact.createAPIAlertRuleCriteriaMinThreshold(value));
                            break;
                        case "Operator":
                            jsonAlertRuleCriteria.setOperator(APIEnumAlertOperator.values()[alertRuleCriteria.getInt(key)]);
                            break;
                        case "RuleCriteriaID":
                            jsonAlertRuleCriteria.setRuleCriteriaID(fact.createAPIAlertRuleCriteriaRuleCriteriaID(value));
                            break;
                        case "Unit":
                            jsonAlertRuleCriteria.setUnit(fact.createAPIAlertRuleCriteriaUnit(APIEnumAlertRuleUnit.values()[alertRuleCriteria.getInt(key)]));
                            break;
                    }
                }
                alertRuleCriteriaArray.getValue().getAPIAlertRuleCriteria().add(jsonAlertRuleCriteria);
            }
        }
        catch(JSONException e)
        {
            System.out.println("AlertRuleCriteria creation exception: "+e.toString());
        }
        return alertRuleCriteriaArray;
    }
    
    private JAXBElement<ArrayOfAPILocation> jsonLocations(JSONArray locations)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPILocation> locationArray = fact.createArrayOfAPILocation(fact.createArrayOfAPILocation());
        try
        {
            for(int i = 0; i < locations.length(); i++)
            {
                APILocation jsonLocation = new APILocation();
                JSONObject location = locations.getJSONObject(i);
                Iterator locationIterator = location.keys();
                
                while(locationIterator.hasNext())
                {
                    String key = locationIterator.next().toString();
                    String value = location.getString(key);
                    switch(key)
                    {
                        case "DisplayName":
                            jsonLocation.setDisplayName(fact.createAPILocationDisplayName(value));
                            break;
                        case "EntryIsEmpty":
                            jsonLocation.setEntryIsEmpty(fact.createAPILocationEntryIsEmpty(location.getBoolean(key)));
                            break;
                        case "LastModified":
                            jsonLocation.setLastModified(fact.createAPILocationLastModified(jsonDate(value)));
                            break;
                        case "LocationTypeID":
                            jsonLocation.setLocationTypeID(fact.createAPILocationLocationTypeID(value));
                            break;
                        case "ManualEntry":
                            jsonLocation.setManualEntry(fact.createAPILocationManualEntry(location.getBoolean(key)));
                            break;
                        case "NodeID":
                            jsonLocation.setNodeID(fact.createAPILocationNodeID(value));
                            break;
                        case "NodeText":
                            jsonLocation.setNodeText(fact.createAPILocationNodeText(value));
                            break;
                        case "ParentLocationTypeID":
                            jsonLocation.setParentLocationTypeID(fact.createAPILocationParentLocationTypeID(value));
                            break;
                        case "Value":
                            jsonLocation.setValue(fact.createAPILocationValue(value));
                            break;
                    }
                }
                locationArray.getValue().getAPILocation().add(jsonLocation);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Location creation exception: "+e.toString());
        }
        return locationArray;
    }
    
    private JAXBElement<ArrayOfAPIRoomCustomField> jsonRoomCustomFields(JSONArray roomCustomFields)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIRoomCustomField> roomCustomFieldsArray = fact.createArrayOfAPIRoomCustomField(fact.createArrayOfAPIRoomCustomField());
        try
        {
            for(int i = 0; i < roomCustomFields.length(); i++)
            {
                APIRoomCustomField jsonRoomCustomField = new APIRoomCustomField();
                JSONObject roomCustomField = roomCustomFields.getJSONObject(i);
                Iterator roomCustomFieldIterator = roomCustomField.keys();
                
                while(roomCustomFieldIterator.hasNext())
                {
                    String key = roomCustomFieldIterator.next().toString();
                    String value = roomCustomField.getString(key);
                    switch(key)
                    {
                        case "BoolValue":
                            jsonRoomCustomField.setBoolValue(fact.createAPIRoomCustomFieldBoolValue(roomCustomField.getBoolean(key)));
                            break;
                        case "CustomFieldID":
                            jsonRoomCustomField.setCustomFieldID(fact.createAPIRoomCustomFieldCustomFieldID(value));
                            break;
                        case "DateTimeValue":
                            jsonRoomCustomField.setDateTimeValue(fact.createAPIRoomCustomFieldDateTimeValue(jsonDate(value)));
                            break;
                        case "IntValue":
                            jsonRoomCustomField.setIntValue(fact.createAPIRoomCustomFieldIntValue(roomCustomField.getInt(key)));
                            break;
                        case "LastModified":
                            jsonRoomCustomField.setLastModified(fact.createAPIRoomCustomFieldLastModified(jsonDate(value)));
                            break;
                        case "Name":
                            jsonRoomCustomField.setName(fact.createAPIRoomCustomFieldName(value));
                            break;
                        case "Searchable":
                            jsonRoomCustomField.setSearchable(fact.createAPIRoomCustomFieldSearchable(roomCustomField.getBoolean(key)));
                            break;
                        case "StringValue":
                            jsonRoomCustomField.setStringValue(fact.createAPIRoomCustomFieldStringValue(value));
                            break;
                        case "Type":
                            jsonRoomCustomField.setType(APIEnumCustomFieldType.values()[roomCustomField.getInt(key)]);
                            break;
                    }
                }
                roomCustomFieldsArray.getValue().getAPIRoomCustomField().add(jsonRoomCustomField);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Location creation exception: "+e.toString());
        }
        return roomCustomFieldsArray;
    }
    
    private JAXBElement<ArrayOfAPIAssetCustomField> jsonAssetCustomFields(JSONArray assetCustomFields)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAssetCustomField> assetCustomFieldsArray = fact.createArrayOfAPIAssetCustomField(fact.createArrayOfAPIAssetCustomField());
        try
        {
            for(int i = 0; i < assetCustomFields.length(); i++)
            {
                APIAssetCustomField jsonAssetCustomField = new APIAssetCustomField();
                JSONObject assetCustomField = assetCustomFields.getJSONObject(i);
                Iterator assetCustomFieldIterator = assetCustomField.keys();
                
                while(assetCustomFieldIterator.hasNext())
                {
                    String key = assetCustomFieldIterator.next().toString();
                    String value = assetCustomField.getString(key);
                    switch(key)
                    {
                        case "BoolValue":
                            jsonAssetCustomField.setBoolValue(fact.createAPIAssetCustomFieldBoolValue(assetCustomField.getBoolean(key)));
                            break;
                        case "CustomFieldID":
                            jsonAssetCustomField.setCustomFieldID(fact.createAPIAssetCustomFieldCustomFieldID(value));
                            break;
                        case "DateTimeValue":
                            jsonAssetCustomField.setDateTimeValue(fact.createAPIAssetCustomFieldDateTimeValue(jsonDate(value)));
                            break;
                        case "IntValue":
                            jsonAssetCustomField.setIntValue(fact.createAPIAssetCustomFieldIntValue(assetCustomField.getInt(key)));
                            break;
                        case "LastModified":
                            jsonAssetCustomField.setLastModified(fact.createAPIAssetCustomFieldLastModified(jsonDate(value)));
                            break;
                        case "Name":
                            jsonAssetCustomField.setName(fact.createAPIAssetCustomFieldName(value));
                            break;
                        case "StringValue":
                            jsonAssetCustomField.setStringValue(fact.createAPIAssetCustomFieldStringValue(value));
                            break;
                    }
                }
                assetCustomFieldsArray.getValue().getAPIAssetCustomField().add(jsonAssetCustomField);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Location creation exception: "+e.toString());
        }
        return assetCustomFieldsArray;
    }
    
    private JAXBElement<ArrayOfAPIPerson> jsonPersons(JSONArray persons)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIPerson> personsArray = fact.createArrayOfAPIPerson(fact.createArrayOfAPIPerson());
        try
        {
            for(int i = 0; i < persons.length(); i++)
            {
                APIPerson jsonPerson = new APIPerson();
                JSONObject person = persons.getJSONObject(i);
                Iterator personIterator = person.keys();
                
                while(personIterator.hasNext())
                {
                    String key = personIterator.next().toString();
                    String value = person.getString(key);
                    switch(key)
                    {
                        case "Name":
                            jsonPerson.setName(fact.createAPIPersonName(value));
                            break;
                        case "Role":
                            jsonPerson.setRole(fact.createAPIPersonRole(value));
                            break;
                        case "RoleID":
                            jsonPerson.setRoleID(fact.createAPIPersonRoleID(value));
                            break;
                        case "UserID":
                            jsonPerson.setUserID(fact.createAPIPersonUserID(value));
                            break;
                    }
                }
                personsArray.getValue().getAPIPerson().add(jsonPerson);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Person creation exception: "+e.toString());
        }
        return personsArray;
    }
    
    private JAXBElement<ArrayOfAPIProcessor> jsonProcessors(JSONArray processors)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIProcessor> processorsArray = fact.createArrayOfAPIProcessor(fact.createArrayOfAPIProcessor());
        try
        {
            for(int i = 0; i < processors.length(); i++)
            {
                APIProcessor jsonProcessor = new APIProcessor();
                JSONObject processor = processors.getJSONObject(i);
                Iterator processorIterator = processor.keys();
                
                while(processorIterator.hasNext())
                {
                    String key = processorIterator.next().toString();
                    String value = processor.getString(key);
                    switch(key)
                    {
                        case "Autodiscover":
                            jsonProcessor.setAutodiscover(fact.createAPIProcessorAutodiscover(processor.getBoolean(key)));
                            break;
                        case "ConnectInfo":
                            jsonProcessor.setConnectInfo(fact.createAPIProcessorConnectInfo(value));
                            break;
                        case "ConnectSSL":
                            jsonProcessor.setConnectSSL(fact.createAPIProcessorConnectSSL(processor.getBoolean(value)));
                            break;
                        case "Connected":
                            jsonProcessor.setConnected(fact.createAPIProcessorConnected(processor.getBoolean(value)));
                            break;
                        case "IPID":
                            jsonProcessor.setIPID(fact.createAPIProcessorIPID(processor.getInt(value)));
                            break;
                        case "LastModified":
                            jsonProcessor.setLastModified(fact.createAPIProcessorLastModified(jsonDate(value)));
                            break;
                        case "Location":
                            jsonProcessor.setLocation(fact.createAPIProcessorLocation(value));
                            break;
                        case "ParentID":
                            jsonProcessor.setParentID(fact.createAPIProcessorParentID(value));
                            break;
                        case "Password":
                            jsonProcessor.setPassword(fact.createAPIProcessorPassword(value));
                            break;
                        case "Port":
                            jsonProcessor.setPort(fact.createAPIProcessorPort(processor.getInt(key)));
                            break;
                        case "ProcessorID":
                            jsonProcessor.setProcessorID(fact.createAPIProcessorProcessorID(value));
                            break;
                        case "ProcessorName":
                            jsonProcessor.setProcessorName(fact.createAPIProcessorProcessorName(value));
                            break;
                        case "SecurePort":
                            jsonProcessor.setSecurePort(fact.createAPIProcessorSecurePort(processor.getInt(key)));
                            break;
                        case "Symbols":
                            jsonProcessor.setSymbols(jsonSymbols(new JSONArray(value)));
                            break;
                        case "Username":
                            jsonProcessor.setUsername(fact.createAPIProcessorUsername(value));
                            break;
                    }
                }
                processorsArray.getValue().getAPIProcessor().add(jsonProcessor);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Processor creation exception: "+e.toString());
        }
        return processorsArray;
    }
    
    private JAXBElement<ArrayOfAPISymbol> jsonSymbols(JSONArray symbols)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPISymbol> symbolsArray = fact.createArrayOfAPISymbol(fact.createArrayOfAPISymbol());
        try
        {
            for(int i = 0; i < symbols.length(); i++)
            {
                APISymbol jsonSymbol = new APISymbol();
                JSONObject symbol = symbols.getJSONObject(i);
                Iterator symbolIterator = symbol.keys();
                
                while(symbolIterator.hasNext())
                {
                    String key = symbolIterator.next().toString();
                    String value = symbol.getString(key);
                    switch(key)
                    {
                        case "ConnectInfo":
                            jsonSymbol.setConnectInfo(fact.createAPISymbolConnectInfo(value));
                            break;
                        case "IPID":
                            jsonSymbol.setIPID(fact.createAPISymbolIPID(symbol.getInt(value)));
                            break;
                        case "LastModified":
                            jsonSymbol.setLastModified(fact.createAPISymbolLastModified(jsonDate(value)));
                            break;
                        case "NodeID":
                            jsonSymbol.setNodeID(fact.createAPISymbolNodeID(value));
                            break;
                        case "NodeText":
                            jsonSymbol.setNodeText(fact.createAPISymbolNodeText(value));
                            break;
                        case "Password":
                            jsonSymbol.setPassword(fact.createAPISymbolPassword(value));
                            break;
                        case "ProcessorID":
                            jsonSymbol.setProcessorID(fact.createAPISymbolProcessorID(value));
                            break;
                        case "ParentID":
                            jsonSymbol.setProcessorName(fact.createAPISymbolProcessorName(value));
                            break;
                        case "RoomID":
                            jsonSymbol.setRoomID(fact.createAPISymbolRoomID(value));
                            break;
                        case "Signals":
                            jsonSymbol.setSignals(jsonSignals(new JSONArray(value)));
                            break;
                        case "SymbolID":
                            jsonSymbol.setSymbolID(fact.createAPISymbolSymbolID(value));
                            break;
                        case "SymbolName":
                            jsonSymbol.setSymbolName(fact.createAPISymbolSymbolName(value));
                            break;
                        case "UserName":
                            jsonSymbol.setUserName(fact.createAPISymbolUserName(value));
                            break;
                        case "Version":
                            jsonSymbol.setVersion(fact.createAPISymbolVersion(value));
                            break;
                    }
                }
                symbolsArray.getValue().getAPISymbol().add(jsonSymbol);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Symbol creation exception: "+e.toString());
        }
        return symbolsArray;
    }
    
    private JAXBElement<ArrayOfAPISignal> jsonSignals(JSONArray signals)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPISignal> signalsArray = fact.createArrayOfAPISignal(fact.createArrayOfAPISignal());
        try
        {
            for(int i = 0; i < signals.length(); i++)
            {
                APISignal jsonSignal = new APISignal();
                JSONObject signal = signals.getJSONObject(i);
                Iterator signalIterator = signal.keys();
                
                while(signalIterator.hasNext())
                {
                    String key = signalIterator.next().toString();
                    String value = signal.getString(key);
                    switch(key)
                    {
                        case "AttributeID":
                            jsonSignal.setAttributeID(fact.createAPISignalAttributeID(value));
                            break;
                        case "AttributeName":
                            jsonSignal.setAttributeName(fact.createAPISignalAttributeName(value));
                            break;
                        case "AttributeType":
                            jsonSignal.setAttributeType(APIEnumAttributeType.values()[signal.getInt(key)]);
                            break;
                        case "DefaultIOMask":
                            jsonSignal.setDefaultIOMask(APIEnumAttributeIOMask.values()[signal.getInt(key)]);
                            break;
                        case "JoinNumber":
                            jsonSignal.setJoinNumber(fact.createAPISignalJoinNumber(signal.getInt(key)));
                            break;
                        case "LastModified":
                            jsonSignal.setLastModified(fact.createAPISignalLastModified(jsonDate(value)));
                            break;
                        case "LogicalOperator":
                            jsonSignal.setLogicalOperator(APIEnumLogicalOperator.values()[signal.getInt(key)]);
                            break;
                        case "Reserved":
                            jsonSignal.setReserved(fact.createAPISignalReserved(signal.getBoolean(key)));
                            break;
                        case "SignalID":
                            jsonSignal.setSignalID(fact.createAPISignalSignalID(value));
                            break;
                        case "SignalMaxValue":
                            jsonSignal.setSignalMaxValue(fact.createAPISignalSignalMaxValue(signal.getInt(key)));
                            break;
                        case "SignalMinValue":
                            jsonSignal.setSignalMinValue(fact.createAPISignalSignalMinValue(signal.getInt(key)));
                            break;
                        case "SignalName":
                            jsonSignal.setSignalName(fact.createAPISignalSignalName(value));
                            break;
                        case "Slot":
                            jsonSignal.setSlot(fact.createAPISignalSlot(value));
                            break;
                        case "SymbolID":
                            jsonSignal.setSymbolID(fact.createAPISignalSymbolID(value));
                            break;
                        case "SymbolName":
                            jsonSignal.setSymbolName(fact.createAPISignalSymbolName(value));
                            break;
                        case "XmlName":
                            jsonSignal.setXmlName(fact.createAPISignalXmlName(value));
                            break;
                    }
                }
                signalsArray.getValue().getAPISignal().add(jsonSignal);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Signal creation exception: "+e.toString());
        }
        return signalsArray;
    }
    
    private JAXBElement<ArrayOfAPIAction> jsonActions(JSONArray actions)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAction> actionsArray = fact.createArrayOfAPIAction(fact.createArrayOfAPIAction());
        try
        {
            for(int i = 0; i < actions.length(); i++)
            {
                APIAction jsonAction = new APIAction();
                JSONObject action = actions.getJSONObject(i);
                Iterator actionIterator = action.keys();
                
                while(actionIterator.hasNext())
                {
                    String key = actionIterator.next().toString();
                    String value = action.getString(key);
                    switch(key)
                    {
                        case "ActionDescription":
                            jsonAction.setActionDescription(fact.createAPIActionActionDescription(value));
                            break;
                        case "ActionID":
                            jsonAction.setActionID(fact.createAPIActionActionID(value));
                            break;
                        case "ActionName":
                            jsonAction.setActionName(fact.createAPIActionActionName(value));
                            break;
                        case "IsOverride":
                            jsonAction.setIsOverride(fact.createAPIActionIsOverride(action.getBoolean(key)));
                            break;
                        case "LastModified":
                            jsonAction.setLastModified(fact.createAPIActionLastModified(jsonDate(value)));
                            break;
                        case "OffsetMinutes":
                            jsonAction.setOffsetMinutes(fact.createAPIActionOffsetMinutes(action.getInt(key)));
                            break;
                        case "OverriddenActionID":
                            jsonAction.setOverriddenActionID(fact.createAPIActionOverriddenActionID(value));
                            break;
                        case "StepList":
                            jsonAction.setStepList(jsonActionSteps(new JSONArray(value)));
                            break;
                    }
                }
                actionsArray.getValue().getAPIAction().add(jsonAction);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Action creation exception: "+e.toString());
        }
        return actionsArray;
    }
    
    private JAXBElement<ArrayOfAPIAppointment> jsonAppointments(JSONArray appointments)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIAppointment> appointmentsArray = fact.createArrayOfAPIAppointment(fact.createArrayOfAPIAppointment());
        try
        {
            for(int i = 0; i < appointments.length(); i++)
            {
                APIAppointment jsonAppointment = new APIAppointment();
                JSONObject appointment = appointments.getJSONObject(i);
                Iterator appointmentIterator = appointment.keys();
                
                while(appointmentIterator.hasNext())
                {
                    String key = appointmentIterator.next().toString();
                    String value = appointment.getString(key);
                    switch(key)
                    {
                        case "Actions":
                            jsonAppointment.setActions(jsonActions(new JSONArray(value)));
                            break;
                        case "AltID":
                            jsonAppointment.setAltID(fact.createAPIAppointmentAltID(value));
                            break;
                        case "Attendees":
                            jsonAppointment.setAttendees(fact.createAPIAppointmentAttendees(value));
                            break;
                        case "End":
                            jsonAppointment.setEnd(fact.createAPIAppointmentEnd(jsonDate(value)));
                            break;
                        case "EventOrMeeting":
                            jsonAppointment.setEventOrMeeting(fact.createAPIAppointmentEventOrMeeting(APIEnumEventOrMeeting.values()[appointment.getInt(key)]));
                            break;
                        case "GW_MeetingID":
                            jsonAppointment.setGWMeetingID(fact.createAPIAppointmentGWMeetingID(value));
                            break;
                        case "IsPrivate":
                            jsonAppointment.setIsPrivate(fact.createAPIAppointmentIsPrivate(appointment.getBoolean(key)));
                            break;
                        case "LastModified":
                            jsonAppointment.setLastModified(fact.createAPIAppointmentLastModified(jsonDate(value)));
                            break;
                        case "Location":
                            jsonAppointment.setLocation(fact.createAPIAppointmentLocation(value));
                            break;
                        case "MeetingComment":
                            jsonAppointment.setMeetingComment(fact.createAPIAppointmentMeetingComment(value));
                            break;
                        case "MeetingSubject":
                            jsonAppointment.setMeetingSubject(fact.createAPIAppointmentMeetingSubject(value));
                            break;
                        case "MeetingType":
                            jsonAppointment.setMeetingType(fact.createAPIAppointmentMeetingType(APIEnumMeetingType.values()[appointment.getInt(key)]));
                            break;
                        case "NotifyAction":
                            jsonAppointment.setNotifyAction(fact.createAPIAppointmentNotifyAction(APIEnumPushNotifyAction.values()[appointment.getInt(key)]));
                            break;
                        case "Organizer":
                            jsonAppointment.setOrganizer(fact.createAPIAppointmentOrganizer(value));
                            break;
                        case "Preset":
                            jsonAppointment.setPreset(fact.createAPIAppointmentPreset(jsonPreset(new JSONObject(value))));
                            break;
                        case "RRule":
                            jsonAppointment.setRRule(fact.createAPIAppointmentRRule(value));
                            break;
                        case "RV_MeetingID":
                            jsonAppointment.setRVMeetingID(fact.createAPIAppointmentRVMeetingID(value));
                            break;
                        case "RolesForMeeting":
                            jsonAppointment.setRolesForMeeting(jsonRoles(new JSONArray(value)));
                            break;
                        case "RoomID":
                            jsonAppointment.setRoomID(fact.createAPIAppointmentRoomID(value));
                            break;
                        case "Start":
                            jsonAppointment.setStart(fact.createAPIAppointmentStart(jsonDate(value)));
                            break;
                    }
                }
                appointmentsArray.getValue().getAPIAppointment().add(jsonAppointment);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Appointment creation exception: "+e.toString());
        }
        return appointmentsArray;
    }
    
    private JAXBElement<ArrayOfAPIRole> jsonRoles(JSONArray roles)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIRole> rolesArray = fact.createArrayOfAPIRole(fact.createArrayOfAPIRole());
        try
        {
            for(int i = 0; i < roles.length(); i++)
            {
                APIRole jsonRole = new APIRole();
                JSONObject role = roles.getJSONObject(i);
                Iterator roleIterator = role.keys();
                
                while(roleIterator.hasNext())
                {
                    String key = roleIterator.next().toString();
                    String value = role.getString(key);
                    switch(key)
                    {
                        case "Contacts":
                            jsonRole.setContacts(jsonRoleContacts(new JSONArray(value)));
                            break;
                        case "IsBuiltIn":
                            jsonRole.setIsBuiltIn(fact.createAPIRoleIsBuiltIn(role.getBoolean(key)));
                            break;
                        case "LastModified":
                            jsonRole.setLastModified(fact.createAPIRoleLastModified(jsonDate(value)));
                            break;
                        case "NodeID":
                            jsonRole.setNodeID(fact.createAPIRoleNodeID(value));
                            break;
                        case "NodeText":
                            jsonRole.setNodeText(fact.createAPIRoleNodeText(value));
                            break;
                        case "Options":
                            jsonRole.setOptions(jsonRoleOptions(new JSONArray(value)));
                            break;
                        case "RoleID":
                            jsonRole.setRoleID(fact.createAPIRoleRoleID(value));
                            break;
                        case "RoleName":
                            jsonRole.setRoleName(fact.createAPIRoleRoleName(value));
                            break;
                    }
                }
                rolesArray.getValue().getAPIRole().add(jsonRole);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Role creation exception: "+e.toString());
        }
        return rolesArray;
    }
    
    private JAXBElement<ArrayOfAPIRoleContact> jsonRoleContacts(JSONArray rolecontactss)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIRoleContact> roleContactsArray = fact.createArrayOfAPIRoleContact(fact.createArrayOfAPIRoleContact());
        try
        {
            for(int i = 0; i < rolecontactss.length(); i++)
            {
                APIRoleContact jsonRoleContact = new APIRoleContact();
                JSONObject roleContact = rolecontactss.getJSONObject(i);
                Iterator roleContactsIterator = roleContact.keys();
                
                while(roleContactsIterator.hasNext())
                {
                    String key = roleContactsIterator.next().toString();
                    String value = roleContact.getString(key);
                    switch(key)
                    {
                        case "ContactID":
                            jsonRoleContact.setContactID(fact.createAPIRoleContactContactID(value));
                            break;
                        case "IsRoomViewUser":
                            jsonRoleContact.setIsRoomViewUser(fact.createAPIRoleContactIsRoomViewUser(roleContact.getBoolean(key)));
                            break;
                        case "Name":
                            jsonRoleContact.setName(fact.createAPIRoleContactName(value));
                            break;
                        case "SmtpAddress":
                            jsonRoleContact.setSmtpAddress(fact.createAPIRoleContactSmtpAddress(value));
                            break;
                        case "UseHtml":
                            jsonRoleContact.setUseHtml(fact.createAPIRoleContactUseHtml(roleContact.getBoolean(key)));
                            break;
                        case "UserID":
                            jsonRoleContact.setUserID(fact.createAPIRoleContactUserID(value));
                            break;
                        case "WebClientUserID":
                            jsonRoleContact.setWebClientUserID(fact.createAPIRoleContactWebClientUserID(value));
                            break;
                    }
                }
                roleContactsArray.getValue().getAPIRoleContact().add(jsonRoleContact);
            }
        }
        catch(JSONException e)
        {
            System.out.println("RoleContacts creation exception: "+e.toString());
        }
        return roleContactsArray;
    }
    
    private JAXBElement<ArrayOfAPIRoleOption> jsonRoleOptions(JSONArray roleoptionss)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIRoleOption> roleOptionsArray = fact.createArrayOfAPIRoleOption(fact.createArrayOfAPIRoleOption());
        try
        {
            for(int i = 0; i < roleoptionss.length(); i++)
            {
                APIRoleOption jsonRoleOption = new APIRoleOption();
                JSONObject roleOption = roleoptionss.getJSONObject(i);
                Iterator roleOptionsIterator = roleOption.keys();
                
                while(roleOptionsIterator.hasNext())
                {
                    String key = roleOptionsIterator.next().toString();
                    String value = roleOption.getString(key);
                    switch(key)
                    {
                        case "Created":
                            jsonRoleOption.setCreated(fact.createAPIRoleOptionCreated(jsonDate(value)));
                            break;
                        case "EmailTemplateID":
                            jsonRoleOption.setEmailTemplateID(fact.createAPIRoleOptionEmailTemplateID(value));
                            break;
                        case "LastModified":
                            jsonRoleOption.setLastModified(fact.createAPIRoleOptionLastModified(jsonDate(value)));
                            break;
                        case "MeetingNotificationOption":
                            jsonRoleOption.setMeetingNotificationOption(fact.createAPIRoleOptionMeetingNotificationOption(APIEnumMeetingEventType.values()[roleOption.getInt(key)]));
                            break;
                    }
                }
                roleOptionsArray.getValue().getAPIRoleOption().add(jsonRoleOption);
            }
        }
        catch(JSONException e)
        {
            System.out.println("RoleOptions creation exception: "+e.toString());
        }
        return roleOptionsArray;
    }
    
    private APIPreset jsonPreset(JSONObject preset)
    {
        ObjectFactory fact = new ObjectFactory();
        APIPreset jsonPreset = new APIPreset();
        try
        {
            Iterator presetIterator = preset.keys();
            while(presetIterator.hasNext())
            {
                String key = presetIterator.next().toString();
                String value = preset.getString(key);
                switch(key)
                {
                    case "Enabled":
                        jsonPreset.setEnabled(fact.createAPIPresetEnabled(preset.getBoolean(key)));
                        break;
                    case "ImageSource1":
                        jsonPreset.setImageSource1(fact.createAPIPresetImageSource1(value));
                        break;
                    case "ImageSource2":
                        jsonPreset.setImageSource2(fact.createAPIPresetImageSource2(value));
                        break;
                    case "LastModified":
                        jsonPreset.setLastModified(fact.createAPIRoleOptionLastModified(jsonDate(value)));
                        break;
                    case "MaximumPresets":
                        jsonPreset.setMaximumPresets(fact.createAPIPresetMaximumPresets(preset.getInt(key)));
                        break;
                    case "PresetFields":
                        jsonPreset.setPresetFields(jsonPresetFields(new JSONArray(value)));
                        break;
                    case "PresetName":
                        jsonPreset.setPresetName(fact.createAPIPresetPresetName(value));
                        break;
                    case "PresetSlot":
                        jsonPreset.setPresetSlot(fact.createAPIPresetPresetSlot(preset.getInt(key)));
                        break;
                    case "WelcomeMessage":
                        jsonPreset.setWelcomeMessage(fact.createAPIPresetWelcomeMessage(value));
                        break;
                }
            }
        }
        catch(JSONException e)
        {
            System.out.println("Preset creation exception: "+e.toString());
        }
        return jsonPreset;
    }
    
    private JAXBElement<ArrayOfAPIPresetField> jsonPresetFields(JSONArray presetfieldss)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIPresetField> presetFieldsArray = fact.createArrayOfAPIPresetField(fact.createArrayOfAPIPresetField());
        try
        {
            for(int i = 0; i < presetfieldss.length(); i++)
            {
                APIPresetField jsonPresetField = new APIPresetField();
                JSONObject presetField = presetfieldss.getJSONObject(i);
                Iterator presetFieldsIterator = presetField.keys();
                
                while(presetFieldsIterator.hasNext())
                {
                    String key = presetFieldsIterator.next().toString();
                    String value = presetField.getString(key);
                    switch(key)
                    {
                        case "FieldLabel":
                            jsonPresetField.setFieldLabel(fact.createAPIPresetFieldFieldLabel(value));
                            break;
                        case "FieldSlot":
                            jsonPresetField.setFieldSlot(fact.createAPIPresetFieldFieldSlot(presetField.getInt(key)));
                            break;
                        case "FieldValue":
                            jsonPresetField.setFieldValue(fact.createAPIPresetFieldFieldValue(value));
                            break;
                        case "MaximumFields":
                            jsonPresetField.setMaximumFields(fact.createAPIPresetFieldMaximumFields(presetField.getInt(key)));
                            break;
                    }
                }
                presetFieldsArray.getValue().getAPIPresetField().add(jsonPresetField);
            }
        }
        catch(JSONException e)
        {
            System.out.println("PresetFields creation exception: "+e.toString());
        }
        return presetFieldsArray;
    }
    
    private JAXBElement<ArrayOfAPIActionStep> jsonActionSteps(JSONArray actionSteps)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPIActionStep> actionStepsArray = fact.createArrayOfAPIActionStep(fact.createArrayOfAPIActionStep());
        try
        {
            for(int i = 0; i < actionSteps.length(); i++)
            {
                APIActionStep jsonActionStep = new APIActionStep();
                JSONObject actionStep = actionSteps.getJSONObject(i);
                Iterator actionStepsIterator = actionStep.keys();
                
                while(actionStepsIterator.hasNext())
                {
                    String key = actionStepsIterator.next().toString();
                    String value = actionStep.getString(key);
                    switch(key)
                    {
                        case "AnalogValue":
                            jsonActionStep.setAnalogValue(fact.createAPIActionStepAnalogValue(actionStep.getInt(key)));
                            break;
                        case "AttributeID":
                            jsonActionStep.setAttributeID(fact.createAPIActionStepAttributeID(value));
                            break;
                        case "AttributeType":
                            jsonActionStep.setAttributeType(APIEnumAttributeTypes.values()[actionStep.getInt(key)]);
                            break;
                        case "DigitalValue":
                            jsonActionStep.setDigitalValue(fact.createAPIActionStepDigitalValue(actionStep.getBoolean(key)));
                            break;
                        case "LastModified":
                            jsonActionStep.setLastModified(fact.createAPIActionStepLastModified(jsonDate(value)));
                            break;
                        case "OrderIndex":
                            jsonActionStep.setOrderIndex(fact.createAPIActionStepOrderIndex(actionStep.getInt(key)));
                            break;
                        case "SerialValue":
                            jsonActionStep.setSerialValue(fact.createAPIActionStepSerialValue(value));
                            break;
                    }
                }
                actionStepsArray.getValue().getAPIActionStep().add(jsonActionStep);
            }
        }
        catch(JSONException e)
        {
            System.out.println("ActionStep creation exception: "+e.toString());
        }
        return actionStepsArray;
    }
    
    private JAXBElement<ArrayOfAPINode> jsonNodes(JSONArray nodes)
    {
        ObjectFactory fact = new ObjectFactory();
        JAXBElement<ArrayOfAPINode> nodesArray = fact.createArrayOfAPINode(fact.createArrayOfAPINode());
        try
        {
            for(int i = 0; i < nodes.length(); i++)
            {
                APINode jsonNode = new APINode();
                JSONObject node = nodes.getJSONObject(i);
                Iterator nodesIterator = node.keys();
                
                while(nodesIterator.hasNext())
                {
                    String key = nodesIterator.next().toString();
                    String value = node.getString(key);
                    switch(key)
                    {
                        case "HasChildren":
                            jsonNode.setHasChildren(node.getBoolean(key));
                            break;
                        case "LastModified":
                            jsonNode.setLastModified(fact.createAPINodeLastModified(jsonDate(value)));
                            break;
                        case "NodeID":
                            jsonNode.setNodeID(fact.createAPINodeNodeID(value));
                            break;
                        case "NodeName":
                            jsonNode.setNodeName(fact.createAPINodeNodeName(value));
                            break;
                        case "NodeType":
                            jsonNode.setNodeType(fact.createAPINodeNodeType(APIEnumNodeType.values()[node.getInt(key)]));
                            break;
                        case "ParentNodeID":
                            jsonNode.setParentNodeID(fact.createAPINodeParentNodeID(value));
                            break;
                        case "TreeNodeChildren":
                            jsonNode.setTreeNodeChildren(fact.createAPINodeTreeNodeChildren(jsonNodes(new JSONArray(value)).getValue()));
                            break;
                    }
                }
                nodesArray.getValue().getAPINode().add(jsonNode);
            }
        }
        catch(JSONException e)
        {
            System.out.println("Node creation exception: "+e.toString());
        }
        return nodesArray;
    }
    
    private XMLGregorianCalendar jsonDate(String date)
    {
        try
        {
            date = date.substring(6,date.length()-7);
            Date uDate = new Date(Long.parseLong(date));
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(uDate);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public APIResult getResult()
    {
        return JSONResult;
    }
}
