package com.revature.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	/** 
	 * what is the purpose of the main method?
	 * 
	 * the main() method is where JIT compiler begins program
	 * execution. The JIT compiler is a part of the JVM
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 8 Primitive datatypes
		
		boolean isCool = true; //1 bit of reserved memory - 1 or 0 == true or false
		byte reallySmallNumber = 127; // 8 bits of reserved memory 
		short shortNumber = 32467; // 16 bits of reserved memory 
		char letter = 'm'; // 16 bits of memory that represent an ASCII character
		
		int standardNumber = 42; // 32 bits of memory *no decimals
		float lessPreciseDecimal = 93.2f; // 32 bits of memory 
		
		double decimal = 145.63; // 64 bits of memory 
		long largeNum = 12345L; // 64 bits of memory 
		
		// long uses (can use "_"(so can ints)) 
		
		long creditCardNumber = 2134_1232_2142_2322L;
		
		int x = 4; 
		int y = 10; 
		
		System.out.println(x + y);
		
		// strings are not primitive data types. Technically a class
		String name = "Spongebob";  
		
		System.out.println(name + " is " + (x + y *100) + " years old.");
		
		// casting === transforming datatypes
		
		byte a = 40; 
		short b = a; // now has the value of byte a
		int c = b;
		double d = c; // this process is called widening (implicit casting)(small datatype into larger)
		
		double dub = 900.9;
		int myInt = (int) dub; // drops off the decimal myInt === 900
		// narrow casting === going bigger to smaller 
		System.out.println("the double that has been explicitly cast to an int is now equal to " + myInt);
		
		// everything above ^ are java literals === hard-coded fixed-values assigned to variables
		
		int min; // variable declaration
		min = Integer.MIN_VALUE; // static variables are available on a class level
		
		System.out.println("The minimum of an int is " + min);
		
		// Completely convert the primitive datatype into an Integer Object == autoboxing == primative -> object
		
		Integer obj1 = new Integer(20);
		Integer obj2 = new Integer("20");
		
		// Question 1: do obj1 and obj2 have the same value? 
		System.out.println(obj1.equals(obj2)); //true
		
		//Question 2: Do obj1 & obj2 point to the same address in memory?
		System.out.println(obj1 == obj2); // false
		
		// unboxing = object to primitive
		
		Double dubObj = 15.45;
		//convert that to a double primitive
		double dubPrimative = dubObj; // implicit way of transforming it
		
		double dubPrimitive2 = Double.valueOf(dubObj); // explicit way
		
		//if I were to do something with
		List<Double> dubList = new ArrayList<Double>();
		
		dubList.add(dubObj);
		dubList.add(dubPrimative);
		
		// without using the wrapper classes (Double vs double) gives you access to methods with those classes
	}
}
