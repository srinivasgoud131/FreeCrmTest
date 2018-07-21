package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	String sheetName ="Contacts";
	
	//invoke super class constructor
	public ContactsPageTest() {
		super();
	}
	
	//initializing browser
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactPage = new ContactPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage.clickOnContacts();
	}
	
	/*@Test(priority=1)
	public void selectSinglContactsPageTest() {
		
		contactPage.selectContactsByName("test1 test");
		
	}
	
	@Test(priority=2)
	public void selectMultiContactsPageTest() {
		
		contactPage.selectContactsByName("naveen hyd");
		contactPage.selectContactsByName("test1 test");
	}*/
	 
	@DataProvider(name="getData")
	public Object[][] getFreeCRMTestData(){
		Object data [][] = TestUtil.getDataFromExcel();
		return data;
	}
	
	@Test(priority=1, dataProvider="getData")
	public void validateCreateNewContacts(Hashtable<String, String> data) {
		homePage.clickOnNewContactsLink();
		String title = data.get("Title");
		String firstname = data.get("Firstname");
		String lastname = data.get("Lastname");
		String mobile = data.get("Phone");
		System.out.println(data.get("Title")+"---------"+data.get("Firstname")+"---"
				+ "---"+data.get("Lastname")+"---"+data.get("Phone"));
		contactPage.createNewContact(title, firstname, lastname, mobile);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}