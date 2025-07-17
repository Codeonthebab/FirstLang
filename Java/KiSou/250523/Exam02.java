package com.examln;
import java.util.*;
/* 
 *  [문] 
 *  	2자리의 정수(0~99) 사이의 정수를 입력받고, 
 *  	10의 자리와 1의 자리가 같은지를 판별하는 프로그램을 구현하시오.
 *  	3자리 수 입력 시, 오류 문구 출력 시킬 것
 *  
 *  [출력 화면]
 *    예1)
 *  	정수 입력 (0 ~ 99) : 77
 *  	[77]은 10의 자리와 1의 자리가 같습니다.
 *  
 *    예2)
 *  	정수 입력 (0 ~ 99) : 97
 *  	[97]은 10의 자리와 1의 자리가 다릅니다.
 *  Tip ) 10의 자리를 구할 때 10의 자리로 나누어서 같은지 다른지 확인해볼 수 있다.
 */		
public class Exam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 (0 ~ 99) : ");
		int a = sc.nextInt();
		int ten = a/10;
		int one = a%10;
		
	if (a < 10 || a > 99) { // 구간 설정을 위한 if문
		System.out.println("["+a+"]은 비교할 수 없습니다."); 
	return ; //return을 통해서 해당 if 문의 실행을 막으면, 다음 if 문이 실행된다.
	}
	
	if (ten == one) {
			System.out.println("["+a+"]은 10의 자리와 1의 자리가 같습니다.");
	} else if (ten != one) {
		System.out.println("["+a+"]은 10의 자리와 1의 자리가 다릅니다.");
	}	
	}
	}
	
