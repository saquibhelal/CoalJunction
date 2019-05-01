package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.ExtentReporterListner.ExtentReporterNG;
import com.qa.pages.BiddingScreen;
import com.qa.pages.CurrentEMD;
import com.qa.pages.LoginPage;
import com.qa.testcase.LoginPageTest;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties Pro;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListner eventListner;
	LoginPage loginPage;
	BiddingScreen bdScreen;
	//ATUTestRecorder recorder;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public TestBase(){
		
		try{
			Pro=new Properties();
			FileInputStream fis=new FileInputStream("D:\\CoalJunction\\TestApp\\src\\main\\java\\com\\qa\\config\\config.properties");
			Pro.load(fis);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initializationBrowser(){
		String browserName=Pro.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			    driver=new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("FF")){
			
			System.setProperty("webdriver.gecko.driver", "E:\\driver\\selenium-firefox-driver-2.4.0.jar"
					+ "\\selenium-firefox-driver-2.4.0.jar");
     			driver=new FirefoxDriver();
		}
		
		
		e_driver=new EventFiringWebDriver(driver);
		//eventListner=new WebEventListner();
		//e_driver.register(eventListner);
		driver= e_driver;
		
		

		driver.manage().window().maximize();
		//driver.manage().window().setPosition(new Point(0, -1000));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(Pro.getProperty("url"));
	    //driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException, ATUTestRecorderException{
		
		
		
		
		
		
		
		/* DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		 Date date = new Date();
		 recorder = new ATUTestRecorder("D:\\ScriptVideos","TestVideo-"+dateFormat.format(date),false);
		 recorder.start(); */
		initializationBrowser();
		loginPage= new LoginPage();
		bdScreen = new BiddingScreen();
		loginPage.loginOperation(Pro.getProperty("username"), Pro.getProperty("password"));		
    }

	@AfterClass
	public void tearDown(/*ITestResult result*/) throws ATUTestRecorderException{
	/*	if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
extent.endTest(extentTest);*/
		
		
		System.out.println("======Browser is shutting down=====\n");
		 driver.quit();
		// recorder.stop();
    }

}
