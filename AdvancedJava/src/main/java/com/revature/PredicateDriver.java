package com.revature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.model.Employee;

public class PredicateDriver {

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
		
		// anon class
		printEmployeesByAge(employees, "All Employees under 50", new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				
				return e.getAge() < 50;
			}
			
		});
		
		// lambda 
		printEmployeesByAge(employees, "All Employees over 30", e -> e.getAge() > 30);
		
		
		/**
		 * Primitive functional interfaces. Predefine Predicates for specific data types
		 */
		System.out.println("===========================");
		IntPredicate greaterThan15 = i -> i > 15;
		System.out.println("is 10 greater than 15? : " + greaterThan15.test(10));
		
		IntPredicate lessThan100 = i -> i > 100;
		
		//PREDICATE Chaining involves the .and method
		System.out.println(lessThan100.and(greaterThan15).test(78));
		
		//useful for handling iterations over a custom list
		Iterator<Employee> it = employees.iterator();
		System.out.println(it.next());
	}
	
	
	private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		
		//this represents conditions by which we're sorting the employees by their age
		System.out.println(ageText);
		
//		for(Employee e : employees) {
//			if(ageCondition.test(e)) {
//				System.out.println(e.getName() + " is " + e.getAge() + " years old.");
//			}
//		}
		employees.forEach((e) -> {
			if(ageCondition.test(e)) {
				System.out.println(e.getName() + " is " + e.getAge() + " years old.");
			}
		});
	}

}
