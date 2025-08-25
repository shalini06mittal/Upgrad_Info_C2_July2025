package com.demo.SpringBootDemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	@Before("execution(public * CustomerServiceImpl.balance(..))")
	public void beforeAdvice1(JoinPoint jp) {
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
	@AfterReturning(pointcut = "execution(public * CustomerServiceImpl.balance(..))", returning = "msg")
	public void afterReturnAdvice(JoinPoint jp, double msg) {
		logger.info("After Returning Advice " + jp.getTarget());
		logger.info("After Returning Advice -  " + jp.getSignature().getName()+" "+msg);
	}
	
	@AfterThrowing(pointcut="execution(public * apply*())", throwing = "ex")
	public void throwsExcpeiton(JoinPoint jp, Exception ex) {
		logger.info("After Throwing Advice " + jp.getTarget());
		logger.info("After Throwing Advice -  " + jp.getSignature().getName()+" "+ex.getMessage());
	}
	
}
