package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	private static Scanner scan = new Scanner(System.in);
	// Inject the dependency that Account Service needs to persist data
	public IAccountDao adao = new AccountDao();
	
	// create an openAccount method that will include a scanner and call the adao.insert() method
	
	public Account openAccount(User u) {
		// prompts for initial deposit
		System.out.println("How much would you like to deposit?\n");
		double balance = scan.nextDouble();
		
		// it reads back to the user 
		System.out.println("You made an initial deposit of $" + balance + "!");
		
		//it creates a new account with the User's id as the accounts owner id property
		Account a = new Account(0, balance, u.getId());
		// then i called the adao.insert method to persist the account to the DB
		int pk = adao.Insert(a);
		// grab the generated primary key from the insert method 
		a.setId(pk);
		return a;
		// return the full account object with its generated PK
	}
	
	public void viewAllAccountsByOwner(int ownerId) {
		for(Account a: adao.findByOwner(ownerId)) {
			System.out.println(a);
		}
	}
	
	public List<Account> findByOwner(int userId) {
		return adao.findByOwner(userId);
	}

}

