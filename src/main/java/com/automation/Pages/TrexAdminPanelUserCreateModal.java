package com.automation.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexAdminPanelHomePageObjects;
import com.automation.ObjectRepository.TrexAdminPanelNewUserRegistrationModal;
import com.automation.driverSupport.DriverManager;


public class TrexAdminPanelUserCreateModal extends TrexAdminPanelNewUserRegistrationModal{
	

	public TrexAdminPanelUserCreateModal(WebDriver driver) {
		
		super(driver);
	}

	
	
	public void clickSaveBtn() {
		click(SaveBtn, "Create User button");
	}
	public void enterUserName(String username) throws AWTException, InterruptedException
	{
		type(this.UserName, username, "email");
	}
	
	public void enterEmail(String Email) throws AWTException, InterruptedException
	{
		type(this.Email, Email, "password");
	}
	
	public void enterZip(String ZipCode) throws AWTException, InterruptedException
	{
		type(this.ZipCode, ZipCode,"Zip Code");
	}
	
	public void enterPassword(String Password) throws AWTException, InterruptedException
	{
		type(this.Password, Password,"Password");
	}
	
	public TrexAdminPanelUserCreateModal NewUserRegistrationValidDetails(String username, String Email,String ZipCode, String Password ) throws InterruptedException, AWTException{
		
		enterUserName(username);
		enterEmail(Email);
		enterZip(ZipCode);
		enterPassword(Password);
		Thread.sleep(2000);
		clickSaveBtn();
		Thread.sleep(12000);
		
		return new TrexAdminPanelUserCreateModal(DriverManager.getDriver());
	}

}


