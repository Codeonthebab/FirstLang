package com.ioex;
import java.util.Scanner;

/* 문1] 
 * 		Scanner 클래스로 이름, 도시, 나이, 체중, 독신 여부를 입력받고
 * 		출력하는 프로그램을 구현하시오
 * 		
 * 		문자열 : 이름, 도시
 * 		정수 : 나이
 * 		실수 : 체중
 * 		논리(boolean : Ture, false) : 독신 여부
 */
public class Exam01 {
	public static void main(String[] args) {
	// 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
				
		String name, city;
		int age; // 이름을 선언, 정수 값인 c에 대입 시키도록 한다
		double weight;
		boolean isSingle;
		
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("도시 : ");
		city = sc.next();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.printf("체중 : ");
		weight = sc.nextDouble();
		System.out.print("독신여부 : ");
		isSingle = sc.nextBoolean();
		
		System.out.print("이름은 "+name+"이고, 도시 명은 "+city+"이고, 나이는 "+age+"이며, 체중은 "+weight+"이며, 독신 여부는 "+isSingle+"이다.");
	}		
}
