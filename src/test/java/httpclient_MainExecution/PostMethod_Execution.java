package httpclient_MainExecution;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Utils.TestUtils;

public class PostMethod_Execution extends propertiesFileLocationPath
{
	String URL;
	httpClient_PostMethod jsonUrl;
	CloseableHttpResponse jsonResponse;
	public static String Access_Inbound_File = findFileLocationPath_Converter.filePathLocation("P10_BankFee");
	
	@BeforeTest
	public void setUpURL()
	{
		String Url = prop.getProperty("TestURL");
		String resourceUrl = prop.getProperty("resourceURL");
		URL = Url + resourceUrl;
	}
	
	@Test
	public  void Postcall() throws ClientProtocolException, JSONException, IOException, URISyntaxException{
		
		StringEntity entity = new StringEntity(Access_Inbound_File,ContentType.APPLICATION_JSON);
		  jsonResponse =  jsonUrl.postCall(URL);
		  System.out.println(jsonResponse);
	}
	
	@Test
	public void postcallResponse() throws ClientProtocolException, JSONException, IOException
	{
		//driver = new HttpClient();
		//apiResponse = driver.getCall(APIURL);
		String responseString = EntityUtils.toString(jsonResponse.getEntity(),"UTF-8");
		JSONObject jsonObj = new JSONObject(responseString);
		System.out.println(jsonObj);
		String responseValue = TestUtils.getValueByJPath( jsonObj, "/per_page");
		System.out.println(responseValue);
		  
}
}
