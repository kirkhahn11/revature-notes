package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;
import com.revature.repositories.IUserDao;
import com.revature.repositories.UserDao;

public class UserService implements IUserService {

	private static Logger log = Logger.getLogger(UserService.class);
	// DEPENDENCT INJECTIONS
	// Our service class is dependent on the DAO layer to provide persistence capability
	public User register(User u) { //if we insert a user from the consol it doesn't have an id yet
		// takes in User object
		log.info("Registering new user...");
		
		if(u.getId() != 0) {
			
			
			throw new RegisterUserFailedException("Recieved user Object did not have id of 0");
		}
		// calls the insert() method from the UserDao
		int generatedId = udao.insert(u);

		if(generatedId != -1 && generatedId != u.getId()) {
			// fairly certain that the INSERT operation was successful
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("Failed to insert the user");
		}
		log.info("Registration of user with id " + u.getId() + " was successful.");
		return u;
	}
	
	public User login(String username, String password) {
		// call some dao methods that check if this user exists, maybe return an array of all and iterate 
		//through each on to check user name and password are the same
		
		// use the findByUsername dao method, then check that that user has the same password as the one entered
		return null;
	}
	
	public void printAllUsers() {
		List<User> users = udao.findAll();
		
		users.forEach(u -> System.out.println(u));
	}
}
