package com.opencart.objectpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.base.BasePage;

public class MyAccountPage extends BasePage {
	
	 WebDriverWait wait ;
	public MyAccountPage(WebDriver driver) {

		super(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountlink;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement logoutLink;

	public boolean checkMyaccountExists() {

		wait.until(ExpectedConditions.visibilityOf(myAccountlink));
		
		return 	 myAccountlink.isDisplayed();
	

	}

	public void clickLogoutBtn() {

		logoutLink.click();

	}

}
