package com.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.automation.ObjectRepository.TrexAdminPanelUserDetailsModal;

public class TrexAdminPanelUserDelete extends TrexAdminPanelUserDetailsModal{
	

	public TrexAdminPanelUserDelete(WebDriver driver) {
		
		super(driver);
	}

	
	
	public void clickEditBtn() {
		click(EditUserBtn, "Edit User button");
	}
	
	public void clickDeleteBtn() {
		click(DeleteBtn,"Delete button");
	}
	
	public void clickYesBtn() {
		click(YesBtn, "Yes button");
	}
	
	public void clickNoBtn() {
		click(NoBtn, "No button");
	}
	
	
	public void DeleteUser() {
		clickDeleteBtn();
		clickYesBtn();
		
	}

}
