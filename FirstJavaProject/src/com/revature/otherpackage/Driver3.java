package com.revature.otherpackage;

import com.revature.accessmods.Driver1;

public class Driver3 extends Driver1 { //by extending we inherit fields and behaviors of the parent class
	
	Driver3 d3 = new Driver3();
	int k = d3.protectedField; // this field is inherited automatically from Driver1 because of extends keyword
	
//	int j = d3.defaultField; we can't inherit that because it's default

	int i = d3.publicField;
}
