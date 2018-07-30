package com.philips.apihub.snow;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SnowService {

	private String SNOWCUrl = "";
	private String username = "";
	private String password = "";

	public static String fileToRead = "C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\BatchExtension.properties";
	
	public String GetIncidentDetails(String IncidentId) {
		
		GetRequiredProperties();
		String restUrl = SNOWCUrl +"/api/now/table/incident/sysparm_query=number%3DINC0426263%5Ecaller_id.user_name%3D310307173&sysparm_limit=10";
		
		String plainCreds = username +":"+ password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("185.46.212.97", 10015));
		clientHttpRequestFactory.setProxy(proxy);

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		ResponseEntity <String> resp = restTemplate.exchange(restUrl, HttpMethod.GET, request, String.class);
				
		return resp.getBody();

		
		
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

    
    SNOWCUrl = prop.getProperty("SNOW_URL");
	username = prop.getProperty("SNOW_USER_ID");
	password = prop.getProperty("SNOW_PASSWORD");
	}



}
