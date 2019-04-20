package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class BidHistory extends TestBase{

	@FindBy(xpath="//input[@value='Bid History']")
	WebElement bidHistory;
	
	@FindBy(xpath="//input[@value='Close']")
	WebElement close;
	
	public BidHistory(){
		PageFactory.initElements(driver, this);
	}
	
	public void bidHistory() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.xpath("//tr[2]//td[1]//iframe[1]")));
		Thread.sleep(2000);
		bidHistory.click();
		
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentWindowId=it.next();
		System.out.println("parent window id:"+parentWindowId);
		
		String childWindow=it.next();
		System.out.println("child window id:"+childWindow);
		Thread.sleep(2000);
		
		driver.switchTo().window(childWindow);
		System.out.println("Child window pop-up title is:"+driver.getTitle());
		
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		close.click();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title:"+driver.getTitle());
	    
		System.out.println("=====Bid History close successfully=====");
	}
}
