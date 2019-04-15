package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ProfilePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'MY PROFILE')]")
	WebElement pLink;
	
	public ProfilePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateUserProfile(){
		String valCheck="Joyotpol Paul";
		return valCheck;
	}
	
	public void profilePageCheck(){
		pLink.click();
		System.out.println("User enter into profile page");
	}
	
}
