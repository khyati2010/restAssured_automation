package com.Trex.DeckDesiner.Automation.ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.Trex.DeckDesiner.Automation.Utils.CommonVariables;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;


public class BasePageObjects<T> extends TestSetup {

	
	
	public void openPage( WebDriver driver,T pageObject)
	{
		PageFactory.initElements(driver, pageObject);
		
		
	}
	
	public void click(WebElement element, String elementName)
	{
		element.click();
		//CommonVariables.getCurrentTestCaseLog().info("Clicked on "+elementName);
		
	}
	
	public void type(WebElement element, int text, String elementName) throws AWTException, InterruptedException
	{
		ClearTextBox(element);
		@SuppressWarnings("deprecation")
		Integer obj3 = new Integer(text);
		String stringvalue1 = obj3.toString(); 
		element.sendKeys(stringvalue1);
		//CommonVariables.getCurrentTestCaseLog().info("Entered "+text+  "<b>" +"as "+"</b>"+elementName);
	}
	public void type(WebElement element, String text, String elementName) 
	{
		ClearTextBox(element);
		element.sendKeys(text);
		//CommonVariables.getCurrentTestCaseLog().info("Entered "+text+  "<b>" +"as "+"</b>"+elementName);
	}	
	
	public void ClearTextBox(WebElement element) {
		
		
		
		if(element.getText()==null) {
			element.click();
		}
		else{
			element.sendKeys(Keys.BACK_SPACE +""+ Keys.BACK_SPACE);
		}
		/*
		 * Actions action = new Actions(DriverManager.getDriver());
		 * action.click(element).keyDown(Keys.DELETE) .keyUp(Keys.DELETE)
		 * .keyDown(Keys.DELETE) .keyUp(Keys.DELETE) .keyDown(Keys.DELETE)
		 * .keyUp(Keys.DELETE) .build() .perform();
		 */
		
	}
	public void pressEnter()  {
		Robot rb=null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public boolean validateElementIsDisplayed(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element.isDisplayed();
	}
	
	public void getElementText(WebElement element, String elementName)
	{
		
		System.out.println(element.getText());
		CommonVariables.getCurrentTestCaseLog().info("Element Text is" +elementName);
		
		
	}
	
	public static void scrollTheElement(WebElement Element) {
		
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("scroll(0,400)");
	}
	public static void scrollDown(WebElement element) throws InterruptedException {
		int iCount = 0;
		while (iCount < 9) {
			scrollTheElement(element);
			Thread.sleep(2000);
			iCount++;
		}
	}
	
	public static boolean ScrollUntillElementIsDisplayed(WebElement element1) throws InterruptedException {
		boolean status = false;
		int iCount = 0;
		
		while (iCount < 5) {
			scrollDown(element1);
			status = element1.isDisplayed();
			if (status) {
				return true;
			}
			//else if (element2.isDisplayed()) {
	//			element2.click();
	//		}
			else {
			iCount++;
			
		}
			}
		return false;
	}
	
	
	

}
