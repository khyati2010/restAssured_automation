package com.Trex.DeckDesiner.Automation.DeckDesignTestCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexDeckHomepage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexDeckResetPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

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