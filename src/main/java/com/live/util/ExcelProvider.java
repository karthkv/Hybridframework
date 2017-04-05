package com.live.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {

	private static XSSFWorkbook workBook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;
	private static FileInputStream fis = null;
	private String path = null;

	public ExcelProvider(String path) throws IOException {
		this.path = path;
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheetAt(0);
		fis.close();
	}

	public static int getRowCount(String sheetName) {

		sheet = workBook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		return rows;
	}

	public static int getColumCount(String sheetName) {

		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		return cols;

	}

	public static String getCellData(int mrow, int mcol) {

		cell = sheet.getRow(mrow).getCell(mcol);
		// cell = row.getCell(mcol);
		System.out.println(cell.getStringCellValue());
		return cell.getStringCellValue();

	}


	public static Object[][] getDataProviderData(ExcelProvider getTestDataFromExcel, String sheetName)
			throws IOException {

		// fis = new FileInputStream(getTestDataFromExcel);
		// workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		int rowCount = ExcelProvider.getRowCount(sheetName);
		System.out.println(rowCount);
		int colCount = ExcelProvider.getColumCount(sheetName);
		System.out.println(colCount);
		/*
		 * if (rowCount <= 0) { Object[][] data = new Object[1][]; return data;
		 * }
		 */
		// create object array & assign  values from excel to object array
		Object[][] data = new Object[rowCount + 1][colCount];
		for (int rownum = 0; rownum <= rowCount; rownum++) {
			for (int colnum = 0; colnum < colCount; colnum++) {
				System.out.println();
				data[rownum][colnum] = getCellData(rownum, colnum);
			}
		}
		return data;

	}

}
