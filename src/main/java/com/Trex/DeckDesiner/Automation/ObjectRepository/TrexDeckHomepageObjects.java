package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckHomepageObjects extends BasePageObjects{

	
	public TrexDeckHomepageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	@FindBy(xpath="//img[@class='caret']")
	protected WebElement Logoutdropdown;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	protected WebElement LogoutBtn;

}
