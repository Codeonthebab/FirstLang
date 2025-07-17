package com.exam;
/*
 * [문 5] 
	2차원 배열을 이용하여 아래와 같이 출력하는 프로그램을 구현하시오.  
	단, 배열의 값을 반복문을 이용하여 저장
	1  5  9 13 17
	2  6 10 14 18  i씩 4씩 증가
	3  7 11 15 19	j는 1씩 감소
	4  8 12 16 20
*/
public class Exam01 {

	public static void main(String[] args) {
		
		/*
		int [][] arr = new int [4] [5];
		int num = 1;
		
		for (int j = 0; j <5 ; j++) {
			for (int i = 0; i < 4; i++) {
				arr[i][j]=num;
				num++;
			}
		}
		
		for(int i = 0; i<4; i++) {
			for (int j=0; j<5; j++) {
				System.out.printf("%2d\t", arr[i][j]);
			}
			System.out.println();
		}
		
		*/
		for (int i = 0; i <= 3;  i++) { 
			for (int j = 0; j <= 4; j++) {
				int result = (i+1)+(j*4);
				System.out.print((result) + "\t");
			}
			System.out.println();
		}
		
	}
}