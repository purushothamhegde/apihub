package com.philips.apihub.informatica.mdm;

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
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class MDMService {
	
    private static SSLSocketFactory sslSocketFactory = null;	
	private String sifUrl = "";
	private String orsId = "";
	private String username = "";
	private String password = "";
    
	public static Logger logger = Logger.getLogger(MDMService.class.getName());
	public static String fileToRead = "C:\\Purush\\WebApps\\apihub\\src\\main\\resources\\BatchExtension.properties";

    @Autowired
    private MDMServiceDAO mdmServiceDAO;
    
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

	    sifUrl = prop.getProperty("MDM_SIF_URL");
	    orsId = prop.getProperty("MDM_ORS_ID");
	    username = prop.getProperty("MDM_USER_NAME");
	    password = prop.getProperty("MDM_PASSWORD");
	    
	    logger.info("SIF URL ::" + sifUrl);
	    logger.info("ORS ID ::" + orsId );
	    logger.info("User Id ::" + username);
	    logger.info("Password ::" + password);
	    
	
	}
	

	
	
	public String FetchBaseObjects() throws IOException {
		
		GetRequiredProperties();
		String strtext = CallService(sifUrl, orsId, username, password,"ExecuteFetchBaseObjects",  "BASE_OBJECT");
		return strtext ;
		
	}

	public List<MDMJobResponse> ExecuteBatchGroup(String BatchGroupName) {
		String rowidBatchGroup="";
		GetRequiredProperties();
		String strtext="";
		try {
			strtext = CallService(sifUrl, orsId, username, password,"ExecuteBatchGroup",  BatchGroupName);
			String Res= strtext ;
			logger.info(Res);
			// Now let us find the status using the C_REPOS Tables.
			
			int intstartpos=0;
			int intendpos=0;

			
			intstartpos=Res.indexOf("<rowidBatchGroupLog>")+20;
			intendpos=Res.indexOf("</rowidBatchGroupLog>");
			rowidBatchGroup= Res.substring(intstartpos, intendpos);
			logger.info("Batch Group Id ::" + rowidBatchGroup);
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return mdmServiceDAO.GetMDMJobGroupResponse(rowidBatchGroup);
	}
	
    protected static void setAcceptAllVerifier(HttpsURLConnection connection) throws NoSuchAlgorithmException, KeyManagementException {

        // Create the socket factory.
        // Reusing the same socket factory allows sockets to be
        // reused, supporting persistent connections.
        if( null == sslSocketFactory) {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, ALL_TRUSTING_TRUST_MANAGER, new java.security.SecureRandom());
            sslSocketFactory = sc.getSocketFactory();
        }

        connection.setSSLSocketFactory(sslSocketFactory);

        // Since we may be using a cert with a different name, we need to ignore
        // the hostname as well.
        connection.setHostnameVerifier(ALL_TRUSTING_HOSTNAME_VERIFIER);
    }

	
	private String CallService(String sUrl,String OrsId, String UserId, String Password, String ServiceName , String ServiceParam) throws IOException {
		
		String responseString = "";
		String outputString = "";
		URL url = new URL(sUrl);
		
		URLConnection connection = url.openConnection();
		
		try {
			setAcceptAllVerifier((HttpsURLConnection)connection);
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput ="";
		
		logger.info("Inside CallService::" );
	    
		
		if (ServiceName.equals("ExecuteFetchBaseObjects")){
			
			xmlInput=ExecuteFetchBaseObjects(sUrl, OrsId, UserId, Password,ServiceName,  ServiceParam);
			
		}
		else if (ServiceName.equals("ExecuteBatchGroup")) {
			
			xmlInput=ExecuteBatchGroup(sUrl, OrsId, UserId, Password,ServiceName,  ServiceParam);
			
		}
		
		
		
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
	
private String ExecuteFetchBaseObjects(String sUrl,String OrsId, String UserId, String Password, String ServiceName , String ServiceParam)  {
		
		String strmlPayload ="";
		strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:siperian.api\">\n" ;
		strmlPayload = strmlPayload + "<soapenv:Header/>";
	    strmlPayload = strmlPayload + "<soapenv:Body>";
	    strmlPayload = strmlPayload + "<urn:listSiperianObjects>";
	    strmlPayload = strmlPayload + "<urn:username>" + UserId + "</urn:username><urn:password><urn:password>" + Password + "</urn:password><urn:encrypted>false</urn:encrypted></urn:password> <urn:userResourcesOnly>TRUE</urn:userResourcesOnly>";
	    strmlPayload = strmlPayload + "<urn:orsId>" + OrsId + "</urn:orsId><urn:objectType>" + ServiceParam + "</urn:objectType>";
	    strmlPayload = strmlPayload + "</urn:listSiperianObjects></soapenv:Body></soapenv:Envelope>";
	    
		return strmlPayload;
		
	}
	

private String ExecuteBatchGroup(String sUrl,String OrsId, String UserId, String Password, String ServiceName , String ServiceParam)  {
	
	String strmlPayload ="";
	strmlPayload=" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:siperian.api\">\n" ;
	strmlPayload = strmlPayload + "<soapenv:Header/>";
    strmlPayload = strmlPayload + "<soapenv:Body>";
    strmlPayload = strmlPayload + "<urn:executeBatchGroup>";
    strmlPayload = strmlPayload + "<urn:username>" + UserId + "</urn:username><urn:password><urn:password>" + Password + "</urn:password><urn:encrypted>false</urn:encrypted></urn:password>";
    strmlPayload = strmlPayload + "<urn:orsId>" + OrsId + "</urn:orsId><urn:batchGroupUid>" + ServiceParam + "</urn:batchGroupUid> <urn:resume>No</urn:resume>";
    strmlPayload = strmlPayload + "</urn:executeBatchGroup></soapenv:Body></soapenv:Envelope>";
    
	return strmlPayload;
	
}









/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	
	
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}


    private static final TrustManager[] ALL_TRUSTING_TRUST_MANAGER = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        private static final HostnameVerifier ALL_TRUSTING_HOSTNAME_VERIFIER  = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };


}
