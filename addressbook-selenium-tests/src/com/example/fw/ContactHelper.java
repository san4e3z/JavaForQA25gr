package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoContactsPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.contact_name);
		type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address);
		type(By.name("home"), contact.home_number);
	    type(By.name("mobile"), contact.mobile_number);
		type(By.name("work"), contact.work_number);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.days);
	    selectByText(By.name("bmonth"), contact.months);	    
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("byear"), contact.years);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToMainPage() {
		click(By.linkText("home page"));
	}

	public void editContact(int index) {
		click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]/td[@class='center'][3]/a"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));	
	}

	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[@name='entry']/td[2]"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData();
			contact.lastname = row.getText();
			contacts.add(contact);		
		}
		return contacts;
	}

}