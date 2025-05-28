package com.loop;

import java.util.*;


public class ForEx09 {
	/*
	 * [문] 알파벳 한 문자를 입력받아 입력받은 문자부터 A까지 감소시켜 출력하는 프로그램을 구현하시오. 
	 * [출력] 알파벳 입력 : e
	 * abcde abcd abc ab a
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳 입력 : ");
		char ap = 'e'; // sc.next().charAt(0);

		if ((ap >= 'A' && ap <= 'Z') || (ap >= 'a' && ap <= 'z')) {
			for (char bt = ap; bt <= ap ; bt--) {
				System.out.println(bt);
				// for (char bte = 'A'; bte <= bt(bt-1); bte++)
//    			System.out.print(bte);		//for () {
			}
			System.out.println();
		}
		sc.close();
	}
}