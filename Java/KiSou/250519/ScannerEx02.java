package com.ioex;
import java.util.*;
public class ScannerEx02 {

	public static void main(String[] args) {
		// 스캐너 객체 생성
				Scanner sc = new Scanner(System.in);
				
		String name; // 문자가 하나 이상 인식
		char c; // 문자 하나
		
		System.out.print("이름 입력 : ");
		name = sc.next();
		
		System.out.print("혈액형 : ");
		c = sc.next().charAt(0);

		System.out.println(name);
		System.out.println(c);
	}

}
