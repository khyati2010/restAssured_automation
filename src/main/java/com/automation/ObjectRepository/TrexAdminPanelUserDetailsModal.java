package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelUserDetailsModal extends BasePageObjects{

	
	public TrexAdminPanelUserDetailsModal(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	@FindBy(xpath="//button[contains(.,'Edit User')]")
	protected WebElement EditUserBtn;
	
	@FindBy(xpath="//button[contains(.,'Delete')]")
	protected WebElement DeleteBtn;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	protected WebElement YesBtn;
	
	@FindBy(xpath="//button[contains(.,'No')]")
	protected WebElement NoBtn;
	

}
