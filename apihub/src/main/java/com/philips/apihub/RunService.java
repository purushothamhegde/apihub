package com.philips.apihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
	
public class RunService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jre1.8.0_144\\lib\\cacert");
		SpringApplication.run(RunService.class, args);
	}

}
