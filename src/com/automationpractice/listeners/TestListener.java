package com.automationpractice.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationpractice.base.ExtentReportManager;
import com.automationpractice.base.SetUps;
import com.automationpractice.utility.Utility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends SetUps implements ITestListener{
	String screenShotsFilename = "./Screenshots/";

	@Override
	public void onStart(ITestContext context) {

		context.setAttribute("WebDriver", TestListener.driver);

		try {
			ExtentReportManager.getReporter();

			System.out.println("Test started ob browser: " + Utility.fetchPropertyValue("browserName"));
			ExtentReportManager.createExtentTest(context.getName()).info("Test started ob browser: " + Utility.fetchPropertyValue("browserName"));

			FileUtils.cleanDirectory(new File(screenShotsFilename)); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			ExtentReportManager.getReporter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TEST PASSED  " + result.getName());

		ExtentReportManager.createExtentTest(result.getName()).log(Status.PASS, "Test:   " + result.getName() + "   PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String screenshotPath = captureScreen(result);
			
			ExtentTest test = ExtentReportManager.createExtentTest(result.getName());
			ExtentTest screenShot = test.addScreenCaptureFromPath(screenshotPath);
			
			System.out.println("\n" + "TEST FAILED: " + result.getName() + "   from class: " + result.getInstanceName()
			+ "\n " + result.getThrowable() + "\n");
			
			test.log(Status.FAIL, "Failed test:    " + result.getName() + "    from class:    " + result.getInstanceName()
			 + "\n" + result.getThrowable());
			
			test.info("ScreenShot available here: " + screenShot);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TEST SKIPPED: " + result.getName() + " from class: " + result.getInstanceName() + "\n" + result.getThrowable());

		ExtentReportManager.createExtentTest(result.getName()).log(Status.SKIP, "Skipped test:    " + result.getName() + 
				"    from class:   " + result.getInstanceName() + "\n" + result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public String captureScreen(ITestResult result) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotName = result.getName() + result.getStartMillis() + ".png";
		String path = screenShotsFilename + screenShotName;
		File target = new File(path);

		FileUtils.copyFile(scrFile,target);

		return path;
	}

}

