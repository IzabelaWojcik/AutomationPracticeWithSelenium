package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class OrderPaymentPage {
	WebDriver driver;
	
	public OrderPaymentPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBankWirePayment() throws IOException {
		driver.findElement(By.className(Utility.fetchLocatorValue("payByBankWire_a_className"))).click();
	}
}
