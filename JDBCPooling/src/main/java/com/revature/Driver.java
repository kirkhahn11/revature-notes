package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.revature.util.ConnectionPool;

public class Driver {

	public static void main(String[] args) throws SQLException {

		ResultSet rs = null;
		Connection connObj = null; 
		PreparedStatement pstmtObj = null;
		ConnectionPool jdbcObj = new ConnectionPool();
		
		// surround everything with a try/catch
		try {
			DataSource dataSource = jdbcObj.setUpPool();// initializing the pool
			jdbcObj.printDbStatus();
			
			//get the connection (from the pool)
			System.out.println("==============Making a new Connection Object for DB operation=========");
			connObj = dataSource.getConnection();
			
			// print the status using dbStatus();
			jdbcObj.printDbStatus();
			
			// use the fetch connection to execute a query (like select * from heros)
			pstmtObj = connObj.prepareStatement("SELECT * FROM heros");
			
			// iterate over the result set returned 
			rs = pstmtObj.executeQuery();
			while(rs.next()) {
				System.out.println("Hero name is " + rs.getString("hero_name"));
			}
			
			// release the db connection object back to the pool 
			System.out.println("===========RELEASING THE DB CONNECTION BACK TO THE POOL============");
			
			jdbcObj.printDbStatus();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connObj.close(); // close the specific connection so it can be sent back to the pool
			// this sends the connection to an idle state... can be used again
		}
		jdbcObj.printDbStatus();
	}

}
