package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class TrexAdminPanelHomePageObjects extends BasePageObjects {

	public TrexAdminPanelHomePageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	
	
	@FindBy(xpath="//h1[text()='Welcome!']")
	public WebElement welcomeMessage;
	
	@FindBy(css=".navbar-brand>a")
	public WebElement trexBrandName;
	
	@FindBy(xpath="//div[text()='Logout']")
	public WebElement logoutButton;
	
	@FindBy(xpath="//*[@role='tab' and text()='Home']")
	public WebElement homeTab;
	
	@FindBy(xpath="//*[@role='tab' and text()='Users']")
	public WebElement usersTab;
	
	@FindBy(xpath="//*[@role='tab' and text()='Products']")
	public WebElement prodcutsTab;
	
	@FindBy(xpath="//*[@role='tab' and text()='assets']")
	public WebElement assetsTab;
	
	@FindBy(xpath="//button[contains(.,'Create User')]")
	protected WebElement CreateUser;
	
	@FindBy(xpath="//p[contains(.,'User has been successfully Deleted.')]")
	protected WebElement UserDeleteSuccessMessagel;
	
	@FindBy(xpath="//button[contains(.,'Load More')]")
	protected WebElement LoadMoreBtn;
	
	

	
	
	
	

}
