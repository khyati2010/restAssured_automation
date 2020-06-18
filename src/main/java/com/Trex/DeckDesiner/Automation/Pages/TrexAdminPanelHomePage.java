package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelHomePageObjects;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;



public class TrexAdminPanelHomePage extends TrexAdminPanelHomePageObjects {


	public TrexAdminPanelHomePage(WebDriver driver) {

		super(driver);
	}

	public TrexAdminPanelUsersPage clickOnUsersTab() {
		click(usersTab, "User Tab");
		return new TrexAdminPanelUsersPage(DriverManager.getDriver());

	}

	public TrexAdminPanelProductsPage clickOnProductsTab() {
		click(prodcutsTab, "Prodcuts Tab");
		return new TrexAdminPanelProductsPage();

	}

	public TrexAdminPanelAssetsPage clickOnAssetsTab() {

		click(assetsTab, "Assets Tab");
		return new TrexAdminPanelAssetsPage();

	}
	

	public void ClickLatestUserCreated() throws InterruptedException {
		ScrollUntillElementIsDisplayed(DriverManager.getDriver().findElement(By.xpath("//td[contains(.,'"+NewUserEmail+"')]/preceding-sibling::td/a")));
		Thread.sleep(2000);
		//SuccessMessage.isDisplayed();
		DriverManager.getDriver().findElement(By.xpath("//td[contains(.,'"+NewUserEmail+"')]/preceding-sibling::td/a")).isDisplayed();
		DriverManager.getDriver().findElement(By.xpath("//td[contains(.,'"+NewUserEmail+"')]/preceding-sibling::td/a")).click();
		Thread.sleep(5000);
		
	}
	
	public TrexAdminPanelUserCreateModal ClickCreateUserBtn() {
		click(CreateUser,"Create User");
		return new TrexAdminPanelUserCreateModal(DriverManager.getDriver());
	}
	
	
	


	public TrexAdminPanelLandingPage logOut()
	{
		click(logoutButton, "Logout Button");
		return new TrexAdminPanelLandingPage(DriverManager.getDriver());
	}
}


