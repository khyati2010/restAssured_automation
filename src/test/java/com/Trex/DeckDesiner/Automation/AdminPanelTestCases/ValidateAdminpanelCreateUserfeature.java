package com.Trex.DeckDesiner.Automation.AdminPanelTestCases;

import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelCreateUserPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelHomePage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLandingPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelLoginPage;
import com.Trex.DeckDesiner.Automation.Pages.TrexAdminPanelUsersPage;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.Utils.TestData;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

import io.codearte.jfairy.producer.person.Person;

public class ValidateAdminpanelCreateUserfeature extends TestSetup {

	public void validateCreateUserWithValidDetails() {

		Person person = TestData.getPersonData();
		// gotoAdmin Panel

		TrexAdminPanelLandingPage landingPage = new TrexAdminPanelLandingPage(DriverManager.getDriver());

		// Login
		TrexAdminPanelLoginPage loginPage = landingPage.clickOnLoginButton();
		TrexAdminPanelHomePage homePage = loginPage.loginWithValidDetails("qa@gmail.com", "tester");

		// Goto Users Tab
		TrexAdminPanelUsersPage usersPage = homePage.clickOnUsersTab();
		TrexAdminPanelCreateUserPage createUserpage = usersPage.clickOnCreateUserButton();

		// Click on Create User
		usersPage = createUserpage.createUserWithValidDetails(person.getEmail(), person.getFullName(),
				person.getPassword(), person.getAddress().getPostalCode());
		
		

	}

	public void validateCreateUserWithInValidEmail() {

	}

	public void validateCreateUserWithInValidUsername() {

	}

	public void validateCreateUserWithInValidPassword() {

	}

	public void validateCreateUserWithPasswordLessThan8Characters() {

	}

	public void validateCreateUserWithInValidZipCode() {

	}

	public void validateCreateUserSuccessMessageIsDisplayed() {

	}

	public void validateCreateUserWVerifyDetailsShowsUserDetail() {

	}

}
