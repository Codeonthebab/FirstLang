package com.loop2;
import java.util.*;
/* 
 * 		while 값을 계속 진행시킬 것인가, 말 것인가 확인하는 문제
 *  		
 */
public class WhileEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println(" 계속 진행하시겠습니까? (y / n) ");
			char ch = sc.next().charAt(0);
			if (ch == 'n' || ch == 'N') {
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0); // break; //return; 으로 대체 가능
			} else if (ch=='y'||ch=='Y') {
				System.out.println("예, 계속하세요. ");
			}
			sc.close();
		}
}
}