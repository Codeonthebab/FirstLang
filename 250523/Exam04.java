package com.examln;

import java.util.*;

/* 
 *  [문] 
 *  	정수 3개를 입력받고 3개의 정수 중 중간 크기의 수를 
 *  	출력하는 프로그램을 작성하시오.
 *  	단, if 문으로 작성하시오.
 *  
 *  [출력 화면]
 *    예1)
 *  	 정수 3개 입력 : 20 100 33
 *  	 중간 값 : 33
 *  	 
 */
public class Exam04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 3개 입력");
		int a, b, c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		if ((b > a && a > c)||(c > a && a > b)) { // b > a > c || c > a > b
			System.out.println("중간 값 : " + a);
		}
		if ((a > b && b > c)||(c > b && b > a)) { // a > b > c  || c > b > a
			System.out.println("중간 값 : " + b);
		}
		if ((a > c && c > b)||(b > c && c > a)) { // a > c > b || b > c > a
			System.out.println("중간 값 : " + c);
			return;
		}

	}
}