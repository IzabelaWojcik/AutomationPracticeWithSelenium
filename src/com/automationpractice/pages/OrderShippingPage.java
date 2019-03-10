package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class OrderShippingPage {
	WebDriver driver;
	
	public OrderShippingPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkAgreeToTermsCheckbox() throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("termsAgree_checkbox_id"))).click();
	}
	
	public void clickProceedToCheckOutButton() throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("orderProceedToCheckOut_buttonOnShippingPage_name"))).click();
	}
}
