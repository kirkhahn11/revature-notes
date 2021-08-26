package com.revature.abstraction;

public interface Ectothermic {

	
	//by default all methods within an interface are abstract and public
	//all attributes (fields) of an interface are by default public, static, and final
	
	public static final int MIN_TEMP = -40;
	public static final int MAX_TEMP = 90;
	
	void heatUp();
	
	void coolDown();
	
	// default methods can be included with body
	default void saySomething() {
		System.out.println("Something is being said from the default method in the interface");
	}
}
