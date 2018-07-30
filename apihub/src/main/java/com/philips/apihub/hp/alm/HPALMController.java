package com.philips.apihub.hp.alm;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.apihub.clarity.ClarityService;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HPALMController {
	
	@Autowired
	private HPALMService HPAlmservice ;
	
	@RequestMapping("/hpalm/project/{projectid}")
	public String GetProjectDefects(@PathVariable("projectid") String ProjectId) throws Exception {
		HPAlmservice= new HPALMService();
		
		return HPAlmservice.GetProjectDefects(ProjectId);
		
	} 
	
	
}
