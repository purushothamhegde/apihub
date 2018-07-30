package com.philips.apihub.snow;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SnowController {

	@Autowired
	private SnowService snowservice ;

	
	
	@RequestMapping("/snow/incident/{id}")
	public String ExecuteJobGroup(@PathVariable("id") String IncidentId) throws IOException {
		return snowservice.GetIncidentDetails(IncidentId);
		
	}
	
	
	
}
