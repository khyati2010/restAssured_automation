package com.Trex.DeckDesiner.Automation.API;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserProfileAPI extends TestSetup {

	public static Response sendGetRequestToProfileAPI(String endPoint, String userEmailId, String accessToken) {
		Response response = given().header("x-access-token", accessToken).get(endPoint + userEmailId);
		return response;
	}

	public static Response sendGetRequestToProfileAPIWithoutAccessToken(String endPoint, String userEmailId,
			String accessToken) {
		Response response = given().get(endPoint + userEmailId);
		return response;
	}

}
