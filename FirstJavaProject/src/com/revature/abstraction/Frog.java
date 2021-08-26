package com.revature.abstraction;

//java does not support multi-inheritance = only 1 class can be inherited
public class Frog extends Animal implements Ectothermic, Amphibious{

	@Override
	public void makeSound() {
		System.out.println("ribbit ribbit");
		
	}
	
	// overloading 
	public void makeSound(int times) {
		for(int i = 0; i < times; i++) {
			System.out.println("ribbit...");
		}
		
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void swim() {
		
	}
}
