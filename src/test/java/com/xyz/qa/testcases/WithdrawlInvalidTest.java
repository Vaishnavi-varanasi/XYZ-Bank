package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.pages.WithdrawlPage;
import com.xyz.qa.util.TestUtilXYZ;

public class WithdrawlInvalidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;
	DepositPage depositpage;
	WithdrawlPage withdrawlpage;

	public WithdrawlInvalidTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameHer"));
		withdrawlpage = customerlogin.navigatetoWithdrawl();
	}
	
	//Fails
	@Test(priority = 1)
	public void withdrawNegativeTest() {
		withdrawlpage.withdrawamountNegative(prop.getProperty("withdrawlNeg"));
	}
	
	//Pass
	@Test(priority = 2)
	public void withdrawCharTest() {
		Assert.assertFalse(withdrawlpage.withdrawamountChar(prop.getProperty("withdrawlChar")));

	}
	
	//Pass
	@Test(priority = 3)
	public void withdrawMorethanBalanceTest() {
		Assert.assertTrue(withdrawlpage.withdrawMorethanBalance(prop.getProperty("withdrawlInvalid")));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
