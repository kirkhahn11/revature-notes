package com.revature.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;

@Service //telling spring (with a stereotype annotation) what type of job this bean does
public class UserService {

	@Autowired
	UserDao userDao;
	
	//findAll
	public Set<User> findAll() {
		List<User> list = userDao.findAll();
		return list.stream()
				.collect(Collectors.toSet());
	}
	
	//findByUsername
	public User findByUsername(String username) {
		return userDao.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No User found with Username " + username));
	}
	
	//findById
	public User findById(int id) {
		return userDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Cant find the user with the Id " + id));
	}
	
	//insert
	public User insert(User u) {
		// add some logic to make sure the user is not null
		
		return userDao.save(u);
	}
}
