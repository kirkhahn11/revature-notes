package com.revature.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinExample {
	
	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(0L, 3535L, 6525L, 2314L,133L, 4L);
		// we will need to calculate the factorials of each of these numbers 
		
		//First we build a data structure to collect some (yet-to-be-new) threads in
		List<FactorialThread> threads = new ArrayList<>();
		
		// step 1) for each number within the input numbers pass it to the constructor of a 
		// newly instantited thread and add it to the thread list
		for(Long l : inputNumbers) {
			//assigining a new thread for each number
			threads.add(new FactorialThread(l));
		}
		
		// step 2) iterate over all the factorial threads and start them
		for(Thread t : threads) {
			t.setDaemon(true);
			t.start(); // this begins race conditions between the factorial threads and hte main threads.
		}
		
		// still in the main thread (because we in the main method)
		for(Thread t : threads) {
			//this will block the main thread until the factorial thread completes
			t.join(); // this may throw an InterruptedException, so we have to add the throws declaration
		}
		
		// step 3) check the result of the factorial threads (if they have finished yet);
		for(int i=0; i<inputNumbers.size(); i++) {
			FactorialThread factorialThread = threads.get(i); //(O(1)) constant time retrieval
			
			// below is a race condition between the main thread 
			if(factorialThread.isFinished()) {
				System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
			} else {
				System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress...");
			}
		}
	}
}
