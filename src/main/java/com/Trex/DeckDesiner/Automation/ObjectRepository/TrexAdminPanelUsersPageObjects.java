package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexAdminPanelUsersPageObjects extends BasePageObjects {
	
	
	public TrexAdminPanelUsersPageObjects(WebDriver driver) {
		super.openPage(driver,this);
	}

	@FindBy(xpath="//button[text()='Create User']")
	public WebElement createUserButton;
	
	@FindBy(xpath="//input[@placeholder='Enter search term']")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement searchButton;
	
	@FindBy(xpath="//button[text()='Load More']")
	public WebElement loadMoreButton;
	
	
	
	
	
	

}
