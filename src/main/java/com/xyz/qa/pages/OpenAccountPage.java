package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends HomePageXYZ {
	
	@FindBy(xpath = "//select[@name='userSelect']")
	WebElement CustomerNameDD;
	
	@FindBy(xpath = "//select[@name='currency']")
	WebElement CurrencyDD;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement ProcessBtn;
	
	@FindBy(xpath = "//button[@ng-click='showCust()']")
	WebElement customersBtn;
	
	public OpenAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean openAccountValid(String customername, String currency) {
		Select selectCN = new Select(CustomerNameDD);
	    selectCN.selectByVisibleText(customername);
	    
	    Select selectCRR = new Select(CurrencyDD);
	    selectCRR.selectByVisibleText(currency);
	    
	    ProcessBtn.click();
	    
	    Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		
		String expectedText = "Account created successfully with account Number";
		
		System.out.println("Expected Error message: " + expectedText);
		System.out.println("Actual Error message: " + alertText);
		
		alt1.accept();
		return alertText.contains(expectedText);

	}
	public String getCreatedAccNum(String customername, String currency) {
		Select selectCN = new Select(CustomerNameDD);
	    selectCN.selectByVisibleText(customername);
	    
	    Select selectCRR = new Select(CurrencyDD);
	    selectCRR.selectByVisibleText(currency);
	    
	    ProcessBtn.click();
	    
	    Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		alt1.accept();
		int len = alertText.length();
		String AccNum = alertText.substring(len - 4);
		return AccNum;
		
	}
	public void openAccountBothBlank() {
		ProcessBtn.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		alt1.accept();
	}
	
	public void openAccountSingleBlank1(String customername) {
		Select selectCN = new Select(CustomerNameDD);
	    selectCN.selectByVisibleText(customername);
		
		ProcessBtn.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		alt1.accept();
	}
	
	public void openAccountSingleBlank2(String currency){
		
		Select selectCRR = new Select(CurrencyDD);
	    selectCRR.selectByVisibleText(currency);
	    
		ProcessBtn.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		alt1.accept();
	}
	
	public CustomersPage navigatetoCustomers() {
		customersBtn.click();
		return new CustomersPage();
	}
}
