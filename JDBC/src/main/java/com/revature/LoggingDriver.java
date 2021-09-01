package com.revature;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * demo class
 * @author kirkhahn
 *
 */
public class LoggingDriver {

	// Step 1. Make a Logger for the class
	private static Logger log = Logger.getLogger(LoggingDriver.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		log.info("Application has started!");
		
		try {
			recurse();
		} catch(Error err) {
			log.error("Something has gone horribly wrong");
		}
		
		log.info("Application has successfully completed!");
	}
	
	public static void recurse() {
		recurse();
	}
}
