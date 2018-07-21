package com.crm.qa.utils;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

public class testData {	
	
	static Xls_Reader reader;
	
	/*@Test(dataProvider="getDataFromExcel")
	public void testdata(String title, String firstname, String lastname, String phone) {
		System.out.println(title+"-------"+firstname+"-----"+lastname+"-----"+phone);
	}*/
	
	@DataProvider
	public static Object[][] getDataFromExcel() {
		
		reader = new Xls_Reader("C:\\Users\\srinivas\\Desktop\\FreeCRMTestData.xlsx");

		String sheetName = "Contacts";
		int rows = reader.getRowCount(sheetName);
		int cols = reader.getColumnCount(sheetName);

		Object[][] testData = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum < rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {

				testData[rows - 2][cols] = reader.getCellData(sheetName, colNum, rowNum);
			}
		}
		return testData;
	}
	
	public static void main(String[] args) {
		System.out.println(getDataFromExcel().toString());
	}
}
