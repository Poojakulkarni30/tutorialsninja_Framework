package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.basetest.BaseTest;
import com.opencart.objectpages.HomePage;
import com.opencart.objectpages.LoginPage;
import com.opencart.objectpages.MyAccountPage;

public class LoginPageTest extends BaseTest {

	@Test(groups= {"Sanity", "Regression", "Master"})

	public void verifyLogin() {

		logger.info("Starting Login Test");

		HomePage hp = new HomePage(getDriver());

		hp.clickMyAccount();
		hp.clickLoginLink();
		logger.info("Clicked on Login Link");


		LoginPage lp = new LoginPage(getDriver());

		lp.setEmail(pr.getProperty("email"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLoginBtn();
		logger.info("Clicked on Login button after entering email and password");

		MyAccountPage myacc = new MyAccountPage(getDriver());

		Assert.assertEquals(myacc.checkMyaccountExists(), true);
		logger.info("Successfully Logged in ");

	}

}
