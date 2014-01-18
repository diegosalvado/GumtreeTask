package com.gumtree.model;

import org.joda.time.DateTime;

public class Person {

	private String name;
	private String gender;
	private DateTime date;
	
	
	public Person(String name, String gender, DateTime date) {
		this.name = name;
		this.gender = gender;
		this.date = date;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public void setDate(DateTime age) {
		this.date = age;
	}
	
	public String toString() {
		return this.name+" "+this.gender+" "+
		this.date.getDayOfMonth()+"/"+this.date.getMonthOfYear()+"/"+this.date.getYearOfCentury();
		
	}
	
}
