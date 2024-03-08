package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.AddCustomerPage;
import com.xyz.qa.pages.BankManagerLoginPage;
import com.xyz.qa.pages.CustomersPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.util.TestUtilXYZ;

public class SearchCustomersTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	AddCustomerPage addcustomerpage;
	CustomersPage customerspage;

	public SearchCustomersTest() {
		super();
	}

	@BeforeMethod
	public void setUp1() {
		initialization();
		homePage = new HomePageXYZ();
		bankmanagerlogin = homePage.navigatetoBMLogin();
		customerspage = bankmanagerlogin.navigatetoCustomers();
	}

	@Test(priority = 1)
	public void searchByFnameTest() {
		Assert.assertTrue(customerspage.searchByFName());
		System.out.println("Search results are accurate");
	}

	@Test(priority = 2)
	public void searchByLnameTest() {
		Assert.assertTrue(customerspage.searchByLName());
		System.out.println("Search results are accurate");
	}

	@Test(priority = 3)
	public void searchByPostTest() {
		customerspage.searchByPost();
		System.out.println("Search results are accurate");
	}
	
	@Test(priority = 4)
	public void searchByaccNumTest() {
		Assert.assertTrue(customerspage.searchaccNum());
		System.out.println("Search results are accurate");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
