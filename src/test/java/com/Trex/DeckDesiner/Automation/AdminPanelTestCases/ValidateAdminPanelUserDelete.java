package com.Trex.DeckDesiner.Automation.AdminPanelTestCases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelHomePage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelUserDelete;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;
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
