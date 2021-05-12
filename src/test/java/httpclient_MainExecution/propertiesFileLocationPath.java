package httpclient_MainExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesFileLocationPath 
{
	public Properties prop;
	
	public final int Rest_response_200 = 200;
	public final int Rest_response_201 = 201;
	public final int Rest_response_400 = 400;
	public final int Rest_response_500 = 500;
	public final int Rest_response_401 = 401;
	public final int Rest_response_404 = 404;
	
	
	public  propertiesFileLocationPath()
	{
		prop = new Properties();
		
		FileInputStream inputstream;
		
		try
		{
			inputstream = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\httpclientSAP_URL_properties\\SAPURL.properties");
			prop.load(inputstream);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
