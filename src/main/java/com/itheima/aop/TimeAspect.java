//package com.itheima.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//@Slf4j
//public class TimeAspect {
//	@Around("execution(* com.itheima.controller.*.*(..))")
//	public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
//		long start = System.currentTimeMillis();
//		Object proceed = joinPoint.proceed();
//		long end = System.currentTimeMillis();
//		log.info(joinPoint.getSignature() + "耗时{}", end - start);
//		return proceed;
//	}
//}
