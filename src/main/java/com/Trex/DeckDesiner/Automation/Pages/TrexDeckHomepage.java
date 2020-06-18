package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexDeckHomepageObjects;
import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexDeckLandingPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexDeckHomepage extends TrexDeckHomepageObjects{
public TrexDeckHomepage(WebDriver driver) {
		
		super(driver);
	}

public boolean ValidateUserLoggedIn() {
	validateElementIsDisplayed(Logoutdropdown) ;
	Logoutdropdown.isDisplayed();
	 
	 return true;
}
public TrexDeckLogoutPage logout() throws InterruptedException {
	
	click(Logoutdropdown, "Logout dropdown");
	click(LogoutBtn,"Logout button");
	Thread.sleep(2000);
	
	return new TrexDeckLogoutPage(DriverManager.getDriver());
}
}
