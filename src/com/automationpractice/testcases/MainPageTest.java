package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.SetUps;
import com.automationpractice.pages.MainPage;
import com.automationpractice.utility.Utility;

public class MainPageTest extends SetUps{
	private int waitForSeconds = 3;
	
	@Test(groups={"mainPageTests", "logIn"})
	public void onPressLogInButtonMoveToLoginSiteTest() throws IOException {
		MainPage page = new MainPage(driver);
		
		page.clickLogInButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loginAndCreateAnAccountURL")));
	}
	
	@Test(groups={"mainPageTests", "buy"})
	public void moveOverElementShowsBuyingAndDetailsOptionsTest() throws IOException, InterruptedException {
		MainPage page = new MainPage(driver);
		moveMouseOverFirstElementToBuy(page);
	}
	
	@Test(groups={"mainPageTests", "buy"}, dependsOnMethods="moveOverElementShowsBuyingAndDetailsOptionsTest")
	public void addToCard() throws IOException, InterruptedException {
		MainPage page = new MainPage(driver);
		
		moveMouseOverFirstElementToBuy(page);
		
		page.clickOnAddToCardButton();

		page.getWindowAfterClickingAddToCardButton();
		
		page.clickOnCheckoutButtonInOrderWindow();

		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderUrL")));
		
		Utility.scroolIntoView(driver, page.getCheckoutButtonOnOrderPage());
		
		page.clickOnCheckoutButtonOnOrderPage();
		
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderLogInURL")));
		
	}
	
	
	private void moveMouseOverFirstElementToBuy(MainPage page) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		WebElement element = page.moveMouseOnFirstItemToBuy();
		Utility.scroolIntoView(driver, element); 
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
}
