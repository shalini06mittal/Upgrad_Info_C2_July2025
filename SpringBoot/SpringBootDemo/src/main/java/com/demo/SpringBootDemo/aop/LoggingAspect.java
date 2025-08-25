package com.demo.SpringBootDemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	public LoggingAspect() {
		logger.info("Logging Aspect constructor");
	}
	
	//pointcut expression
	@Before("execution(public * apply*(..))")
	public void beforeAdvice(JoinPoint jp) {
		logger.info("Before Advice applied on method");
		logger.info("Before Advice " + jp.getTarget());
		logger.info("Before Advice " + jp.getSignature().getName());
	}
	@After("execution(public * apply*(..))")
	public void afterAdvice(JoinPoint jp) {
		logger.info("After Advice applied on method");
		logger.info("After Advice " + jp.getTarget());
		logger.info("After Advice " + jp.getSignature().getName());
	}
}
