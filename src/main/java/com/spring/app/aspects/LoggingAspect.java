package com.spring.app.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger log = Logger.getLogger(getClass().getName()) ;
	
//	@Before("execution(void com.spring.app..*.set*(*))")		//before the the execution of set methods in the package with only 1 argument
//	public void callSetters(JoinPoint joinPoint){
//		String method = joinPoint.getSignature().getName() ;
//		String args = joinPoint.getArgs()[0].toString() ;
//		log.info("Called "+method+" with arg "+args+" on "+joinPoint.getTarget());
//	}
	
//	@Around("execution(String playGame())")				//used as aspect before and after execution of the method
	public Object aroundCall(ProceedingJoinPoint proceedJoinPoint) throws Throwable{
		boolean rain = Math.random() < 0.5 ;
		Object result = null ;
		if(rain){
			log.info(proceedJoinPoint.getTarget()+" rained out");
		}else{
			result = proceedJoinPoint.proceed() ;		//execute the method
			log.info("match result : "+result);
		}
		return result ;
	}
}
