package com.Trex.DeckDesiner.Automation.AdminPanelTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelHomePage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLoginPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateAdminpanelLoginFeature extends TestSetup {

	@Test
	public void validateAdminPanelLoginWithValidCredentials() {
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		TrexAdminPanelHomePage adminPanelHomePage = loginPage.loginWithValidDetails("qa@gmail.com", "tester");

		Assert.assertTrue(adminPanelHomePage.welcomeMessage.isDisplayed());
		Assert.assertTrue(adminPanelHomePage.usersTab.isDisplayed());

	}

	@Test
	public void validateAdminPanelLoginWithInValidCredentials() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("qa@gmail.com", "dfsf");
		Assert.assertTrue(loginPage.incorrectUserPasswordErrorMessage.isDisplayed());
		
		
	}

	@Test
	public void validateAdminPanelLoginWithUserEmailNotExist() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("sdfjsdj@dhfsjhdfkshfkh.com", "dfsf");
		Assert.assertTrue(loginPage.invalidUserErrorMessage.isDisplayed());
		
		
	}
	
	@Test
	public void validateAdminPanelLoginWithRegularUser() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("reg@t.com", "tester123");
		Assert.assertTrue(loginPage.invalidUserErrorMessage.isDisplayed());
		
		
	}

	
	@Test
	public void validateAdminPanelLoginWithoutEmail() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("", "tester123");
		Assert.assertTrue(!loginPage.loginButton.isEnabled());
		
		
	}
	
	@Test
	public void validateAdminPanelLoginWithoutPassword() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("reg@t.com", "");
		Assert.assertTrue(!loginPage.loginButton.isEnabled());
		
		
	}
	
	
	@Test
	public void validateAdminPanelLoginWithoutEmailAndPassword() {

		
		
		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		loginPage=loginPage.loginWithInvalidDetails("", "");
		Assert.assertTrue(!loginPage.loginButton.isEnabled());
		
		
	}


}
