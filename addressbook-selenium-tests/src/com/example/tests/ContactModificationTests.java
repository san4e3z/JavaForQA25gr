package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);

	    // actions
		app.getContactHelper().editContact(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToMainPage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    // assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.remove(index);
	    oldList.add(contact);
	    
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    
	    assertEquals(newList, oldList);

	}
}