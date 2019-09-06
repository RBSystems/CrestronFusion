package com.ztfd.crestronFusion.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ztfd.crestronFusion.api.entities.APIResult;
import com.ztfd.crestronFusion.api.entities.APIRoom;
import com.ztfd.crestronFusion.helpers.*;



@Service
public class RoomService {

    private static String serviceUrl = "";

    private static String currPage = "Room ";

    @Value("${serviceUrl}")
    public  void setServiceUrl(String Url){
        serviceUrl=Url;
    }

	public List<APIRoom> getRoomAll() {
		APIResult api_Result;
        APIRoom apiRoomToPutPost = null;

		api_Result = InvokeAPIService(serviceUrl, "null", "/rooms/", "GET", "JSON", apiRoomToPutPost);

		return api_Result.getAPIRooms().getValue().getAPIRoom();
        /*ArrayList<Room> list=new ArrayList<Room>();
        for(APIRoom r:lstApiRooms){
            Room room=new Room();
            room.setRoomName(r.getRoomName().getValue());
            list.add(room);
        }*/


	}
	private static APIResult InvokeAPIService(String serviceUrl, String queryString, String path, String requestMethod, String xmlJson, APIRoom apiRoomToPutPost) {
        String apiHttpRequest;
        String apiResult = "";
        String apiXmlJsonIn = "";
        String apiXmlJsonOut = "";
        String apiError = "";
        APIResult api_Result = null;
        String apiReturnResult = "";
        HttpURLConnection httpConn = null;
        JAXBContext jaxbContextRoom = null;
        Marshaller marshaller = null;
        JAXBContext jaxbContextResult = null;
        Unmarshaller unmarshaller = null;

        try {
            if (!"".equalsIgnoreCase(queryString)) {                                                                    //Proceed if querystring is not empty.
                httpConn = API_Helper.GetHttpURLConnection(serviceUrl, queryString, path, xmlJson, requestMethod);      //Create HttpURLConnection with passed values

                apiHttpRequest = httpConn.getURL().toString();                                                          //Store URL in apiHttpRequest, so that it can be shown in Result area.

                ApiLog.One.WriteText("HttpRequest ::" + apiHttpRequest);
                if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {                                      //Do some extra work for PUT/POST, as it needs Room resource to send with.
                    jaxbContextRoom = JAXBContext.newInstance(APIRoom.class);
                    marshaller = jaxbContextRoom.createMarshaller();
                    marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
                    StringWriter stringWriter = new StringWriter();
                    marshaller.marshal(apiRoomToPutPost, stringWriter);

                    String strObjectToPost = stringWriter.toString();                                                   //XML string generated of room resource.
                    apiXmlJsonIn = strObjectToPost;

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

                ApiLog.One.WriteText("XmlJsonOut ::" + apiReturnResult);
                apiXmlJsonOut = API_Helper.EncodeHTML(apiReturnResult);

                httpConn.disconnect();                                                                                   //Disconnect connection
                Integer respsponseCode = httpConn.getResponseCode();

                //if (respCode.equals(new Integer(200)) || respCode.equals(new Integer(400)))
                //Check for 200 -OK response

                try {

                    //Convert the returned result (unmarshal) into API_Result resource and return
                    //Also assign correct values to apiResult, apiXmlJsonOut so that it can be shown in results pane.

                    jaxbContextResult = JAXBContext.newInstance(APIResult.class);
                    unmarshaller = jaxbContextResult.createUnmarshaller();
                    JAXBElement<APIResult> elemApi_Result = null;

                    if (xmlJson.contains("json")) {
                        if (respsponseCode == HttpURLConnection.HTTP_CREATED || respsponseCode == HttpURLConnection.HTTP_OK) {
                            JSONPacker jsonPacker = new JSONPacker(apiReturnResult);
                            api_Result = jsonPacker.getResult();
                        }
                    } else {
                        InputStream is = new ByteArrayInputStream(apiReturnResult.getBytes());
                        elemApi_Result = (JAXBElement<APIResult>) unmarshaller.unmarshal(is);
                        api_Result = elemApi_Result.getValue();
                    }
                    if (api_Result.getStatus() != null) {
                        apiResult = api_Result.getStatus().getValue();
                    }
                    if (api_Result.getMessage() != null) {
                        apiResult = apiResult + " :: " + api_Result.getMessage().getValue();
                    }
                } catch (Exception ex) {
                    ApiLog.One.WriteException(ex);
                    String receivedResponse = "Server returned HTTP_RESPONSE_CODE ::" + respsponseCode;
                    ApiLog.One.WriteText(receivedResponse);
                    apiXmlJsonOut = receivedResponse;
                    apiResult = receivedResponse;
                }
            }
        } catch (Exception ex) {
            apiResult = "Error:" + API_Helper.ExtractAPIResultDetails(httpConn.getErrorStream());
            ApiLog.One.WriteException(ex);
            apiError = "Error Message: " + ex.getMessage() + "Stack Trace:" + ex.getStackTrace().toString();
        }
        return api_Result;
    }


}
