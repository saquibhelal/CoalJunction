package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class SignInNegativeTc extends TestBase{

	@FindBy(xpath="//input[@name='userid']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//tr[4]//td[2]")
	WebElement errorMsg;
	
	@FindBy(xpath="//tr[5]//td[2]")
	WebElement errorMsg1;
	
	public SignInNegativeTc(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean signInuserName(String usrName){
		String msg=userName.getText();
		boolean actualMsg=false;
		userName.sendKeys("");
		submit.click();
		try{
			if(errorMsg.isDisplayed()){
				  //System.out.println("You enter wrong userName");	
				Assert.assertEquals(msg, "*Username is required");
				  Thread.sleep(2000);
				  return true;
			}
	}catch (Exception e) {
		return false;
	}
		return actualMsg;
  }
	
	public boolean signInpassword(String paswd){
		String msg=password.getText();
		boolean actualMsg=false;
		password.sendKeys("");
		submit.click();
		try{
			if(errorMsg1.isDisplayed()){
				  //System.out.println("You enter wrong userName");	
				Assert.assertEquals(msg, "*Password is required");
				  Thread.sleep(2000);
				  return true;
			}
	}catch (Exception e) {
		return false;
	}
		return actualMsg;
  }
	
}

/*String title=courseType.validateCourseTypePage();
SoftAssert softassert=new SoftAssert();
softassert.assertEquals(title,"Standard & Sections");
softassert.assertAll();
System.out.println("======You are Landing on the Correct Page======");*/