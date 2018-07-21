package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait = 10;
	static Xls_Reader reader;

	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getDataFromExcel() {

		reader = new Xls_Reader(
				"E:\\srinivas131\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		String sheetName ="Contacts";
		int rows = reader.getRowCount(sheetName);
		int cols = reader.getColumnCount(sheetName);

		Object[][] testData = new Object[rows-1][1];
		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
				table = new Hashtable<String, String>();
				for (int colNum = 0; colNum < cols; colNum++) {
					table.put(reader.getCellData(sheetName, colNum, 1), reader.getCellData(sheetName, colNum, rowNum));
					// testData[rowNum-2][colNum] = reader.getCellData(sheetName, colNum, rowNum);
					testData[rowNum - 2][0] = table;
				}
			}
		return testData;
		}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}
}