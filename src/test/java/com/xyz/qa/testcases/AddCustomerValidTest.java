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
 XYZ-T7
 */
public class AddCustomerValidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	AddCustomerPage addcustomerpage;
	CustomerLoginPage customerlogin;

	public AddCustomerValidTest() {
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
	 This Test runs addCustomer() method in AddCustomerPage and this test will pass if all functions performed in that method are run successfully
	 */
	@Test(priority = 1)
	public void addCustTest() {
		addcustomerpage.addCustomer();
	}
    /* 
     This test verifies if the new customer we added earlier through 'Add Customer' in Bank Manager Login is visible in Customer Login Page
     */
	@Test(priority = 2)
	public void verifyAddedCustTest() {
		addcustomerpage.addCustomer();
		homePage = addcustomerpage.navigatetoHome();
		customerlogin = homePage.navigatetocustomerdetails("Vaishnavi Varanasi");
		customerlogin.verifycustomerName("Vaishnavi Varanasi");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
