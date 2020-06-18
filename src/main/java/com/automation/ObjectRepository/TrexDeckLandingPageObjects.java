package com.automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckLandingPageObjects extends BasePageObjects{

	
	public TrexDeckLandingPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
	@FindBy(xpath="//button[contains(.,'LOG IN')]")
	protected WebElement LoginBtn;
	
	@FindBy(xpath="//button[contains(.,'RESET DECK')]")
	protected WebElement ResetBtn;
	
	@FindBy(xpath="//div[@class='footer-item footer-title' and contains(.,'Shape')]")
	protected WebElement ShapeBottomNavigation;
	
	@FindBy(xpath="//div[@class='footer-item footer-title' and contains(.,'Dimensions')]")
	protected WebElement DimensioneBottomNavigation;
	
	@FindBy(xpath="(//*[@name='feet'])[1]")
	protected WebElement DimensionAFeet;
	
	@FindBy(xpath="(//*[@name='feet'])[2]")
	protected WebElement DimensionBFeet;
	
	@FindBy(xpath="(//*[@name='inch'])[1]")
	protected WebElement DimensionAInch;
	
	@FindBy(xpath="(//*[@name='inch'])[2]")
	protected WebElement DimensionBInch;

	@FindBy(xpath="//button[contains(.,'SAVE DECK')]")
	protected WebElement SaveBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	protected WebElement SavedAlert;
	
	
}
