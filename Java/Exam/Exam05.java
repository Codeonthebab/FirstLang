package com.exam;

import java.util.*;

/*
 	[문 1] 
    두개의 정수를 입력받아 두 수 사이의 
    합계를 구하는 프로그램을 구현하시오.
    
    [결과]
    첫번째 수 : 20
    두번째 수 : 10
    10에서 20 사이의 합계는 165입니다.
   
*/
public class Exam05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("첫번째 수 : ");
		int a = sc.nextInt();
		System.out.print("두번째 수 : ");
		int b = sc.nextInt();
		
		if (a>b) {
			a=a^b;
			b=b^a;
			a=a^b;
		}
		int sum = 0;
		
		for (int i = a; i <= b; i++) {
			sum+=i;
		}
		
		System.out.println(a+"에서"+b+"사이의 합계는 "+sum+"입니다.");
		
		sc.close();
	}
}