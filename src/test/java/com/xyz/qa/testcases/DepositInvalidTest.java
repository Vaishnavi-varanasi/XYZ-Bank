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

public class DepositInvalidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;
	DepositPage depositpage;

	public DepositInvalidTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameRon"));
		depositpage = customerlogin.navigatetoDeposit();
	}
	
	//Fails
	@Test(priority = 1)
	public void depositNegativeTest() {
		depositpage.depositamountNegative(prop.getProperty("depositNeg"));
	}
	
	//Passes
	@Test(priority = 2)
	public void depositCharTest() {
		Assert.assertFalse(depositpage.depositamountChar(prop.getProperty("depositChar")));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
