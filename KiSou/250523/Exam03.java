package com.examln;

import java.util.*;

/* 
 *  [문] 
 *  	정수로 된 돈의 금액을 입력받아 
 *  	오만원권, 만원권, 오천원권, 천원권
 *  	500원 동전, 100원 동전, 50원 동전, 10원 동전, 5원 동전, 1원 동전
 *  	이 각각 몇개인지를 변환하는 프로그램을 구현하시오.
 *  	
 *  	단, if문만을 사용하시오.
 *  
 *  [출력 화면]
 *    예1)
 *  	 금액 입력 : 65376
 *  	 5만원 : 1매
 *  	 1만원 : 1매
 *  	 5천원 : 1매
 *  	 1천원 : 0매
 *  	 500원 : 0개
 *  	 100원 : 3개
 *  	 50원 : 1개
 *  	 10원 : 2개
 *  	 1원 : 6개
 *  
 */
public class Exam03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 입력 : ");
		int n = sc.nextInt();
		final int oman = 50000;
		final int man = 10000;
		final int ochun = 5000;
		final int chun = 1000;
		final int obek = 500;
		final int bek = 100;
		final int osip = 50;
		final int sip = 10;
		final int il = 1;
		
		/*
		int oo = n / oman ;
		int mm = oo / man ;
		int oc = (mm%oman) / ochun ;
		int c = (oc%oman) / chun ;
		int ob = (c%oman) / 500 ;
		int b = (ob%oman) / bek ;
		int os = (b%oman) / osip ;
		int s = (os%oman) / sip ;
		int i = (s%oman) / il ; 
		*/
		int result = 0;
		
		result = n / oman;
		n = n % oman;
		if (result>0) {
			System.out.println("5만원 : "+result);
		}
		result = n / man;
		n = n % man;
		if (result>0) {
				System.out.println("1만원 : "+result);
		}
		result = n / ochun;
		n = n % ochun;
		if (result>0) {
		System.out.println("5천원 : "+result);
		}
		result = n / chun;
		n = n % chun;
		if (result>0) {
		System.out.println("1천원 : "+result);
		}
		result = n / obek;
		n = n % obek;
		if (result>0) {
		System.out.println("500원 : "+result);
		}
		result = n / bek;
		n = n % bek;
		if (result>0) {
		System.out.println("100원 : "+result);
		}
		result = n / osip;
		n = n % osip;
		if (result>0) {
		System.out.println("50원 : "+result);
		}
		result = n / sip;
		n = n % sip;
		if (result>0) {
		System.out.println("10원 : "+result);
		}
		result = n / il;
		n = n % il;
		if (result>0) {
		System.out.println("1원 : "+result);
		}
		return;
	}

}

		
			/*
			System.out.println("1만원 : "+mm);
			System.out.println("5천원 : "+oc);
			System.out.println("1천원 : "+c);
			System.out.println("500원 : "+ob);
			System.out.println("100원 : "+b);
			System.out.println("50원 : "+os);
			System.out.println("10원 : "+s);
			System.out.println("1원 : "+il);
			*/
		