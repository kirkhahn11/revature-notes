package com.revature.abstraction;

public interface Callable {

	void powerOn();
	void dial(int phoneNumber);
	boolean callPhone(int phoneNumber);
	boolean isRinging();
}
