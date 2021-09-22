package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.annotation.TrackTime;
import com.revature.data.Dao1;

@Service
public class Business1 {

	// business layer depends on the dao!
	@Autowired
	private Dao1 dao1;
	
	@TrackTime
	public String calculateSomething() {
		// strenuous business logic
		return dao1.retrievSomething();
	}
}
