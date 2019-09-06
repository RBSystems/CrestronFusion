package com.ztfd.crestronFusion.servlet;

import com.ztfd.crestronFusion.api.entities.APIAsset;
import com.ztfd.crestronFusion.helpers.API_Helper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StatusService {

    private static String serviceUrl = "";


    @Value("${serviceUrl}")
    public  void setServiceUrl(String Url){
        serviceUrl=Url;
    }

    public HashMap<String,String> getAssetStatusByAssetID(String assetID){
        String result;
        String path = "/assets/"+assetID;
        APIAsset apiAssetToPutPost = null;
        result = InvokeAPIService(serviceUrl, "null", path, "GET", "XML", apiAssetToPutPost);
        System.out.println(result);
        Pattern assetStatusNamePattern = Pattern.compile("<AttributeName>(.*?)</AttributeName>");// 匹配的模式
        Matcher assetStatusName = assetStatusNamePattern.matcher(result);

        Pattern assetStatusValuePattern = Pattern.compile("<CurrentValue>(.*?)</CurrentValue>");// 匹配的模式
        Matcher assetStatusValue = assetStatusValuePattern.matcher(result);
        HashMap<String,String> assetStatusHashMap=new HashMap<>();

        while (assetStatusName.find()&&assetStatusValue.find()) {
            assetStatusHashMap.put(assetStatusName.group(1).replace(" ",""),assetStatusValue.group(1));
        }
        return assetStatusHashMap;

    }
    private static String InvokeAPIService(String serviceUrl, String queryString, String path, String requestMethod, String xmlJson, APIAsset apiAssetToPutPost) {

        String apiHttpRequest;
        String apiReturnResult = "";
        HttpURLConnection httpConn;
        JAXBContext jaxbContextAsset;
        Marshaller marshaller;

        try {
            if (!"".equalsIgnoreCase(queryString)) {                                                                    //Proceed if querystring is not empty.
                httpConn = API_Helper.GetHttpURLConnection(serviceUrl, queryString, path, xmlJson, requestMethod);      //Create HttpURLConnection with passed values
                apiHttpRequest = httpConn.getURL().toString();                                                          //Store URL in apiHttpRequest, so that it can be shown in Result area.

                ApiLog.One.WriteText("HttpRequest ::" + apiHttpRequest);                                                //Also log the request

                if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {                                      //Do some extra work for PUT/POST, as it needs Asset resource to send with.
                    jaxbContextAsset = JAXBContext.newInstance(APIAsset.class);
                    marshaller = jaxbContextAsset.createMarshaller();
                    marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
                    StringWriter stringWriter = new StringWriter();
                    marshaller.marshal(apiAssetToPutPost, stringWriter);

                    String strObjectToPost = stringWriter.toString();                                                   //XML string generated of Asset resource.

                    if (xmlJson.contains("json")) {                                                                     //If user selected JSON, then convert resource to JSON
                        strObjectToPost = API_Helper.GetJSONString(strObjectToPost);
                    }

                    OutputStream os = httpConn.getOutputStream();                                                       //get output stream, to write resource to.
                    os.write(strObjectToPost.getBytes());                                                               //write resource to output stream.
                    os.flush();
                    httpConn.connect();
                }

                BufferedReader in = new BufferedReader( //Get inputstream of http connection
                        new InputStreamReader( //This will return stream for all GET/PUT/POST/DELETE operations.
                                httpConn.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {                                                           //Read and store in apiReturnResult
                    apiReturnResult += inputLine;
                }
                httpConn.disconnect();

            }
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);;
        }
        return apiReturnResult;
    }
}
