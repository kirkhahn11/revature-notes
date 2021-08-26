package com.revature.strings;

public class Driver {

	public static void main(String[] args) {

		/**
		 * Strings are used to store a sequence of characters but are treated as objects
		 * coming from the String class!
		 * 
		 * created 2 ways
		 * 1. String Object created with the new keyword -> goes to the heap
		 * 2. String literal with = "bobish" -> goes to the String Pool inside the heap
		 */
		
		String stringObject = new String("Straight to the general heap we go");
		String stringLiteral = "Straight to the string pool we go...";
		
		System.out.println(stringObject);
		System.out.println(stringLiteral);
		
		String str1 = "hello";
		String str2 = "hello";
		
		//do they point to the same location in memory
		System.out.println(str1 == str2); //true 
		
		String strObj2 = new String("hello");
		
		// does it work for string objects? 
		System.out.println(str1 == strObj2); //...no
		
		String str3 = "Hello World";
		
		String str4 = "Hello " + "World";
		
		System.out.println(str3 == str4); //still true
		
		//hash code DOES NOT point to the same place in memory
		System.out.println(strObj2.hashCode());
		System.out.println(str1.hashCode());
		
		String str5 = "Hello ";
		String str6 = str5 + "World"; // this is equivalent to using the new keyword due to immutability
		
		
		//str6 is going to the general heap, not the pool
		System.out.println(str6 == str4);
		
		String str6InPool = str6.intern();
		
		// intern() sends the string to the pool
		System.out.println(str4 == str6InPool);
		
		/**
		 * The String API
		 * 
		 * tons of methods to use on strings
		 */
		
		String newStrObject = str6InPool.concat("something"); //equivalent to the new keyword == in general heap
		System.out.println(newStrObject);
		
		String test = "the brown fox jumped over the lazy dog";
		
		String chopped = test.substring(5);
		System.out.println(chopped);
		
		// StringBuffer and StringBuilder are mutable versions of the string class
		// StringBuffer is threadsafe and slower than stringBuilder
		// 
		
		StringBuilder sbuild = new StringBuilder("Hello");
		
		sbuild.append(" ");
		sbuild.append("World"); //modifying the object, not possible on a string
		
		// you can send the StringBuilder object and send it to the string pool
		
		System.out.println(sbuild);
		String myString = sbuild.toString(); // still in the general heap
		
		String sbInPool = myString.intern();
		
		System.out.println(sbInPool == str4);
	}

}
