package com.automationpractice.datagenerators;

import java.io.FileInputStream;
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
		XSSFSheet emailSheet = workbook.getSheet(sheetName);
		int numberOfRows = emailSheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberOfRows][1];

		for(int i = 0; i < numberOfRows; i++) {
			XSSFRow row = emailSheet.getRow(i);
			XSSFCell email = row.getCell(0);
			testData[i][0] = email.getStringCellValue();
		}

		return testData;

	}

	@DataProvider(name="Excel-TwoColumns-DataProvider")
	public static Object[][] testDataGeneratorTwoColumnSheet(Method met) throws IOException{

		String sheetName = "";
		
		if(met.getName().endsWith("enterCorrectLoginAndPasswordTest")) {
			sheetName = "existingAccount";
		}
		else if(met.getName().endsWith("enterIncorrectLoginData")) {
			sheetName = "notExistingAccount";
		}

		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet emailSheet = workbook.getSheet(sheetName);
		int numberOfRows = emailSheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberOfRows][2];

		for(int i = 0; i < numberOfRows; i++) {
			XSSFRow row = emailSheet.getRow(i);
			XSSFCell login = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = login.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}

		return testData;

	}

}
