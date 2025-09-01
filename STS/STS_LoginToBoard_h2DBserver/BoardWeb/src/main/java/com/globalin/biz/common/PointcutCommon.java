package com.globalin.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.globalin.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.globalin.biz..*Impl.get*(..))")
	public void getPointcut() {}
}
