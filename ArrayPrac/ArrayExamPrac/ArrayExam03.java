package com.ArrayEx;

/*
* 
* 	2차원 배열을 이용하여 다음과 같이 출력하시오.
*
* 	반복문을 이용하여 배열에 값을 저장한 후 
* 	아래와 같이 출력되도록 프로그램을 구현하시오.
* 	단 , 1번과 5번은 레기드 배열로 처리하시오.
*
*  [문3]
*  20 16 12  8  4   -4 씩 줄어      i = 0  20 - i
*  19 15 11  7  3				  i = 1
*  18 14 10  6  2                 i = 2
*  17 13  9  5  1  모양을 출력하세요.
*/

public class ArrayExam03 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 4;  i++) {
			for (int j = 0; j < 5; j++) {
				int startnum = (20-i);
				int numToprint = startnum-(j*4);
				System.out.printf("%3d", numToprint);	
			}
			System.out.println();
		}
	}
}