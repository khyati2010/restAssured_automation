package com.Trex.DeckDesiner.Automation.Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelLoginPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexAdminPanelLoginPage extends TrexAdminPanelLoginPageObjects{
	
	public TrexAdminPanelLoginPage(WebDriver driver)
	{
		super(driver);
	}
	

	public void enterEmail(String email) 
	{
		type(this.email, email, "email");
	}
	
	public void enterPassword(String password) 
	{
		type(this.password, password, "password");
	}
	
	public void clickOnLoginButton()
	{
		click(loginButton, "loginButton");
	}
	
	public TrexAdminPanelHomePage loginWithValidDetails(String email,String password) 
	{
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
		return new TrexAdminPanelHomePage(DriverManager.getDriver());
		
		
	}
	
	public TrexAdminPanelLoginPage loginWithInvalidDetails(String email, String password) 
	{
		
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
		return this;
	}
	
	
	
	

}
