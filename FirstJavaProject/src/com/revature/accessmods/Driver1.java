package com.revature.accessmods;

public class Driver1 {

	public int publicField = 1;
	protected int protectedField = 2;
	int defaultField = 3; //default
	private int privateField = 4; 
	
	public static void main(String[] args) {
		
		/**
		 * 4 Pillars of OO{
		 * 
		 * Abstraction
		 * Polymorphism
		 * Inheritance
		 * Encapsulation
		 * 
		 * Encapsulation is a mechanism in which data and methods can be
		 * wrapped together within a single class
		 */
		
		Driver1 d1 = new Driver1();
		
		//can access all above fields 
		System.out.println(d1.privateField);
		System.out.println(d1.defaultField);
		System.out.println(d1.protectedField);
		System.out.println(d1.publicField);
	}

}
