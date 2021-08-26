package com.revature;

public class MainMethodDemo {

	/**
	 * The JVM's JIT compiler searches for the main() method
	 * args represent a list of commands that could follow the execution command
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TEsting 123");
		for(String s : args) {
			System.out.println(s);
		}
	}

}
