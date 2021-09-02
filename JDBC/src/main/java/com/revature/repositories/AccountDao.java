package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao implements IAccountDao{

	private static Logger log = Logger.getLogger(AccountDao.class);

	@Override
	public int Insert(Account a) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO kirkh.accounts (balance, acc_owner) VALUES (?, ?) RETURNING kirkh.accounts.id";
			
			//prepared statement
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setDouble(1, a.getBalance());
			stat.setInt(2, a.getOwnerId());
			
			ResultSet rs;
			if((rs = stat.executeQuery()) != null) {
				
				rs.next();
				int id = rs.getInt(1);
				return id;
			}
			
		} catch(SQLException e) {
			log.warn("Unable to insert Account");
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	@Override
	public List<Account> findByOwner(int userId) {
		List<Account> ownedAccounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT kirkh.accounts.id, kirkh.accounts.balance FROM kirkh.accounts\n"
					+ "	INNER JOIN kirkh.users_account_jt \n"
					+ "		ON kirkh.accounts.id = kirkh.users_account_jt.account 	\n"
					+ "			WHERE kirkh.users_account_jt.acc_owner = ?;"; //this will have to be a joins
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, userId);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				
				Account a = new Account(id, balance);
				if(!ownedAccounts.contains(a)) {
				ownedAccounts.add(a);
				}
			}
			
			stat.setInt(1, userId);
		} catch (SQLException e) {
			log.warn("SQL Exception occured when querying all accounts");
			e.printStackTrace();
		}
		
		return ownedAccounts;
	}

	@Override
	public List<Account> findAll() { // here we are making an actual query
		BasicConfigurator.configure();
		//start with an empty ArrayList of accounts
		List<Account> accountList = new ArrayList<Account>(); 
		//obtain connection with try-with-resources
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement stat = conn.createStatement();
			String sql = "SELECT * FROM accounts";
		
			ResultSet rs = stat.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id"); // you can specify the column number or name
				double balance = rs.getDouble("balance");
				
				Account a = new Account(id, balance);
				accountList.add(a);
			}
		} catch (SQLException e) {
			log.warn("SQL Exception occured when querying all accounts");
			e.printStackTrace();
		}
		//create statement + sql string
//		
		
		// send the statement to the DB
		
		//iterate through the response... while(rs.next())
		
			// grab data on each row for the account 
		
		// construct the account object
		
		//add the account object to the list 
		
		// then we have to use the ResultSet to iterate over the returned data set and create a list of account objects

		// return the account list 
		return accountList;
	}

	@Override
	public List<Account> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
