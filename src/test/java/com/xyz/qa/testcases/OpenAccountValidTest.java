package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.CustomersPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.pages.OpenAccountPage;
import com.xyz.qa.util.TestUtilXYZ;

public class OpenAccountValidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	OpenAccountPage openaccountpage;
	CustomersPage customerspage;

	public OpenAccountValidTest() {
		super();
	}

	@BeforeMethod
	public void setUp1() {
		initialization();
		homePage = new HomePageXYZ();
		bankmanagerlogin = homePage.navigatetoBMLogin();
		openaccountpage = bankmanagerlogin.navigatetoOpenAcc(); 
		customerspage = new CustomersPage();
	}
	
	
	  @Test(priority = 1) 
	  public void openAccountValidTest() {
	  Assert.assertTrue(openaccountpage.openAccountValid(prop.getProperty("usernameA"),prop.getProperty("currencyD"))); 
	  }
	 
	
	@Test(priority = 2)
	public void openAccountVerifyTest() {
		
		String AccNum = openaccountpage.getCreatedAccNum(prop.getProperty("usernameA"),prop.getProperty("currencyD"));
		
		openaccountpage.navigatetoCustomers();
		Assert.assertTrue(customerspage.openAccountVerifyinCustomers(AccNum));
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
