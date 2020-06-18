package com.automation.APITestCases;

import static com.automation.Utils.Json.jsonHasKey;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.API.UserLoginAPI;
import com.automation.POJO.UserLogin;
import com.automation.SetUp.TestSetup;
import com.automation.Utils.TestUtils;

import io.restassured.response.Response;


@Listeners(com.automation.Utils.TestListeners.class)

public class ValidateUserLoginAPI extends TestSetup {

	@Test(enabled = true, priority = 0)
	public void validateLoginWithValidDetails() {
		UserLogin loginData = new UserLogin("shalabh@tpg.com", "shalabh");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());


		Assert.assertEquals(response.statusCode(), 200);


		Assert.assertEquals(response.statusLine().contains("OK"), true);

		Assert.assertTrue(jsonHasKey(response, "access_token"));

		String accessTokenValueInResponse = response.jsonPath().get("access_token");

		Assert.assertNotNull(accessTokenValueInResponse);

	}

	@Test(enabled = true, priority = 1)
	public void validateLoginWithInValidEmail() {

		UserLogin loginData = new UserLogin("abhigya.jha@gmail", "tester");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());

		Assert.assertEquals(response.statusCode(), 400);

		Assert.assertEquals(response.statusLine().contains("Bad Request"), true);

		Assert.assertFalse(jsonHasKey(response, "access_token"));

		String actualErrorMessage = response.jsonPath().get("message");

		Assert.assertEquals(actualErrorMessage, "Invalid email address");

	}

	@Test(enabled = true, priority = 2)
	public void validateLoginWithInValidPassword() {

		UserLogin loginData = new UserLogin("shalabh@tpg.com", "tester123");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());

		// response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 400);

		Assert.assertEquals(response.statusLine().contains("Bad Request"), true);

		Assert.assertFalse(jsonHasKey(response, "access_token"));

		String actualErrorMessage = response.jsonPath().get("message");

		Assert.assertEquals(actualErrorMessage, "Incorrect username or password.");

	}

	@Test(enabled = true, priority = 3)
	public void validateLoginWithEmailNotRegistered() {

		UserLogin loginData = new UserLogin("sachin@gmail.com", "123121");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());

		Assert.assertEquals(response.statusCode(), 400);

		Assert.assertEquals(response.statusLine().contains("Bad Request"), true);

		Assert.assertFalse(jsonHasKey(response, "access_token"));

		String actualErrorMessage = response.jsonPath().get("message");

		Assert.assertEquals(actualErrorMessage, "User does not exist.");

	}

	@Test(enabled = true, priority = 4)
	public void validateLoginWithEmptyPayload() {

		// UserLogin loginData = new UserLogin("", "");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(TestUtils.getEmptyJson().toString(),
				configProperty.getUserLoginAPIEndPoint());

		Assert.assertEquals(response.statusCode(), 400);

		Assert.assertEquals(response.statusLine().contains("Bad Request"), true);

		Assert.assertFalse(jsonHasKey(response, "access_token"));

		String actualErrorMessage = response.jsonPath().get("message");

		Assert.assertEquals(actualErrorMessage, "Input payload validation failed");

	}

}
