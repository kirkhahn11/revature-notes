package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Declare that it is an aspect
// configure
@Aspect
@Configuration //declares something that will interact with beans in the spring App
public class BeforeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//define what type of method to intercept and WHEN (before)
	@Before("execution(* com.revature.business.*.*(..))") // we have provided a Pointcut
	public void before(JoinPoint joinPoint) { //JoinPoint = the object (method, field) where the aspect is plugged in
		//define what we do when we intercept the method (logging info about what's happening) 
		logger.info("Intercepted Method call {}", joinPoint);
		
		//Aspect = pointcut (where to cut in(after Before annotation)) + advice (what to do)
	}
	
}
