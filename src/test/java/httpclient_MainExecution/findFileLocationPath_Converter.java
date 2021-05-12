package httpclient_MainExecution;

import java.nio.file.Files;
import java.nio.file.Paths;


public class findFileLocationPath_Converter 
{	
	public static String filePathLocation(String filename)
	{
		String filePath = System.getProperty("user.dir")+"\\JsonFiles\\"+filename;	
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));	
			}
		catch(Exception e)
		{
			return null;
		}
		
	}
}

