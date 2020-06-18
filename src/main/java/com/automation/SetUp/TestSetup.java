package com.automation.SetUp;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.automation.Utils.CommonVariables;
import com.automation.Utils.ConfigProperty;
import com.automation.Utils.ExcelReader;
import com.automation.Utils.ExtentManager;
import com.automation.Utils.TestUtils;
import com.automation.driverSupport.DriverFactory;
import com.automation.driverSupport.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.utility.RandomString;

public class TestSetup {

	public static ConfigProperty configProperty;
	public static RequestSpecification requestSpecification = null;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Date date = new Date();
	
	public static String NewUserEmail = dateFormat.format(date)+"@gmail.com";
	

	@BeforeSuite
	public synchronized void setup() {

		configProperty = ConfigFactory.create(ConfigProperty.class);
		RestAssured.baseURI = configProperty.getBaseURI();
		RestAssured.basePath = configProperty.getBasePath();
		setBasicRequestSpecification();
		CommonVariables.extentReport = ExtentManager.GetExtent(configProperty.getTestReportFilePath());
		TestUtils.archiveLastTestReport();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {

		CommonVariables.setCurrentTestClassName(getClass().getSimpleName());
		ExtentTest classTest = CommonVariables.extentReport.createTest(CommonVariables.getCurrentTestClassName());
		CommonVariables.setCurrentTestClassLog(classTest);

	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) throws MalformedURLException {

		WebDriver driver = null;
		if (driver == null) {
			
			
			if(method.getDeclaringClass().getName().contains("Admin"))
			{
				driver = DriverFactory.createDriverInstance(configProperty.getBrowserName(),
						configProperty.getDriverType());
				DriverManager.getDriver().navigate().to(configProperty.getQAAdminPanelURL());
			}
			else if(method.getClass().getName().contains("Deck"))
			{
				driver = DriverFactory.createDriverInstance(configProperty.getBrowserName(),
						configProperty.getDriverType());
				
			}
			

		}

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		CommonVariables.extentReport.flush();
		DriverManager.killDriver();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {

	}

	public static void setBasicRequestSpecification() {
		requestSpecification = given().contentType(ContentType.JSON);

	}
	
	public static RequestSpecification basicRequestSpecification() {
		return given().contentType(ContentType.JSON);

	}
	
	public static ExtentTest logger()
	{
		return CommonVariables.currentTestCaseLog.get();
	}

}
