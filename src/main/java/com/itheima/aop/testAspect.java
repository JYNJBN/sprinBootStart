//package com.itheima.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@Aspect
//public class testAspect {
//	//	@Pointcut("execution(* com.itheima.controller.*.*(..))")
////	指定添加了自定义注解mylog的方法
//	@Pointcut("@annotation(com.itheima.aop.MyLog)")
//	public void pd() {
//	}
//
//	@Around("pd()")
//	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//		log.info("环绕前通知");
//		Object proceed = joinPoint.proceed();
//		System.out.println("asdb");
//		System.out.println(proceed);
//		log.info("环绕后通知");
//		return proceed;
//	}
//
//	@Before("pd()")
//	public void before() {
//		log.info("前置通知");
//	}
//
//	@After("pd()")
//	public void after() {
//		log.info("后置通知");
//	}
//
//	//	执行完并且没有异常后执行
//	@AfterReturning("pd()")
//	public void AfterReturning() {
//		log.info("返回通知");
//	}
//
//	//	执行完并且有异常后执行
//	@AfterThrowing("pd()")
//	public void AfterThrowing() {
//		log.info("异常通知");
//	}
//}
