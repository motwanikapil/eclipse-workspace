package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
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
	public void logMethodCall(JoinPoint joinPoint) {
		// logic - what to do
		logger.info("Before Aspect - Method is called - {}", joinPoint);
	}
}
