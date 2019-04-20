package com.qa.testcase;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CurrentStatusScreen;
import com.qa.pages.LoginPage;

public class CurrentStatusScreenTest extends TestBase{

	LoginPage loginPage;
	CurrentStatusScreen crScreen;
	
	public CurrentStatusScreenTest(){
		super();
	}
	
	@Test
	public void postVerificationScreenTest(){
		crScreen=new CurrentStatusScreen();
		crScreen.postVerificationScreen();
	}
}
