package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions
		app.getContactHelper().editContact(0);
		ContactData contact = new ContactData();
		contact.contact_name = "Name after modification";
		contact.lastname = "New first name";
		contact.home_number = "Update";
		contact.email1 = "new email";
		contact.days = "-";
		contact.months = "-";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToMainPage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    // assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.remove(0);
	    oldList.add(contact);
	    
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    
	    assertEquals(newList, oldList);

	}
}