package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBaseXYZ;

public class BankManagerLoginPage extends TestBaseXYZ{
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;
	
	@FindBy(xpath = "//button[@ng-class='btnClass1']")
	WebElement addcustBtn;
	
	@FindBy(xpath = "//button[@ng-click='openAccount()']")
	WebElement openAccBtn;
	
	@FindBy(xpath = "//button[@ng-click='showCust()']")
	WebElement customersBtn;
	
	public BankManagerLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AddCustomerPage navigatetoAddCust() {
		addcustBtn.click();
		return new AddCustomerPage();
	}
	public OpenAccountPage navigatetoOpenAcc() {
		openAccBtn.click();
		return new OpenAccountPage();
	}
	public CustomersPage navigatetoCustomers() {
		customersBtn.click();
		return new CustomersPage();
	}
	
}
