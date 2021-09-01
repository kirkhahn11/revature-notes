package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

/** 
 * DAO is a data access object
 * 
 * it is used to separate persistance logic from business logic
 * DAO need all CRUD methods 
 * @author kirkhahn
 *
 */
public interface IUserDao {

	int insert(User u); // we aim to return the primary key of the user inserted into the DB
	User findByUsername(String username); // READ/GET method
	List<User> findAll();
	User findById(int id);
	boolean update(User u);
	boolean delete(int id);

}
