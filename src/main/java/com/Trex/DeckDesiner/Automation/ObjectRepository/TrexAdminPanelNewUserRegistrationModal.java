package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelNewUserRegistrationModal extends BasePageObjects{

	
	public TrexAdminPanelNewUserRegistrationModal(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	@FindBy(id="name")
	protected WebElement UserName;
	
	@FindBy(id="email")
	protected WebElement Email;
	
	@FindBy(id="zip_code")
	protected WebElement ZipCode;
	
	@FindBy(id="password")
	protected WebElement Password;
	
	@FindBy(xpath="//button[contains(.,'Save')]")
	protected WebElement SaveBtn;
	
	@FindBy(xpath="//p[contains(.,'User has been successfully Created.')]")
	protected WebElement SuccessMessage;

}
