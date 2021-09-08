package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.revature.model.Employee;

public class ComparatorDriver {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<Employee>();
		
		Employee zayn = new Employee("Zayn Smith", 40);
		Employee marry = new Employee("Mary Shelly", 60);
		Employee abby = new Employee("Abby McCormick", 30);
		Employee xavier = new Employee("Xavier Hall", 25);
		
		employees.add(zayn);
		employees.add(marry);
		employees.add(xavier);
		employees.add(abby);
		
		// here we are providing the functionality for the Consumer interface which is 
		// implemented by the forEach method
		employees.forEach((e) -> System.out.println(e));
		
		// this is a comparable object
		NameSorter ns = new NameSorter();
		
		Collections.sort(employees, ns);
		
		System.out.println("==============================");
		
		employees.forEach((e) -> System.out.println(e));

		
		// Challenge 1: call the Collections.sort method and create a Comporator anonymous class to sort in DESCENDING order
		System.out.println("=========================");
		Collections.sort(employees, new Comparator<Employee>() {
			
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp2.getName().compareTo(emp1.getName());
			}
			
		});
		employees.forEach((e) -> System.out.println(e));

		// Challenge 2: call the Collections.sort method and create a lambda function to sort employees by age in ASCENDING order
		System.out.println("=============================");
		Collections.sort(employees, (emp1, emp2) -> Integer.valueOf(emp1.getAge()).compareTo(emp2.getAge()));
		employees.forEach((e) -> System.out.println(e));

	}
		

}

//we need to define a Comparator
	// when we use the Comparator, we define an external class to the object we want to sort
	// We implement the comparator interface on this class and then override the compare() method
	//(This is different than the compareTo() method from the comparable interface)
	

class NameSorter implements Comparator<Employee> {

	// we are sorting by NAME 
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getName().compareTo(emp2.getName());
	}
}
