package com.revanture.util;

import com.revanture.exceptions.NotAGradeException;
import com.revanture.models.Student;

// all this class is, is a place for useful methods
public class UtilityMethods {

	public static void validateGradeYear(int gradeYear) throws NotAGradeException {
		
		if(gradeYear <= 0 || gradeYear > 4) {
			throw new NotAGradeException("Please Enter a valid grade number between 1 and 4");
		}
	}
	
	public static void printStudentInfo(Student[] arr) {
		for(Student s : arr) {
			s.showStatus();
		}
	}
}
