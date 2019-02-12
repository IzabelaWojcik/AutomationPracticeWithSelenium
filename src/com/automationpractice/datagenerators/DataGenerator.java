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
	
	@DataProvider(name="Excel-DataProvider")
	public static Object[][] testDataGenerator(Method met) throws IOException{
		if(met.getName().equalsIgnoreCase("createAnAccount_enterCorrectEmailTest")) {
			
			FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet emailSheet = workbook.getSheet("emailCorrect");
			int numberOfRows = emailSheet.getPhysicalNumberOfRows();

			Object[][] testData = new Object[numberOfRows][1];
		
			for(int i = 0; i < numberOfRows; i++) {
				XSSFRow row = emailSheet.getRow(i);
				XSSFCell email = row.getCell(0);
				testData[i][0] = email.getStringCellValue();
			}
			
			return testData;
			
		}
		else {
			Object[][] testData = new Object[2][3];
			return testData;
		}
		
	}
	
}
