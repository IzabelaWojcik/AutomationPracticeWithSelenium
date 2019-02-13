package com.automationpractice.datagenerators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name="Excel-OneColumn-DataProvider")
	public static Object[][] testDataGeneratorOneColumnSheet(Method met) throws IOException{

		String sheetName = "";
		int numberOfColumns = 1;
		
		if(met.getName().equalsIgnoreCase("enterCorrectEmailTest")){
			sheetName = "emailCorrect";
		}
		else if(met.getName().equalsIgnoreCase("enterIncorrectEmailTest")){
			sheetName = "emailIncorrect";
		}
		else if(met.getName().equalsIgnoreCase("enterExistingEmailTest")){
			sheetName = "existingAccount";
		}
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberOfRows][numberOfColumns];

		for(int i = 0; i < numberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell email = row.getCell(0);
			testData[i][0] = email.getStringCellValue();
		}

		return testData;

	}

	@DataProvider(name="Excel-TwoColumns-DataProvider")
	public static Object[][] testDataGeneratorTwoColumnSheet(Method met) throws IOException{

		String sheetName = "";
		int numberOfColumns = 2;
		
		if(met.getName().endsWith("enterCorrectLoginAndPasswordTest")) {
			sheetName = "existingAccount";
		}
		else if(met.getName().endsWith("enterIncorrectLoginData")) {
			sheetName = "notExistingAccount";
		}

		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberOfRows][numberOfColumns];

		for(int i = 0; i < numberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell login = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			testData[i][0] = login.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}

		return testData;

	}
	
	@DataProvider(name="Excel-TwelveColumns-DataProvider")
	public static Object[][] testDataGeneratorTwelveColumnsSheet(Method met) throws IOException{
		
		String sheetName = "";
		int numberOfColumns = 12;
		
		if(met.getName().endsWith("")) {
			sheetName = "createAccountFormAllDataRequired";
		}
		
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		
		Object[][] testData = new Object[numberOfRows][numberOfColumns];
		
		for(int i = 0; i < numberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell name = row.getCell(0);
			XSSFCell lastname = row.getCell(1);
			XSSFCell password = row.getCell(2);
			XSSFCell company = row.getCell(3);
			XSSFCell address = row.getCell(4);
			XSSFCell addressLine2 = row.getCell(5);
			XSSFCell city = row.getCell(6);
			XSSFCell postCode = row.getCell(7);
			XSSFCell additionalInformation = row.getCell(8);
			XSSFCell homeNumber = row.getCell(9);
			XSSFCell mobileNumber = row.getCell(10);
			XSSFCell addressAlias = row.getCell(11);
			
			testData[i][0] = name.getStringCellValue();
			testData[i][1] = lastname.getStringCellValue();
			testData[i][2] = password.getStringCellValue();
			testData[i][3] = company.getStringCellValue();
			testData[i][4] = address.getStringCellValue();
			testData[i][5] = addressLine2.getStringCellValue();
			testData[i][6] = city.getStringCellValue();
			testData[i][7] = postCode.getStringCellValue();
			testData[i][8] = additionalInformation.getStringCellValue();
			testData[i][9] = homeNumber.getStringCellValue();
			testData[i][10] = mobileNumber.getStringCellValue();
			testData[i][11] = addressAlias.getStringCellValue();
		}
		
		return testData;
	}
	
}
