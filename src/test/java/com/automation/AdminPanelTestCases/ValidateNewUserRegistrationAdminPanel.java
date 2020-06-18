package com.automation.AdminPanelTestCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.ObjectRepository.TrexAdminPanelNewUserRegistrationModal;
import com.automation.Pages.TrexAdminPanelHomePage;
import com.automation.Pages.TrexAdminPanelLandingPage;
import com.automation.Pages.TrexAdminPanelLoginPage;
import com.automation.Pages.TrexAdminPanelUserCreateModal;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

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

