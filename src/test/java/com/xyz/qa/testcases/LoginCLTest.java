package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.util.TestUtilXYZ;

public class LoginCLTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;

	public LoginCLTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameN"));

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "XYZ Bank");
	}

	@Test(priority = 2)
	public void verifyHeaderTest() {
		Assert.assertTrue(customerlogin.verifyHeader());
	}

	@Test(priority = 3)
	public void verifyAccountNumberTest() {
		Assert.assertTrue(customerlogin.verifyAccountNumber());

	}

	@Test(priority = 4)
	public void verifyCustomerNameTest() {
		Assert.assertTrue(customerlogin.verifycustomerName(prop.getProperty("usernameN")));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
