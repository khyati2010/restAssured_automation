package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckLoginPageObjects extends BasePageObjects{
public TrexDeckLoginPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
@FindBy(xpath="//input[@name='email']")
protected WebElement Email;

@FindBy(xpath="//input[@name='password']")
protected WebElement Password;

@FindBy(xpath="//button[contains(.,'LOG IN') and @type='submit']")
protected WebElement LoginBtnModal;

@FindBy(xpath="//button[contains(.,'CREATE ACCOUNT')]")
protected WebElement CreateAccountBtn;

@FindBy(xpath="//div[contains(.,':( There was a problem') and @class='error-title-font-style']")
protected WebElement errorMessage;
}

