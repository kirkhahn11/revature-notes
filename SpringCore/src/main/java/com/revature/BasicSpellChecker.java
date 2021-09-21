package com.revature;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//primary tag makes basicspellchecker the default when injecting class into an object
@Component
public class BasicSpellChecker implements SpellChecker {

	
	public void checkSpelling(String str){
		if(str != null) {
			System.out.println("Checking spelling using BasicSpellChecker");
			System.out.println("Spell Checking Completed!");
		} else {
			throw new RuntimeException("An exception occured while checking spelling.");
		}
	}
}
