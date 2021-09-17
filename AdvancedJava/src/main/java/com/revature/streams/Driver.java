package com.revature.streams;

import java.util.Arrays;
import java.util.List;

public class Driver {

	/**
	 * Streams - Stream API was introduced in Java 8
	 * used to process a collection of objects -- A STREAM IS NOT A COLLECTION!!
	 * 
	 * a stream is a sequence of object references that support various methods
	 * methods can be pipelined to produce the desired result
	 * 
	 * We use Streams to take input from Collections, Arrays, or I/O channels.
	 * 
	 */
	public static void main(String[] args) {

		List<String> bingoNums = Arrays.asList(
				"D46", "D40",
				"B12", "B06",
				"G53", "G49", "G15", "g64",
				"I13", "I22", "I29",
				"O71"
				);
		
		// Let's print all of the Bingo numbers in column G
		// Old Way Below
		bingoNums.forEach(num -> {
			if(num.toUpperCase().startsWith("G")) {
				System.out.println(num);
			}
		});
		// method referencing Class::Method == can not pass in parameters 
		//String::toUpperCase
		//Streams are not used to change data
		bingoNums.stream()
			.map(String::toUpperCase) // map applies a given function to each element within a data structure
			.filter(s -> s.startsWith("G"))
			.sorted()
			.forEach(System.out::println);
		
	}

}
