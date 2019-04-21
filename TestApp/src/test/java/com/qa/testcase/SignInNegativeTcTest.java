package com.qa.testcase;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SignInNegativeTc;

public class SignInNegativeTcTest extends TestBase {

	LoginPage loginPage;
	SignInNegativeTc signNegTc;
	
	public SignInNegativeTcTest(){
		super();
	}
	
	@Test
	public void userNameTest(String usName){
		signNegTc=new SignInNegativeTc();
		signNegTc.signInuserName(usName);
	}
}
