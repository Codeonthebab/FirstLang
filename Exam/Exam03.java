package com.exam;

import java.util.*;

/*
	[문 3] 
    	Scanner 를 이용하여 알파멧 소문자 하나를 입력받고 
    	다음과 같이 출력하는 프로그램을 작성하시오.
    	
    [소문자 알파벳 하나는 입력하시오.] >> e
      abcde
      abcd
      abc
      ab
      a
*/
public class Exam03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("[소문자 알파벳 하나는 입력하시오.] >> ");
		char alpha = sc.next().charAt(0);

		if ((alpha >= 'a' && alpha <= 'z')) {
			for (char i = alpha; i >= 'a'; i--) {
				for (char j = 'a'; j <= i; j++) {
					System.out.print((j) + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}