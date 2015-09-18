package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoContactsPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData group) {
		type(By.name("firstname"), group.contact_name);
		type(By.name("lastname"), group.lastname);
	    type(By.name("address"), group.address);
		type(By.name("home"), group.home_number);
	    type(By.name("mobile"), group.mobile_number);
		type(By.name("work"), group.work_number);
		type(By.name("email"), group.email1);
		type(By.name("email2"), group.email2);
		type(By.name("email2"), group.email2);
		selectByText(By.name("bday"), group.days);
	    selectByText(By.name("bmonth"), group.months);	    
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("byear"), group.years);
	    type(By.name("address2"), group.address2);
	    type(By.name("phone2"), group.phone2);
	}

	

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToMainPage() {
		click(By.linkText("home page"));
	}

	public void editContact(int index) {
		click(By.xpath("//tr[@name='entry'][" + index + "]/td[@class='center'][3]/a"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
		
	}
	
	
}