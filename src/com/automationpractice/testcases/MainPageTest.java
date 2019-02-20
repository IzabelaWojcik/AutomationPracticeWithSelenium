package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.SetUps;
import com.automationpractice.pages.MainPage;
import com.automationpractice.utility.Utility;

public class MainPageTest extends SetUps{

	@Test(groups= {"mainPageTests", "logIn"})
	public void onPressLogInButtonMoveToLoginSiteTest() throws IOException {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.clickLogInButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loginAndCreateAnAccountURL")));
	}
	
}
