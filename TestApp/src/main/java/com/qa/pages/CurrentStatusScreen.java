package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CurrentStatusScreen extends TestBase {

	@FindBy(xpath="//font[contains(text(),'Refresh ')]")
	WebElement refresh;
	
	
	public CurrentStatusScreen(){
		PageFactory.initElements(driver, this);
	}
	
	public void postVerificationScreen(){
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='refresh']")));
		refresh.click();
		
	}
}
