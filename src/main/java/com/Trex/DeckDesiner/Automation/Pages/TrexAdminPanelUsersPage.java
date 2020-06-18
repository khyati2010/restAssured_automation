package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelUsersPageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexAdminPanelUsersPage extends TrexAdminPanelUsersPageObjects{
	
	
	public TrexAdminPanelUsersPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public TrexAdminPanelCreateUserPage clickOnCreateUserButton()
	{
		click(createUserButton, "create user button");
		return new TrexAdminPanelCreateUserPage(DriverManager.getDriver());
	}
	
	
	

}
