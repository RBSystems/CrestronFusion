package com.ztfd.crestronFusion.servlet;


import com.ztfd.crestronFusion.helpers.API_Constants;
import com.ztfd.crestronFusion.helpers.API_Helper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class LoginService {

    private static String serviceUrl = "";
    private static String apiPasscode = "";


    @Value("${serviceUrl}")
    public  void setServiceUrl(String Url){
        serviceUrl=Url;
    }

    @Value("${apiPasscode}")
    public void setAPIPasscode(String passcode){
        apiPasscode=passcode;
    }

    public Integer login(String name,String pwd,String roles){

        Integer result = LoginToAPI(apiPasscode, name, pwd, roles);
        return 1;
    }


    protected Integer LoginToAPI(String apiPasscode, String userName, String password, String roles) {
        String currPage = "Login ";
        ApiLog.One.WriteText(currPage + " Enter LoginToAPI");
        String retResult = "";

        try {
            String path = "/Security/" + userName + "/";
           // Integer securityLevel = Integer.parseInt(getServletContext().getInitParameter("SecurityLevel"));
            System.out.println( API_Helper.GetSecuredToken(1, userName, apiPasscode));
            String queryString = "roles=" + roles
                    + "&ReturnUrl=" + serviceUrl
                    + "&" +API_Helper.GetSecuredToken(1, userName, apiPasscode);
            System.out.println(queryString);
            HttpURLConnection httpConn = API_Helper.GetHttpURLConnection(serviceUrl, queryString, path, API_Constants.WebRequestContentTypeXml, null);
            httpConn.disconnect();
            Integer i=httpConn.getResponseCode();
            System.out.println(i);
            /*httpConn.setInstanceFollowRedirects(false);
            apiHttpRequest = httpConn.getURL().toString();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            httpConn.getInputStream()));
            String inputLine;
            try {
                while ((inputLine = in.readLine()) != null) {
                    retResult += inputLine;
                }
            } catch (Exception ex) {
            }


            // Check if it is a redirect.
            int httpResponseCode = httpConn.getResponseCode();
            if (httpResponseCode == HttpURLConnection.HTTP_MOVED_PERM
                    || httpResponseCode == HttpURLConnection.HTTP_MOVED_TEMP
                    || httpResponseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                apiXmlJsonOut = API_Helper.EncodeHTML(retResult);
                ApiLog.One.WriteText("XmlJsonOut ::" + retResult);
                retResult = GetUrlFromResult(retResult);
                in.close();
            }*/
        } catch (Exception ex) {
            ApiLog.One.WriteException(ex);

        }
        ApiLog.One.WriteText(currPage + " Leave LoginToAPI");
        return 1;
    }

}
