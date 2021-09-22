package com.revature.data;

import org.springframework.stereotype.Repository;

import com.revature.annotation.TrackTime;

// offshoot of Component annotation that denotes the class is a DAO class
@Repository
public class Dao1 {

	@TrackTime
	public String retrievSomething() {
		return "Dao1";
	}	
}
