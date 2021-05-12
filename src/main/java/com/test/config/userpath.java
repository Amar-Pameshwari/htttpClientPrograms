package com.test.config;

import org.testng.annotations.Test;

import com.test.base.TestBase;

public class userpath
{
	TestBase testPath;
	
	@Test
	public void userpathfind()
	{
		testPath = new TestBase();		
		System.out.println(testPath.prop);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(testPath.Rest_response_200);
	}
}
