package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 2; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
		//
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] city = {"Saint-Petersburg", "Moscow", "London", "Rome", "Paris"};
		Random rnd = new Random();
		
		for (int i = 0; i < 2; i++) {
			ContactData contact = new ContactData();
			contact.contact_name = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address = city[rnd.nextInt(city.length)];
			contact.home_number = generateRandomString();
			contact.mobile_number = generateRandomString();
			contact.work_number = generateRandomString();
			contact.email1 = generateRandomString() + "@example.com";
			contact.email2 = generateRandomString() + "@example.com";
			contact.days = String.valueOf(rnd.nextInt(31));
			contact.months = months[rnd.nextInt(months.length)];
			contact.years = String.valueOf(1970 + rnd.nextInt(20));
			contact.address2 = city[rnd.nextInt(city.length)];
			contact.phone2 = generateRandomString();
			
			list.add(new Object[]{contact});
		}
		//
		return list.iterator();
	}


}