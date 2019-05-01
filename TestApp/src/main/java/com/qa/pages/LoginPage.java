package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.HighLightElement;
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
	
	@FindBy(xpath="//input[@name='tranPassword']")
	WebElement tranPas;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[contains(text(),'Bidding')]")
	WebElement btnLnk;
	
	@FindBy(xpath="//td[@class='errorclass']")
	WebElement errorMsg;
	
	@FindBy(xpath="//p/font[text()='The transaction password you entered is correct. ']")
	WebElement txSuccessMsg;
	
	@FindBy(xpath="//input[@value='Reset']")
	WebElement reset;
	
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void loginOperation(String usNm,String ps) throws InterruptedException{
		
		boolean xyz = false; 
		HighLightElement.highLightElement(driver, userName);
		userName.sendKeys(usNm);
		HighLightElement.highLightElement(driver, pass);
		pass.sendKeys(ps);
		HighLightElement.highLightElement(driver, submitBtn);
		submitBtn.click();
		HighLightElement.highLightElement(driver, bidingLink);
		bidingLink.click();
		HighLightElement.highLightElement(driver, tranPas);
		tranPas.sendKeys("password1");
		//reset.click();
		Thread.sleep(3000);
		//tranPas.sendKeys("password1");
		HighLightElement.highLightElement(driver, submit);
	    submit.click();
	    HighLightElement.highLightElement(driver, btnLnk);
	    btnLnk.click();
		/*try{
			if(errorMsg.isDisplayed())
				  System.out.println("You enter wrong password");				 
		}
		
		catch(Exception e){
			System.out.println(driver.findElement(By.xpath("//p/font[text()='The transaction password you entered is correct. ']")).getText());
			btnLnk.click();			
		}*/
		
		
		
		/*btnLnk.click();		
		
		System.out.println("===="+actual);
		String error="The transaction password you entered is incorrecrt.";
		if(actual.contains(error)){
			System.out.println("You enter wrong password");
		}else{
			
			btnLnk.click();
			System.out.println("You enter correct password");
		}*/
		
	}
	
	/*public boolean validateError(String txPassword){
		boolean xyz = false;
		tranPas.sendKeys(txPassword); 
		submit.click();	
		try{
			if(errorMsg.isDisplayed()){
				  System.out.println("You enter wrong password");	
				  Thread.sleep(2000);
				  return true;
			}
		}
		
		catch(Exception e){
			return false;	
		}
		
		return xyz;
	}
	
	public boolean validateSuccess(String txPassword){
		boolean xyz = false;	
		WebElement txPassfield = driver.findElement(By.xpath("//input[@name='tranPassword']"));
		txPassfield.click();
		txPassfield.sendKeys(txPassword); 
		submit.click();	
		try{
			if(txSuccessMsg.isDisplayed()){
				  System.out.println("You enter CORRECT password");
				  driver.findElement(By.xpath("//a[contains(text(),'Bidding')]")).click();
				  return true;
			}
		}
		
		catch(Exception e){
			return false;	
		}
		
		return xyz;
	}
		*/
	
	
	public void tansactionPasswordValidation(String usNm,String ps){
		userName.sendKeys(usNm);
		pass.sendKeys(ps);
		submitBtn.click();
		bidingLink.click();
		tranPas.sendKeys("password5");
		
	}

	
	
	
	
	
}
