package com.revature.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JoinPointConfig {

	@Pointcut("execution(* com.revature.business.*.*(..))")
	public void businessLayerExecution() {
		// Now we just pass this to the qualified name of the method to specific aspects
	}
	
	@Pointcut("execution(* com.revature.business.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("com.revature.aspect.JoinPointConfig.businessLayerExecution() && com.revature.aspect.JoinPointConfig.dataLayerExecution()")
	public void allLayerExecution() {}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {}
	
	@Pointcut("within(com.revature.data..*)")
	public void dataLayerExecutionWithin() {}
	
	@Pointcut("@annotation(com.revature.annotation.TrackTime)")
	public void trackTimeAnnotation() {}
}
