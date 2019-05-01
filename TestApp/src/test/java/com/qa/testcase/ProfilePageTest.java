package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase{

	LoginPage loginPage;
	ProfilePage prfPage;
	//ExcelDataConfig excel=new ExcelDataConfig("D:\\CoalJunction\\TestApp\\src\\main\\java\\com\\qa\\testdata\\CoalTestData2.xlsx");
	
	
	
	public ProfilePageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		initializationBrowser();
		loginPage= new LoginPage();
		prfPage=new ProfilePage();
		loginPage.loginOperation(Pro.getProperty("username"),Pro.getProperty("password"));
    }
	
	@Test(priority=3)
	public void userProfileValidateTest() throws InterruptedException{
		
		Thread.sleep(4000);
		String heck=prfPage.validateUserProfile();
		Assert.assertEquals(heck, "Joyotpol Paul");
	}
	
	@Test(priority=2)
	public void profileTest(){
		prfPage.profilePageCheck();
		System.out.println("Success");
	}
	
	@Test(priority=1)
	public void test(){
		prfPage.TestApp();
	}
	
	@AfterClass
	public void tearDown(){
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
   }
}
