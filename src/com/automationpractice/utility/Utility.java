package com.automationpractice.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	public static String fetchPropertyValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(file);
		return property.get(key).toString();
	}
	
	public static String fetchLocatorValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("./Config/Elements.properties");
		Properties property = new Properties();
		property.load(file);
		return property.get(key).toString();
	}
	
	public static void scroolIntoView(WebDriver driver, WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
}
