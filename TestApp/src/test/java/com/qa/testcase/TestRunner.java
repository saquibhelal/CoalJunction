package com.qa.testcase;

import org.testng.TestNG;

import com.qa.base.ExtentReporterNG;

public class TestRunner {

	static TestNG testNg;
	
	public static void main(String[] args) {
		
		//ExtentReporterNG ext =new ExtentReporterNG();
		
		 testNg=new TestNG();
		 testNg.setTestClasses(new Class[]{LoginPageTest.class,CurrentEMDTest.class,
				 BidHistoryTest.class,CurrentStatusScreenTest.class});
		 //testNg.addListener(ext);
		 testNg.run();
	}

}
