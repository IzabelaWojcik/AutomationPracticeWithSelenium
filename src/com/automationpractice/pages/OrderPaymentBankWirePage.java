package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class OrderPaymentBankWirePage {
	WebDriver driver;
	
	public OrderPaymentBankWirePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickConfirmOrder() throws IOException {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("confirmOrder_button_xpath"))).click();
	}
}	
