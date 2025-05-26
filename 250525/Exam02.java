package com.exam;
import java.util.*;
public class Exam02 {
	/*
	 * [문2] 
	 * 		사칙연산자를 입력받아 계산하는 프로그램을 구현하시오. 
	 * 		연산자는 +,-, *, / 네가지로 하고, 피연산자는 모두 실수로 함
	 *
	 *
	 * [출력 결과]
	 * 
	 * 		0으로 나누기 연산시에는 -> 0으로 나눌수 없습니다.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double f = 0, n1, n2 = 0;
		String oper = " ";
		
		System.out.print("계산할 숫자를 입력해주세요.");
		n1 = sc.nextDouble();
		System.out.print("사칙 연산자를 입력해주세요.");
		oper = sc.next();
		System.out.print("계산할 숫자를 입력해주세요.");
		n2 = sc.nextDouble();
		
		/* 오류 교정문
		if (n1 = sc.nextDouble()&& n2 = sc.nextDouble()) {
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		*/
		
		if (oper.equals("")) {
			System.out.println("연산자가 입력되지 않았습니다.");
		} else if ((n1 == 0 || n2 == 0)) {
			System.out.println("0으로 나누기 연산시에는 -> 0으로 나눌수 없습니다.");
		}
		
			switch (oper) {
			case "+":
				f = n1 + n2;
				break;
			case "-":
				f = n1 - n2;
				break;
			case "*":
				f = n1 * n2;
				break;
			case "/":
				f = n1 / n2;
				break;
			default:
				System.out.println("잘못된 연산자 입력입니다.");

			}
			System.out.printf("계산 결과 %.2f", f);
		}
	
}
