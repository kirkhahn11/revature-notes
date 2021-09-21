package com.revature;

import org.springframework.context.annotation.ComponentScan;

// This class does literally the same thing that the Beans.xml file does when it loads
@ComponentScan(basePackages = "com.revature") //searches for all classes with the component annotation
public class AppConfig {

//	@Bean(name = "basicSpellChecker")
//	public BasicSpellChecker createBasicSpellChecker() {
//		
//		return new BasicSpellChecker();
//	}
//	
//	@Bean(name = "advancedSpellChecker")
//	public AdvancedSpellChecker createAdvancedSpellChecker() {
//		
//		return new AdvancedSpellChecker();
//	}
//	
//	@Bean(name = "emailClient")
//	public EmailClient createEmailClient() {
//		
//		EmailClient emailClient = new EmailClient();
//		
//		//use setter injection
//		emailClient.setSpellChecker(createAdvancedSpellChecker());
//		
//		return emailClient; 
//	}
	
	// 2 Types of Dependency Injection
	// 1. Constructor Injection
	// 2. Setter Injection
}
