package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.LoggingDriver;

// Singleton design pattern instantiates an object ONCE

/**
 * Singleton design pattern
 * 
 * -- private constructors
 * -- static field of an instance of the class to be returned
 * -- leverage a public static getInstance() (our's is the getConnection() method)
 * @author kirkhahn
 *
 */
public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(LoggingDriver.class);

	private static Connection conn = null;
	
	// we want to make the constructor PRIVATE = to control instantiation
	private ConnectionUtil() {
		super();
	}
	
	// in a singleton design we create static getInstyance() method
	public static Connection getConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				log.info("returned connection");
				return conn;
			}
		} catch (Exception e) {
			return null;
		}
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("/Users/kirkhahn/Desktop/revature-notes/JDBC/src/main/resources/application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			
			log.info("Database Connection Established");
		} catch (FileNotFoundException e) {
			log.error("Cannot establish database connection");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Cannont locate application.properties file.");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("Failed to re-use a connection.");
			return null;
		}
		
		return conn;
	}
}
