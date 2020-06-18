package com.Trex.DeckDesiner.Automation.DeckDesignTestCases;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexDeckHomepage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLogoutPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateUserDeckDimensionsAreSaved extends TestSetup{
	
	@Test
	public void ValidateValidUserLoginDeck() throws InterruptedException, AWTException{

		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		
		
		Thread.sleep(15000);
		
		TrexDeckLoginPage loginPage = landingPage.clickLoginBtn();
		TrexDeckHomepage homePage = loginPage.Login("3qa@gmail.com", "Tester@123");
		

		Thread.sleep(3000);
		homePage.ValidateUserLoggedIn();
		
		landingPage.ChangeDeckDimensions(39,30,2,8);
		landingPage.saveDeck();
		landingPage.validateDeckDimensions(39,30,2,8);
		Thread.sleep(2000);
		TrexDeckLogoutPage logout = homePage.logout();
		logout.SaveAndLogout();
		landingPage.validateUserLoggedOut();
		Thread.sleep(3000);
		landingPage.clickLoginBtn();
		loginPage.Login("3qa@gmail.com", "Tester@123");
		Thread.sleep(3000);
		homePage.ValidateUserLoggedIn();
		Thread.sleep(3000);
		landingPage.validateDeckDimensions(39,30,2,8);
	
	}

	
}
