package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		// An object is a reusable component within our code 
		
		// classes are blueprints of an object, and they define how objects behave
		
		Scanner scan = new Scanner(System.in);
		
		//prompt the user to enter their name
		System.out.println("Please enter your name");
		
		// captures the user's input into a variable called name
		String name = scan.nextLine();
		
		//prompt the user to enter their name
		System.out.println("Please enter your age");
		int age = scan.nextInt();
		
		// print back to the user what their age will be in 100 years using a method we create
		System.out.println("In the future you, " + name + " will be " + getFutureAge(age) + " years old.");
	}
	
	// public is an access modifier. public === access anywhere in app
	// static === I do not need to instanciate this class in-order for it to be called
	// int is the return type 
	// (int variable) is the data needed 
	public static int getFutureAge(int currentAge) {
		
		return currentAge + 100;
	}

}
