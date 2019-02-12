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
	
	public static boolean validateElementExist(WebDriver driver, String locType, String locValue){
		boolean result = false;
		
		try {
			
			if(locType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("class")) {
			}
			else if(locType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("name")) {
			}
			
			result = true;
		}
		catch(Exception e){
			System.out.println("ERROR: element isn't displayed");
		}
		
		return result;
	}
}
