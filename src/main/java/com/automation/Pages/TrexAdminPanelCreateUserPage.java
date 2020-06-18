package com.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexAdminPanelCreateUserPageObjects;
import com.automation.driverSupport.DriverManager;

public class TrexAdminPanelCreateUserPage extends TrexAdminPanelCreateUserPageObjects {

	public TrexAdminPanelCreateUserPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String name) {
		type(userName, name, "userName");
	}

	public void enterEmail(String emailId) {
		type(email, emailId, "emailId");

	}

	public void enterZipCode(String zipCode) {
		type(zip, zipCode, "zipCode");
	}

	public void enterPassword(String pwd) {
		type(password, pwd, "password");

	}

	public void clickOnSave() {
		click(saveUser, "superUser");
	}

	public TrexAdminPanelUsersPage createUserWithValidDetails(String email, String name, String password, String zip) {
		enterUserName(name);
		enterEmail(email);
		enterZipCode(zip);
		enterPassword(password);
		clickOnSave();
		return new TrexAdminPanelUsersPage(DriverManager.getDriver());

	}

	public TrexAdminPanelCreateUserPage createUserWithInValidDetails(String email, String name, String password,
			String zip) {
		enterUserName(name);
		enterEmail(email);
		enterZipCode(zip);
		enterPassword(password);
		clickOnSave();
		return this;

	}

}
