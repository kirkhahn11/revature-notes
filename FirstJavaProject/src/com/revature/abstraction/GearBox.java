package com.revature.abstraction;

// bad practice example. DON'T DO THIS
public class GearBox {

	private boolean clutchIsIn;
	
	//an interface is a contract specifying that the method signatures will not change!
	public void operateClutch(boolean inOrOut) {
		this.clutchIsIn = inOrOut;
	}
	
	
	//inOrOur == either in or out
	public void operateClutch(String inOrOut) {
		
		this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
	}
}
