package com.philips.apihub.hp.alm;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class HPALMService {
	private String HPALM_Url= "";
	private String username = "";
	private String password = "";

	
	private String host = "";
	private String port = "";
	private String domain = "";
	private String project = "";

	private Config config;
    private Client client;
    
    

	public static Properties readAlmProperties() throws IOException
    {
        Properties almProperties = new Properties();
        
    	
        File file = new File("C:\\Purush\\LocalGit\\apihub\\apihub\\src\\main\\resources\\alm.properties");
        
        if (file.exists()) {
        	
        	
        } else 
        
        {
            //logger.error("Exception :: GetRequiredProperties :: Config file not found");
            throw new RuntimeException("Exception :: readAlmProperties :: Config file not found");
        }
        
        almProperties.load(new FileInputStream(file));



        return almProperties;

    }    

        
    
	
	public String GetProjectDefects(String sProjectId) throws IOException, Exception 
	{
		config = new Config(readAlmProperties());
		client = new Client(config);
		
		
		String res="";
		client.login();
		res=client.GetDefects(sProjectId);
		client.logout();
		return res;
		
	}
}
