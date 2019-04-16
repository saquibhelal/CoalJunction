package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class LoginPageNegative extends TestBase {

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
	WebElement trnBtn;
	
	@FindBy(xpath="//td[@class='errorclass']")
	WebElement error;
	
	
	
	public LoginPageNegative(){
		PageFactory.initElements(driver, this);
	}
	
	public void loginOper(String usNm,String ps){
		userName.sendKeys(usNm);
		pass.sendKeys(ps);
		submitBtn.click();
		bidingLink.click();
		tranPas.sendKeys("password5");
		trnBtn.click();
		String actual=error.getText();
		String expected_error="The transaction password you entered is incorrect.";
		Assert.assertEquals(actual, expected_error);
		
		
		
		/*String title=courseType.validateCourseTypePage();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(title,"Standard & Sections");
		softassert.assertAll();
        System.out.println("======You are Landing on the Correct Page======");*/
	}
	
	
}
