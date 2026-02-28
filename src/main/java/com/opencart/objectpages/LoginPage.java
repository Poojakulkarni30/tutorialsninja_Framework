package com.opencart.objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "input-email")
	WebElement emailLink;
	@FindBy(id = "input-password")
	WebElement passwordLink;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	public void setEmail(String email) {

		emailLink.sendKeys(email);
	}

	public void setPassword(String password) {

		passwordLink.sendKeys(password);
	}

	public void clickLoginBtn() {

		loginBtn.click();
	}

}
