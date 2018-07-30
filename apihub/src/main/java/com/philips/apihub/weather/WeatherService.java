package com.philips.apihub.weather;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	private String sWeatherMapApikey="";
	private String sWeatherMapApiUrl="";
	
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

	    
	    sWeatherMapApikey = prop.getProperty("WEATHERMAP_API_KEY");
	    sWeatherMapApiUrl = prop.getProperty("WEATHERMAP_API_URL");
		}


	public String GetWeather(String City) {
		GetRequiredProperties();
		
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("185.46.212.97", 10015));
		clientHttpRequestFactory.setProxy(proxy);
		RestTemplate rs = new RestTemplate(clientHttpRequestFactory);

		
		
		if (City.equals("")) {
			
			City="Bangalore";
		}
		
		String response=rs.getForObject(sWeatherMapApiUrl +"?q=" + City +"&appid=" + sWeatherMapApikey , String.class);
		
		return response;
	}
	
	
}
