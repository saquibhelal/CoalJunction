package com.qa.testcase;

import org.testng.Assert;
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
	public void setUp() throws InterruptedException{
		initializationBrowser();
		loginPage= new LoginPage();
		loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));
    }
	
	@Test(priority=2)
	public void LoginTxTestPass(){
		boolean result = loginPage.validateSuccess("password1");
		Assert.assertEquals(result, true);
	}
	
	@Test(priority=1)
	public void LoginTxTestFail(){
		boolean result = loginPage.validateError("password2");
		Assert.assertEquals(result, true);
	}
	@Test
	public void loginPageTest(){
		//loginPage.biddingLinkOp();
		
		/*loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));*/
	}
	
	@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		// driver.quit();
   }
}
