package com.automation.DeckDesignTestCases;

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

import com.automation.ObjectRepository.TrexDeckLandingPageObjects;
import com.automation.Pages.TrexAdminPanelHomePage;
import com.automation.Pages.TrexAdminPanelLandingPage;
import com.automation.Pages.TrexAdminPanelLoginPage;
import com.automation.Pages.TrexAdminPanelUserCreateModal;
import com.automation.Pages.TrexDeckHomepage;
import com.automation.Pages.TrexDeckLandingPage;
import com.automation.Pages.TrexDeckLoginPage;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

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
