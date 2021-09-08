package com.revature;

public class Driver {

	public static void main(String[] args) {
		// 1 way to create a thread is by passing through a runnable object
		Thread classyThread = new Thread(new MyThread());
		
		
		classyThread.start();
		
		//faster way to create a thread below
		//create a thread with an anonymous class
		Thread anonThread = new Thread(new Runnable() {

			public void run() {
				System.out.println("Running from a thread created with an anonymous class!");
			}
			
		});
		
		anonThread.start();
		
		// easiest way!
		// create a thread with a lambda!
		Thread lambdaThread = new Thread(() -> System.out.println("Running from the lambda thread!"));
		
		lambdaThread.start();
		
		// 3 parts of a lambda 
		//1 runnable list
		//2 arrow 
		//3 body
		
		new Thread(() -> {
			// lambdas allow us to do functional programming in java
			int x = 100; 
			
			System.out.println("Printing from a muliti");
			System.out.println("line");
			System.out.println("thread created from a lambda");
		}).start();
		
		System.out.println("End of main method and thread");
		
		
	}

}

// 1st way to create a thread is to create a class that implements Runnable interface
// any interface that has 1 method you need to is a functional interface
class MyThread implements Runnable {

	public void run() {
		
		int sum = UtilityMethods.add(10, 90);
		
		System.out.println("MyThread is running");
		
		System.out.println("The sum of two numbers is " + sum);
	}
	
}

class UtilityMethods {
	public static int add(int x, int y) {
		
		return x + y;
	}
}