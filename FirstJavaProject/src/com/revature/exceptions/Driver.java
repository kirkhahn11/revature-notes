package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int x = 10;
		int y = 0; 
		
		System.out.println(divideTryCatch());
		
		System.out.println("I finally reached this line of code!");
	}
	
	// Polymorphism, overloading == change amount of arguments or type of arguments
	static int divideTryCatch() { //not taking in ANY parameters
		
		try {
			System.out.println("Please enter a number: ");
			int x = scan.nextInt();
			
			System.out.println("Please enter a number to divide by: ");
			int y = scan.nextInt();
			
			return x/y;
		} catch (ArithmeticException e) {
			System.out.println(e);
			return 0;
		} catch(InputMismatchException ex) {
			System.out.println("Please enter a valid number.");
			return 0;
		} finally {
			scan.close();
		}
	}

	static int divide(int x, int y) {
		return x / y;
	}
	
	// I want to safe=guard my code so that it doesn't crash to handle exceptions using try/catch blocks
	static int divideTryCatch(int x, int y) {
		
		try {
			return x/y;
		} catch(ArithmeticException e) {
			System.out.println("You can't divide by zero!!!");
			return 0;
		} finally {
			// this block of code will ALWAYS execute no matter what... typically used to close resources
			System.out.println("in the finally block");
		}
	}
	
	static void createFileCheckedExceptionDemo(String path, String text) {
		
		//Checked exception demo
		FileWriter writer;
		
		try {
			writer = new FileWriter(path, true);
			writer.write(text);
			writer.close();
		} catch (IOException e) { //this is a checked exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
