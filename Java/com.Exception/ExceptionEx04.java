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
public class ExceptionEx04 {
	public static void main (String [] args) {
		
		try {
			//Exception e = new Exception ("고의로 예외를 발생 시켰음다");
			//throw e; 
			throw new Exception ("고의로 예외를 발생 시켰음다! "); // 위에 두 코드를 하나로 함축시키기가 가능
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("으음 ~ 정상 처리됨. ");
		
	}
}
 