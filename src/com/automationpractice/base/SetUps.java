package com.automationpractice.base;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automationpractice.utility.Utility;

public class SetUps {
	public static final String SCREENSHOTS_FOLDERNAME = "Screenshots";
	public static final Path SCREENSHOTS_PATH = Paths.get(SCREENSHOTS_FOLDERNAME);
	public static WebDriver driver;
	
	@BeforeSuite
	public void setupBeforeSuite() {
		Utility.cleanFolder(SCREENSHOTS_FOLDERNAME, SCREENSHOTS_PATH);
	}

	@BeforeMethod(alwaysRun=true)
	@Parameters("openedURL")
	public void setupBeforeMethod(String url) throws IOException {

		System.out.println("url = " + url);

		if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		driver.quit();
	}

}
