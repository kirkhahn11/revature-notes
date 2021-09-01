package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;
import com.revature.repositories.UserDao;
import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		// TODO Auto-generated method stub

		ConnectionUtil.getConnection();
//		
//		User u1 = new User("Batman", "pass", new ArrayList<Account>(), Role.Admin);
//		
//		UserDao ud = new UserDao();
//		
//		int didItExecuteCorrectly = ud.insert(u1);
//		
//		System.out.println(didItExecuteCorrectly);
		
		IAccountDao adao = new AccountDao();
		
		List<Account> account = adao.findAll();
		System.out.println(account);
		
		System.out.println(adao.findByOwner(5));
	}

}
