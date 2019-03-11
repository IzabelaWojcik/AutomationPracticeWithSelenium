package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.SetUps;
import com.automationpractice.datagenerators.DataGenerator;
import com.automationpractice.pages.MainPage;
import com.automationpractice.pages.OrderChooseAddressPage;
import com.automationpractice.pages.OrderLogInPage;
import com.automationpractice.pages.OrderPage;
import com.automationpractice.pages.OrderPaymentBankWirePage;
import com.automationpractice.pages.OrderPaymentPage;
import com.automationpractice.pages.OrderShippingPage;
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
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class, groups={"mainPageTests", "buy"}, dependsOnMethods="moveOverElementShowsBuyingAndDetailsOptionsTest")
	public void orderedSuccesfullyPaidByBankWire(String login, String password) throws IOException, InterruptedException {
		MainPage mainPage = new MainPage(driver);
		
		moveMouseOverFirstElementToBuy(mainPage);
		
		mainPage.clickOnAddToCardButton();
		mainPage.getWindowAfterClickingAddToCardButton();
		
		WebElement element = mainPage.getCheckoutButtonInOrderWindow();
		Utility.scroolIntoView(driver, element);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element)).click();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderUrL")));
		
		OrderPage orderPage = new OrderPage(driver);
		Utility.scroolIntoView(driver, orderPage.getCheckoutButtonOnOrderPage());
		orderPage.clickOnCheckoutButtonOnOrderPage();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderLogInURL")));
		
		OrderLogInPage orderLogInPage = new OrderLogInPage(driver);
		orderLogInPage.enterEmailToLogIn(login);
		orderLogInPage.enterPasswordToLogIn(password);
		orderLogInPage.clickLogInButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderChooseAdderssURL")));
		
		OrderChooseAddressPage orderChooseAddressPage = new OrderChooseAddressPage(driver);
		orderChooseAddressPage.clickProceedToCheckOutButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderShippingURL")));
		
		OrderShippingPage orderShippingPage = new OrderShippingPage(driver);
		orderShippingPage.checkAgreeToTermsCheckbox();
		orderShippingPage.clickProceedToCheckOutButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderPaymentURL")));
		
		OrderPaymentPage orderPaymentPage = new OrderPaymentPage(driver);
		orderPaymentPage.clickBankWirePayment();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("orderPaymentBankWire")));
		
		OrderPaymentBankWirePage orderPaymentBankWirePage = new OrderPaymentBankWirePage(driver);
		orderPaymentBankWirePage.clickConfirmOrder();
		assertTrue(Compare.validatePartialURL(driver, Utility.fetchPropertyValue("orderConfirmationPagePartialURL")));
	}
	
	
	private void moveMouseOverFirstElementToBuy(MainPage page) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		WebElement element = page.moveMouseOnFirstItemToBuy();
		Utility.scroolIntoView(driver, element); 
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
}
