package com.automationpractice.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automationpractice.utility.Utility;

public class Driver {
	public WebDriver driver;
	
	@BeforeMethod
	public void initialDriverInstance() throws IOException {
		if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValue("loginAndCreateAnAccountURL"));
	}
	
	@AfterMethod
	public void closeDriverInstance() {
		driver.quit();
	}
}
