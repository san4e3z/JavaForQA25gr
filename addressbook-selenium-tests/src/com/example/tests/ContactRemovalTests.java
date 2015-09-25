package com.example.tests;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		// save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    // actions

		app.getContactHelper().editContact(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToMainPage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    //assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.remove(index);
	    
	    assertEquals(newList, oldList);	
	}
	
}