package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperVillianDao;
import com.revature.models.Crime;
import com.revature.models.SuperVillian;

public class App {

	static CrimeDao cdao = new CrimeDao();
	static SuperVillianDao svdao = new SuperVillianDao();
	
	public static void main(String[] args) {
		
		System.out.println("Starting the program....");
		
		Crime c1 = new Crime("Arson", "Setting the city ablaze");
		Crime c2 = new Crime("Freeze", "covering the city in ice");
		Crime c3 = new Crime("Time Manipulation", "freezin' time, robbin' banks");
		
		System.out.println("Inserting the transient objs into the DB with the .save() session method.....");
		
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);
		
		List<Crime> crimeList = new ArrayList<Crime>();
		crimeList.add(c1);
		crimeList.add(c2);
		crimeList.add(c3);
		
		SuperVillian joker = new SuperVillian("Joker", "evilness", 300_000_000, crimeList);
		
		svdao.insert(joker);
		System.out.println("Retrieving all Villian Objects");
		
		//Printing out each villian object within the returned list
		svdao.selectAll().forEach(System.out::println);
		
		
		System.out.println("Ending the program......");
	}

}
