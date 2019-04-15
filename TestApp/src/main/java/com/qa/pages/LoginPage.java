package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//input[@name='userid']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'BIDDING')]")
	WebElement bidingLink;
	
	@FindBy(xpath="//input[@value='password']")
	WebElement tranPas;
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void loginOperation(String usNm,String ps){
		userName.sendKeys(usNm);
		pass.sendKeys(ps);
		submitBtn.click();
		//bidingLink.click();
		//tranPas.sendKeys("password4");
	}
	
	
}
