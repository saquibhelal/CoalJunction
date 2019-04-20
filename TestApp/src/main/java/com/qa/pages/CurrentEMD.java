package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CurrentEMD extends TestBase {
	
	@FindBy(xpath="//input[@value='Current EMD Allocation']")
	WebElement currentEmd;
	
	@FindBy(xpath="//input[@value='Close']")
	WebElement close;
	
	@FindBy(xpath="//a[@class='confirm top_link']")
	WebElement logOut;
	
	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	WebElement confirm;
	
	@FindBy(xpath="//span[contains(text(),'Are you sure that you want to logout?')]")
	WebElement msg;
	
	public CurrentEMD(){
		PageFactory.initElements(driver, this);
	}
	
	public void emdAllocationCheck() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.xpath("//tr[2]//td[1]//iframe[1]")));
		Thread.sleep(2000);
		currentEmd.click();
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
	    
		System.out.println("=====Current EMD close successfully=====");
		
		logOut.click();
		System.out.println(logOut.getText());
		Thread.sleep(5000);
        System.out.println(msg.getText());
		System.out.println(confirm.getText());
		confirm.click();
		
		/*Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();*/
	}

}
