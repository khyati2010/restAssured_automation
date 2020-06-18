package com.automation.AdminPanelTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.Pages.TrexAdminPanelLandingPage;
import com.automation.SetUp.TestSetup;
import com.automation.driverSupport.DriverManager;

public class ValidateTrexAdminPanelLandingPage extends TestSetup {

	@Test
	public void validateLandingPageTitle() {

		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());

		Assert.assertEquals(landingPage.getPageTitle(), "Trex Deck Designer Admin");

	}

}
