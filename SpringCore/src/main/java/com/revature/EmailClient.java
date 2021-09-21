package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//an important reusable portion of our code 
@Component
public class EmailClient {
	
	// This is a property for Spring 
	
	//autowired makes the property necessary to be injected into a class
	@Autowired
	@Qualifier("advancedSpellChecker")
	private SpellChecker spellChecker;
//	private BasicSpellChecker bsc;
	
//	public EmailClient(SpellChecker spellChecker) {
//		this.spellChecker = spellChecker; //at runtime, the type of spellchecker will be determined
//										// by the class i pass in at instantiation 
//	}
	
	void sendEmail(String emailMessage) {
		// call a spell checker to check the message before sending
		spellChecker.checkSpelling(emailMessage);
		//imagine the logic for sending the message below
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
	
	
}
