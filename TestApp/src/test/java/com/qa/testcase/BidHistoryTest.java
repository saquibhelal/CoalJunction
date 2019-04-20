package com.qa.testcase;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BidHistory;
import com.qa.pages.LoginPage;

public class BidHistoryTest extends TestBase {

	LoginPage loginPage;
	BidHistory bdHstry;
	
	public BidHistoryTest(){
		super();
	}
	
	@Test
	public void bidHistoryTest() throws InterruptedException{
		bdHstry=new BidHistory();
		bdHstry.bidHistory();
	}
}
