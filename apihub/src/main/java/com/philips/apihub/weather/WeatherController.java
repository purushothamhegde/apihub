package com.philips.apihub.weather;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherservice ;

	
	@RequestMapping("/Weather/city/{id}")
	public String GetWeather(@PathVariable("id") String City) {
		
		return weatherservice.GetWeather(City); 
			
			
		}
	

}
