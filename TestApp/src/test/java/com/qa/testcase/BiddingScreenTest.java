package com.qa.testcase;

import org.testng.Assert;
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
	String sheetName="Sheet1";
	
	
	public BiddingScreenTest(){
		super();
	}
	
	/*@BeforeClass
	public void setUp() throws InterruptedException{
		initializationBrowser();
		loginPage= new LoginPage();
		bdScreen = new BiddingScreen();
		loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));		
    }*/
	
	@DataProvider
	public Object[][] getCoalTestDataSheet(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
}
	@Test(dataProvider="getCoalTestDataSheet")
	public void biddingScreenTest(String quanty,String prc) throws InterruptedException{
		System.out.println("quanty: "+quanty+" " +"prc: "+prc);
		bdScreen=new BiddingScreen();
		bdScreen.bidingScreenInput(quanty, prc);
		
	}
	
	

	/*@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
    }*/
}
