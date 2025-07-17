package com.ArrayEx;

/*
* 
* 	2차원 배열을 이용하여 다음과 같이 출력하시오.
*
* 	반복문을 이용하여 배열에 값을 저장한 후 
* 	아래와 같이 출력되도록 프로그램을 구현하시오.
* 	단 , 1번과 5번은 레기드 배열로 처리하시오.
*
*  	[문2] 
*  	
*	 1  2  3  4  5		i = 0
*	 10  9  8  7  6     i = 1  10 시작
*	 11 12 13 14 15		i = 2  
*	 20 19 18 17 16 	i = 3  20 시작
*		모양을 출력하세요.
*/

public class ArrayExam02 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 4;  i++) {
			int startnum = 0;
			if ( i % 2 == 0 ) { // 0 행, 2행 
				startnum = (i/2) * 10 + 1 ;
			} else { // 1행, 3행 , 10, 20
				startnum = (i/2) * 10 + 10;
			}
			for (int j = 0; j < 5; j++) {
				if (i % 2 == 0) {  // 0행, 2행
					int numToprint = startnum + (j);
					System.out.printf("%3d", numToprint);
				} else { // 1행, 3행
					int numToprint = startnum - (j);
					System.out.printf("%3d", numToprint);
				}	
			}
			System.out.println();
		}
	}
}