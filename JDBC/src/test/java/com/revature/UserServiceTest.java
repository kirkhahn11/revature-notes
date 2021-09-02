package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.services.UserService;

// testsuite 
public class UserServiceTest {

	private UserService uservice;
	
	//declare the DEPENDENCIES of the userservice 
	//We will be using Mockito to "mock" the dao later, that the UserService is dependent on
	private UserDao mockdao;
	
	User dummyUser;
	
	@Before // before every test is run
	public void setUp() {
		
		uservice = new UserService();
		
		//mock the dependency that's provided to the UserService
		mockdao = mock(UserDao.class);
		
		// every UserService has a DAO that it relies on...
		uservice.udao = mockdao;
		
		// this is a stub == object for testing purposes
		dummyUser = new User();
		dummyUser.setAccounts(new ArrayList<Account>());
		dummyUser.setId(0);
		
	}
	
	@After 
	public void tearDown() {
		uservice = null;
		dummyUser = null;
		mockdao = null;
	}
	
	
	// whenever we insert a user, it returns a valid primary key
	// if it were NOT returning the right key, we'd have some major problems
	@Test
	public void testRegisteredUser_returnsNewPk() {
		BasicConfigurator.configure();
		dummyUser= new User(0, "Spongebob", "Sandy", Role.Admin, new ArrayList<Account>());
		
		// Generate a hard coded random primary key that will be returned by the mockdao's insert method
		Random r = new Random();
		int fakePk = r.nextInt(100);
		
		//intercepts the UserService's call to the DAO layer
		when(mockdao.insert(dummyUser)).thenReturn(fakePk); // this user should never be inserted into the DB
		
		User registeredUser = uservice.register(dummyUser);
		assertEquals(registeredUser.getId(), fakePk);
		
	}
	
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_idGreaterThanZero_throwsException() {
		BasicConfigurator.configure();
		// here we try registering a User whoseid is > 0
		
		List<Account> accounts = new ArrayList<Account>();
		Account a = new Account();
		a.setBalance(7000);
		
		accounts.add(a);
		
		dummyUser = new User(23, "Bob", "pass", Role.Customer, accounts);
		
		uservice.register(dummyUser);
	}
	
	
	
}
