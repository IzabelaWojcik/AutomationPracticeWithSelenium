package com.automationpractice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.utility.Utility;

public class LoginAndCreateAnAccountPage{
	WebDriver driver;
	
	public LoginAndCreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//textFields
	public void enterEmailToCreateAnAccount(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_txtField_id"))).sendKeys(email);
	}
	
	public void enterEmailToLogIn(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("email_txtField_id"))).sendKeys(email);
	}
	
	public void enterPasswordToLogIn(String password) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("password_txtField_id"))).sendKeys(password);
	}
	
	public void enterFirstname(String firstname) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("firstname_txtField_id"))).sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("lastname_txtField_id"))).sendKeys(lastname);
	}
	
	public void enterCompanyName(String company) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("company_txtField_id"))).sendKeys(company);
	}
	
	public void enterAddress(String address) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("address_txtField_id"))).sendKeys(address);
	}
	
	public void enterAddressLine2(String address) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("addresLine2_txtField_id"))).sendKeys(address);
	}
	
	public void enterCity(String city) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("city_txtField_id"))).sendKeys(city);
	}
	
	public void enterPostCode(int postCode) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("postCode_txtField_id"))).sendKeys(String.valueOf(postCode));
	}
	
	public void enterHomePhone(int phoneNumber) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("homePhone_txtField_id"))).sendKeys(String.valueOf(phoneNumber));
	}
	
	public void enterMobilePhone(int phoneNumber) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("mobilePhone_txtField_id"))).sendKeys(String.valueOf(phoneNumber));
	}
	
	public void enterAddressAlias(String address) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("addressAlias_txtField_id"))).sendKeys(address);
	}

	public String getFirstnameFromTxtField() throws IOException{
		return driver.findElement(By.id(Utility.fetchLocatorValue("firstname_autoFilledTxtField_id"))).getAttribute("value");
	}
	
	public String getLastnameFromTxtField() throws IOException{
		return driver.findElement(By.id(Utility.fetchLocatorValue("lastname_autoFilledTxtField_id"))).getAttribute("value");
	}
	
	public String getEmailFromTxtField() throws IOException{
		return driver.findElement(By.xpath(Utility.fetchLocatorValue("email_autoFilledTxtField_xpath"))).getAttribute("value");
	}
	
	//textAreas
	public void enterAdditionalInformation(String text) throws IOException{
		driver.findElement(By.id(Utility.fetchLocatorValue("additionalInformation_txtArea_id"))).sendKeys(text);
	}
		
	//buttons
	public void clickCreateAnAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_button_id"))).click();
	}
			
	public void clickLogInButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("logIn_button_id"))).click();
	}
	
	public void clickSubmitAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("submitAccount_button_id"))).click();
	}
	
	//radioButtons
	public void checkGenderMaleRadioButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("genderMale_radioButton_id"))).click();
	}
			
	public void checkGenderFemaleRadioButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("genderFemale_radioButton_id"))).click();
	}
	
	//checkBoxes
	public void checkNewsletterCheckbox() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("newsletter_checkbox_id"))).click();
	}
			
	public void checkSpecialOffersCheckbox() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("specialOffers_checkbox_id"))).click();
	}
	
	//dropdownLists
	public void selectDayFromDropdownList() throws IOException {
		Select day = new Select(driver.findElement(By.id(Utility.fetchLocatorValue("chooseDay_dropdownList_id"))));
		day.selectByIndex(2);
	}
	
	public void selectMonthFromDropdownList() throws IOException {
		Select month = new Select(driver.findElement(By.id(Utility.fetchLocatorValue("chooseMonth_dropdownList_id"))));
		month.selectByIndex(2);
	}
	
	public void selectYearFromDropdownList() throws IOException {
		Select year = new Select(driver.findElement(By.id(Utility.fetchLocatorValue("chooseYear_dropdownList_id"))));
		year.selectByIndex(2);
	}
	
	public void selectStateFromDropdownList() throws IOException {
		Select state = new Select(driver.findElement(By.id(Utility.fetchLocatorValue("state_dropdownList_id"))));
		state.selectByIndex(2);
	}
	
	public void selectCountryFromDropdownList() throws IOException {
		Select country = new Select(driver.findElement(By.id(Utility.fetchLocatorValue("country_dropdownList_id"))));
		country.selectByIndex(2);
	}
	
}
