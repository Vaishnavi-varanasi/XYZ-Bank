package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.AddCustomerPage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.util.TestUtilXYZ;
/* 
In Jira(Zephyr Squad), this test case number is 
XYZ-T8
*/
public class AddCustomerInvalidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	AddCustomerPage addcustomerpage;
	CustomerLoginPage customerlogin;

	public AddCustomerInvalidTest() {
		super();
	}

	@BeforeMethod
	public void setUp1() {
		initialization();
		homePage = new HomePageXYZ();
		bankmanagerlogin = homePage.navigatetoBMLogin();
		addcustomerpage = bankmanagerlogin.navigatetoAddCust();
	}

	/* 
	 This test is to verify if the Add Customer functionality is accepting duplicate data(Already existing customer data)
	 This test should pass, as the website doesn't accept duplicate inputs
	 */
	@Test(priority = 1)
	public void addCustDuplicateTest() {
		Assert.assertTrue(addcustomerpage.addCustDuplicate());
	}

	/*
	 This test is for checking data validations for input fields
	 This test will fail as it is a bug
	 */
	// Bug ID in Jira is XYZ-40
	@Test(priority = 2)
	public void addCustValidationTest() {
		Assert.assertFalse(addcustomerpage.addCustomerValidation());
	}

	/*
	 This test is for checking Add Customer Functionality with Invalid Data(Numbers)
	 This test will fail as it is a bug
	 */
	// Bug ID in Jira is XYZ-39
	@Test(priority = 3)
	public void addCustNumbersTest() {
		Assert.assertFalse(addcustomerpage.addCustomerNumbers());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
