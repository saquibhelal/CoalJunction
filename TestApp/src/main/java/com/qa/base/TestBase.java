package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties Pro;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListner eventListner;
	
	
	public TestBase(){
		
		try{
			Pro=new Properties();
			FileInputStream fis=new FileInputStream("D:\\CoalJunction\\TestApp\\src\\main\\java\\com\\qa\\config\\config2.properties");
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
			
			System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver_win32 (1)\\chromedriver.exe");
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


}
