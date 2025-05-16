package com.operex;

/*	복합대입연산자, 복합연산, 배정연산자
 * 	+=, -=, .. ETC
 * 	a = a + b = > a += b
 */

public class OperEx06 {

	public static void main(String[] args) {
		int a = 10;
		int result = 0;
		
		result += a;
		System.out.println("result : " +result); // 10
		result *= a;
		System.out.println("result : " +result); // 100
		result -= a;
		System.out.println("result : " +result); // 90
		result %= a;
		System.out.println("result : " +result); // 0
	}

}
