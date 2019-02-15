package com.automationpractice.datagenerators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
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
		XSSFSheet sheet = createSheet(sheetName);
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

		XSSFSheet sheet = createSheet(sheetName);
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

	@DataProvider(name="Excel-DataProvider")
	public static Object[][] testDataGeneratorTwelveColumnsSheet(Method met) throws IOException{

		String sheetName = "";

		if(met.getName().endsWith("fillAllRegistrationFormWithCorrectData")) {
			sheetName = "createAccountFormAllDataRequired";
		}

		XSSFSheet sheet = createSheet(sheetName);
		int numberOfRows = getRowsCount(sheet);
		int numberOfColumns = getColumnsCount(sheet);

		Object[][] testData = new Object[numberOfRows-1][numberOfColumns];

		for(int i = 1; i < numberOfRows; i++) {
			for(int j = 0; j < numberOfColumns; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);

				testData[i-1][j] = getCellValue(cell);
			}
		}

		return testData;
	}

	private static Object getCellValue(Cell cell) {
		Object cellValue = null;

		if(cell != null) {

			CellType cellType = cell.getCellTypeEnum();

			if(cellType == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			}

			else if(cellType == CellType.NUMERIC) {
				Double doubleValue = cell.getNumericCellValue();

				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} 
				else {
					cellValue = cell.getNumericCellValue();

					if(!doubleValue.toString().contains(".*")) {
						cellValue = doubleValue.intValue();
					}
				}
			}

			else if(cellType == CellType.BOOLEAN) {
				cellValue = cell.getBooleanCellValue();
			}

			else if(cellType == CellType.BLANK) {
				cellValue = "";
			}

			else if (cellType == CellType.FORMULA) {
				cellValue = cell.getCellFormula();
			}

		}
		else {
			cellValue = "";
		}

		return cellValue.toString();
	}

	private static XSSFSheet createSheet(String sheetName) throws FileNotFoundException, IOException {
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	private static int getRowsCount(XSSFSheet sheet) {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int getColumnsCount(XSSFSheet sheet) {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
}
