package com.test.base;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Utils.TestUtils;



public class GetTestCall extends TestBase
{

	
	HttpClient driver;
	String APIURL;
	CloseableHttpResponse apiResponse;
	
	@BeforeTest
	public void setUp()
	{
		
		String URL = prop.getProperty("URI");
		String serviceURL = prop.getProperty("serviceURI");
		APIURL = URL+serviceURL;
	}
	
	@Test
	public void testgetcall() throws ClientProtocolException, JSONException, IOException
	{
		driver = new HttpClient();
		apiResponse = driver.getCall(APIURL);
		//System.out.println(apiResponse);
		
		Assert.assertEquals(apiResponse.getStatusLine().getStatusCode(), Rest_response_200);
		System.out.println(apiResponse.getStatusLine().getStatusCode());
		System.out.println(Rest_response_200);
	}
	
	@Test
	public void testgetcallResponse() throws ClientProtocolException, JSONException, IOException
	{
		//driver = new HttpClient();
		//apiResponse = driver.getCall(APIURL);
		String responseString = EntityUtils.toString(apiResponse.getEntity(),"UTF-8");
		JSONObject jsonObj = new JSONObject(responseString);
		
		System.out.println(jsonObj);
		
		  String responseValue = TestUtils.getValueByJPath( jsonObj, "/per_page");
		  
		  System.out.println(responseValue);
		  
			
			  Assert.assertEquals(responseValue, "6");
			  
			  Assert.assertEquals(TestUtils.getValueByJPath(jsonObj,
			  "/data[0]/last_name"),"Bluth");
			  System.out.println(TestUtils.getValueByJPath(jsonObj, "/data[0]/last_name"));
			  
			  Assert.assertEquals(TestUtils.getValueByJPath(jsonObj,
			  "/data[1]/first_name"),"Janet");
			  System.out.println(TestUtils.getValueByJPath(jsonObj,
			  "/data[1]/first_name"));
			  
			  Assert.assertEquals(TestUtils.getValueByJPath(jsonObj,
			  "/data[5]/email"),"tracey.ramos@reqres.in");
			  System.out.println(TestUtils.getValueByJPath(jsonObj, "/data[5]/email"));
			  
			  Assert.assertEquals(TestUtils.getValueByJPath(jsonObj,
			  "/support/url"),"https://reqres.in/#support-heading");
			  System.out.println(TestUtils.getValueByJPath(jsonObj, "/support/url"));
			 
	} 
}
