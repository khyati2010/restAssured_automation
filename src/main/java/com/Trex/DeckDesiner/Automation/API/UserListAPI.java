package com.Trex.DeckDesiner.Automation.API;

import static io.restassured.RestAssured.given;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import io.restassured.response.Response;

public class UserListAPI extends TestSetup {

	public static Response sendGetRequestToUserListAPIWithLimitAndPagination(String endPoint, String accessToken, String limit,
			String paginationToken) {
		Response response = given().header("x-access-token", accessToken).header("limit", limit)
				.header("pagination_token", paginationToken).get(endPoint);

		return response;
	}

	public static Response sendGetRequestToUserListAPIWithLimitAndPagination(String endPoint, String limit, String paginationToken) {
		Response response = given().header("limit", limit).header("pagination_token", paginationToken)
				.get(endPoint);

		return response;
	}

	public static Response sendGetRequestToUserListAPIWithPagination(String endPoint, String accessToken, String paginationToken) {
		Response response = given().header("x-access-token", accessToken).header("pagination_token", paginationToken)
				.get(endPoint);

		return response;
	}

	public static Response sendGetRequestToUserListAPIWithLimit(String endPoint, String accessToken, String limit) {
		Response response = given().header("x-access-token", accessToken).header("limit", limit).get(endPoint);

		return response;
	}

	public static Response sendGetRequestToUserListAPI(String endPoint, String accessToken) {

		return basicRequestSpecification().header("x-access-token", accessToken).get(endPoint);

	}

}
