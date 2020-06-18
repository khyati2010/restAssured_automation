package com.Trex.DeckDesiner.Automation.DeckDesignTestCases;

import java.awt.AWTException;
  
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexDeckHomepage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckRegistrationPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

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
