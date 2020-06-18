package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelLandingPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexAdminPanelLandingPage extends TrexAdminPanelLandingPageObjects {
	

	public TrexAdminPanelLandingPage(WebDriver driver) {
		super(driver);
	}

	// Actions:

	public String getPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		if (title != null) {
			return title;
		} else {
			return "";
		}

	}

	public TrexAdminPanelLoginPage clickOnLoginButton() {

		click(loginButton, "loginButton");
		return new TrexAdminPanelLoginPage(DriverManager.getDriver());
			

	}

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}

	
	
	

}
