package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.SetUps;
import com.automationpractice.pages.MainPage;
import com.automationpractice.utility.Utility;

public class MainPageTest extends SetUps{

<<<<<<< HEAD
	@Test(groups={"mainPageTests", "logIn"})
=======
	@Test(groups= {"mainPageTests", "logIn"})
>>>>>>> origin/master
	public void onPressLogInButtonMoveToLoginSiteTest() throws IOException {
		MainPage page = new MainPage(driver);
		
		page.clickLogInButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loginAndCreateAnAccountURL")));
	}
	
	@Test(groups={"mainPageTests", "buy"})
	public void moveOverElementShowsBuyingAndDetailsOptions() throws IOException, InterruptedException {
		MainPage page = new MainPage(driver);
		
		page.mouseOverFirstItemToBuy();
		
	}
	
}
