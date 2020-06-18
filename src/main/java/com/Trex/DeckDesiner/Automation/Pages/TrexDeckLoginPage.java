package com.Trex.DeckDesiner.Automation.Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Trex.DeckDesiner.Automation.ObjectRepository.DeckDesingerLandingPageObjects;
import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexDeckLoginPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexDeckLoginPage extends TrexDeckLoginPageObjects{
	public TrexDeckLoginPage(WebDriver driver) {
		super(driver);
	}
	public TrexDeckHomepage Login(String UserEmail, String userPassword) throws InterruptedException, AWTException {
		EnterUsername(UserEmail);
		EnterPassword(userPassword);
		clickLoginButtonOnModal();
		Thread.sleep(5000);

		return new TrexDeckHomepage(DriverManager.getDriver());
	}
	public void EnterUsername(String UserEmail) throws AWTException, InterruptedException {
		type(Email, UserEmail, "Email");
	}

	public void EnterPassword(String UserPassword) throws AWTException, InterruptedException {
		type(Password, UserPassword, "Password");
	}

	public void clickLoginButtonOnModal() {
		click(LoginBtnModal, "Login button");
	}

	public TrexDeckRegistrationPage clickCreateAccount() {
		click(CreateAccountBtn, "create account");
		
		return new TrexDeckRegistrationPage(DriverManager.getDriver());
	}
	
	public void ValidateInvalidMessageDisplayed() {
		validateElementIsDisplayed(errorMessage);
	}
}
