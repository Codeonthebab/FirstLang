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
public class ExceptionEx05 {
	public static void main (String [] args) {
		
		try {
		throw new RuntimeException ("d"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
 