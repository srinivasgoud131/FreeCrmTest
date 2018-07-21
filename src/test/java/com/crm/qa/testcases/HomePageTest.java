package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	DealsPage dealPage;
	TasksPage taskPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		dealPage=new DealsPage();
		taskPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Test cases should be independent or separated from each other
	//Before each test case launch the browser and login
	//Execute the test case
	//After each test case close the browser
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title = homePage.validateHomePagetitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserName() {
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifyDealsPageLinkTest() {
		dealPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksPageLinkTest() {
		taskPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}