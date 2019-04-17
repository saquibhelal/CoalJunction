package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class BiddingScreen extends TestBase {

	@FindBy(xpath="//input[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//input[@name='price']")
	WebElement price;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement bidSubmit;
	
	public BiddingScreen(){
		PageFactory.initElements(driver, this);
	}

	public void bidingScreenInput(String qunty, String prce) {
		
		driver.findElement(By.xpath("//input[@name='quantity']")).click();;
		//quantity.click();
		quantity.sendKeys(qunty);
		price.click();
		price.sendKeys(prce);
		bidSubmit.click();
		bidSubmit.getText();
		System.out.println(bidSubmit);
		
	}
}
