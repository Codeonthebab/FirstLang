package com.loop2;
import java.util.*;
/* 
 *  	[문]
 *  		I can do it을 5번 출력하면서
 *  		i의 값이 0이 아닌 동안 출력하게끔 하시오.
 *  		5, 4, 3, 2, 1, 0 감소하게끔 - 1씩 증가가 아닌 감소
 *  		
 */
public class WhileEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 10; 
		
		System.out.println(" insert coin ");
				
		while (i-- != 0) { // 조건 => -1이 아니면 참
			System.out.println(" insert coin ");
			System.out.println(i);
			for (int j = 0; j < 2_000_000_000;j++) {	
			}
		}
	sc.close();
	System.out.println("Game Over");
	}
}
