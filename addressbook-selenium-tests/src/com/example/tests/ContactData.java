package com.example.tests;

public class ContactData {
	
	public String contact_name;
	public String lastname;
	public String address;
	public String home_number;
	public String mobile_number;
	public String work_number;
	public String email1;
	public String email2;
	public String days;
	public String months;
	public String years;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	
	public ContactData(String contact_name, String lastname, String address,
			String home_number, String mobile_number, String work_number,
			String email1, String email2, String days, String months,
			String years, String address2, String phone2) {
		this.contact_name = contact_name;
		this.lastname = lastname;
		this.address = address;
		this.home_number = home_number;
		this.mobile_number = mobile_number;
		this.work_number = work_number;
		this.email1 = email1;
		this.email2 = email2;
		this.days = days;
		this.months = months;
		this.years = years;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}