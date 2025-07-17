package com.operex;

/*
		논리 연산자(boolean) : &&(and), \\(or), !(not)
		
*/

public class OperEx04 {

	public static void main(String[] args) {

		boolean a;
		boolean b;
		
		if((a = 4 > 3) | (b = 5 > 7)) {
			System.out.println("a :"+a);
			System.out.println("b :"+b);
		}
	// 에러의 원인은 : 초기화 되지 않았다
	//  a = true; b = false; = > true
			
	}
}
