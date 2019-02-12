package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utility.Utility;

public class LoginAndCreateAnAccountPage{
	WebDriver driver;
	
	public LoginAndCreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmailToCreateAnAccount(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_txtField_id"))).sendKeys(email);
	}
	
	public void clickCreateAnAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_button_id"))).click();
	}
	
	public void enterEmailToLogIn(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("logIn_txtField_id"))).sendKeys(email);
	}
	
	public void enterPasswordToLogIn(String password) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("logInPassword_txtField_password"))).sendKeys(password);
	}

}
