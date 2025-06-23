package com.condition;
/*
 * [문]
 * 		사용자로 부터 임의의 정수를 입력받은 정수가
 * 		2의 배수인지, 3의 배수인지, 2와 3의 배수인지, 2와 3의 배수가 아닌지.
 * 		판단하는 프로그램을 구현하시오.
 */
import java.io.*;
import java.util.*;
public class IfEX07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("정수를 입력해주세요.");
		n = sc.nextInt();
		
		if ((n%2==0)&&(n%3==0)&&(n%6==0)) 
			System.out.println("2의 배수이며 3의 배수, 2와 3의 배수입니다.");
		else if ((n%2==1)&&(n%3==1)) {
			System.out.println("2와 3의 배수가 아닙니다.");
	}
}
}
/* 선생님 풀이
 * 	if ((n % 2==0)&&(n % 3 ==0) {
 * 		System.out.println(n+"==> 2와 3의 배수임!!")
 * 	else if ((n % 2==0) {
 * 		System.out.println(n+"==> 2의 배수임!!")
 *  else if ((n % 3==0) {
 * 		System.out.println(n+"==> 3의 배수임!!")
 *  else 
 * 		System.out.println(n+"==> 배수 아임!!")
 */