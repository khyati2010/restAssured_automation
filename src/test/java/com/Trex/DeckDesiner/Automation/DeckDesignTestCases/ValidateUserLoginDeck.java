package com.Trex.DeckDesiner.Automation.DeckDesignTestCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.Authenticator;

import org.apache.http.client.AuthenticationHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexDeckLandingPageObjects;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelHomePage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelUserCreateModal;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckHomepage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLoginPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateUserLoginDeck extends TestSetup{
	
	@Test
	public void ValidateValidUserLoginDeck() throws InterruptedException, AWTException{

		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		
		
		Thread.sleep(15000);
		
		TrexDeckLoginPage loginPage = landingPage.clickLoginBtn();
		TrexDeckHomepage homePage = loginPage.Login("3qa@gmail.com", "Tester@123");
		
		homePage.ValidateUserLoggedIn();
		
		

	}
	@Test
	public void ValidateInvalidUserLoginUserDeck() throws InterruptedException, AWTException{

		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		
		
		Thread.sleep(15000);
		
		TrexDeckLoginPage loginPage = landingPage.clickLoginBtn();
		loginPage.Login("2qa@gmail.com", "Tester123");
		loginPage.ValidateInvalidMessageDisplayed();
	}

}
