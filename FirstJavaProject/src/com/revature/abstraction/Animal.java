package com.revature.abstraction;

// abstract classes cannot be instantiated 
public abstract class Animal {

	private int legs;
	private String color;
	
	
	public Animal() {
		System.out.println("Animal constructor is called");
	}
	//abstract method no body/implementation 
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("The animal is existing");
	}
}
