package com.revature.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

//class that represents a connection to the database
//only a single instance of this class is available during the use of the application
public class ConnectionFactory {

	private BasicDataSource ds;
	private static final ConnectionFactory connection_factory = new ConnectionFactory();

	static { // static initalizer loads before the main method
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}
	private ConnectionFactory() {
		try {
			Properties props = new Properties();
			props.load(new FileReader("src/main/resources/application.properties"));
			ds = new BasicDataSource();
			ds.setUsername(props.getProperty("username"));
			ds.setUrl(props.getProperty("url"));
			ds.setPassword(props.getProperty("password"));
			ds.setMinIdle(5);
			ds.setDefaultAutoCommit(false);
			ds.setMaxOpenPreparedStatements(100);
		} catch (IOException e) {
			// would log the file was not found
			// can create a custom logger using a BufferedReader and regex

		}
	}

	// this is a method to retreive a current static instance of the
	// ConnectionFactory class.
	public static ConnectionFactory getInstance() {
		return connection_factory;
	}

	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
