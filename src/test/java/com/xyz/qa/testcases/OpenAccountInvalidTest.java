package com.xyz.qa.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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

public class OpenAccountInvalidTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	BankManagerLoginPage bankmanagerlogin;
	OpenAccountPage openaccountpage;
	CustomersPage customerspage;

	public OpenAccountInvalidTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		bankmanagerlogin = homePage.navigatetoBMLogin();
		openaccountpage = bankmanagerlogin.navigatetoOpenAcc();
		customerspage = new CustomersPage();
	}

	@Test(priority = 1)
	public void openAccountBlankTest() {
		try {
			openaccountpage.openAccountBothBlank();

		} catch (NoAlertPresentException e) {
			System.out.println("Blank input is not accepted, so test is successfull");
		}
	}

	@Test(priority = 2)
	public void openAccountSingleBlankTest1() {
		try {
			openaccountpage.openAccountSingleBlank1(prop.getProperty("usernameA"));

		} catch (NoAlertPresentException e) {
			System.out.println("Blank input is not accepted, so test is successfull");
		}
	}

	@Test(priority = 3)
	public void openAccountSingleBlankTest2() {
		try {
			openaccountpage.openAccountSingleBlank2(prop.getProperty("currencyD"));

		} catch (NoAlertPresentException e) {
			System.out.println("Blank input is not accepted, so test is successfull");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
