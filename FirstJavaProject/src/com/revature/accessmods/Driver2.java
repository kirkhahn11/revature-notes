package com.revature.accessmods;

public class Driver2 {

	// we'll set fields of THIS class equal to the value of the Driver1 obj
	
	public Driver1 d1 = new Driver1();
	
	int y = d1.publicField;
//	int x = d1.privateField unaccessible because of private modifier 
	int z = d1.protectedField;
	int a = d1.defaultField;
}
