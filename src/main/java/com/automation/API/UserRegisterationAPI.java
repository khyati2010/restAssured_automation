package com.automation.API;

import com.automation.POJO.UserRegisteration;
import com.automation.POJO.UserRegisterationEmptyData;
import com.automation.SetUp.TestSetup;

import io.restassured.response.Response;

public class UserRegisterationAPI extends TestSetup{
	public static Response sendPostRequestToRegisterationAPI(UserRegisteration userRegisterationData,String endpoint)
	{
		Response response=requestSpecification.body(userRegisterationData).post(endpoint);
		return response;
	}
	
	public static Response sendPostRequestToRegisterationEmptyDataAPI(UserRegisterationEmptyData userRegisterationData,String endpoint)
	{
		Response response=requestSpecification.body(userRegisterationData).post(endpoint);
		return response;
	}
}
