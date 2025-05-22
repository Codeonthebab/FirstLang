package com.condition;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
 * [문]  사용자로부터 두 정수와 연산자를 받아 
 * 		해당 연산을 처리하는 프로그램을 구현하시오.
 * 
 * [출력결과]
 * 		첫번째 정수입력 : 10
 * 		연산자 입력 [+, -, *, /] : +
 * 		두번째 정수입력 : 14
 * 		
 * 		10 + 14 = 24
 */
import java.util.*;
public class IfEx09 {
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		int n1, n2 ;
		char ca;
		
		System.out.print("첫번째 정수를 입력하시오. \n");
		n1 = (char)System.in.read();
		
		// sc.nextLine();
		
		System.out.print("연산자를 입력하시오 : ");
		//ca = sc.nextBoolean();
		ca = (char)System.in.read();
		System.in.read();
		System.in.read();
		
		System.out.println("두번째 정수를 입력하시오.");
		n2 = (char)System.in.read();
		
		if ((ca == '+'))
			System.out.printf("결과는 ==> %d + %d = %d", n1, n2, (n1+n2));
		else if ((ca == '-'))
			System.out.printf("결과는 ==> %d - %d = %d", n1, n2, (n1-n2));
		else if ((ca == '*'))
			System.out.printf("결과는 ==> %d * %d = %d", n1, n2, (n1*n2));
		else if ((ca == '/'))
			System.out.printf("결과는 ==> %d / %d = %d", n1, n2, (n1/n2));
		else {
			System.out.println("연산자가 아닙니다.");
		
		}
	}

}
