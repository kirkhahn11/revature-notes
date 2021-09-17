package com.revature.producerconsumerproblem;
// In order to create a thread that possess the producer functionallity at runtime
// we're going to create a thread like Thread prod = new Thread(new Producer());
public class Producer implements Runnable{

	public Holder data;
	int max;
	
	
	public Producer(Holder data, int max) {
		super();
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		for(int i = 0; i < max; i++) {
			this.data.setVal(i);
			System.out.println("The producer put: " + i);
		}
	}

}
