package com.automation.DeckDesignTestCases;

import java.awt.AWTException;
  
import org.testng.annotations.Test;

import com.automation.Pages.TrexDeckHomepage;
import com.automation.Pages.TrexDeckLandingPage;
import com.automation.Pages.TrexDeckLoginPage;
import com.automation.Pages.TrexDeckRegistrationPage;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

public class ValidateNewUserRegistrationTrexDeck extends TestSetup{

	
	@Test
	public void ValidateUserRegistrationValidDetails() throws InterruptedException, AWTException {
		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		Thread.sleep(15000);
		
		TrexDeckLoginPage loginPage = landingPage.clickLoginBtn();
		TrexDeckRegistrationPage registrationPage = loginPage.clickCreateAccount();
		TrexDeckHomepage homepage = registrationPage.CreateNewUserAccount("Anshul", "Tester@123", dateFormat.format(date)+"anshul@gmail.com", "Tester@123", "1p1p1");
		homepage.ValidateUserLoggedIn();
	
	}

}
