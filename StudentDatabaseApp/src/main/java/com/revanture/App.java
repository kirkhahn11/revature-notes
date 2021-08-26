package com.revanture;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revanture.exceptions.NotAGradeException;
import com.revanture.models.Student;
import com.revanture.util.UtilityMethods;

public class App {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
			
		run();
		
		}

	
	public static void run() {

		//Step 1. promp the user for how many students to enter
		System.out.println("What is the total number of students?");
		int capacity = scan.nextInt();
		// get the capacity for an array of Student objects
		Student[] studentArray = new Student[capacity];
		// iterate over the array and for each object, we promp the use for all object details
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println("Please enter the students first name");
			String firstName = scan.next();
			System.out.println("Please enter the students last name");
			String lastName = scan.next();
			System.out.println("Please enter the students grade year: \n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior");
			int gradeYear = 0;
			boolean isValidInput = false;
			
			while(!isValidInput) {
			try {
				gradeYear = scan.nextInt();
				UtilityMethods.validateGradeYear(gradeYear);
				isValidInput = true;
			} catch (NotAGradeException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException ex) {
				System.out.println("Just encountered a " + ex + ". Please enter a valid number between 1 - 4");
			} finally {
				scan.nextLine();
			}
			}
			
			studentArray[i] = new Student(firstName, lastName, gradeYear);
			
			studentArray[i].enroll();
		}
		
		UtilityMethods.printStudentInfo(studentArray);
	}
}


