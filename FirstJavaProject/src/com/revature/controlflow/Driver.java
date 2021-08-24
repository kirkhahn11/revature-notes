package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		// if - else statement 
		
		int temp = 31;
		if(temp < 32) {
			System.out.println("It's too cold out!");
		} else {
			System.out.println("It's not too cold out...");
		}
		
		//ternary operator 
		System.out.println((temp < 32) ? "COLD!" : "NOT COLD!");
		
		int hungerLevel = 7; 
		
		if(hungerLevel > 6) {
			System.out.println("Need food now!");
		} else if (hungerLevel >= 4) {
			System.out.println("I could snack");
		} else {
			System.out.println("Not hungry at all...");
		}
		
		// do while loop
		do {
			System.out.println("In the do while loop");
		} while(false);
		
		int counter = 10; 
		while (counter > 0) {
			System.out.println(counter);
			counter--;
		}
		// switch case
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of your birthday month");
		
		int monthNum = scan.nextInt();
		
		String month;
		
		switch(monthNum) {
		
		case 6: 
			month = "June"; 
			break;
		case 7: 
			month = "July";
			break; 
		default: 
			month = "Sorry lazy dev calendar";
		}
		
		System.out.println("You were born in " + month);
		
		
		// for loop
		for(int i = 0; i < 10; i++) {
			System.out.println("i is equal to " + i);
		}
		
		String word = scan.next();
		
		for(int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
	}

}
