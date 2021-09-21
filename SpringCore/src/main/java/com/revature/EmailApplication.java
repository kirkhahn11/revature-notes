package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmailApplication {

	public static void main(String[] args) {

//		EmailClient emailClient = new EmailClient(new AdvancedSpellChecker());
		// below is XML configuration
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		//AppConfig class
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// to instantiate an EmailClient bean
		// A Spring Bean is nothing more than a Java Pojo that is managed by the 
		EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
		
		emailClient.sendEmail("Hey, " + 
				"This is my first email message.");
		
		emailClient.sendEmail("Hey, " + 
				"This is my second email message.");
	}

}
