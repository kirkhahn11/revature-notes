package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @throws Throwable 
	 * @Around is an advice type which ensures that an advice can 
	 * run before and after method execution
	 */
	
	// declare the advice with @Around 
	// declare the pointcut 
	@Around("com.revature.aspect.JoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint pJoinPoint) throws Throwable {
		// capture the start time and the end time of the method
		long start = System.currentTimeMillis();
		
		// we have to give the method permission to continue executing
		pJoinPoint.proceed();
		
		long totalTime = System.currentTimeMillis() - start;
		// log the difference between the two
		logger.info("Time taken by {} is {}", pJoinPoint, totalTime);
	}

	// GOAL: Have this aspect intercept any method that has our special annotation
}
