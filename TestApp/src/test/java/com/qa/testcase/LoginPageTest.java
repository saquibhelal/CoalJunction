package com.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initializationBrowser();
		loginPage= new LoginPage();
		loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));
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
