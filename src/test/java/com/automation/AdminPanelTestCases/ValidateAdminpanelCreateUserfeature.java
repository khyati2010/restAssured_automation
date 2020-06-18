package com.automation.AdminPanelTestCases;

import com.automation.Pages.TrexAdminPanelCreateUserPage;
import com.automation.Pages.TrexAdminPanelHomePage;
import com.automation.Pages.TrexAdminPanelLandingPage;
import com.automation.Pages.TrexAdminPanelLoginPage;
import com.automation.Pages.TrexAdminPanelUsersPage;
import com.automation.SetUp.TestSetup;
import com.automation.Utils.TestData;
import com.automation.driverSupport.DriverManager;

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
