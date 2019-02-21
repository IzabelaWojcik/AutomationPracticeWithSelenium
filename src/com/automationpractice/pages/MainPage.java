package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automationpractice.utility.Utility;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogInButton() throws IOException {
		driver.findElement(By.className(Utility.fetchLocatorValue("login_button_className"))).click();
	}
	
	public void mouseOverFirstItemToBuy() throws IOException, InterruptedException {
		WebElement element = driver.findElement(By.xpath(Utility.fetchLocatorValue("firstItemToBuy_li_xpath")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Utility.fetchLocatorValue("firstItemToBuy_li_xpath")))).perform();
	}
	
}
