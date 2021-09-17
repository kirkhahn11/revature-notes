package com.revature;

import java.lang.reflect.Method;

public class ClassInspector {

	// here we will use Reflection
	public static void listDeclaredMethods(Class<?> clazz) {
		
		System.out.println("Listing all the declared methods of class" + clazz.getName());
		Method[] methods = clazz.getDeclaredMethods();
		
		if(methods.length == 0) {
			System.out.println("\t There are no no methods in the class: " + clazz.getName());
		}
		
		for(Method method : methods) {
			
			// we don't want to see inherited methods
			if(method.getDeclaringClass() == Object.class) {
				continue;
			}
			
			System.out.println("\nMethod name: " + method.getName());
			System.out.println("\nMethod param count: " + method.getParameterCount());
			System.out.println("\nMethod declared class: " + method.getDeclaringClass());
			System.out.println("\nMethod declared annotations: " + method.getDeclaredAnnotations());
			
			
		}
	}
}
