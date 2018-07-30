package com.philips.apihub.informatica.mdm;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.apihub.informatica.powercenter.PCJobResponse;
import com.philips.apihub.informatica.powercenter.PowerCenterService;
import com.philips.apihub.informatica.powercenter.PowerCenterWorkflow;

@RestController
public class MDMController {

	
	
	@Autowired
	private MDMService mdmservice ;
	
	@RequestMapping("/informatica/mdm")
	public String GetMDMJobGroups() throws IOException {
		return mdmservice.FetchBaseObjects();
		
	} 
	
	@RequestMapping("/informatica/mdm/{id}")
	public List<MDMJobResponse> ExecuteJobGroup(@PathVariable("id") String JobGroupId) throws IOException {
		return mdmservice.ExecuteBatchGroup(JobGroupId);
		
	}
	
	
	
}
