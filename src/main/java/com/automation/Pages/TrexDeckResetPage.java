package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

import com.automation.ObjectRepository.TrexDeckResetPageObjects;
import com.automation.driverSupport.DriverManager;

public class TrexDeckResetPage extends TrexDeckResetPageObjects{
	public TrexDeckResetPage(WebDriver driver) {
		super(driver);
	}
	public TrexDeckLandingPage clickReset() {
		click(Reset, "Reset button");
	return new TrexDeckLandingPage(DriverManager.getDriver());
	}
	public TrexDeckLandingPage clickCancel() {
		click(Cancel, "Cancel button");
	return new TrexDeckLandingPage(DriverManager.getDriver());
		
	}

}
