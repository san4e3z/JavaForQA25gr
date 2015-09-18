package com.example.tests;

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

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    gotoContactsPage();
    
    ContactData contact = new ContactData();
    contact.contact_name = "Contact name 1";
    contact.lastname = "Last name 1";
    contact.address = "Saint-Petersburg";
    contact.home_number = "812";
    contact.mobile_number = "981";
    contact.work_number = "812";
    contact.email1 = "example@yandex.ru";
    contact.email2 = "example2@yandex.ru";
    contact.days = "1";
    contact.months = "January";
    contact.years = "1987";
    contact.address2 = "Moscow";
    contact.phone2 = "921";
     
    fillContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	    openMainPage();
	    gotoContactsPage();
	    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
	    submitContactCreation();
	    returnToMainPage();
	  }
}