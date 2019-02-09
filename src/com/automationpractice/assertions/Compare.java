package com.automationpractice.assertions;

import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validatePAgeURL(WebDriver driver, String expURL) {
		boolean flag = false;
		
		if(driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
			flag = true;
		}
		
		return flag;
	}
}
