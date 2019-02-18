package com.automationpractice.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.automationpractice.assertions.Compare;
import com.automationpractice.base.SetUps;
import com.automationpractice.datagenerators.DataGenerator;
import com.automationpractice.pages.LoginAndCreateAnAccountPage;
import com.automationpractice.utility.Utility;

public class LoginAndCreateAnAccountPageTest extends SetUps{
	private int waitForSeconds = 3;
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void enterCorrectEmailTest(String email) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertTrue(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
	}
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void enterIncorrectEmailTest(String email) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertFalse(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
	}
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void enterExistingEmailTest(String email) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToCreateAnAccount(email);
		page.clickCreateAnAccountButton();
		
		assertFalse(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
	}
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void enterIncorrectLoginData(String login, String password) throws IOException{
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToLogIn(login);
		page.enterPasswordToLogIn(password);
		page.clickLogInButton();
		
		assertFalse(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loggedUserURL")));
		
	}
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void fillAllRegistrationFormWithCorrectData(String name, String lastname, String password, String company,
			String address, String addressLine2, String city, String postCode, String additionalInformation,
			String homeNumber, String mobileNumber, String addressAlias) throws IOException
	{
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		String email = generateEmail();
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds,  TimeUnit.SECONDS);
		
		page.enterEmailToCreateAnAccount(email);
		System.out.println(email);
		page.clickCreateAnAccountButton();
		
		assertTrue(Compare.validateElementIsDisplayed(driver, "id", "account-creation_form"));
		
		page.checkGenderFemaleRadioButton();
		page.checkGenderMaleRadioButton();
		page.enterFirstname(name);
		page.enterLastname(lastname);
		page.enterPasswordToLogIn(password);
		page.selectDayFromDropdownList();
		page.selectMonthFromDropdownList();
		page.selectYearFromDropdownList();
		page.checkNewsletterCheckbox();
		page.checkSpecialOffersCheckbox();
		page.enterCompanyName(company);
		page.enterAddress(address);
		page.enterAddressLine2(addressLine2);
		page.enterCity(city);
		page.selectStateFromDropdownList();
		page.enterPostCode(postCode);
		page.enterAdditionalInformation(additionalInformation);
		page.enterHomePhone(homeNumber);
		page.enterMobilePhone(mobileNumber);
		page.enterAddressAlias(addressAlias);
		
		assertEquals(page.getEmailFromTxtField(), email);
		assertEquals(page.getFirstnameFromTxtField(), name);
		assertEquals(page.getLastnameFromTxtField(), lastname);
		
		page.clickSubmitAccountButton();
		
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loggedUserURL")));
		
	}
	
	@Test(dataProvider="Excel-DataProvider", dataProviderClass=DataGenerator.class)
	public void enterCorrectLoginAndPasswordTest(String login, String password) throws IOException {
		
		driver.manage().timeouts().implicitlyWait(waitForSeconds, TimeUnit.SECONDS);
		
		LoginAndCreateAnAccountPage page = new LoginAndCreateAnAccountPage(driver);
		
		page.enterEmailToLogIn(login);
		page.enterPasswordToLogIn(password);
		page.clickLogInButton();
		
		assertTrue(Compare.validatePageURL(driver, Utility.fetchPropertyValue("loggedUserURL")));
		
	}
	
	public String generateEmail() {
		int length = 8;
		
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		             + "abcdefghijklmnopqrstuvwxyz"
		             + "0123456789";
		
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		
		String email = str + "@o2.pl";
		
		return email;
	}
	
}
