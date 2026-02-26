package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.basetest.BaseTest;
import com.opencart.objectpages.HomePage;
import com.opencart.objectpages.RegistrationPage;

public class RegistrationPageTest extends BaseTest {

	@Test
	public void verifyAccountRegistration() {

		logger.info("Starting Registration Test");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegisterLink();
		logger.info("Navigated to Registration Page");

		RegistrationPage rp = new RegistrationPage(driver);

		rp.enterFirstName("Jayna");
		rp.enterLastName("Wichai");
		rp.enterEmail("test" + System.currentTimeMillis() + "@yopmail.com");
		rp.enterPhone("123456789");
		String pwd = "Root@123";
		rp.enterPwd(pwd);
		rp.confirmPwd(pwd);
		rp.clickCheckbox();
		rp.clickContinueBtn();
		logger.info("Submitted registration form");

		String confmsg = rp.getConfirmMsg();
		logger.info("verifying the successful message ");

		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		logger.info("Account successfully created");
		
	}

}
