package com.automation.APITestCases;



import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.API.UserProfileAPI;
import com.automation.SetUp.TestSetup;
import com.automation.Utils.Json;
import com.automation.Utils.TestData;
import com.automation.Utils.TestUtils;

import io.codearte.jfairy.producer.person.Person;
import io.restassured.response.Response;


@Listeners(com.automation.Utils.TestListeners.class)
public class ValidateUserProfileAPI extends TestSetup {

	//String uid = null;
	//String adminAccessToken = null;
	
	
	@Test(priority=0)
	public void validateUserProfileAPIWithValidEmail() {
		
		Person person=TestUtils.createNewUser();
		String uid = TestUtils.getUID(person.getEmail(), person.getPassword());
		String adminAccessToken = TestUtils.getAdminUserAccessToken();

		Response response = UserProfileAPI.sendGetRequestToProfileAPI(configProperty.getUserProfileEndPoint(), uid,
				adminAccessToken);

		Assert.assertEquals(response.statusCode(), 200);
		// Validate the email id of the user in response
		Assert.assertEquals(response.jsonPath().get("email"), person.getEmail());

		// Validate the Name of the user in response
		Assert.assertEquals(response.jsonPath().get("name"), person.getFullName());

		// Validate the zip_code of the user in response
		Assert.assertEquals(response.jsonPath().get("zip_code"), person.getAddress().getPostalCode());

		// Validate the uid of the user in response is not null
		Assert.assertNotNull(response.jsonPath().get("uid"));

		// validate that the user is not admin

		Assert.assertEquals(response.jsonPath().get("is_admin"), "false");

	}

	@Test(priority=1)
	public void validateUserProfileAPIWithInValidEmail() {

		String adminAccessToken = TestUtils.getAdminUserAccessToken();

		Response response = UserProfileAPI.sendGetRequestToProfileAPI(configProperty.getUserProfileEndPoint(),
				RandomStringUtils.randomAlphanumeric(20), adminAccessToken);

		// validating response status code
		Assert.assertEquals(response.statusCode(), 400);

		// validating response does not have email field
		Assert.assertTrue(!Json.jsonHasKey(response, "email"));

		// Validating response contains message field
		Assert.assertTrue(Json.jsonHasKey(response, "message"));

		// Validating response contains error message "Invalid User Id Token"
		Assert.assertEquals(response.jsonPath().get("message"), "Invalid User Id Token");

	}

	@Test(priority=2)
	public void validateUserProfileAPIWithoutEmail() {

		String adminAccessToken = TestUtils.getAdminUserAccessToken();

		Response response = UserProfileAPI.sendGetRequestToProfileAPI(configProperty.getUserProfileEndPoint(), "",
				adminAccessToken);

		// validating response status code
		Assert.assertEquals(response.statusCode(), 200);


	}

	@Test(priority=3)
	public void validateUserProfileAPIWithInvalidAccessToken() {
		Person person=TestUtils.createNewUser();
		String uid = TestUtils.getUID(person.getEmail(), person.getPassword());
		
		Response response = UserProfileAPI.sendGetRequestToProfileAPI(configProperty.getUserProfileEndPoint(),uid,
				RandomStringUtils.randomAlphanumeric(20));
		
		//validate response status code is 401
		Assert.assertEquals(response.statusCode(), 401);
		
		// validating response does not have email field
		Assert.assertTrue(!Json.jsonHasKey(response, "email"));
		
		// Validating response contains message field
		Assert.assertTrue(Json.jsonHasKey(response, "message"));

		// Validating response contains error message "Invalid User Id Token"
		Assert.assertEquals(response.jsonPath().get("message"), "Invalid Token");

	}

	@Test(priority=4)
	public void validateUserProfileAPIWithoutAccessToken() {
		Person person=TestUtils.createNewUser();
		String uid = TestUtils.getUID(person.getEmail(), person.getPassword());
		
		Response response = UserProfileAPI.sendGetRequestToProfileAPI(configProperty.getUserProfileEndPoint(),uid,
				"");
		
		//validate response status code is 401
		Assert.assertEquals(response.statusCode(), 401);
		
		// validating response does not have email field
		Assert.assertTrue(!Json.jsonHasKey(response, "email"));
		
		// Validating response contains message field
		Assert.assertTrue(Json.jsonHasKey(response, "message"));

		// Validating response contains error message "Invalid User Id Token"
		Assert.assertEquals(response.jsonPath().get("message"), "Invalid Token");
		
		

	}

}
