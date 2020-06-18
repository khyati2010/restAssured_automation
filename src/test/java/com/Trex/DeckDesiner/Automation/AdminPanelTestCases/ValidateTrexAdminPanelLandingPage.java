package com.Trex.DeckDesiner.Automation.AdminPanelTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateTrexAdminPanelLandingPage extends TestSetup {

	@Test
	public void validateLandingPageTitle() {

		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());

		Assert.assertEquals(landingPage.getPageTitle(), "Trex Deck Designer Admin");

	}

}
