package com.Trex.DeckDesiner.Automation.APITestCases;



import static com.Trex.DeckDesiner.Automation.Utils.Json.jsonHasKey;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.API.UserListAPI;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.Utils.Json;
import com.Trex.DeckDesiner.Automation.Utils.TestUtils;

import io.restassured.response.Response;

public class ValidateUserListAPI extends TestSetup {

	@Test
	public void validateUserListAPIWithValidDetails() {

		Response response = UserListAPI.sendGetRequestToUserListAPI(configProperty.getUserListAPIEndPoint(),
				TestUtils.getAdminUserAccessToken());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.getStatusLine().contains("OK"));
		Assert.assertTrue(jsonHasKey(response, "users"));
		Assert.assertTrue(jsonHasKey(response, "users_count"));

		int usersCountFieldValueInResponse = response.jsonPath().get("users_count");
		int totalCountOfUsersInResponse = response.jsonPath().getList("users").size();

		if (usersCountFieldValueInResponse == totalCountOfUsersInResponse) {
			Assert.assertTrue(true);

		} else {
			Assert.fail("Users_Count feild value does not match with Users Array list size");
		}

	}

	@Test
	public void validateUserListAPIWithLimitDefined() {
		Response response = UserListAPI.sendGetRequestToUserListAPIWithLimit(configProperty.getUserListAPIEndPoint(),
				TestUtils.getAdminUserAccessToken(), "5");

		// validate response status code is 200
		Assert.assertEquals(response.statusCode(), 200);

		// validate user_count field value in response is equal to limit passed in
		// request
		int usersCountFieldValueInResponse = response.jsonPath().get("users_count");
		int totalCountOfUsersInResponse = response.jsonPath().getList("users").size();

		Assert.assertEquals(usersCountFieldValueInResponse, 5);

		// validate user_count field value and size of users field array in respons are
		// same
		Assert.assertEquals(totalCountOfUsersInResponse, usersCountFieldValueInResponse);

		List<Map<String, String>> listOfUsers = response.jsonPath().getList("users");

		// validate that for each user in the list, user_status field is available

		for (Map<String, String> userDetails : listOfUsers) {
			Assert.assertTrue(userDetails.containsKey("user_status"));
		}

		// validate that for each user in the list, user_status field has value Enabled
		// or disabled

		for (Map<String, String> userDetails : listOfUsers) {
			String userStatusValue = userDetails.get("user_status");
			if (userStatusValue.equals("Enabled") || userStatusValue.equals("Disabled")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("user_status field value neither Enabled nor Disabled");
			}

		}

		// validate that for each user in the list, is_admin field is available
		for (Map<String, String> userDetails : listOfUsers) {
			Assert.assertTrue(userDetails.containsKey("is_admin"));
		}

		// validate that for each user in the list, is_admin field has value either T or
		// F

		for (Map<String, String> userDetails : listOfUsers) {
			String userStatusValue = userDetails.get("is_admin");
			if (userStatusValue.equals("T") || userStatusValue.equals("F")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("user_status field value neither T nor F");
			}
		}

	}

	@Test
	public void ValidatePaginationInUserListAPI() {

		Response response = UserListAPI.sendGetRequestToUserListAPIWithLimit(configProperty.getUserListAPIEndPoint(),
				TestUtils.getAdminUserAccessToken(), "5");

		// validate response status code is 200
		Assert.assertEquals(response.statusCode(), 200);

		// validate user_count field value in response is equal to limit passed in
		// request
		int usersCountFieldValueInResponse = response.jsonPath().get("users_count");
		int totalCountOfUsersInResponse = response.jsonPath().getList("users").size();

		Assert.assertEquals(usersCountFieldValueInResponse, 5);

		// validate user_count field value and size of users field array in response are
		// same
		if (totalCountOfUsersInResponse == usersCountFieldValueInResponse) {
			Assert.assertTrue(true);

		} else {
			Assert.fail("Users_Count feild value does not match with Users Array list size");
		}

		// validate that pagination_token field is available in the response

		Assert.assertTrue(Json.jsonHasKey(response, "pagination_token"));

		// validate the pagination_token field value is not null

		Assert.assertNotNull(response.jsonPath().get("pagination_token"));

		// now send the request again and not pass pagination_token as well in request

		Response newResponse = UserListAPI.sendGetRequestToUserListAPIWithLimitAndPagination(
				configProperty.getUserListAPIEndPoint(), TestUtils.getAdminUserAccessToken(), "10",
				Json.getFieldValue(response, "pagination_token"));
		// Validate that the new response and old response are not equal

		String res1 = response.body().asString();
		String res2 = newResponse.body().asString();

		Assert.assertNotEquals(res1, res2);

	}

	@Test
	public void validateUserListAPIWithInvalidAccessToken() {

		Response response = UserListAPI.sendGetRequestToUserListAPI(configProperty.getUserListAPIEndPoint(),
				TestUtils.invalidAcessToken());

		// Validate that in case of n=invalid token passed, status code is 401
		Assert.assertEquals(response.statusCode(), 401);

		String messageInResponse = response.jsonPath().get("message");
		Assert.assertEquals(messageInResponse, "Invalid Token");

	}

	@Test
	public void validateUserListWithRegularUserAccessToken() {

		Response response = UserListAPI.sendGetRequestToUserListAPI(configProperty.getUserListAPIEndPoint(),
				TestUtils.getRegularUserAccessToken());

		// Validate that in case of n=invalid token passed, status code is 401
		Assert.assertEquals(response.statusCode(), 403);

		String messageInResponse = response.jsonPath().get("message");
		Assert.assertEquals(messageInResponse, "Access denied, Seems you are not authorized to view this.");

	}

	@Test
	public void validateUserListWithInvalidLimitPassed() {

		Response response = UserListAPI.sendGetRequestToUserListAPIWithLimit(configProperty.getUserListAPIEndPoint(),
				TestUtils.getAdminUserAccessToken(), "0");

		// Validate that in case of n=invalid token passed, status code is 401
		Assert.assertEquals(response.statusCode(), 400);

		String messageInResponse = response.jsonPath().get("message");
		Assert.assertEquals(messageInResponse, "limit range should between 1 to 60");

	}

	@Test
	public void validateUserListWithoutAccessToken() {

		Response response = UserListAPI.sendGetRequestToUserListAPI(configProperty.getUserListAPIEndPoint(), "");

		// Validate that in case of n=invalid token passed, status code is 401
		Assert.assertEquals(response.statusCode(), 401);

		String messageInResponse = response.jsonPath().get("message");
		Assert.assertEquals(messageInResponse, "Invalid Token");

	}

	@Test
	public void validateUserListAPIWithInvalidPaginationToken() {
		Response response = UserListAPI.sendGetRequestToUserListAPIWithPagination(
				configProperty.getUserListAPIEndPoint(), TestUtils.getAdminUserAccessToken(),
				TestUtils.invalidPaginationToken());
		
		Assert.assertEquals(response.statusCode(), 400);
		
		String messageInResponse = response.jsonPath().get("message");
		Assert.assertEquals(messageInResponse, "Please correct your entries and try again");

	}

}
