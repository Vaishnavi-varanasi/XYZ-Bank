package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawlPage extends HomePageXYZ{

	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement LogoutBtn;
	
	@FindBy(xpath = "//button[@ng-click='transactions()']")
	WebElement TransactionsBtn;
	
	@FindBy(xpath = "(//strong[@class='ng-binding'])[1]")
	WebElement AccountNumberDisplay;
	
	@FindBy(xpath = "(//strong[@class='ng-binding'])[2]")
	WebElement BalanceDisplay;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[3]")
	WebElement CurrencyDisplay;

	@FindBy(xpath = "//option[@selected=\"selected\"]")
	WebElement AccNumDropDown;
	
	@FindBy(xpath = "//input[@placeholder=\"amount\"]")
	WebElement AmountInputW;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement WithdrawBtn;
	
	@FindBy(xpath = "//span[@class='error ng-binding']")
	WebElement message;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
	WebElement amtTransactionTable;
	
	public WithdrawlPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CustomerLoginPage navigatetoCLogin(){
		CustomerLoginBtn.click();
	    
		return new CustomerLoginPage();
	}
	
	public CustomerLoginPage clickonLogout(){
		LogoutBtn.click();
		return new CustomerLoginPage();
	}
	
	public TransactionsPage navigatetoTransactions() {
		TransactionsBtn.click();
		return new TransactionsPage();
	}
	public void withdrawamount(String amt) {
		AmountInputW.sendKeys(amt);
		WithdrawBtn.click();
		String msgDisplayed = message.getText();
		if(msgDisplayed.equals("Transaction Successful")) {
			
			System.out.println("Transaction Successful message is displayed");
			
			}
		String BalanceStr = BalanceDisplay.getText();
		System.out.println("Balance is " + BalanceStr);
	}
	
	public boolean verifywithdrawamount(String amt) {
		String ogBalanceStr = BalanceDisplay.getText();
	    int ogBalance = Integer.parseInt(ogBalanceStr);
	    AmountInputW.sendKeys(amt);
	    WithdrawBtn.click();
	    String newBalanceStr = BalanceDisplay.getText();
	    int newBalance = Integer.parseInt(newBalanceStr);
	    String difference = String.valueOf(ogBalance - newBalance);
	    
	    return amt.equalsIgnoreCase(difference);
	}
	public boolean verifyintransactionsW(String amt) {
		AmountInputW.sendKeys(amt);
		WithdrawBtn.click();
		
		TransactionsBtn.click();
		
		String tableAmt = amtTransactionTable.getText();
		return tableAmt.equalsIgnoreCase(amt);
		
	}
	
	public void withdrawamountNegative(String amt) {
		AmountInputW.sendKeys(amt);
		WithdrawBtn.click();
		String msgDisplayed = message.getText();
		System.out.println(msgDisplayed);
	}

	public boolean withdrawamountChar(String amt) {
		AmountInputW.sendKeys(amt);
		WithdrawBtn.click();
		String Amtdisplayed = AmountInputW.getText();
		return Amtdisplayed.equalsIgnoreCase(amt);
		
	}
	
	public boolean withdrawMorethanBalance(String amt) {
		AmountInputW.sendKeys(amt);
		WithdrawBtn.click();
		String actualError= message.getText();
		String expectedError = "Transaction Failed. You can not withdraw amount more than the balance.";
		return actualError.equalsIgnoreCase(expectedError);
		
	}
	
	
}
