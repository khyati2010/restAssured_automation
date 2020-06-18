package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelCreateUserPageObjects extends BasePageObjects {

	public TrexAdminPanelCreateUserPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}

	@FindBy(id = "name")
	public WebElement userName;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "zip_code")
	public WebElement zip;

	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement saveUser;
	


}
