package com.automationpractice.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.Driver;
import com.automationpractice.datagenerators.DataGenerator;
import com.automationpractice.pages.LoginAndCreateAnAccountPage;

public class LoginAndCreateAnAccountPageTest extends Driver{

	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void createAnAccount_enterCorrectEmailTest(String email) throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertTrue(Compare.validateElementExist(driver, "id", "account-creation_form"));
	}
	
}
