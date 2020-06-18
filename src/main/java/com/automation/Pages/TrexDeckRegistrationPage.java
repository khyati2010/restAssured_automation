package com.automation.Pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.ObjectRepository.TrexDeckLoginPageObjects;
import com.automation.ObjectRepository.TrexDeckRegistrationObjects;
import com.automation.driverSupport.DriverManager;

public class TrexDeckRegistrationPage extends TrexDeckRegistrationObjects{
	public TrexDeckRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterName(String Name) {
		UserName.sendKeys(Name);
	}
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void enterPassword(String Password) {
		UPassword.sendKeys(Password);
	}
	
	public void enterConfirmPassword(String ConfirmPassword) {
		CPassword.sendKeys(ConfirmPassword);
	}
	
	public void enterZip(String zip) {
		Zip.sendKeys(zip);
	}
	
	public void ClickCaptcha() throws AWTException {
		/*
		 * Robot rb = new Robot(); rb.mouseMove(574, 449);
		 */
		
		WebElement iFrame = DriverManager.getDriver().findElement(By.xpath("//iframe[@name='a-3oanvbuqtkho']"));
		DriverManager.getDriver().switchTo().frame(iFrame);
		WebElement iFrame_checkbox = Captcha;
		iFrame_checkbox.click();
		//Captcha.click();
	}
	
	public void CheckTerms() {
		TermsCheckBox.click();
	}
	
	public void ClickCreateAccountBtn() {
		CreateAccountBtn.click();
	}
	public TrexDeckHomepage CreateNewUserAccount(String Name, String Password, String email, String ConfirmPassword, String zip) throws InterruptedException, AWTException {
		
		enterName(Name);
		
		enterEmail(email);
		enterPassword(Password);
		enterConfirmPassword(ConfirmPassword);
		enterZip(zip);
		Thread.sleep(20000);
		//ClickCaptcha();
		CheckTerms();
		ClickCreateAccountBtn();
		
		Thread.sleep(6000);
		
		return new TrexDeckHomepage(DriverManager.getDriver());
	}

}
