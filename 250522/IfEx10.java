package com.condition;
import java.util.*;
/* [문]
 * 		두 정수를 입력받아 큰수를 알아 맞히는 프로그램을 구현하시오.
 * 
 */
public class IfEx10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, max = 0;
		
		System.out.println("첫번째 정수");
		a = sc.nextInt();
		System.out.println("두번째 정수");
		b = sc.nextInt();
		
		if (a > b) {
			max = a;
			System.out.println("첫번째 수인("+a+")가 두번째 수 ("+b+")보다 큰 수 ("+max+") 입니다.");
		} else {  
			max = b;
			System.out.println("두번째 수인("+b+")가 첫번째 수 ("+a+")보다 큰 수 ("+max+") 입니다.");
	}
	}

}
