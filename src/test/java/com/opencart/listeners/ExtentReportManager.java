package com.opencart.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.opencart.basetest.BaseTest;
import com.opencart.utils.ScreenshotUtil;

public class ExtentReportManager implements ITestListener {

	private ExtentSparkReporter sparkreporter;
	private ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	String reportName;

	public void onStart(ITestContext testConext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";
		sparkreporter = new ExtentSparkReporter("./reports/" + reportName);

		sparkreporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkreporter.config().setReportName("opencart Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);

		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("SubModule", "Customers");
		extent.setSystemInfo("UserName", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = testConext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testConext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testConext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {

			extent.setSystemInfo("Groups", includedGroups.toString());

		}

	}

	public void onTestStart(ITestResult result) {
	    ExtentTest extentTest = extent.createTest(result.getName());
	    extentTest.assignCategory(result.getMethod().getGroups());
	    test.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, result.getName() + " Test Passed");
		test.remove();

	}

	public void onTestFailure(ITestResult result) {

		test.get().log(Status.FAIL, result.getThrowable());

		try {

			String path = ScreenshotUtil.captureScreen(BaseTest.getDriver(), result.getName());
			test.get().addScreenCaptureFromPath(path);

		} catch (Exception e) {

			e.printStackTrace();
		}
		test.remove();
	}

	public void onTestSkipped(ITestResult result) {

		test.get().log(Status.SKIP, result.getName() + " got skipped");
		test.remove();

	}

	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir") + "/reports/" + reportName;		
		File 	extentReport= new File(pathOfExtentReport);
		try {
			
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
