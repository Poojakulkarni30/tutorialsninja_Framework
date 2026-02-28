package com.opencart.basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public Logger logger;
	public Properties pr;

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	@BeforeMethod(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {

		logger = LogManager.getLogger(this.getClass());
		WebDriver driver;
		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			return;
		}

	tlDriver.set(driver);
	FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		pr = new Properties();
		pr.load(file);
		getDriver().get(pr.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		file.close();
	}

	

	@AfterMethod(groups = { "Sanity", "Regression", "Master" })

	public void tearDown() {

		getDriver().quit();
		tlDriver.remove();
	}

}
