package com.revature.controlflow;


import java.text.DecimalFormat;
import java.util.Scanner;

public class GradingClacChallenge {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the max possible points");
		
		double totalPossiblePoints = scan.nextDouble();
		
		System.out.println("Enter the points recieved");
		
		double actualPoints = scan.nextDouble();
		
		double grade = calcGrade(totalPossiblePoints, actualPoints);
		
		String letterGrade;
		
		if(grade >= 90) {
			letterGrade = "A";
		} else if (grade >= 80) {
			letterGrade = "B";
		} else if (grade >= 70) {
			letterGrade = "C";
		} else if (grade >= 60) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		DecimalFormat df = new DecimalFormat("###.#");
		
		System.out.println("The Students Letter grade is " + letterGrade + ". That's " + df.format(grade) + "% !");
		
		scan.close();
	}
	
	public static double calcGrade(double total, double actual) {
		return ((actual / total) * 100);
	}

}
