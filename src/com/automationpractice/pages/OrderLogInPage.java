package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class OrderLogInPage {
	WebDriver driver;
	
	public OrderLogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterPasswordToLogIn(String password) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("orderPassword_txtField_id"))).sendKeys(password);
	}
	
	public void enterEmailToLogIn(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("orderEmail_txtField_id"))).sendKeys(email);
	}
	
	public void clickLogInButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("orderLogIn_button_id"))).click();
	}
}
