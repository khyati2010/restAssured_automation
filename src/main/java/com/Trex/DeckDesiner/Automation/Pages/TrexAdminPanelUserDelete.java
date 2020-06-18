package com.Trex.DeckDesiner.Automation.Pages;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.ObjectRepository.TrexAdminPanelUserDetailsModal;

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
