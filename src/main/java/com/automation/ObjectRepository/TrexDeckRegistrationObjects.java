package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckRegistrationObjects  extends BasePageObjects{
public TrexDeckRegistrationObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
@FindBy(xpath="//input[@name='username']")
protected WebElement UserName;

@FindBy(xpath="//input[@name='email']")
protected WebElement Email;

@FindBy(xpath="//input[@name='password']")
protected WebElement UPassword;

@FindBy(xpath="//input[@name='cpassword']")
protected WebElement CPassword;

@FindBy(xpath="//input[@name='zipcode']")
protected WebElement Zip;

@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
protected WebElement Captcha;

@FindBy(xpath="//input[@name='termsCheckbox']")
protected WebElement TermsCheckBox;

@FindBy(xpath="//button[@type='submit' and contains(.,'CREATE ACCOUNT')]")
protected WebElement CreateAccountBtn;

}
