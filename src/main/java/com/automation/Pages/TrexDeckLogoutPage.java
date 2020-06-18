package com.automation.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexDeckLogoutPageObjects;
import com.automation.driverSupport.DriverManager;

public class TrexDeckLogoutPage extends TrexDeckLogoutPageObjects{
	public TrexDeckLogoutPage(WebDriver driver) {
		super(driver);
	}
	
	public TrexDeckHomepage SaveAndLogout() throws InterruptedException {
		
		click(SavenLogout, "Save and logout button");
		Thread.sleep(5000);
		return new TrexDeckHomepage(DriverManager.getDriver());
	}

public TrexDeckHomepage CancelAndResume() {
		
		click(CancelnResume, "Cancel and resume button");
		return new TrexDeckHomepage(DriverManager.getDriver());
	}
}
