package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBaseXYZ;

public class CustomerLoginPage extends TestBaseXYZ {

	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement LogoutBtn;

	@FindBy(xpath = "//button[@ng-click='transactions()']")
	WebElement TransactionsBtn;

	@FindBy(xpath = "//button[@ng-click='deposit()']")
	WebElement DepositBtn;

	@FindBy(xpath = "//button[@ng-click='withdrawl()']")
	WebElement WithdrawlBtn;

	@FindBy(xpath = "(//div[@ng-hide='noAccount'])[1]")
	WebElement HeaderDiv;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[1]")
	WebElement AccountNumberDisplay;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[2]")
	WebElement BalanceDisplay;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[3]")
	WebElement CurrencyDisplay;

	@FindBy(xpath = "//option[@selected=\"selected\"]")
	WebElement AccNumDropDown;
	
	@FindBy(xpath = "//span[@class='fontBig ng-binding']")
	WebElement NameDisplayed;

	public CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyHeader() {
		return HeaderDiv.isDisplayed();
	}

	public boolean verifyAccountNumber() {
		String accnum1 = AccNumDropDown.getText();
		String accnum2 = AccountNumberDisplay.getText();
		return accnum1.equalsIgnoreCase(accnum2);

	}
	
	public boolean verifycustomerName(String name){
		String namedisplay = NameDisplayed.getText();
		return name.equalsIgnoreCase(namedisplay);
	}

	public TransactionsPage navigatetoTransactions() {
		TransactionsBtn.click();
		return new TransactionsPage();
	}

	public DepositPage navigatetoDeposit() {
		DepositBtn.click();
		return new DepositPage();
	}

	public WithdrawlPage navigatetoWithdrawl() {
		WithdrawlBtn.click();
		return new WithdrawlPage();
	}
	public HomePageXYZ navigatetoHomePage() {
		HomeBtn.click();
		return new HomePageXYZ();
	}

}
