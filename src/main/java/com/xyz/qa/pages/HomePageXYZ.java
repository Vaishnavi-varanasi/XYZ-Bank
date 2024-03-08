package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBaseXYZ;

public class HomePageXYZ extends TestBaseXYZ{
	
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeBtn;
	
	@FindBy(xpath = "//strong[contains(text(),'XYZ Bank')]")
	WebElement Title;
	
	@FindBy(xpath = "//button[contains(text(),'Customer Login')]")
	WebElement CustomerLoginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
	WebElement BankMangerLoginBtn;
	
	@FindBy(xpath = "//select[@id='userSelect']")
	WebElement YourNameDD;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	
	public HomePageXYZ(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public CustomerLoginPage navigatetocustomerdetails(String customername){
		CustomerLoginBtn.click();
		Select select = new Select(YourNameDD);
	    select.selectByVisibleText(customername);
	    LoginBtn.click();
	    
		return new CustomerLoginPage();
	}
	
	public BankManagerLoginPage navigatetoBMLogin(){
		BankMangerLoginBtn.click();
		return new BankManagerLoginPage();
	}
}
