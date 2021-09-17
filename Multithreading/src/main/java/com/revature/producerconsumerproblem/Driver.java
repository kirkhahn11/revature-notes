package com.revature.producerconsumerproblem;

public class Driver {
	//producer consumer problem
	public static void main(String[] args) {

		Holder data = new Holder();
		int numValuesToGenerate = 10;
		
		// Create Threads 
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer(data, numValuesToGenerate));
		 
		// Start threads
		System.out.println("Starting threads.......");
		
		producerThread.start();
		consumerThread.start();
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
