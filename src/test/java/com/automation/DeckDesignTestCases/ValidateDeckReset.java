package com.automation.DeckDesignTestCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.automation.Pages.TrexDeckHomepage;
import com.automation.Pages.TrexDeckLandingPage;
import com.automation.Pages.TrexDeckLoginPage;
import com.automation.Pages.TrexDeckResetPage;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

public class ValidateDeckReset extends TestSetup {

	@Test
	public void ValidateDeckDimensionOnReset() throws InterruptedException, AWTException {

		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		Thread.sleep(14000);
		landingPage.ChangeDeckDimensions(12, 12, 1, 1);
		Thread.sleep(2000);
		TrexDeckResetPage reset = landingPage.ResetDeck();
		reset.clickReset();
		Thread.sleep(2000);
		landingPage.validateDeckDimensions(14, 20, 0, 0);

	}

	@Test
	public void ValidateDeckDimensionOnCancel() throws InterruptedException, AWTException {

		TrexDeckLandingPage landingPage = new TrexDeckLandingPage(DriverManager.getDriver());
		Thread.sleep(14000);
		landingPage.ChangeDeckDimensions(12, 12, 1, 1);

		Thread.sleep(2000);
		TrexDeckResetPage reset = landingPage.ResetDeck();
		reset.clickCancel();
		Thread.sleep(2000);
		landingPage.validateDeckDimensions(12, 12, 1, 1);
	}
}