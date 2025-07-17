package com.ArrayEx;

/*
* 
* 	2차원 배열을 이용하여 다음과 같이 출력하시오.
*
* 	반복문을 이용하여 배열에 값을 저장한 후 
* 	아래와 같이 출력되도록 프로그램을 구현하시오.
* 	단 , 1번과 5번은 레기드 배열로 처리하시오.
*
*  [문5]
*  1  2  3  4
*  5  6  7
*  8  9
*  10 
*/

public class ArrayExam05 {
	public static void main(String[] args) {
		
		int[][] raggedArray = {
				{1,2,3,4},
				{5,6,7},
				{8,9},
				{10}
		};
		for (int i = 0; i < raggedArray.length; i++) {
			for (int j = 0; j < raggedArray[i].length; j++) {
				System.out.print(raggedArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}