package com.automationpractice.testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.Driver;
import com.automationpractice.datagenerators.DataGenerator;
import com.automationpractice.pages.LoginAndCreateAnAccountPage;
import com.automationpractice.utility.Utility;

public class LoginAndCreateAnAccountPageTest extends Driver{

	//@Ignore
	@Test(dataProvider="Excel-OneColumn-DataProvider", dataProviderClass=DataGenerator.class)
	public void createAnAccount_enterCorrectEmailTest(String email) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertTrue(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
	}
	
	//@Ignore
	@Test(dataProvider="Excel-OneColumn-DataProvider", dataProviderClass=DataGenerator.class)
	public void createAnAccount_enterIncorrectEmailTest(String email) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertFalse(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
	}
	
	@Test(dataProvider="Excel-TwoColumns-DataProvider", dataProviderClass=DataGenerator.class)
	public void logIn_enterCorrectLoginAndPasswordTest(String login, String password) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToLogIn(login);
		page.enterPasswordToLogIn(password);
		page.clickLogInButton();
		
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loggedUserURL")));
		
	}
	
}
