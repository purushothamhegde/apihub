package com.philips.apihub.informatica.powercenter;

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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;



@Service
public class PowerCenterService {

	private String PCWSUrl = "";
	private String PCDomain = "";
	private String PCService = "";
	private String PCRepoName = "";
	private String PCFolder = "";
	private String username = "";
	private String usernamespace = "";
	private String password = "";

	public static String fileToRead = "C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\BatchExtension.properties";
	

	
	private List<PowerCenterWorkflow> pcworkflows= Arrays.asList(
			
			new PowerCenterWorkflow("wf_xyz","1"),
			new PowerCenterWorkflow("wf_abc","2")
			);
	
	public List<PowerCenterWorkflow> GetPowerCenterWorkflows(){
		
		return  pcworkflows;
		
	}


	
	private void GetRequiredProperties() {


		
		Properties prop = new Properties();
		
	    
        try {
            
            File file = new File(fileToRead);
            
            if (file.exists()) {
                //logger.info("Config file exists");
            } else {
                //logger.error("Exception :: GetRequiredProperties :: Config file not found");
                throw new RuntimeException("Exception :: GetRequiredProperties :: Config file not found");
            }
            
            prop.load(new FileInputStream(file));

        } catch (Exception e) {

            //logger.error("Exception :: GetRequiredProperties :: " + e.getMessage(), e);

            throw new RuntimeException("Exception :: GetRequiredProperties :: " + e.getMessage());
        }

        
	    PCWSUrl = prop.getProperty("PC_WS_URL");
	    PCDomain = prop.getProperty("PC_DOMAIN");;
		PCService = prop.getProperty("PC_SERVICE_NAME");
		PCRepoName = prop.getProperty("PC_REPO_NAME");
		PCFolder = prop.getProperty("PC_FOLDER");
		username = prop.getProperty("PC_USER_NAME");
		usernamespace = prop.getProperty("PC_USER_NAMESPACE");
		password = prop.getProperty("PC_PASSWORD");

		System.out.println("PC Url" + PCWSUrl);
		//logger.info("PC Domain" + PCDomain );
	    
	    
	    
	}
	

	
public PCJobResponse RunPCJob(String sWorkflowname) throws IOException {
		
		GetRequiredProperties();
		
		String SessionId = doLogin();
		
		String strtext = RunWorkflow(sWorkflowname,SessionId);
		PCJobResponse pcjobres= new PCJobResponse();
		pcjobres.setPcjobresponse(strtext);
				
		return pcjobres ;
		
	}
	

private String RunWorkflow(String workflowname , String SessionId)
{
	String strPayload="";
	String strResponse="";
	String wfstatus="";
	Integer StartPos=0;
	Integer EndPos=0;
			
	try {
	
		strPayload=StartWorkflow(PCDomain, PCService, PCFolder, SessionId, workflowname);
		strResponse = CallService(PCWSUrl,strPayload);
		
		
		strPayload=GetStatus(PCDomain, PCService, PCFolder, SessionId, workflowname);
		strResponse = CallService(PCWSUrl,strPayload);
		//<WorkflowRunStatus>SUCCEEDED</WorkflowRunStatus>

		StartPos= strResponse.indexOf("<WorkflowRunStatus>")+19;
		EndPos= strResponse.indexOf("</WorkflowRunStatus>");
		strResponse = strResponse.substring(StartPos, EndPos);
		
		
	//	logger.info("RunWorkflow Response ::" + strResponse );
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return strResponse ;
	
	
}

private String doLogin()
{
	String sessionId="";
	String strPayload="";
	String strResponse=""; 
			
	try {
	
		strPayload=Login(PCWSUrl, PCDomain, PCService, PCRepoName, PCFolder, username, usernamespace, password);
		strResponse = CallService(PCWSUrl,strPayload);
		
		if (strResponse.contains("<SessionId>")) {
		Integer istartpos = strResponse.indexOf("<SessionId>")+11;
		Integer iendtpos = strResponse.indexOf("</SessionId>");
		sessionId= strResponse.substring(istartpos, iendtpos);
		//logger.info("Session ID ::" + sessionId);
		}
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return sessionId;
}



	private String CallService(String sUrl, String Payload) throws IOException {
		
		String responseString = "";
		String outputString = "";
		URL url = new URL(sUrl);
		
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput ="";
		
		//logger.info("Inside CallService::" );
	    
		xmlInput=Payload;
		
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		
		
		String SOAPAction ="a";
		
		//logger.info("SOAP Message ::" + xmlInput );
		
		
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
		//logger.info("SOAP Raw Response ::" + outputString );
		
		return outputString;
		
	}
	
	
	
	private String Login(String sUrl,String Domain, String service, String reponame, String folder , String username, String usernamespace, String Password) 
	{
		String strmlPayload ="";
		
		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsh=\"http://www.informatica.com/wsh\">\n" ;
		strmlPayload = strmlPayload + "<soapenv:Header/>";
	    strmlPayload = strmlPayload + "<soapenv:Body>";
	    strmlPayload = strmlPayload + "<wsh:Login>";
	    strmlPayload = strmlPayload + "<RepositoryDomainName>" + PCDomain + "</RepositoryDomainName><RepositoryName>" + PCRepoName + "</RepositoryName>";
	    strmlPayload = strmlPayload + "<UserName>"+ username + "</UserName><Password>" + Password + "</Password><UserNameSpace>" + usernamespace + "</UserNameSpace>" ;
	    strmlPayload = strmlPayload + "</wsh:Login></soapenv:Body></soapenv:Envelope>";
	    
		return strmlPayload ;
	}
	
	
	private String StartWorkflow(String Domain, String service, String folder , String sessionid, String workflowName) 
	{
		String strmlPayload ="";
		
		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsh=\"http://www.informatica.com/wsh\">\n" ;
		strmlPayload = strmlPayload + "<soapenv:Header>" + "<wsh:Context><SessionId>"+  sessionid + "</SessionId></wsh:Context></soapenv:Header>";
	    strmlPayload = strmlPayload + "<soapenv:Body>";
	    strmlPayload = strmlPayload + "<wsh:StartWorkflow>" + "<DIServiceInfo><DomainName>" + Domain + "</DomainName><ServiceName>"+ service +"</ServiceName></DIServiceInfo><FolderName>"+ folder +"</FolderName>";
	    strmlPayload = strmlPayload + "<WorkflowName>"+ workflowName +"</WorkflowName>"; 
	    strmlPayload = strmlPayload + "<RequestMode>NORMAL</RequestMode></wsh:StartWorkflow></soapenv:Body></soapenv:Envelope>";
	    
		return strmlPayload ;
	}
	
	
	private String GetStatus(String Domain, String service, String folder , String sessionid, String workflowName)
	{
		String strmlPayload ="";
		
		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsh=\"http://www.informatica.com/wsh\">\n" ;
		strmlPayload = strmlPayload + "<soapenv:Header>" + "<wsh:Context><SessionId>"+  sessionid + "</SessionId></wsh:Context></soapenv:Header>";
	    strmlPayload = strmlPayload + "<soapenv:Body>";
	    strmlPayload = strmlPayload + "<wsh:GetWorkflowDetailsEx>" + "<DIServiceInfo><DomainName>" + Domain + "</DomainName><ServiceName>"+ service +"</ServiceName></DIServiceInfo><FolderName>"+ folder +"</FolderName>";
	    strmlPayload = strmlPayload + "<WorkflowName>"+ workflowName +"</WorkflowName>"; 
	    strmlPayload = strmlPayload + "</wsh:GetWorkflowDetailsEx></soapenv:Body></soapenv:Envelope>";
	    
		return strmlPayload ;

		
	}
	


}
