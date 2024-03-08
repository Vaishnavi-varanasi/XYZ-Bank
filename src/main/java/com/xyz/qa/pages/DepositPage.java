package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage extends HomePageXYZ {

	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement LogoutBtn;

	@FindBy(xpath = "//button[@ng-click='transactions()']")
	WebElement TransactionsBtn;

	@FindBy(xpath = "//button[@ng-click='withdrawl()']")
	WebElement WithdrawlBtn;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[1]")
	WebElement AccountNumberDisplay;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[2]")
	WebElement BalanceDisplay;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[3]")
	WebElement CurrencyDisplay;

	@FindBy(xpath = "//option[@selected=\"selected\"]")
	WebElement AccNumDropDown;

	@FindBy(xpath = "//input[@placeholder=\"amount\"]")
	WebElement AmountInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement DepositBtn;

	@FindBy(xpath = "//span[@class='error ng-binding']")
	WebElement message;

	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
	WebElement amtTransactionTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]")
	WebElement typeTransactionTable;

	public DepositPage() {
		PageFactory.initElements(driver, this);
	}

	public CustomerLoginPage clickonLogout() {
		LogoutBtn.click();
		return new CustomerLoginPage();
	}

	public TransactionsPage navigatetoTransactions() {
		TransactionsBtn.click();
		return new TransactionsPage();
	}

	public void depositamount(String amt) {
		AmountInput.sendKeys(amt);
		DepositBtn.click();
		String msgDisplayed = message.getText();
		if (msgDisplayed.equals("Deposit Successful")) {

			System.out.println("Deposit Successful message is displayed");

		}
		String BalanceStr = BalanceDisplay.getText();
		System.out.println("Balance is " + BalanceStr);
	}

	public boolean verifydepositamount(String amt) {
		String ogBalanceStr = BalanceDisplay.getText();
		int ogBalance = Integer.parseInt(ogBalanceStr);
		AmountInput.sendKeys(amt);
		DepositBtn.click();
		String newBalanceStr = BalanceDisplay.getText();
		int newBalance = Integer.parseInt(newBalanceStr);
		String difference = String.valueOf(newBalance - ogBalance);

		return amt.equalsIgnoreCase(difference);
	}

	public boolean verifyintransactionsD(String amt) {

		AmountInput.sendKeys(amt);
		DepositBtn.click();

		TransactionsBtn.click();

		String tableAmt = amtTransactionTable.getText();
		return tableAmt.equalsIgnoreCase(amt);

	}

	public void depositamountNegative(String amt) {
		AmountInput.sendKeys(amt);
		DepositBtn.click();
		String msgDisplayed = message.getText();
		System.out.println(msgDisplayed);
	}

	public boolean depositamountChar(String amt) {
		AmountInput.sendKeys(amt);
		DepositBtn.click();
		String Amtdisplayed = AmountInput.getText();
		return Amtdisplayed.equalsIgnoreCase(amt);
		
	}
	
	public boolean verifyintransactionsDT(String amt) {

		AmountInput.sendKeys(amt);
		DepositBtn.click();

		TransactionsBtn.click();
		driver.navigate().back();
		driver.navigate().forward();
		
		String tableAmt = amtTransactionTable.getText();
		return tableAmt.equalsIgnoreCase(amt);

	}

	public WithdrawlPage navigateToWithdrawl() {
		WithdrawlBtn.click();
		return new WithdrawlPage();

	}

}
