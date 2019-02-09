package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import com.automationpractice.base.Driver;
import com.automationpractice.utility.Utility;

public class LoginAndCreateAnAccountPage extends Driver{
	
	public void enterEmailToCreateAnAccount(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_txtField_id"))).sendKeys(email);
	}
	
	public void clickCreateAnAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_button_id"))).click();
	}

}
