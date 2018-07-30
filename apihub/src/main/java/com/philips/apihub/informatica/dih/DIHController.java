package com.philips.apihub.informatica.dih;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;


@RestController
public class DIHController {

	
	@Autowired
	private DIHService dihservice ;
	
	
	@RequestMapping("/informatica/dih/{id}")
	public String ExecuteJobGroup(@PathVariable("id") String sPubSubId) throws IOException {
	
		System.out.println("Inside DIH Call");
		
		String Res=dihservice.RunDIHJob(sPubSubId,"publication");
		String sRes="";
		
		if (Res.contains("<status>SUCCESS</status>")) 
		{
			System.out.println("Triggered the DIH Job , Now finidng out the Status");
			
			Integer intstartpos=Res.indexOf("<eventId>")+9 ;
			Integer intendpos=Res.indexOf("</eventId>");
			String sEventId="";
			sEventId= Res.substring(intstartpos, intendpos);
			
			// We now have the Event Id So next step is to find the Status
			
			
			try {
				sRes = dihservice.GetEventStatus(sEventId);
				
				while (sRes.contains("Processing")) {
					TimeUnit.SECONDS.sleep(30);
					
					sRes = dihservice.GetEventStatus(sEventId);
					System.out.println("Event Status Response::" + sRes);					
					
					
				}
	
				System.out.println("Event Status Response::" + sRes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			

			
		}
		else
		{
			//Something went wrong let us inform the user about it. 
			
			System.out.println("Unable to Trigger the DIH Job !!");
			
		}
		
		return sRes;
		
		
	}

	
	@RequestMapping("/informatica/dih/status/{id}")
	public String GetEventStatus(@PathVariable("id") String sEventId) throws IOException {
	
		System.out.println("Inside DIH Event Status Call");
		String sRes="";
			try {
				sRes = dihservice.GetEventStatus(sEventId);
				System.out.println("Event Status Response::" + sRes);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
		return sRes;
		
		
	}

	
	
	
	
}
