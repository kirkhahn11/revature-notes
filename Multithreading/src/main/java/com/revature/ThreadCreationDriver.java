package com.revature;

public class ThreadCreationDriver {

	public static void main(String[] args) {

		Thread t1 = new NewThread();
		t1.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		//this belongs to the Main Thread 
		System.out.println("Hello from the Main Thread! It's name is " + Thread.currentThread().getName());
		
		// 2nd way is to create a thread (anon class.. or lambda to provide functionality of the run() method
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("We are now in thread " + Thread.currentThread().getName());
			}
			
		});
		
		Thread t3 = new Thread(() -> System.out.println("running from a lmabda thread"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.setName("Thread 2 Electric Buggalo");
		t2.start();
		/*
		 * Thread states:
		 *  1. New Thread
		 *  2. Runnable Thread - its run() method has been implemented
		 *  3. Running Thread
		 *  4. Non-runnable (Blocked)
		 *  5. Terminated
		 */
	}

	private static class NewThread extends Thread {
		
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}
}
