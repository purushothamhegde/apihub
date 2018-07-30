package com.philips.apihub.clarity;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClarityController {

	@Autowired
	private ClarityService clarityservice ;
	
	@RequestMapping("/clarity/project/{projectid}")
	public String GetClarityProjectDetail(@PathVariable("projectid") String ProjectId) throws IOException {
		clarityservice= new ClarityService();	
		return clarityservice.GetClarityProjectDetail(ProjectId);
		
	} 
	
	
	
	
}
