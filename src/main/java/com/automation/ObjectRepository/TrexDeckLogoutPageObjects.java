package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckLogoutPageObjects extends BasePageObjects{
public TrexDeckLogoutPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
@FindBy(xpath="//button[contains(.,'SAVE & LOG OUT')]")
protected WebElement SavenLogout;

@FindBy(xpath="//button[contains(.,'CANCEL & RESUME')]")
protected WebElement CancelnResume;

}
