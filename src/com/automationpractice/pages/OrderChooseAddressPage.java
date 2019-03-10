package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class OrderChooseAddressPage {
	WebDriver driver;
	
	public OrderChooseAddressPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProceedToCheckOutButton() throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("orderProceedToCheckOut_button_name"))).click();
	}
}
