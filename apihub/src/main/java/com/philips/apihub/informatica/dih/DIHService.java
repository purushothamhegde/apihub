package com.philips.apihub.informatica.dih;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



@Service
public class DIHService {
	
	private String DIHUrl = "";
	private String DIHRestUrl="";
	
	private String username = "";
	private String password = "";
	private String restusername="";
	
	
	
	public static Logger logger = Logger.getLogger(DIHService.class.getName());
	public static String fileToRead = "C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\BatchExtension.properties";
	
	
	private void GetRequiredProperties() {


		
		Properties prop = new Properties();
		
        try {
            
            File file = new File(fileToRead);
            
            if (file.exists()) {
                logger.info("Config file exists");
            } else {
                logger.error("Exception :: GetRequiredProperties :: Config file not found");
                throw new RuntimeException("Exception :: GetRequiredProperties :: Config file not found");
            }
            
            prop.load(new FileInputStream(file));

        } catch (Exception e) {

            logger.error("Exception :: GetRequiredProperties :: " + e.getMessage(), e);

            throw new RuntimeException("Exception :: GetRequiredProperties :: " + e.getMessage());
        }

        DIHUrl = prop.getProperty("DIH_WS_URL");
	    username = prop.getProperty("DIH_USER_NAME");
		password = prop.getProperty("DIH_PASSWORD");

        DIHRestUrl = prop.getProperty("DIH_REST_URL");
        restusername= prop.getProperty("DIH_REST_USER_NAME");
        
	    
	
	}

	
	public String RunDIHJob(String spub_sub_Name, String PubSubType) throws IOException {
		
		GetRequiredProperties();
		
		
		String strtext = RunPubSub( username,password,  spub_sub_Name, PubSubType);
				
		return strtext ;
		
	}




	public String RunPubSub(String UserName, String Password,  String spub_sub_Name, String PubSubType) throws IOException {
		String strtext = GeneratePayload(UserName , Password, spub_sub_Name, PubSubType);
		strtext = CallService(DIHUrl, strtext);
		return strtext ;
		
	}


	private String GeneratePayload(String username, String Password, String sPubsubName, String PubSubType) 
	{
		String strmlPayload ="";
		
		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:inf=\"http://www.informatica.com/\" xmlns:ser=\"http://b2b.informatica.com/dih/962/services\"> \n" ;
		strmlPayload = strmlPayload + "<soapenv:Header><inf:Security><UsernameToken><Username>" + username + "</Username><Password>" + Password +"</Password></UsernameToken></inf:Security></soapenv:Header>";
		strmlPayload = strmlPayload + "<soapenv:Body>";
	    strmlPayload = strmlPayload + "<ser:StartPubSubRequest>";
	    strmlPayload = strmlPayload + "<name>" +  sPubsubName + "</name><preprocessPublication>false</preprocessPublication>";
	    strmlPayload = strmlPayload + "<type>"+ PubSubType +"</type>" ;
	    strmlPayload = strmlPayload + "</ser:StartPubSubRequest></soapenv:Body></soapenv:Envelope>";
	    
		return strmlPayload ;
	}



	private String CallService(String sUrl, String Payload) throws IOException {
		
		String responseString = "";
		String outputString = "";
		URL url = new URL(sUrl);
		
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput ="";
		
		logger.info("Inside CallService::" );
	    
		xmlInput=Payload;
		
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		
		
		String SOAPAction ="a";
		
		logger.info("SOAP Message ::" + xmlInput );
		
		
		httpConn.setRequestProperty("Content-Length",
		String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		
		out.write(b);
		out.close();
		
		
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
	//Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
		outputString = outputString + responseString;
		}
		logger.info("SOAP Raw Response ::" + outputString );
		
		return outputString;
		
	}


	public String GetEventStatus(String sEvent) throws Exception {
		
		GetDIHEventStatus mydihEvent = new GetDIHEventStatus();
		
			return mydihEvent.GetEventStatus(sEvent);
		 }

	}




