package com.examln;
import java.util.*;
/* 
 *  [문] 
 *  	원화를 입력받아 달러로 바꾸는 프로그램을 구현하시오.
 *  	1$ = 1375
 *  
 *  [출력 화면]
 *  	원화 입력 : 2800
 *  	[2800원]은 $2.0 달러 입니다.
 *  
 */		
public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원화 입력 : ");
		int won = sc.nextInt();
		final double nanum = 1375;
		double dol = 0;
		
		if (won != 0) {
			dol = won / nanum;
			System.out.printf("[" +won+ "]은 %.2f 달러 입니다.", dol);
		}	else { 
				System.out.printf("잘못된 입력입니다.");
		}
		

	}
}
