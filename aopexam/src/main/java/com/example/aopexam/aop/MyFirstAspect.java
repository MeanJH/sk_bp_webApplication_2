package com.example.aopexam.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.aopexam.domain.Product;

@Component
@Aspect
public class MyFirstAspect {
	@Pointcut("execution(* com.example..*.addProduct(..))")
	private void pc() {}
	
	@Pointcut("execution(* findProduct(String))")
	private void pc2() {}
	
	
	@Before("execution(* com.example..ProductServiceImpl.addProduct(..))")
	public void before(JoinPoint jp) {
		//메소드가 시작되기 전에 동작하는 어드바이스 
		System.out.println("Hello~~~ Before **********************************");
		
		Signature sig =	jp.getSignature();
		System.out.println(sig.getName());
		
		Object[] args = jp.getArgs();
		
		for (Object object : args) {
			System.out.println("==========> 인자 ::::::::::   "+object);
		}
	}
	
	@After("pc()")
	public void after() {
		//메소드가 실행된 후 동작하는 어드바이스 
		System.out.println("Hello~~~ After **********************************");
	}
	
	@AfterReturning(value = "pc2()",returning = "product")
	public void afterReturning(JoinPoint jp, Product product) {
		System.out.println("Hello AfterReturning ==============  메소드가 에외 없이 실행 되었을때 ");
		Signature sig =	jp.getSignature();
		System.out.println(sig.getName());
		
		Object[] args = jp.getArgs();
		
		for (Object object : args) {
			System.out.println("==========> 인자 ::::::::::   "+object);
		}
		
		product.setName("new pen!!!");
	}
	
	@AfterThrowing(value = "pc2()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("Hello AfterThrowing  =====================  예외가 발생되었을 때 실행!@!! ");
		System.out.println("exception value = "+ ex);
	}
	
	@Around("pc2()")
	public Product around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Hello Around  ===================메소드가 실행되기 전!!");
		
		Product product = (Product)	pjp.proceed(); // 실제 메서드 실행!!!  
		
		System.out.println("Hello Around  ===================메소드가 실행된 후!!");
		
		product.setPrice(1000);
		
		return product;
	}
}
