package com.revature.datatypes;

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
		
	}
}
