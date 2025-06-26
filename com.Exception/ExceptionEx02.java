package com.excp;
/*
 * 	[예외 처리] 
 * 	정의 : 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
 * 	목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행 상태를 유지하는 것
 * 	
 * 	[예외를 처리하기 위한 try ~ catch 문]
 * 	try {
 *	// 예외가 발생할 가능성이 있는 코드를 작성
 *	} catch (Exception e1) {
 *	// Exception e1의 오류가 발생했을 경우 이를 처리하기 위한 코드를 작성
 *	} catch (Exception e2) {
 *	// Exception e2의 오류가 발생했을 경우 이를 처리하기 위한 코드를 작성
 *	}
 */
public class ExceptionEx02 {
	public static void main (String [] args) {
		int num = 100;
		int result = 0;
		
		for (int i=0; i<10; i++) {
		
			result = num / (int)(Math.random() * 10);
			System.out.println(result);
		}
	}
}
