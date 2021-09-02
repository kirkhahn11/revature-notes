package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class App {

	public static void main(String[] args) {
		BasicConfigurator.configure();

		menu();

	}

	public static void menu() {
		
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! If you are a customer please press 1. /n If you would like to login please press 2.");
		
		// prepare errors for improper inputs 
		int input = scan.nextInt();
		
		if(input == 1) {
			// create a new user..
			System.out.println("Enter your username");
			String username = scan.next();
			
			System.out.println("Enter your password");
			String password = scan.next();
			
			User u = new User(0, username, password, Role.Customer, new ArrayList<Account>());
			
			u = userv.register(u);
			
			System.out.println("Would you like to open an account? Y/N");
			
			String yesOrNo = scan.next();
			System.out.println(u.getId());
			if(yesOrNo.equalsIgnoreCase("y")) {
				
				for(int i = 0; i < 2; i++) {
					System.out.println("Opening account #" + i++);
					aserv.openAccount(u);
				}
			}
		} else {
			System.out.println("goodbye");
			System.exit(0);
			// call some userv.login() method 
		}
		
	}
}
