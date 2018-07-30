package com.philips.apihub.informatica.powercenter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerCenterController {

	@Autowired
	private PowerCenterService pcservice ;
	
	@RequestMapping("/informatica/pc")
	public List<PowerCenterWorkflow> GetPowerCenterWorkflows() {
		return pcservice.GetPowerCenterWorkflows();
		
	} 
	
	@RequestMapping("/informatica/pc/{id}")
	public PCJobResponse ExecutePCJob(@PathVariable("id") String WorkflowId) throws IOException {
		return pcservice.RunPCJob(WorkflowId);
		
	}
	
}
