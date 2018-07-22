package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'srinivas')]")
	private WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	private WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	private WebElement newContacts;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	private WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	private WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameLable() {
		return userNameLable;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getNewContacts() {
		return newContacts;
	}

	public WebElement getDealsLink() {
		return dealsLink;
	}

	public WebElement getTasksLink() {
		return tasksLink;
	}

	public String validateHomePagetitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUsername() {
		TestUtil.switchToFrame();
		return userNameLable.isDisplayed();
	}

	public ContactPage clickOnContactsLink() {
		TestUtil.switchToFrame();
		contactsLink.click();
		return new ContactPage();
	}

	public DealsPage clickOnDealsLink() {
		TestUtil.switchToFrame();
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		TestUtil.switchToFrame();
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactsLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newContacts.click();
	}
}