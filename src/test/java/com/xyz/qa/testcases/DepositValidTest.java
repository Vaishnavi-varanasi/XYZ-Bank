package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.util.TestUtilXYZ;

public class DepositValidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;
	DepositPage depositpage;

	public DepositValidTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameRon"));
		depositpage = customerlogin.navigatetoDeposit();
	}
	@Test(priority = 1)
	public void depositamountTest() {
		depositpage.depositamount(prop.getProperty("deposit1"));
		depositpage.depositamount(prop.getProperty("deposit2"));
	}
	@Test(priority = 2)
	public void verifydepositamountTest() {
		Assert.assertTrue(depositpage.verifydepositamount(prop.getProperty("deposit2")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
