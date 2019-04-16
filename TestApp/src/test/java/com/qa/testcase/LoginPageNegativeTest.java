package com.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginPageNegative;

public class LoginPageNegativeTest extends TestBase {

	LoginPageNegative loginPageNegative;
	
	public LoginPageNegativeTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initializationBrowser();
		loginPageNegative= new LoginPageNegative();
		loginPageNegative.loginOper(Pro.getProperty("username"), Pro.getProperty("password"));
    }
	
	@Test
	public void loginPageTest(){
		//loginPage.biddingLinkOp();
		
		/*loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));*/
	}
	
	@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
   }
}
