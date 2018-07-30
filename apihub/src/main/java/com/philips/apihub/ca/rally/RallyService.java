package com.philips.apihub.ca.rally;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
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

import org.apache.commons.codec.binary.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RallyService {

	private String RallyUrl = "";
	private String username = "";
	private String password = "";

    private static SSLSocketFactory sslSocketFactory = null;
    
    
	public static String fileToRead = "C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\BatchExtension.properties";

	
	
	public String GetRallyProjects(String sProject) {
		
		GetRequiredProperties();
		String plainCreds = username +":"+ password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		String sRes="";
		String sUserStory="";
		String sUserStorydtl="";
		try {
			sRes= request(RallyUrl,base64Creds,false);
			ObjectMapper mapper = new ObjectMapper();
			
		
			RallyFeaturesResponse Featureresponse = mapper.readValue(sRes, RallyFeaturesResponse.class);
			sRes= "";						 
			 Results myresults[]=Featureresponse.getQueryResult().getResults();
			 
			 sUserStory="";
			 
			 
			 for (int i=0 ; i <= myresults.length-1;i++) {
				 
				 sRes=myresults[i].get_ref();
				 // So we got the List of Features. Now check if these features are of our Project.
				//System.out.println(sRes);
				 sRes= request(sRes,base64Creds,false);
				 
				 ObjectMapper mapper1 = new ObjectMapper();
				 RallyFeatureDetails FeatureList = mapper1.readValue(sRes, RallyFeatureDetails.class);
				 Feature myFeature = FeatureList.getFeature();
				 
				 
				 
				 if (myFeature.getProject().get_refObjectName().equals(sProject)) {
					 
					 // Find the User Stories associated with these features. 
					 
					 sUserStory= request(myFeature.getUserStories().get_ref(),base64Creds,false);
					 
					 UsResponse myusresp = mapper1.readValue(sUserStory, UsResponse.class);
					 
					 System.out.println(myusresp.getQueryResult().getTotalResultCount());					 
					 
					 List <UsResults> myresultlist =myusresp.getQueryResult().getResults();
					 
					 for ( int j =0 ; j <= myresultlist.size()-1; j++) {
						 
						 UsResults myresult = myresultlist.get(j);
						 sUserStorydtl=sUserStorydtl +myresult.getFormattedID() + " ::" + myresult.getFlowState().get_refObjectName() + "\n";
						 System.out.println(myresult.getFormattedID() + " ::" + myresult.getFlowState().get_refObjectName());
					 }
					 
					 
					 
				 }
				 
				 
				 
				 
					 				 
			 } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sUserStorydtl;
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

        
	    RallyUrl = prop.getProperty("RALLY_REST_URL");
		username = prop.getProperty("RALLY_USER_ID");
		password = prop.getProperty("RALLY_PASSWORD");

	}




public String request(String url, String authheader, boolean enableCertCheck) throws Exception {
    BufferedReader reader = null;
    
    StringBuilder sb = new StringBuilder();
    
    URL RALLYRESTURL= new URL(url);
        try {

        	
        	SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("185.46.212.97", 10015));
        	
        	
        	
            HttpsURLConnection myHttpsUrlConnection =(HttpsURLConnection) RALLYRESTURL.openConnection(proxy);
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
//            System.out.println(sb.toString());

            
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
