package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//1: Configuration
// AOP

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	// pointcut - when?
	// execution(* PACKAGE.*.*(..))
	// execution(* com.in28minutes.learnspringapp.appexample.business.*.*(..))
	@Before("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		// logic - what to do
		logger.info("Before Aspect - {} is called with arguments - {}", joinPoint, joinPoint.getArgs());
	}
	
	@After("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
	public void logMethodCallAfterExection(JoinPoint joinPoint) {
		// logic - what to do
		logger.info("After Aspect - {} is called with arguments", joinPoint);
	}
	
	@AfterThrowing(pointcut = "execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))", 
			throwing = "exception" 
	)
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		// logic - what to do
		logger.info("After throwing - {} has thrown an exception {}", joinPoint, exception);
	}
	
	@AfterReturning(pointcut = "execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))",
			returning = "resultValue"
	)
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		// logic - what to do
		logger.info("After returning aspect- {} has returnValue {}", joinPoint, resultValue);
	}
}
