package com.automation.API;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;


public class UserDeleteAPI {
	
	
	public static Response sendDeleteRequestToDeleteAPI(String apiEndPoint,String uid,String accessToken)
	{
		Response response=given().header("x-access-token",accessToken).delete(apiEndPoint+uid);
		return response;
	}
	
	public static Response sendDeleteRequestToDeleteAPI(String apiEndPoint,String uid)
	{
		Response response=given().delete(apiEndPoint+uid);
		return response;
	}


}
