package com.opencart.objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountLink;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	

	public void clickMyAccount() {

		myAccountLink.click();
	}

	public void clickRegisterLink() {
		register.click();
	}
	
	public void clickLoginLink() {
		login.click();	
		
	
	}
	
}
