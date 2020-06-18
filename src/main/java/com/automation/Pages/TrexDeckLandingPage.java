package com.automation.Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.ObjectRepository.TrexDeckLandingPageObjects;
import com.automation.driverSupport.DriverManager;
import com.sun.tools.xjc.reader.gbind.Element;

public class TrexDeckLandingPage extends TrexDeckLandingPageObjects{
public TrexDeckLandingPage(WebDriver driver) {
		
		super(driver);
	}

public TrexDeckLoginPage clickLoginBtn() {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[contains(.,'LOG IN')]"))));
	click(LoginBtn, "Login button");
	return new TrexDeckLoginPage(DriverManager.getDriver());
}

public boolean validateUserLoggedOut(){
	LoginBtn.isDisplayed();
	return true;
}

public void ChangeDeckDimensions(int i, int j, int k, int l) throws InterruptedException, AWTException {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='footer-item footer-title' and contains(.,'Dimensions')]"))));
	Thread.sleep(5000);
	click(DimensioneBottomNavigation, "Dimensions from bottom navigation panel");
	type(DimensionAFeet, i, "Dimension of A in feets");
	type(DimensionBFeet, j, "Dimension of B in Feets");
	type(DimensionAInch, k, "Dimension of A in Inch");
	type(DimensionBInch, l, "Dimension of B in Inch");
	pressEnter();
}
public void saveDeck() throws InterruptedException {
	click(SaveBtn,"Save button");
	Thread.sleep(2000);
	assertEquals(SavedAlert.isDisplayed(), true);
	Thread.sleep(2000);
}
public void validateDeckDimensions(int i, int j, int k, int l) {	
	
	int A = Integer.parseInt(DimensionAFeet.getAttribute("value"));
	int B = Integer.parseInt(DimensionBFeet.getAttribute("value"));
	int C = Integer.parseInt(DimensionAInch.getAttribute("value"));
	int D = Integer.parseInt(DimensionBInch.getAttribute("value"));
	
	
	assertEquals(A, i);
	assertEquals(B, j);
	assertEquals(C, k);
	assertEquals(D, l);
}
	
public TrexDeckResetPage ResetDeck() {
	
	click(ResetBtn, "Reset button");
	
	return new TrexDeckResetPage(DriverManager.getDriver());
}
	
}



