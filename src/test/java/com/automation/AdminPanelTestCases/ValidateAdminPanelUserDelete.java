package com.automation.AdminPanelTestCases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.Pages.TrexAdminPanelHomePage;
import com.automation.Pages.TrexAdminPanelLandingPage;
import com.automation.Pages.TrexAdminPanelLoginPage;
import com.automation.Pages.TrexAdminPanelUserDelete;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;
import com.sun.tools.xjc.Driver;

public class ValidateAdminPanelUserDelete extends TestSetup{
	
	@Test
	public void ValidateAdminPanelUserDelete() throws InterruptedException, AWTException{

	TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());
	
	TrexAdminPanelLoginPage adminPanelLoginPage= landingPage.clickOnLoginButton();
	Thread.sleep(2000);
	TrexAdminPanelHomePage adminPanelHomePage= adminPanelLoginPage.loginWithValidDetails("qa@gmail.com", "tester");		
	Thread.sleep(3000);
	adminPanelHomePage.clickOnUsersTab();
	Thread.sleep(3000);
	
	adminPanelHomePage.ClickLatestUserCreated();
	Thread.sleep(3000);
	TrexAdminPanelUserDelete delete = new TrexAdminPanelUserDelete(DriverManager.getDriver());
	delete.clickDeleteBtn();
	delete.clickYesBtn();
	Thread.sleep(3000);
	

	
	
	}
}
