package com.qa.testcase;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CurrentEMD;
import com.qa.pages.LoginPage;

public class CurrentEMDTest extends TestBase{
	
	LoginPage loginPage;
	CurrentEMD crntEmd;
	
	
	public CurrentEMDTest(){
		super();
	}
	
	@Test
	public void currentEMDTest() throws InterruptedException{
		crntEmd=new CurrentEMD();
		crntEmd.emdAllocationCheck();
		
	}

}