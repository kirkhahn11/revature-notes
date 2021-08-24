package com.revature.models;

import java.io.Serializable;

// Our custom class inherits from the java.lang.Object (Object class)
// you can only declare ONE public class per file


public class Person {

	// available on a class level... call it using Person.MAX_AGE
	public static int MAX_AGE = 115;
	
	// Instance variables (not static) 
	private String name; 
	private int age;
	private double height; 
	private double weight; 
	
	public Person() {
		//no-args constructor
	}
	
	public Person(String name) {
		super(); //super() calls the parent constructor. (Object class in this case which is always available)
		this.name = name;
	}
	
	
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}


	public double calculateBMI() {
		return (this.weight/this.height/this.height)*703;
	}

	// getters & setters
	
	// We are overriding a method that we inherit from the Object class
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
