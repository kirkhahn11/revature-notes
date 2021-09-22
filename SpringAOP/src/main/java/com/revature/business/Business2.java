package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

@Service
public class Business2 {

	// business layer depends on the dao!
	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething() {
		// strenuous business logic
		return dao2.retrievSomething();
	}
}
