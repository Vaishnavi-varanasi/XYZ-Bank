package com.xyz.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBaseXYZ;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.HomePageXYZ;
import com.xyz.qa.pages.TransactionsPage;
import com.xyz.qa.pages.WithdrawlPage;
import com.xyz.qa.util.TestUtilXYZ;

public class TransactionsTest extends TestBaseXYZ {
	HomePageXYZ homePage;
	TestUtilXYZ testUtil;
	CustomerLoginPage customerlogin;
	DepositPage depositpage;
	WithdrawlPage withdrawlpage;
	TransactionsPage transactionspage;

	public TransactionsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePageXYZ();
		customerlogin = homePage.navigatetocustomerdetails(prop.getProperty("usernameHer"));
		depositpage = new DepositPage();
		withdrawlpage = new WithdrawlPage();
		transactionspage = new TransactionsPage();
	}

	@Test(priority = 1)
	public void viewTransactionWithdrawlTest() {

		customerlogin.navigatetoTransactions();
		transactionspage.verifyTransactionsW();

	}

	@Test(priority = 2)
	public void viewTransactionDepositTest() {

		customerlogin.navigatetoTransactions();
		transactionspage.verifyTransactionsD();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
