package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDao implements IUserDao{

	private static Logger log = Logger.getLogger(UserDao.class);
	
	@Override
	public int insert(User u) {
		BasicConfigurator.configure();
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			// We start with a SQL string
			
			String sql = "INSERT INTO kirkh.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING kirkh.users.id";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, u.getUsername());
			stat.setString(2, u.getPassword());
			
			// enum is... tough. Custom types == OTHER
			stat.setObject(3, u.getRole(), Types.OTHER);
			
			ResultSet rs; // our SQL statement will return a value! We need to iterate over it
			
			if((rs = stat.executeQuery()) != null) {
				rs.next();
				
				int id = rs.getInt(1);
				
				log.info("Successfully inserts at Id " + id);
				return id; 
			}
			
			
		} catch (SQLException e) {
			log.error("Unable to insert User");
			e.printStackTrace();
		}
		
		return -1; // if something doesnt go right 
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
