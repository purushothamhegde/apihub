package com.philips.apihub.informatica.mdm;

import java.io.Serializable;
import java.util.List;


public class MDMJobResponseList implements Serializable {

	private List <MDMJobResponse> mdmresponselist ;

	public List<MDMJobResponse> getMdmresponselist() {
		return mdmresponselist;
	}

	public void setMdmresponselist(List<MDMJobResponse> mdmresponselist) {
		this.mdmresponselist = mdmresponselist;
	}
	
}
