package com.revature.abstraction;

public class DeskPhone implements Callable {

	// it would be a good design decision to delegate these shared fields to an abstract class, 
	// not an interface, where they remain constant
	private int myNumber;
	private boolean isRinging;
	
	/**
	 * Challenge: Take all the properties and delegate them to an abstract class
	 * @param myNumber
	 */
	
	public DeskPhone(int myNumber) {
		super();
		this.myNumber = myNumber;
	}

	@Override
	public void powerOn() {
		System.out.println("No action taken, already plugged in");
	}

	@Override
	public void dial(int phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRinging() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
