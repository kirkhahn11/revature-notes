package com.revature.data;

import org.springframework.stereotype.Repository;

// offshoot of Component annotation that denotes the class is a DAO class
@Repository
public class Dao2 {

	public String retrievSomething() {
		return "Dao2";
	}	
}
