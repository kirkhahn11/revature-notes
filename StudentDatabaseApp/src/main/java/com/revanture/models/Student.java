package com.revanture.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

	private static Scanner scan = new Scanner(System.in);
	private static int globalId = 1000; //every time a student is instantiated, id will increase by 1
	//firstname
	//lastname
	//gradeYear
	//studentId
	//list of courses
	//tuition balance
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId; //string because of concatenating grade year to an auto generated id
	private List<Course> courses = new ArrayList<Course>();
	
	// here we are declaring a DYNAMIC datastructure and inferring generics
	// ArrayLists allow us to add and remove with ease
	
	private double tuitionBalance = 0;

	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		setStudentId(gradeYear);
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + "]";
	}

	private void setStudentId(int gradeYear) {
		this.studentId = gradeYear + "" + globalId;
		globalId++;
	}
	
	public void enroll() {
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		boolean isDone = false;
		while(!isDone) {
			System.out.println("Enter a course to enroll in: \nEnter q to exit.");
			
			String courseName = scan.next();
			// if the user presses q to quit, we quit out of the loop..
			if(!courseName.equalsIgnoreCase("q")) {
				Course newCourse = new Course(courseName);
				
				coursesToAdd.add(newCourse);
				tuitionBalance += Course.costOfCourse;
				
				scan.nextLine();
			} else {
				//if they hit "q"
				System.out.println("===== quitting ======");
				isDone = true;
			}
		}
		
		courses = coursesToAdd;
		
		System.out.println("ENROLLED IN: " + courses.toString());
	}
	
	public void viewBalance() {
		System.out.println("Your balance is $" + tuitionBalance);
	}
	
	public void showStatus() {
		System.out.println("\nName: " + firstName + " " + lastName + "\nStudent ID: " + studentId+ "\nCourses enrolled in: " + courses.toString() + "\nTuition: " + tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		
		System.out.println("Enter your payment amount: ");
		
		double payment = scan.nextDouble();
		
		tuitionBalance -= payment;
		
		System.out.println("Thank you for your payment of " + payment);
		
		viewBalance();
	}
	/**
	 * Methods
	 * enroll()
	 * viewBalance()
	 * showStatus()
	 * payTuition()
	 */
}
