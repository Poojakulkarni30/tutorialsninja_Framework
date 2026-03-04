package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.basetest.BaseTest;
import com.opencart.objectpages.ForgotPasswordPage;
import com.opencart.objectpages.HomePage;

public class ForgotPasswordTest extends BaseTest {

	HomePage hp;
	ForgotPasswordPage fp;

	@Test(priority = 1, groups = { "sanity", "Master" })
	public void verifyisForogtPasswordLinkClickable() {

		logger.info("Starting forgot password Test");

		hp = new HomePage(getDriver());

		hp.clickMyAccount();
		hp.clickLoginLink();
		logger.info("Clicked on Login Link");

		fp = new ForgotPasswordPage(getDriver());
		fp.ClickForgotPasswordLink();

		logger.info("Clicked on forgot password Link");

		Assert.assertEquals(fp.forgotPasswordPage(), true);

		logger.info("Checked title of forgot password page");

	}

	@Test(priority = 2, dependsOnMethods = { "verifyisForogtPasswordLinkClickable" }, groups = { "Sanity, Master" })
	public void VerifyconfirmationMsg() {

		hp = new HomePage(getDriver());

		hp.clickMyAccount();
		hp.clickLoginLink();
		logger.info("Clicked on Login Link");
		fp = new ForgotPasswordPage(getDriver());
		fp.ClickForgotPasswordLink();
		logger.info("Clicked on forgot password link");
		fp.insertEmailId("Test@yopmail.com");
		logger.info("Entered email id in the textbox");
		fp.clickContinueBtn();
		
		logger.info("clicked on continue button");

		Assert.assertEquals(fp.verifyConfirmationMsg(), true);
		logger.info("Verifying the confirmation msg");

	}

}
