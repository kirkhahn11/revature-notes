package com.revanture.models;

public class Course {

	private String name;
	public static final double costOfCourse = 600.00;
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	
}
