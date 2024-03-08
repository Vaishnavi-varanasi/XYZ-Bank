package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.xyz.qa.base.TestBaseXYZ;

public class CustomersPage extends TestBaseXYZ{
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement searchBar;
	
	@FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
	WebElement deleteBtn;
	
	
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[1]")
	WebElement fname1;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[2]/td[1]")
	WebElement fname2;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
	WebElement lname;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]")
	WebElement postcode;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[4]")
	WebElement accnum;
	
	
	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Delete() {
		deleteBtn.click();
		searchBar.clear();
	}
	
	public boolean searchByFName() {
		searchBar.sendKeys("Ha");
		String expectedFName = "Harry";
		String firstName = fname1.getText();
		return expectedFName.equalsIgnoreCase(firstName);
	}
	public boolean searchByLName() {
		searchBar.sendKeys("Dum");
		String expectedLName = "Dumbledore";
		String lastName = lname.getText();
		return expectedLName.equalsIgnoreCase(lastName);
	}
	public void searchByPost() {
		searchBar.sendKeys("E8");
		String expectedFName1 = "Hermoine";
		String firstName1 = fname1.getText();
		String expectedFName2 = "Neville";
		String firstName2 = fname2.getText();
		
		Assert.assertEquals(firstName1, expectedFName1);
	    Assert.assertEquals(firstName2, expectedFName2);
		
	}
	
	public boolean searchaccNum() {
		searchBar.sendKeys("1008");
		String expectedFName = "Ron";
		String firstName = fname1.getText();
		return expectedFName.equalsIgnoreCase(firstName);
	}
	
	public boolean openAccountVerifyinCustomers(String AccNumber) {
		searchBar.sendKeys(AccNumber);
		String expectedAccNum = accnum.getText();
		
		return expectedAccNum.contains(AccNumber);
		
	}
	

}
