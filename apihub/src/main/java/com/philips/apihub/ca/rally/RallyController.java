package com.philips.apihub.ca.rally;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RallyController {

		@Autowired
		private RallyService rallyservice ;
		
		@RequestMapping("/ca/rally/project/{projectid}")
		public String GetRallyProjects(@PathVariable("projectid") String ProjectId) {
			
			
			
			return rallyservice.GetRallyProjects(ProjectId);
			
		} 
		
		
	}


