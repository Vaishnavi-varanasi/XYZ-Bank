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
	
	  @Test(priority = 1) 
	  public void addCustTest() {
	  addcustomerpage.addCustomer(); 
	  }
	 
	
	@Test(priority = 2)
	public void verifyAddedCustTest(){
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
