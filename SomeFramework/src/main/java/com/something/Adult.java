package com.something;

public class Adult implements Person {
	
	private String name;
	private int age;
	private String city;
	private String country;
	
	
	public Adult(String name, int age, String city, String country) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
	}

	public void introduce() {
		System.out.println("My name is " + this.name);
	}

	public void sayAge() {
		System.out.println("I am " + this.age + " years old.");
	}

	public void sayWhereFrom() {
		System.out.println("I'm from " + this.city + ", " + this.country);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
