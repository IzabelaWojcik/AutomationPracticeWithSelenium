package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.utility.Utility;

public class OrderPage {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnCheckoutButtonOnOrderPage() throws IOException {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("buttonOnPageAfertClickingCheckoutButton_checkoutButton_xpath"))).click();
	}
	
	public WebElement getCheckoutButtonOnOrderPage() throws IOException {
		return driver.findElement(By.xpath(Utility.fetchLocatorValue("buttonOnPageAfertClickingCheckoutButton_checkoutButton_xpath")));
	}
}
