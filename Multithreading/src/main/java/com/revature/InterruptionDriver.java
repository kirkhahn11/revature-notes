package com.revature;

import java.math.BigInteger;

public class InterruptionDriver {

	public static void main(String[] args) {

	// here We will instantiate a thread by passing a runnable object to its constructor
		Thread compThread = new Thread(new LongComputationTask(new BigInteger("1000"), new BigInteger("231411231")));
		
		// does not require the thread to exit but thread will still run
		// kind of saves your place 
		compThread.setDaemon(true);
		
		compThread.start();
		
		// if the data doesn't compile in 3 seconds the thread will be interrupted 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compThread.interrupt();
	}

	// Class is to calculate a number to a given power
	private static class LongComputationTask implements Runnable{
		
		private BigInteger base;
		private BigInteger power;
		
		
		
		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			// this will be the last step
			// we will print out the result of the pow() method
			System.out.println(base + "^" + power + " = " + this.pow(base, power));
		}
		
		//method to calculate a num to a given power
		private BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;
			
			/*
			 * The compareTo method is just checking that we don't raise the base to a number > power
			 * because a return value of 0 will indicate "equal to"
			 */
			for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread prematurley interrupted");
					return BigInteger.ZERO;
				}
				result = result.multiply(base);
			}
			
			return result;
		}
	}
}
