package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	public static void main(String[] args) {

		//create a simple HashMap
		
		Map<String, String> languages = new HashMap<String, String>();
		
		// use the .put() method to insert into a Map
		languages.put("Java", "A compiled high-level object oriented platform independent language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted languages, lightweight, runs in browser or Node.js");
		
		/**
		 * The Map interface does not extend Iterable (Collection interface)
		 * 
		 * - Cannot have duplicate keys 
		 * - Can have duplicate values
		 */
		
		languages.put("JavaScript", "not JAVA...!"); // would replace the key from the previous "Javascript" key
		
		System.out.println("I Like to program in: " + languages.get("Java"));
		
		/**
		 * how to iterate over a Map?
		 */
		
		for(String key : languages.values()) {
			System.out.println("The key is " + key);
		}
		
		// how to iterate over both values and keys?!?
		
		for(Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
		}
	}

}
