package com.revature.abstraction;

//must implement abstract methods if extending abstract classes
public class Cat extends Animal{

	private String breed;
	private boolean hasFur;
	
	@Override
	public void makeSound() {
		System.out.println("MEOW!");
	}
	
	public Cat() {
		super();
		this.hasFur = true;
		System.out.println("Cat has been created");
	}

	
	// getters and setters
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public String toString() {
		return "Cat [breed=" + breed + ", hasFur=" + hasFur + "]";
	}
	
	
}
