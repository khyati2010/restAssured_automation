package com.automation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.API.UserLoginAPI;
import com.automation.API.UserRegisterationAPI;
import com.automation.POJO.UserLogin;
import com.automation.POJO.UserRegisteration;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

import io.codearte.jfairy.producer.person.Person;
import io.restassured.response.Response;

public class TestUtils extends TestSetup {

	public static void captureScreenshot() throws IOException {

		

	
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir")+configProperty.getScreenShotsPath() + TestUtils.getScreenShotName()));

	}

	public static String getScreenShotName() {
		Date date = new Date();
		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return screenshotName;
	}


	public static void archiveLastTestReport() {

		File lastTestReportFile = new File(
				configProperty.getTestReportFilePath() + configProperty.getTestReportName());

		File newFile = new File(configProperty.getArchivedTestReportsPath() + TestUtils.getArchivedReportName());

		if(lastTestReportFile.exists()) {
		lastTestReportFile.renameTo(newFile);
		lastTestReportFile.delete();
		}


	}

	public static String getArchivedReportName() {

		String date = new SimpleDateFormat("dd_MM_yyyy:hh_mm_ss").format(new Date());


		String reportName = configProperty.getTestReportName();
		String newReportName = reportName.substring(0, reportName.indexOf(".")) + "_" + date + ".html";
		return newReportName;
	}
	
	public static JSONObject getEmptyJson()
	{
		return new JSONObject();
	}
	
	

	public static Person createNewUser() {
		Person person = TestData.getPersonData();
		UserRegisteration user= new UserRegisteration(person.getEmail(), person.getPassword(), person.getFullName(), person.getAddress().getPostalCode());
		UserRegisterationAPI.sendPostRequestToRegisterationAPI(user, configProperty.getUserRegistrationAPIEndPoint());
		
		return person;
		
		
	}
	
	public static String getUID(String email,String password)
	{
		UserLogin login = new UserLogin(email, password);
		Response response=UserLoginAPI.sendPostRequestToLoginAPI(login, configProperty.getUserLoginAPIEndPoint());
	
		return response.jsonPath().get("uid");
	
	}
	
	public static String getAccessToken(UserLogin userLoginData)
	{
		Response response=UserLoginAPI.sendPostRequestToLoginAPI(userLoginData, configProperty.getUserLoginAPIEndPoint());
	
		return response.jsonPath().get("access_token");
	
	}
	
	public static String getAdminUserAccessToken()
	{
		UserLogin login = new UserLogin("qa@gmail.com", "tester");
		Response response=UserLoginAPI.sendPostRequestToLoginAPI(login, configProperty.getUserLoginAPIEndPoint());
		return response.jsonPath().get("access_token");
	
	}
	
	public static String getRegularUserAccessToken()
	{
		UserLogin login = new UserLogin("latest1@gmail.com", "tester");
		Response response=UserLoginAPI.sendPostRequestToLoginAPI(login, configProperty.getUserLoginAPIEndPoint());
		return response.jsonPath().get("access_token");
	
	}
	
	
	
	public static Map<String,String> getUserTokenAndUID(String email,String password)
	{
		Map<String,String> map= new HashMap<String,String>();
		UserLogin login = new UserLogin(email, password);
		Response response=UserLoginAPI.sendPostRequestToLoginAPI(login, configProperty.getUserLoginAPIEndPoint());
		
		String userUID=response.jsonPath().get("uid");
		String userAccessToken=response.jsonPath().get("access_token");
		
		map.put("uid", userUID);
		map.put("accessToken", userAccessToken);
		return map;
	}
	
	public static String invalidAcessToken()
	{
		return RandomStringUtils.randomAlphanumeric(10);
	}

	public static String invalidPaginationToken()
	{
		return RandomStringUtils.randomAlphanumeric(20);
	}


	

	
	
	
	
}
