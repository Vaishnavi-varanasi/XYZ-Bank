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

public class WithdrawValidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;
	DepositPage depositpage;
	WithdrawlPage withdrawlpage;

	public WithdrawValidTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameHer"));
		// depositpage = customerlogin.navigatetoDeposit();
		withdrawlpage = customerlogin.navigatetoWithdrawl();
	}

	@Test(priority = 1)
	public void withdrawamountTest() {
		withdrawlpage.withdrawamount(prop.getProperty("withdrawl1"));

	}

	@Test(priority = 2)
	public void verifywithdrawlamountTest() {
		Assert.assertTrue(withdrawlpage.verifywithdrawamount(prop.getProperty("withdrawl2")));
	}

	/*
	 * @Test(priority = 3) public void verifyintransactionsWTest() {
	 * Assert.assertTrue(withdrawlpage.verifyintransactionsW(prop.getProperty(
	 * "withdrawl3"))); }
	 */
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
