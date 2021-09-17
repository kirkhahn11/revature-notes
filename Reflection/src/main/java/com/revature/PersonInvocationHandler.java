package com.revature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.something.Person;

//this is a Dynamic Proxy Design Pattern
// A proxy is an "add-on" to a class, that allows us to intercept method invocation and modify runtime behavior
public class PersonInvocationHandler implements InvocationHandler{
	
	//declare the interface we are overriding 
	private Person person;
	
	//create a constructor for the proxy object so we can instantiate the object
	public PersonInvocationHandler(Person person) {
		super();
		this.person = person;
	}
	
	// Using this method, we can modify the behavior of a class using reflection
	public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
		
		//here were adding extra functionality (a message) and still invoking the original method 
		System.out.println("Hello");
		
		//the invoke method has access to the originally invoked methods and all its arguments 
		return method.invoke(person, args);
	}


}
