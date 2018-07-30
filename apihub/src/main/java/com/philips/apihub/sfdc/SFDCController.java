package com.philips.apihub.sfdc;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.philips.apihub.ca.rally.RallyService;

@RestController
public class SFDCController {
	@Autowired
	private SFDCService sfdcservice ;

	
	@RequestMapping("/sfdc/contact")
	public String GetContact() {
		
		return sfdcservice.GetContact();
	}
}

	

