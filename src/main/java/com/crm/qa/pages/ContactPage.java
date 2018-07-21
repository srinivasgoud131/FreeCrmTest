package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement clickOnContacts;
	
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	WebElement contactPageLabel;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//input/following-sibling::input[@value='Save']")
	WebElement clickOnSave;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactPage clickOnContacts() {
		clickOnContacts.click();
		return new ContactPage();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']")).click();
	}
	
	public void createNewContact(String title1, String ftname, String ltname, String mobile) {
		Select select = new Select(title);
		select.selectByVisibleText(title1);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		phone.sendKeys(mobile);
		clickOnSave.click();
	}
	
}