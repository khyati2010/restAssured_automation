package com.automation.Utils;

import org.json.JSONObject;

import io.restassured.response.Response;

public class Json {
	
	public static boolean jsonHasKey(Response responseJson,String key)
	{
		JSONObject json= new JSONObject(responseJson.asString());
		return json.has(key);
	}
	public static boolean jsonHasKey(String responseJson,String key)
	{
		JSONObject json= new JSONObject(responseJson);
		
		return json.has(key);
	}

	public static String getFieldValue(Response responseJson,String key)
	{
		JSONObject json= new JSONObject(responseJson.asString());
		return  (String) json.get(key);
	}
	
	public static String getFieldValue(String responseJson,String key)
	{
		JSONObject json= new JSONObject(responseJson);
		return  (String) json.get(key);
	}

}
