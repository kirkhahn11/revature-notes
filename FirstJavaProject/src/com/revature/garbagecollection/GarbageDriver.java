package com.revature.garbagecollection;

public class GarbageDriver {

	public static void main(String[] args) {

		System.out.println("Instantiating GarbageDriver object...");
		
		GarbageDriver gd = new GarbageDriver();
		// Currently the "gd" ref variable is in the stack and the object is in the heap
		
		System.out.println("GarbageDriver object successfully created");
		
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally block is running");
		}
		
		gd = null;
		
		/**
		 * Garbage Collection is not deterministic == we don't have much control
		 */
		
		/**
		 * Every object that extends the java.lang.Object class (every object) has a method called finalize()
		 * 
		 * when an object's finalize method is called 
		 */
		
		System.gc();
		
		for(;;) {
			System.out.println("...");
		}
	}
		@Override
		protected void finalize() {
			System.out.println("GarbageDriver finalize method has been called");
			
			System.out.println("***********************");
			System.out.println("***********************");
			System.out.println("***********************");
			
			System.out.println("Goodbye!");
			
			System.exit(0);
		}
	

}
