package com.opencart.objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;

public class ForgotPasswordPage extends BasePage {

	
	public ForgotPasswordPage(WebDriver driver) {
		
		
		super(driver);
	}
	
	
	@FindBy (xpath= "//a[text()='Forgotten Password']") WebElement ForgotPasswordLink;
	@FindBy(xpath="//h1[text()='Forgot Your Password?']") WebElement FpPageTitle;
	@FindBy(id="input-email") WebElement EmailAddressPlaceholder;
	@FindBy(xpath="//input[@value='Continue']") WebElement ContinueBtn;
	@FindBy(xpath="//div[text()='An email with a confirmation link has been sent your email address.']") WebElement confirmationMsg;
	
	
	
	public void ClickForgotPasswordLink() {
		
		ForgotPasswordLink.click();
		
	}
	
	public boolean forgotPasswordPage() {
		
		return FpPageTitle.isDisplayed();
		
		
	}
	
	public void insertEmailId(String EmailId) {
		EmailAddressPlaceholder.sendKeys(EmailId);
		
	}
	
	public void clickContinueBtn() {
	    ContinueBtn.click();
	}
	public boolean verifyConfirmationMsg() {
		
	return	confirmationMsg.isDisplayed();
		
		
	}
	
}
