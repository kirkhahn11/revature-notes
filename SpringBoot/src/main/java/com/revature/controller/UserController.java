package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController // specific type of controller that assumes we're returning a response body
@RequestMapping("/users") // all methods and endpoints exposed at http://localhose:8090/api/users
public class UserController {

	//our controller needs to call its dependency, which is our user service
	@Autowired
	UserService userService;
	
	/**
	 * if someone sends a GET request to our endpoint
	 * They retrieve all users
	 */
	

	@GetMapping
	public ResponseEntity<Set<User>> findAll() {
		// I can also add specific response information
		// ResponseEntity allows us to send back custom HTTP status and headers within the HTTP response
		return ResponseEntity.ok(userService.findAll());
	}
	
	// GET request that reads the id from the query parameter
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		// call the service method, pass the captured id through, and return it as a response entity with 200 ok status
		return ResponseEntity.ok(userService.findById(id));
	}
	
	// Create a method that finds the user by their username
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(userService.findByUsername(username));
	}
	
	
	@PostMapping("/add")				//Valid annotation requieres the user to comply with the restrictions we set in the model
	public ResponseEntity<User> addUser(@Valid @RequestBody User u){ // we're taking in the User object in the http request body
		
		return ResponseEntity.ok(userService.insert(u));
	}
	
	
}
