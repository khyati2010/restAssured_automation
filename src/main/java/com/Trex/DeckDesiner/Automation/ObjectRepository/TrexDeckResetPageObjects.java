package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrexDeckResetPageObjects extends BasePageObjects{
public TrexDeckResetPageObjects(WebDriver driver) {
		
		super.openPage(driver, this);
	}
@FindBy(xpath="//div[@class='col']//button[contains(.,'RESET')]")
protected WebElement Reset;

@FindBy(xpath="//button[contains(.,'CANCEL')]")
protected WebElement Cancel;

}
