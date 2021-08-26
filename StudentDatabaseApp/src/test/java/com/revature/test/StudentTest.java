package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revanture.exceptions.NotAGradeException;
import com.revanture.models.Course;
import com.revanture.models.Student;
import com.revanture.util.UtilityMethods;

public class StudentTest {

	// declare some dummy objects
	
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@Before
	public void setUp() {
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("Math 101");
		c2 = new Course("History 400");
		
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	public void tearDown() {
		c1 = null;
		c2 = null;
		courses = null;
		
		dummyStudent = null;
	}
	
	@Test
	public void whenInstanciateStudent_thenIncrementStaticId() {
	
		dummyStudent = new Student("Kirk", "Hahn", 3);
		
		//Never set getter for student ID; unit test is telling us to improve code
		String actualId = dummyStudent.getStudentId();
		
		String expectedId = "31000";
		
		assertEquals(expectedId, actualId);
	}
	
	//we need to test exceptions as well!
	@Test(expected=NotAGradeException.class)
	public void badGradeYearThrowsANotAGradeException() {
		int badGradeYear = 7;
		
		UtilityMethods.validateGradeYear(badGradeYear);
	}
	
	@Test(expected=NotAGradeException.class) 
	public void negativeGradeYearThrowsANotAGradeException() {
		int negativeGradeYear = -4;
		
		UtilityMethods.validateGradeYear(negativeGradeYear);
	}
	
	
	// Create a test that checks a negative grade throws the notagrade exception
	
	// Create a test that checks InputMismatchException
	
	/**
	 * test driven development is when we write a test immediately after we write the method
	 * 
	 * typically 1 assertion per test
	 */
}
