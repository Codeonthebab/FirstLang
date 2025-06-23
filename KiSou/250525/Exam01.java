package com.exam;

import java.io.*;
import java.util.*;

public class Exam01 {
	/*
	 * 
	 * [문1] 
	 * 	1 ~ 99까지의 정수를 입력받고 정수에 3, 6, 9 중 
	 * 	하나가 있는 경우는 "박수짝", 
	 * 	두개가 있는 경우는 "박수짝짝" 출력하는 프로그램을 구현하시오.
	 * 
	 * [출력 결과] 
	 * 	1 ~ 99 사이의 정수 입력 : 36 박수짝짝
	 *
	 */

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 적어주세요 (0~99) : ");
		int a = sc.nextInt();
		int tendigit = a / 10; // 10의 자리
		int onedigit = a % 10; // 1의 자리
		String zzak = " ";
		String zzake = " ";
		// String none = " "; 
		
		if (a < 1 || a > 99) {
			System.out.println("0 ~ 99까지만 입력하세요. ");
		}
		
		switch (tendigit) {
		case 3:
		case 6:
		case 9:
			zzak = "짝";
			break;
		}
		switch (onedigit) {
		case 3:
		case 6:
		case 9:
			zzake = "짝";
			break;
			}
			/*
			 * if (zzake == null) { System.out.print(" "); }
			 */
		if (zzak.equals(" ") && zzake.equals(" ")) {
		 System.out.println("박수 안 칠꺼야.");
		} else {
			System.out.print("박수" + zzak + zzake); // 기본 출력문구
		}
			sc.close();
			
	}
}

