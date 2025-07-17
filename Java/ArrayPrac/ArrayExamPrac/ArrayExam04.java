package com.ArrayEx;

/*
* 
* 	2차원 배열을 이용하여 다음과 같이 출력하시오.
*
* 	반복문을 이용하여 배열에 값을 저장한 후 
* 	아래와 같이 출력되도록 프로그램을 구현하시오.
* 	단 , 1번과 5번은 레기드 배열로 처리하시오.
*
*   [문4]
* 	1 5  9 13 17      i가 +1씩 증가,j는 +4씩 증가
* 	2 6 10 14 18
* 	3 7 11 15 19
* 	4 8 12 16 20  모양을 출력하세요.
*/

public class ArrayExam04 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 4;  i++) {
			for (int j = 0; j < 5; j++) {
				int numToprint = (i+1) + (j*4);
				System.out.printf("%3d", numToprint);	
			}
			System.out.println();
		}
	}
}