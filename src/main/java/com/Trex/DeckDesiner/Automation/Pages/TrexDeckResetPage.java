package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexDeckResetPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

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
