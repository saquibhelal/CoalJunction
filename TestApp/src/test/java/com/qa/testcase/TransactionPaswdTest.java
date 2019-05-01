package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.TransactionPasswd;

public class TransactionPaswdTest extends TestBase{

	TransactionPasswd trnPwd;
	
	public TransactionPaswdTest(){
		super();
	}
	
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		initializationBrowser();
		trnPwd= new TransactionPasswd();
		trnPwd.loginOp(Pro.getProperty("username"), Pro.getProperty("password"));
    }
	
	
	@Test
	public void appTest(){
		String actualMsg="The transaction password you entered is incorrect.";
		String expectedMsg=trnPwd.transactionPassValidation(Pro.getProperty("TransactionPasswordMsg"));
		Assert.assertEquals(expectedMsg, actualMsg);
		System.out.println("Operation Done");
	}
	
	@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
   }
}
