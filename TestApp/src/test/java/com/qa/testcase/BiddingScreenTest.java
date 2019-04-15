package com.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BiddingScreen;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class BiddingScreenTest extends TestBase {

	LoginPage loginPage;
	BiddingScreen bdScreen;
	String sheetName="Bid";
	
	
	public BiddingScreenTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initializationBrowser();
		loginPage= new LoginPage();
		loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));
    }
	
	@DataProvider
	public Object[][] getCoalTestDataSheet(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
}
	@Test(dataProvider="getCoalTestDataSheet")
	public void biddingScreenTest(String quanty,String prc){
		bdScreen.bidingScreenInput(quanty, prc);
		
	}
	

	@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
    }
}
