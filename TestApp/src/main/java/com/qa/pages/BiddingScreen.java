package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class BiddingScreen extends TestBase {

	@FindBy(xpath="//input[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//input[@name='rate']")
	WebElement price;
	
	@FindBy(xpath="//tr[3]//td[7]//input[2]")
	WebElement bidSubmit;
	
	public BiddingScreen(){
		PageFactory.initElements(driver, this);
	}

	public void bidingScreenInput(String qunty, String prce) throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='bidOnAuctions']")));
		Thread.sleep(2000);
		quantity.sendKeys(qunty);
		//price.sendKeys(prce);
		bidSubmit.click();
		Thread.sleep(7000);
		
		
	}
}
