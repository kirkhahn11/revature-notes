package com.revature.scopes;

/**
 * in Java there are 4 scopes
 * 
 * 1. Class Scope (Global Scope)
 * 2. Instance Scope (variables that belong to an individual object)
 * 3. Method Scope 
 * 4. Block Scope (most private) 
 * 
 * the term "field" refers to a static or instance scope variable
 * the term "local variable" refers to a method or block scope
 * @author kirkhahn
 *
 */
public class Driver {

	public static void main(String[] args) {

		// cannont access mc variable in another method === method scope
		MyClass mc = new MyClass();
		
		int x = MyClass.myStaticVar;
		
		double z = mc.myInstanceVar;
		
		// Static variables are not allowed inside of a method
		
		int m = 5;
		
		while (m > 0) {
			// declared in the block scope
			// can't access "result" outside of block
			int result = m * m;
			System.out.println(result);
			m--;
		}
	}

}
