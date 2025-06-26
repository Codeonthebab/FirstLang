package com.excp;
/*
 * 		[throw]
 * 		- 프로그래머가 고의로 예외를 발생 시킬 때 사용함
 * 		 1. 먼저, 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만듬
 * 			Exception e = new Exception ("고의로 예외를 발생 시켰음");
 * 
 * 		 2. 키워드 throw를 이용해서 예외를 발생시킴
 * 			throw e;
 */	
public class ExceptionEx06 {
	
	public static void main (String [] args) throws Exception {
		method01 ();
	}
	
	static void method01 () throws Exception {
		method02 ();
	}
	
	static void method02 () throws Exception {
		throw new Exception () ;
	}
	
	/*  1. 예외가 발생했을 때, 모두 3개의 메소드가 호출 스택에 있으며,
	 * 	2. 예외가 발생한 곳은 제일 윗줄에 있는 method02 라는 것과
	 *  3. main 메소드가 method01() 을, 그리고 method01 ()은
	 *     method02()를 호출 했다.
	 *     round robin 
	 */
}
 