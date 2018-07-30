package com.philips.apihub.sfdc;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Service
public class SFDCService {

	private String SFDCUrl = "";
	private String accesstoken = "";
	private String SFDCActionUrl = "";
	private String consumerkey = "";
	private String consumersecret = "";
	private String username = "";
	private String password = "";
    private static SSLSocketFactory sslSocketFactory = null;

    public static String fileToRead = "C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\BatchExtension.properties";
	
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

    
    SFDCUrl = prop.getProperty("SFDC_LOGIN_URL");
	username = prop.getProperty("SFDC_USER_ID");
	password = prop.getProperty("SFDC_PASSWORD");
	consumerkey = prop.getProperty("SFDC_CONSUMER_KEY");
	consumersecret = prop.getProperty("SFDC_CONSUMER_SECRET");
	}

	

public String GetContact() {
	
	GetRequiredProperties();
	doLogin();
	
	String oauthToken = accesstoken;


	  String restUrl = SFDCActionUrl +"/services/data/v43.0/sobjects/Contact/listviews/00B28000006rXAnEAM/results";
	  HttpHeaders restHeaders = new HttpHeaders();
	  restHeaders.setContentType(MediaType.APPLICATION_JSON);
	  restHeaders.add("X-PrettyPrint", "1");
	  restHeaders.add("Authorization", "OAuth " + oauthToken);

	  // Create a Multi value map in case there are query params. In this example
	  // there are none so just an empty map is okay
	  MultiValueMap<String, String> mv2Map = new LinkedMultiValueMap<>();

	  // Following example code is using the RestTemplate exchange(..) method for making a GET request
	  // Other methods like getForEntity() or getForObject() can also be used.
	  HttpEntity<?> restRequest = new HttpEntity<>(mv2Map, restHeaders);
	  
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		
		
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("185.46.212.97", 10015));
		clientHttpRequestFactory.setProxy(proxy);

	
		
		
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

		
	  // Make a request and read the response string
	  ResponseEntity<String> responseStr = restTemplate.exchange(restUrl, HttpMethod.GET, restRequest,
	    String.class);

	  // Return just the body of the response. You can examine the headers, etc if you wish
	  HttpStatus responseStatus = responseStr.getStatusCode();
	  HttpHeaders responseHeaders = responseStr.getHeaders();
	  String responseBody = responseStr.getBody();

	  return responseBody;
	
}

@SuppressWarnings("unchecked")
private void doLogin() {
	
	SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
	
	Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("185.46.212.97", 10015));
	clientHttpRequestFactory.setProxy(proxy);
	
	
	RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

	  MultiValueMap<String, String> mvMap = new LinkedMultiValueMap<>();
	  mvMap.add("grant_type", "password");
	  mvMap.add("client_id", consumerkey);
	  mvMap.add("client_secret", consumersecret);
	  mvMap.add("username", username);
	  mvMap.add("password", password);
	  
	  Map<String, String> token = (Map<String, String>) restTemplate.postForObject(SFDCUrl, mvMap, Map.class);
	  accesstoken=token.get("access_token");
	  SFDCActionUrl=token.get("instance_url");
	  
	  
	  
	
	
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
