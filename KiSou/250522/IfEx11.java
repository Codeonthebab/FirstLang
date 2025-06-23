package com.condition;

import java.util.*;

/* [문]
 * 		사용자로부터 3개의 정수를 입력받아 
 * 		작은 수 부터 큰 수를 순서대로 출력하는 프로그램을 구현하시오.
 * 
 * [실행 결과]
 *  첫번째 : 16
 *  두번째 : 8
 *  세번째 : 21
 * 	
 * 	출력 결과 => 8, 16, 21
 */
public class IfEx11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	int a, b, c;
	int imsi;
	
	System.out.print("첫번째 : ");
	a = sc.nextInt();
	System.out.print("두번째 : ");
	b = sc.nextInt();
	System.out.print("세번째 : ");
	c = sc.nextInt();
	/* 선생님 풀이
	 * a, b, c
	 * 1. 첫번째 정수가 두번째 정수보다 크다면
	 * 두 정수의 자리를 바꾼다. a와 b가 자리를 바꾼다.
	 * 
	 * if(a>b) {
	 * imsi = 1;
	 * a = b;
	 * b = imsi;
	 *  a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		
	 * 2. 첫번째 정수가 세번째 정수보다 크다면
	 * 두 정수의 자리를 바꾼다. a와 c가 자리를 바꾼다.
	 * 
	 * if(a>c) {
	 * imsi = 1;
	 * a = c;
	 * c = imsi;
	 *  a = a ^ c;
		c = c ^ a;
		a = a ^ c;
	 * 
	 * 3. 두번째 정수가 세번째 정수보다 크다면
	 * 두정수의 자리를 바꾼다. b와 c가 자리를 바꾼다.
	 * 
	 * if(b>c) {
	 * imsi = 1;
	 * b = c;
	 * c = imsi;
	 *  b = b ^ c;
		c = c ^ b;
		b = b ^ c; 
	 * 결과 출력
	 * System.out.println("결과 : " +a+ "+b+" " +c");
	 */
	if(a>b) {
		int imsi1 = 1;
		a = b;
		b = imsi1;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		
	} else if(a>c) {
		imsi = 1;
		a = c;
		c = imsi;
		a = a ^ c;
		c = c ^ a;
		a = a ^ c; 
	} else if(b>c) {
		imsi = 1;
		b = c;
		c = imsi;
		b = b ^ c;
		c = c ^ b;
		b = b ^ c;
	}	
	System.out.println("출력 결과 => " + a + ", " + b + ", " + c);
		
	/*
	 * 아래는 본인 생각 결과물
	a = a ^ b;
	b = b ^ a;
	
			
			
	
	if (((a > b)&&(a > c)&&(b > c))) {
		System.out.println("출력 결과 =>"+a+", "+b+", "+c+"");
	} else if ((b > a)&&(b > c)&&(c > a)) {  
		System.out.println("출력 결과 =>"+b+", "+a+", "+c+"");
	} else if ((c > a)&&(c > b)&&(c > a)) {  
		System.out.println("출력 결과 =>"+c+", "+b+", "+a+"");
	} else {
			System.out.println("재실행 후, 다시 입력해주세요");
		}
	*/
	}
}
