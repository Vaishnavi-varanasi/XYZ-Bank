package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends HomePageXYZ {
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;

	@FindBy(xpath = "//input[@placeholder = 'First Name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@placeholder = 'Last Name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@placeholder = 'Post Code']")
	WebElement postcode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addcustSubmit;

	public AddCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void addCustomer() {
		firstname.sendKeys("Vaishnavi");
		lastname.sendKeys("Varanasi");
		postcode.sendKeys("4050");
		addcustSubmit.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		System.out.println("Alert Message: " + alertText);
		alt1.accept();
	}
	
	public boolean addCustDuplicate() {
		firstname.sendKeys("Ron");
		lastname.sendKeys("Weasly");
		postcode.sendKeys("E55555");
		addcustSubmit.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		String expectedText = "Please check the details. Customer may be duplicate.";
		System.out.println("Expected Error message: " + expectedText);
		System.out.println("Actual Error message: " + alertText);
		alt1.accept();
		return alertText.equals(expectedText);
	}
	
	public boolean addCustomerValidation() {
		firstname.sendKeys("GinnyGinnyGinnyGinnyGinnyGinnyGinnyGinny");
		lastname.sendKeys("WeasleyWeasleyWeasleyWeasleyWeasley");
		postcode.sendKeys("102030405060708090100110120130140");
		addcustSubmit.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		System.out.println("Alert Message: " + alertText);
		alt1.accept();
		
		String AcceptMsg = "Customer added successfully with customer id";
		return alertText.contains(AcceptMsg);
	}
	
	public boolean addCustomerNumbers() {
		firstname.sendKeys("13045737");
		lastname.sendKeys("24638477");
		postcode.sendKeys("102030405");
		addcustSubmit.click();
		Alert alt1 = driver.switchTo().alert();
		String alertText = alt1.getText();
		System.out.println("Alert Message: " + alertText);
		alt1.accept();
		
		String AcceptMsg = "Customer added successfully with customer id";
		return alertText.contains(AcceptMsg);
	}
	public HomePageXYZ navigatetoHome() {
		HomeBtn.click();
		return new HomePageXYZ();
		
	}

}
