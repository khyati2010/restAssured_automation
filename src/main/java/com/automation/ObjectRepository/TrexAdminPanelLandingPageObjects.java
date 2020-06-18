package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelLandingPageObjects extends BasePageObjects{

	public TrexAdminPanelLandingPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[text()='Login']")
	protected WebElement loginButton;
	
	
	@FindBy(id="home-tabs-tab-home")
	protected WebElement homeTab;
	
	@FindBy(className="lander")
	protected WebElement welcomeMessage;
	

	
	
	
	
	
	
	
	
	

}
