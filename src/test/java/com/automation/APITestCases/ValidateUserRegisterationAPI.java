package com.automation.APITestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.API.UserLoginAPI;
import com.automation.API.UserRegisterationAPI;
import com.automation.POJO.UserLogin;
import com.automation.POJO.UserRegisteration;
import com.automation.POJO.UserRegisterationEmptyData;
import com.automation.SetUp.TestSetup;

import io.restassured.response.Response;

import static com.automation.Utils.Json.*;

import java.net.URISyntaxException;

public class ValidateUserRegisterationAPI extends TestSetup {
	String actualErrorMessage;
	
	@Test(enabled=true,priority=1)
	public void validateRegisterationValidDetails() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail.com", "tester", "AnshulMittal", "10209");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 201);

		AssertJUnit.assertEquals(response.statusLine().contains("Created"), true);
		
		AssertJUnit.assertTrue(jsonHasKey(response, "access_token"));

	}
	
	@Test(enabled=true,priority=2)
	public void validateRegisterationInvalidEmail() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail", "tester", "AnshulMittal", "10209");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Invalid Email Address.");

	}
	
	@Test(enabled=true,priority=3)
	public void validateRegisterationInvalidPassword() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail.com", "tr", "Anshul", "10209");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Password length should be minimum 6 characters. ");

	}
	@Test(enabled=true,priority=4)
	public void validateRegisterationInvalidName() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail.com", "tester", "A", "10209");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Name should contain minimum 2 characters and no numbers.");

	}
	
	@Test(enabled=true,priority=5)
	public void validateRegisterationInvalidZipCode() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail.com", "tester", "Anshul", "109");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Zip code should be 5 digit numeric value.");

	}
	@Test(enabled=true,priority=6)
	public void validateRegisterationWithDuplicateDetails() throws URISyntaxException {
		
		UserRegisteration registeration = new UserRegisteration(dateFormat.format(date)+"anshul@gmail.com", "tester", "Anshul", "10209");	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("error");
		
		AssertJUnit.assertEquals(actualErrorMessage, "An account with the given email already exists.");

	}
	
	@Test(enabled=true,priority=0)
	public void invalidateRegisterationWithoutDetails() throws URISyntaxException {
		
		UserRegisterationEmptyData registeration = new UserRegisterationEmptyData();	
		Response response = UserRegisterationAPI.sendPostRequestToRegisterationEmptyDataAPI(registeration, configProperty.getUserRegistrationAPIEndPoint());
		response.prettyPrint();
		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);		

		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Required field 'email' missing");

	}
	
}
