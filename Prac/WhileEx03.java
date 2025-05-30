package com.loop2;
import java.util.*;
/* 
 *  	[문]
 *  		사용자로부터 반복해서 숫자를 입력받다가 0을 입력하면 끝마치고
 *  		합계를 출력하는 프로그램을 구현하시오.
 *  		
 */
public class WhileEx03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, sum = 0 ; 
		boolean flag = true;
		
		while (flag) {
			System.out.print("정수 입력 : ");
			n = sc.nextInt();
			if (n != 0) {
				sum += n;
			} else {
				break;  // flag = false; 대체 가능
			}
		}
		sc.close();
		System.out.println("총 값(Gun price) : " +sum);
}
}