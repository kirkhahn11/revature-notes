package com.revature.arrays;

import java.util.Scanner;

public class InteractiveArrays {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		int size = 5;
		
		int[] returnedArr = getIntegers(size);
		
		printArray(returnedArr);
		
		double avg = getAverage(returnedArr);
		
		System.out.println(avg);
		
	}

	// step 1: asks user to create an array and input custom values 
	static int[] getIntegers(int capacity) {
		
		System.out.println("Enter " + capacity + " integers");
		
		int[] values = new int[capacity]; 
		
		for(int i = 0; i < values.length; i++) {
			values[i] = scan.nextInt(); 
		}
		
		return values;
	}
	
	static void printArray(int[] arr) { 
		
		for(int n : arr) {
			System.out.println(n);
		};
	}
	
	public static double getAverage(int[] numbers) {
		double temp = 0;
		for(int i = 0; i < numbers.length; i++) {
			temp += numbers[i];
		}
		return temp / numbers.length;
	}
}
