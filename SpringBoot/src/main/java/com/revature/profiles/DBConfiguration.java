package com.revature.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	
	@Profile("dev")
	@Bean
	public String DevDatabaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for DEV - H2";
	}
	
	@Profile("test")
	@Bean
	public String TestDatabaseConnection() {
		System.out.println("DB connection for TEST - low cost RDS instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for TEST - low cost RDS instance";
	}
	
	@Profile("prod")
	@Bean
	public String ProdDatabaseConnection() {
		System.out.println("DB connection for PROD - High performance RDS instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for PROD - High performance RDS instance";
	}
	
	
}
