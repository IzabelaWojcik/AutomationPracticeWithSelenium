package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.utility.Utility;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogInButton() throws IOException {
		driver.findElement(By.className(Utility.fetchLocatorValue("login_button_className"))).click();
	}
	
	public void clickOnAddToCardButton() throws IOException {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("firstItemToBuyAddToCard_span_xpath"))).click();
	}
	
	public void clickOnCheckoutButtonInOrderWindow() throws IOException {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("windowAfterClickingAddToCard_checkoutButton_xpath"))).click();
	}
	
	public WebElement moveMouseOnFirstItemToBuy() throws IOException, InterruptedException {
		return driver.findElement(By.xpath(Utility.fetchLocatorValue("firstItemToBuy_li_xpath")));
	}
	public WebElement getWindowAfterClickingAddToCardButton() throws IOException {
		return driver.findElement(By.className(Utility.fetchLocatorValue("windowAfterClickingAddToCard_div_class")));
	}
	
	
	//quick view
//	public WebElement getFirstItemDeatilsWindow() throws IOException {
//		return driver.findElement(By.xpath(Utility.fetchLocatorValue("firstItemDetailsWindow_div_xpath")));
//	}
	
}
