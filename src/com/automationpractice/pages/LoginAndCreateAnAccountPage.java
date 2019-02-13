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
		driver.findElement(By.id("firstname_txtField_id")).sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) throws IOException{
		driver.findElement(By.id("lastname_txtField_id")).sendKeys(lastname);
	}
	
	public void enterCompanyName(String company) throws IOException{
		driver.findElement(By.id("company_txtField_id")).sendKeys(company);
	}
	
	public void enterAddress(String address) throws IOException{
		driver.findElement(By.id("address_txtField_id")).sendKeys(address);
	}
	
	public void enterAddressLine2(String address) throws IOException{
		driver.findElement(By.id("addresLine2_txtField_id")).sendKeys(address);
	}
	
	public void enterCity(String city) throws IOException{
		driver.findElement(By.id("city_txtField_id")).sendKeys(city);
	}
	
	public void postCode(String postCode) throws IOException{
		driver.findElement(By.id("postCode_txtField_id")).sendKeys(postCode);
	}
	
	public void enterHomePhone(String phoneNumber) throws IOException{
		driver.findElement(By.id("homePhone_txtField_id")).sendKeys(phoneNumber);
	}
	
	public void enterMobilePhone(String phoneNumber) throws IOException{
		driver.findElement(By.id("mobilePhone_txtField_id")).sendKeys(phoneNumber);
	}
	
	public void enterAddressAlias(String address) throws IOException{
		driver.findElement(By.id("addressAlias_txtField_id")).sendKeys(address);
	}
	
	//textAreas
	public void enterAdditionalInformation(String text) throws IOException{
		driver.findElement(By.id("additionalInformation_txtArea_id")).sendKeys(text);
	}
		
	//buttons
	public void clickCreateAnAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("createAnAccount_button_id"))).click();
	}
			
	public void clickLogInButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("logIn_button_id"))).click();
	}
	
	public void clickSubmitAccountAccountButton() throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("submitAccount_button_id"))).click();
	}
	
	//radioButtons
	public void checkGenderMaleRadioButton() {
		driver.findElement(By.id("genderMale_radioButton_id")).click();
	}
			
	public void checkGenderFemaleRadioButton() {
		driver.findElement(By.id("genderFemale_radioButton_id")).click();
	}
		
	//checkBoxes
	public void checkNewsletterCheckbox() {
		driver.findElement(By.id("newsletter_checkbox_id")).click();
	}
			
	public void checkSpecialOffersCheckbox() {
		driver.findElement(By.id("specialOffers_checkbox_id")).click();
	}
	
	//dropdownLists
	public void selectDayFromDropdownList() {
		Select day = new Select(driver.findElement(By.id("chooseDay_dropdownList_id")));
		day.selectByIndex(2);
	}
	
	public void selectMonthFromDropdownList() {
		Select month = new Select(driver.findElement(By.id("chooseMonth_dropdownList_id")));
		month.selectByIndex(2);
	}
	
	public void selectYearFromDropdownList() {
		Select year = new Select(driver.findElement(By.id("chooseYear_dropdownList_id")));
		year.selectByIndex(2);
	}
	
	public void selectStateFromDropdownList() {
		Select state = new Select(driver.findElement(By.id("state_dropdownList_id")));
		state.selectByIndex(2);
	}
	
	public void selectCountryFromDropdownList() {
		Select country = new Select(driver.findElement(By.id("country_dropdownList_id")));
		country.selectByIndex(2);
	}
	
}
