package com.condition;
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
public class IfEx08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1, n2 ;
		char ca;
		
		System.out.print("첫번째 정수를 입력하시오. \n");
		n1 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("연산자를 입력하시오 : ");
		//ca = sc.nextBoolean();
		ca = sc.nextLine().charAt(0);
		
		System.out.println("두번째 정수를 입력하시오.");
		n2 = sc.nextInt();
		
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
