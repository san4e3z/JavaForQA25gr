package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
  
  @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	app.getContactHelper().gotoContactsPage();    
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    //assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);

  }
}