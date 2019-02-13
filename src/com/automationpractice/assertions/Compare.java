package com.automationpractice.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validatePageURL(WebDriver driver, String expURL) {
		boolean flag = false;

		if(driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
			flag = true;
		}

		return flag;
	}

	public static boolean validateElementIsDisplayed(WebDriver driver, String locType, String locValue){
		boolean result = false;

		try {

			if(locType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("class")) {
				driver.findElement(By.className(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locValue)).isDisplayed();
			}

			result = true;
		}
		catch(Exception e){
		}

		return result;
	}

	public static boolean validateElementExist(WebDriver driver, String locType, String locValue){
		boolean result = false;

		try {

			if(locType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locValue));
			}
			else if(locType.equalsIgnoreCase("class")) {
				driver.findElement(By.className(locValue));
			}
			else if(locType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locValue));
			}
			else if(locType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locValue));
			}

			result = true;
		}
		catch(Exception e){
		}

		return result;
	}

}
