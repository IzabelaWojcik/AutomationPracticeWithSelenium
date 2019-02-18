package com.automationpractice.base;

import java.io.IOException;

import com.automationpractice.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public static ExtentReports getReporter() throws IOException {
		
		if(extent == null) {
			
			htmlReporter= new ExtentHtmlReporter("ExtentHtmlReports.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			extent.setSystemInfo("Browser", Utility.fetchPropertyValue("browserName"));
		}

		return extent;
	}
	
	public static ExtentTest createExtentTest(String testName) {
		extentTest = extent.createTest(testName);
		return extentTest;
	}
	
}
