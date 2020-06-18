package com.Trex.DeckDesiner.Automation.AdminPanelTestCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelNewUserRegistrationModal;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelHomePage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelUserCreateModal;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateNewUserRegistrationAdminPanel extends TestSetup{
	
		@Test
		public void ValidateNewUserRegistration() throws InterruptedException, AWTException{

		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
		
		TrexAdminPanelLoginPage adminPanelLoginPage= landingPage.clickOnLoginButton();
		Thread.sleep(2000);
		TrexAdminPanelHomePage adminPanelHomePage= adminPanelLoginPage.loginWithValidDetails("qa@gmail.com", "tester");		
		Thread.sleep(3000);
		adminPanelHomePage.clickOnUsersTab();
		TrexAdminPanelUserCreateModal userCreate = adminPanelHomePage.ClickCreateUserBtn();
		
		userCreate.NewUserRegistrationValidDetails("Anshul Mittal", NewUserEmail, "12345", "Tester@123");
	
		}
}

