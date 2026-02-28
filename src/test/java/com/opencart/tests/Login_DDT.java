package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.basetest.BaseTest;
import com.opencart.dataproviders.TestDataProviders;
import com.opencart.objectpages.HomePage;
import com.opencart.objectpages.LoginPage;
import com.opencart.objectpages.MyAccountPage;

public class Login_DDT extends BaseTest {

	@Test(dataProvider = "LoginData", dataProviderClass = TestDataProviders.class, groups= {"Data driven", "Regression"})
	public void verify_LoginDDT(String email, String pwd, String expectedResult) {

		HomePage hp = new HomePage(getDriver());
		hp.clickMyAccount();
		hp.clickLoginLink();

		LoginPage lp = new LoginPage(getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginBtn();

		MyAccountPage myacc = new MyAccountPage(getDriver());
		boolean targetPage = myacc.checkMyaccountExists();

		if (expectedResult.equals("Valid")) {

			if (targetPage == true) {

				myacc.clickLogoutBtn();
				Assert.assertEquals(targetPage, true);

			}

			else {

				Assert.assertTrue(false);
			}

			if (expectedResult.equals("Invalid")) {

				if (targetPage == false)

					myacc.clickLogoutBtn();
				Assert.assertEquals(targetPage, false);

			}

			else {

				Assert.assertTrue(true);
			}

		}

	}
}
