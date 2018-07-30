package com.philips.apihub.clarity;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.philips.apihub.informatica.mdm.MDMService;

@Service
public class ClarityService {
	private String Clarity_Url="";
	private String userid="";
	private String password="";
	
	public static Logger logger = Logger.getLogger(MDMService.class.getName());
	public static String fileToRead = "C:\\Purush\\WebApps\\apihub\\src\\main\\resources\\BatchExtension.properties";
	
	
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

	    Clarity_Url = prop.getProperty("CLARITY_URL");
	    userid = prop.getProperty("CLARITY_USER_ID");
	    password = prop.getProperty("CLARITY_PASSWORD");
	    
	    
	
	}
	

	private String CreateProjectDetailsPayload(String sUserId, String sPassword,  String sProjectId)  {
		
		String strmlPayload ="";

		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:quer=\"http://www.niku.com/xog/Query\">" ;
		strmlPayload = strmlPayload + "<soapenv:Header><quer:Auth><quer:Username>"+sUserId +"</quer:Username><quer:Password>"+ sPassword +"</quer:Password></quer:Auth></soapenv:Header>";
		strmlPayload = strmlPayload +"<soapenv:Body><quer:Query><quer:Code>test_ret_prj_details</quer:Code><quer:Filter><quer:project_id>"+ sProjectId +"</quer:project_id></quer:Filter></quer:Query></soapenv:Body>";
	    strmlPayload = strmlPayload + "</soapenv:Envelope>";
	    
	    System.out.println(strmlPayload);
	    
		return strmlPayload;
		
		
		
	}
	
	
	public String GetClarityProjectDetail(String ProjectId) throws IOException {
		
		GetRequiredProperties();
		
		
		String sPayload= CreateProjectDetailsPayload(userid, password, ProjectId);
		
		
		URL url = new URL(Clarity_Url);
		
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		
		
		byte[] buffer = new byte[sPayload.length()];
		buffer = sPayload.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction ="a";
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
		
		String responseString = "";
		String outputString = "";
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
//Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
		outputString = outputString + responseString;
		}
		
		return outputString;
		
	}
}
