package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TransactionPasswd extends TestBase{

	
	@FindBy(xpath="//input[@name='userid']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'BIDDING')]")
	WebElement bidingLink;
	
	@FindBy(xpath="//input[@name='tranPassword']")
	WebElement tranPas;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	
	public TransactionPasswd(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginOp(String usNm,String ps){
		userName.sendKeys(usNm);
		pass.sendKeys(ps);
		submitBtn.click();
		bidingLink.click();
		
	}
	
	public String transactionPassValidation(String property){
		tranPas.sendKeys("pass");
		submit.click();
		return property;
	}


	
}
