package com.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexAdminPanelLandingPageObjects;
import com.automation.driverSupport.DriverManager;

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
