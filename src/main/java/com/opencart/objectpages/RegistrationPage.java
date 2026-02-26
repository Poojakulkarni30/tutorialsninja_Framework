package com.opencart.objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtboxfirstName;
	@FindBy(id = "input-lastname")
	WebElement txtboxLastName;
	@FindBy(id = "input-email")
	WebElement txtboxEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtboxTelephone;
	@FindBy(id = "input-password")
	WebElement txtboxPassword;
	@FindBy(name = "confirm")
	WebElement txtboxConfirmpwd;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement chkBox;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement confirmMsg;
	
	public void enterFirstName(String fname) {

		txtboxfirstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {

		txtboxLastName.sendKeys(lname);
	}

	public void enterEmail(String email) {

		txtboxEmail.sendKeys(email);

	}

	public void enterPhone(String phone) {

		txtboxTelephone.sendKeys(phone);
	}

	public void enterPwd(String pwd) {

		txtboxPassword.sendKeys(pwd);
	}

	public void confirmPwd(String pwd) {

		txtboxConfirmpwd.sendKeys(pwd);
	}

	public void clickCheckbox() {

		chkBox.click();
	}

	public void clickContinueBtn() {

		btnContinue.click();
	}

	public String getConfirmMsg() {
		
		try {
			return (confirmMsg.getText());
			
		}
		catch(Exception e) {
			
			return (e.getMessage());
		}
		
	}
}
