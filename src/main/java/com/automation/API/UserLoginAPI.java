package com.automation.API;

import com.automation.POJO.UserLogin;
import com.automation.SetUp.TestSetup;

import io.restassured.response.Response;

public class UserLoginAPI extends TestSetup{
	
	public static Response sendPostRequestToLoginAPI(UserLogin userLoginData,String endpoint)
	{
		Response response=requestSpecification.body(userLoginData).post(endpoint);
		return response;
	}
	
	public static Response sendPostRequestToLoginAPI(String userLoginData,String endpoint)
	{
		Response response=requestSpecification.body(userLoginData).post(endpoint);
		return response;
	}
	
	
	
	

}
