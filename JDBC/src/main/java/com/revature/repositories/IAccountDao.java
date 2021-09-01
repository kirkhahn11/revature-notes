package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {

	int Insert(Account a); //returns the primary key
	List<Account> findByOwner(int userId);
	List<Account> findAll();
	List<Account> findById(int id);
	boolean update(Account a);
	boolean delete(int id);
}
