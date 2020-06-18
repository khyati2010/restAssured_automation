package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelLoginPageObjects extends BasePageObjects{

	
	public TrexAdminPanelLoginPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement password;
	
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginButton;
	
	
	@FindBy(xpath="//p[text()='Incorrect username or password.']")
	public WebElement incorrectUserPasswordErrorMessage;
	
	@FindBy(xpath="//p[text()='Invalid User! Kindly contact Admin.']")
	public WebElement invalidUserErrorMessage;
	
	@FindBy(xpath="//p[text()='Name should contain minimum 2 characters.']")
	public WebElement invalidNameError;
	
	
	@FindBy(xpath="//div[text()='Incorrect email format.']")
	public WebElement invalidEmailFormatError;
	
	
	@FindBy(xpath="//input[@id='zip_code']//following-sibling::div")
	public WebElement invalidZipCode;
	
	@FindBy(xpath="//input[@id='password']//following-sibling::div/text()")
	public WebElement invalidPasswordError;
	
	
	
	
	
	
	
	
	
	
	
}
