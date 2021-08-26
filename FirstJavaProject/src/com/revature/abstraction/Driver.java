package com.revature.abstraction;

// abstraction is the process of hiding certain details and only showing essential information
// achieved with interfaces and abstract classes in Java
// you can instantiate either and abstract class or an interface
public class Driver {

	public static void main(String[] args) {

		// Animal is my reference type
		Animal a1 = new Cat();
		
		// I can now reassign this variable to any other object whose class extends Animal
		// will not work if the type was declared as Cat
		a1 = new Frog();
	}

}
