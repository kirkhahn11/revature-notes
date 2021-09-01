package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	/**
	 * Arrays are container objects which contain ONE type of element
	 * 
	 * Arrays can't change size
	 * 
	 * (1) declare the datatype that it can hold
	 * (2) initalize it's capacity 
	*/
	
	public static void main(String[] args) {
		
		int size = 10;
		
		int[] numbers = new int[size]; // default value of every index is zero
		String[] words = new String[size]; // default value of every index is null
		
		Object[] objects;  
		
		System.out.println(numbers);
		
		numbers[0] = 4;
		numbers[2] = 30;
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (i+1) * 10;
			System.out.println(numbers[i]);
		}
		
		//enhanced for-loop
		for(int n : numbers) {
			System.out.println(n);
		}
		
		String[] fruit = {"Orange", "Apple", "Fig"};
		
		System.out.println(Arrays.toString(fruit));
		Arrays.sort(fruit);
		System.out.println(Arrays.toString(fruit));
		
		System.out.println(Arrays.toString(numbers));
		for(int i = 0; i <= 5; i++) {
			System.out.println(i);
		}
	}
}

