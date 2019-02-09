package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogInButton() throws IOException {
		driver.findElement(By.className(Utility.fetchLocatorValue("login_button_className"))).click();
	}
	
}
