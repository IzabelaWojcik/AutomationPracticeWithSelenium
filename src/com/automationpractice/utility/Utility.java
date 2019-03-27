package com.automationpractice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
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
	
	
	public static void cleanFolder(String foldername, Path path) {
        if (Files.exists(path)) {
			try {
				FileUtils.cleanDirectory(new File(foldername));
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
}
