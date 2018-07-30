package com.philips.apihub.informatica.dih;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;


public class GetDIHEventStatus {

	
    private static SSLSocketFactory sslSocketFactory = null;
    
    
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

	public String GetEventStatus(String sEvent) throws Exception {
		
		  
		  GetRequiredProperties();
		  
		  String sResponse="";
		  String DihUrl= DIHRestUrl + "/event/"+ sEvent;
		  
		  
		  
			String plainCreds = restusername +":"+ password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			sResponse= request(DihUrl,base64Creds,false);
			return sResponse;
		 }

    
    public String request(String url, String authheader, boolean enableCertCheck) throws Exception {
        BufferedReader reader = null;
        
        StringBuilder sb = new StringBuilder();
        URL DIHRESTURL= new URL(url);
        
            try {

                HttpsURLConnection myHttpsUrlConnection =(HttpsURLConnection) DIHRESTURL.openConnection();
                myHttpsUrlConnection.setRequestProperty("Authorization", "Basic " + authheader);
                
                
                myHttpsUrlConnection.setRequestMethod("GET");
                myHttpsUrlConnection.setDoInput(true);
                myHttpsUrlConnection.setDoOutput(true);
                

                

                // Normally, instanceof would also be used to check the type.
                if( ! enableCertCheck ) {
                    setAcceptAllVerifier((HttpsURLConnection)myHttpsUrlConnection);
                }

                reader = new BufferedReader(new InputStreamReader(myHttpsUrlConnection.getInputStream()), 1);

                char[] buf = new char[1024];
                
                int count = 0;
                while( -1 < (count = reader.read(buf)) ) {
                    sb.append(buf, 0, count);
                }
                System.out.println(sb.toString());

                
                reader.close();
                
                return sb.toString();

            } catch (IOException ex) {
                System.out.println(ex);

                if( null != reader ) {
                    reader.close();
                }
            }
			return sb.toString();
        }
    
    
    /**
     * Overrides the SSL TrustManager and HostnameVerifier to allow
     * all certs and hostnames.
     * WARNING: This should only be used for testing, or in a "safe" (i.e. firewalled)
     * environment.
     * 
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
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
