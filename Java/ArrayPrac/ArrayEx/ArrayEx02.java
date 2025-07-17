package com.arrayetwo;
/*
 */
public class ArrayEx02 {
	public static void main(String[] args) {
		
		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,0,30},
				{40,40,40},
				{50,50,50}
		};
		/* 배열선언과 for문을 활용한 부분
		for (int i = 0; i < score.length; i++) {
			for (int j=0; j<score[j].length; j++) {
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
		}
		*/ // 아래 부분은 위 배열선언을 간결하게 쓸 수 있는 사항
		int sum = 0;
		for (int[]temp : score) {
			for(int i : temp) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int[]temp : score) { 
			//score의 각 요소(1차원 배열 주소)를 1차원 배열인 temp에 저장
			for(int i : temp) {
				// temp는 1차원 배열을 가리키는 참조 변수
				sum += i;
			}
			//System.out.println();
		}
		System.out.print("합계 : "+sum);
	}
}