package com.test.base;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;



public class HttpClient 
{
	//1. Get Call
	public CloseableHttpResponse getCall(String url) throws ClientProtocolException, IOException,JSONException {
		
		CloseableHttpClient httpclient=	HttpClients.createDefault();
		HttpGet getCall = new HttpGet(url); //Rest Call
		CloseableHttpResponse response =httpclient.execute(getCall);
		return response;
		
		/*
		//A. Extracting Status Code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		//B. Getting Response Json
		String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
		JSONObject jsonObject = new JSONObject(responseString);
		System.out.println("API Response Json:"+ jsonObject);
		
		//C. Getting response header
		Header[] headerResponse = response.getAllHeaders();
		
		HashMap<String, String> hasMapList = new HashMap<String, String>();
		
		for (Header header : headerResponse) {
			
			hasMapList.put(header.getName(), header.getValue());
		}
		System.out.println(hasMapList);
		*/
	}
}
