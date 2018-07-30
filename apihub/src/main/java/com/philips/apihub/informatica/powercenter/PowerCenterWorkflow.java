package com.philips.apihub.informatica.powercenter;

public class PowerCenterWorkflow {

	private String WorkflowName="";
	private String WorkflowId="";

	public PowerCenterWorkflow() {
	}

	
	public PowerCenterWorkflow(String workflowName, String workflowId) {
		super();
		WorkflowName = workflowName;
		WorkflowId = workflowId;
	}
	public String getWorkflowName() {
		return WorkflowName;
	}
	public void setWorkflowName(String workflowName) {
		WorkflowName = workflowName;
	}
	public String getWorkflowId() {
		return WorkflowId;
	}
	public void setWorkflowId(String workflowId) {
		WorkflowId = workflowId;
	}
	

}
