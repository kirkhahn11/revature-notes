package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * A java bean is a type of POJO, but more specific and specialized
 * 
 * it's searilaizable
 * have getters/setters
 * have an overriden haschode() and equals() method
 * @author kirkhahn
 *
 */
public class Employee extends Person implements Serializable{

	// all the properties of Person are present in Employee
	
	private String dept;

	// calling the super() from the Person class
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " dept =" + dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}


	
	// all the getters and setters already exist from the Person class because of inheritance
	
	
}
