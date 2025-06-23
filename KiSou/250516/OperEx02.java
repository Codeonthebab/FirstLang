package com.operex;

/*
 * 살술 연산자
 * = > +, -, *, /, %
 *     byte, short, char, int 사이의 연산 결과는 int 형
 *     
 *     long, float, double -> 연산 결과가 큰 자료형으로 결정
 */

public class OperEx02 {

	public static void main(String[] args) {
		short a, b;
		a = b = 10;
		
		int c = a + b; // 같은 자료형이 더해지면 결과는 int로 선언해야 함
		
		
		System.out.println("c의 값은 :" +c);
		
				

	}

}
