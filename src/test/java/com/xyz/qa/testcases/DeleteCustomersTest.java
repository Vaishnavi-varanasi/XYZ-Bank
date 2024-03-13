package com.xyz.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
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

/* 
In Jira(Zephyr Squad), this test case number is 
XYZ-T12
*/
public class DeleteCustomersTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	AddCustomerPage addcustomerpage;
	CustomersPage customerspage;

	public DeleteCustomersTest() {
		super();
	}

	@BeforeMethod
	public void setUp1() {
		initialization();
		homePage = new HomePageXYZ();
		bankmanagerlogin = homePage.navigatetoBMLogin();
		customerspage = bankmanagerlogin.navigatetoCustomers();
	}

	/*
	 In this test, I deleted user by searching for first name in search bar
	 After deleting, I searched for the deleted user, if element is not found them it means that the delete action is performed successfully
	 I used NoSuchElementFoundException for that
	 */
	@Test(priority = 1)
	public void deleteByFnameTest() {

		Assert.assertTrue(customerspage.searchByFName());
		customerspage.Delete();
		try {
			customerspage.searchByFName();

		} catch (NoSuchElementException e) {
			System.out.println("Delete action performed successfully");
		}
	}
	/*
	 In this test, I deleted user by searching for last name in search bar
	 After deleting, I searched for the deleted user, if element is not found them it means that the delete action is performed successfully
	 I used NoSuchElementFoundException for that
	 */
	@Test(priority = 2)
	public void deleteByLnameTest() {

		Assert.assertTrue(customerspage.searchByLName());
		customerspage.Delete();
		try {
			customerspage.searchByLName();

		} catch (NoSuchElementException e) {
			System.out.println("Delete action performed successfully");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}