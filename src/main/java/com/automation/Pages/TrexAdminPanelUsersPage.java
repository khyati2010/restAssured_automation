package com.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexAdminPanelUsersPageObjects;
import com.automation.driverSupport.DriverManager;

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
