package com.revature;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class AdvancedSpellChecker implements SpellChecker{

	public void checkSpelling(String str) {
		if(str != null) {
			System.out.println("Checking spelling using AdvancedSpellChecker");
			// determining the language of the email
			// checking grammatical errors and spellings 
			System.out.println("Spell Checking Completed!");
		} else {
			throw new RuntimeException("An exception occured while checking spelling.");
		}
	}
}
