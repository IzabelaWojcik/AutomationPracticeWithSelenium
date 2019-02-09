package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.Driver;
import com.automationpractice.pages.MainPage;
import com.automationpractice.utility.Utility;

public class MainPageTest extends Driver{

	@Test
	public void validatePageURLTest() throws IOException {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.clickLogInButton();
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loginURL")));
	}
	
}
