package com.revature.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
//Apache commons dbcp gives us the functionality to create the connection pool. But we have to do so
// by using its specific class and functionality called GenericObjectPool

/**
 * Connection pooling means that connections are REUSED rather than created
 * each tie a connection is requested
 * 
 * in order to facilitate a connection reuse, a memory cache of database connectinos 
 * called a CONNECTION POOL, is maintained by a connection pooling module
 * as a layer on top of any standard JDBC driver product
 *
 */
public class ConnectionPool {

	/**
	 * We will use this class to supply general database credentials and attain
	 * and object called GenericObjectPool (usually called gpool)
	 * 
	 * gPool is a special object that holds all the connections to our database at once
	 * 
	 */
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String JDBC_db_url = "jdbc:postgresql://localhost:5432/postgres";
	static final String JDBC_USER = "postgres";
	static final String JDBC_PASS = "";
	
	// ^^This will be added to properties file with is .gitignore!!
	
	private static GenericObjectPool gPool = null;
	
	public DataSource setUpPool () throws Exception {
		//We use the DataSrouce Interface to create a connection object that participates in connection pooling
		
		Class.forName(JDBC_DRIVER);
		
		// create an instance of the GenericObjectPool that holds our pool of connection objects
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		
		// Create a ConnectionFactory object which will be used by the pool to create the connections (which are all objects)
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_db_url, JDBC_USER, JDBC_PASS);
		
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
	}
	
	public GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	// for our own benefit, create a method to print the connection pool status
	public void printDbStatus() {
		System.out.println("Max: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + 
				"; Idle: " + getConnectionPool().getNumIdle());
	}
}
