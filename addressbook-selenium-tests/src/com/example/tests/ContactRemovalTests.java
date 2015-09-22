package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    // actions

		app.getContactHelper().editContact(0);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToMainPage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    //assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.remove(0);
	    
	    assertEquals(newList, oldList);	
	}
	
}