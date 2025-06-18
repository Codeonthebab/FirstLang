package com.ArrayEx;

/*
* 
* 	2차원 배열을 이용하여 다음과 같이 출력하시오.
*
* 	반복문을 이용하여 배열에 값을 저장한 후 
* 	아래와 같이 출력되도록 프로그램을 구현하시오.
* 	단 , 1번과 5번은 레기드 배열로 처리하시오.
*
*  	[문1] 
*  	1
* 	2  3
* 	4  5  6
*	7  8  9  10  모양을 출력하세요.
*/

public class ArrayExam01 {
	public static void main(String[] args) {
		int[][] raggedArray = {
				{1},
				{2,3},
				{4,5,6},
				{7,8,9,10}
		};
		for (int i = 0; i < raggedArray.length; i++) {
			for (int j = 0; j < raggedArray[i].length; j++) {
				System.out.print(raggedArray[i][j] + " ");
			}
			System.out.println();
		}
	}
		/*
		 * = new int[4][];
		raggedArray[0] = new int[1]; 
		raggedArray[1] = new int[2]; 
		raggedArray[2] = new int[3];
		raggedArray[3] = new int[4];
		
		raggedArray[0][0] = 1;
		
		raggedArray[1][0] = 2;
		raggedArray[1][1] = 3;
		
		raggedArray[2][0] = 4;
		raggedArray[2][1] = 5;
		raggedArray[2][2] = 6;
		
		raggedArray[3][0] = 7;
		raggedArray[3][1] = 8;
		raggedArray[3][2] = 9;
		raggedArray[3][3] = 10;
		*/
		
}