package com.xyz.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage extends HomePageXYZ{
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement LogoutBtn;
	
	@FindBy(xpath = "//button[@ng-click='deposit()']")
	WebElement DepositBtn;

	@FindBy(xpath = "//button[@ng-click='withdrawl()']")
	WebElement WithdrawlBtn;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr")
	WebElement transactionRow;
	
	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	WebElement resetBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Back')]")
	WebElement backBtn;
	
	@FindBy(xpath = "//input[@placeholder=\"amount\"]")
	WebElement AmountInput;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
	WebElement amtTransactionTable;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]")
	WebElement typeTransactionTable;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[2]/td[2]")
	WebElement amtTransactionTable1;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[2]/td[3]")
	WebElement typeTransactionTable1;
	
	@FindBy(xpath = "//strong[contains(text(),'XYZ Bank')]")
	WebElement Title;
	
	public TransactionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void resetTable() {
		resetBtn.click();
	}
	public void clickonHome() {
		backBtn.click();
	}

	public boolean verifyTransactionsD() {
		String tableTranstype  = typeTransactionTable.getText();
		String expectedType = "Credit";
		return tableTranstype.equalsIgnoreCase(expectedType);
	}
	
	public boolean verifyTransactionsW() {
		String tableTranstype  = typeTransactionTable.getText();
		String expectedType = "Debit";
		return tableTranstype.equalsIgnoreCase(expectedType);
	}
	
	
	
	public void before() {
		resetBtn.click();
		backBtn.click();
		
	}
	
	
}
