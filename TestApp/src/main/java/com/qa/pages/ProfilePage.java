package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class ProfilePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'MY PROFILE')]")
	WebElement pLink;
	
	@FindBy(xpath="//body//tr[3][@class='alternateColumnClass']")
	WebElement test;
	
	
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
	
	public void TestApp(){
		String element=driver.findElement(By.xpath("//body//tr[3][@class='alternateColumnClass']")).getText();
		System.out.println(element);
		if(element.equals("")){
			System.out.println("No value is present");
			Assert.fail("Header value is not available");
		}else{
			System.out.println("Value is present");
		}
		
		/*String lst=element.getText();
		for(WebElement we:lst){
			System.out.println(we);*/
			
		}
	}
	

