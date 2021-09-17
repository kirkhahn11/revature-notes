package com.revature;

import java.lang.reflect.Proxy;
import java.util.Scanner;

import com.something.Adult;
import com.something.Person;

public class Driver {

	public static void main(String[] args) {

		Adult a1 = new Adult("Kirk", 29, "Coahoma", "Texas");
		ClassInspector.listDeclaredMethods(Adult.class);
		// I want to modify the method at runtime
		// I can't because the code belongs to someone else (external framework)
//		a1.introduce();
		
		/**
		 * Reflection API is used to examine and modify the behaviors of method, classes, and interfaces
		 * 
		 */
		// Get a classloader from the origional object that we want to create a proxy for
		ClassLoader a1ClassLoader = a1.getClass().getClassLoader();
		
		//capture all the interfaces that the original object implements 
		Class[] interfaces = a1.getClass().getInterfaces();
		
		//create a proxy for our Adult object 
		Person proxyA1 = (Person) Proxy.newProxyInstance(a1ClassLoader, interfaces, new PersonInvocationHandler(a1));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a method for Kirk the object to do! either introduce or sayAge");
		String method = scan.next();
		
		if(method.equals("introduce")) {
			
		proxyA1.introduce();
		} else if(method.equals("sayAge")) {
			a1.sayAge();
		}
		

	}

}
