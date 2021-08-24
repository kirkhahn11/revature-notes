package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		
		// a reference type is a "custom type". This is a user defined class
		Person p1 = new Person("Kirk", 30, 64, 160.56);
		
		System.out.println(p1);
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		
		System.out.println(Person.MAX_AGE); //Invoking a static variable

		
		System.out.println("Fred's BMI is " + p1.calculateBMI());
		
		// 2 Separate objects are being instantiated
		Employee e1 = new Employee("Bob", 2, 3, 5, "Finance");
		Employee e2 = new Employee("Bob", 2, 3, 5, "Finance");
		
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		// what if I want to put Employee objects inside of a data structure (some type of a Set(no duplicates))
		
		System.out.println(e1 == e2);
	}

}
