package com.arrayetwo;
/*
 * 	다차원 배열을 활용하여 아래와 같이 출력되도록 프로그래밍 하시오.
 * 	=====================================================
 * 	번호    국어   영어   수학   총점    평균
 *  --------------------------------------
 *  1	   100	 100   100	 300	100.0
 *  2	    20	  20	20	  60     20.0
 *  3	    30	  30	30    90     30.0
 *  4	    40	  40	40   120     40.0
 *  5	    50	  50	50   150     50.0
 *  
 *  총점    240   240   240
 */
public class ArrayEx03 {
	public static void main(String[] args) {
		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		};
		
		// 과목별 총점 변수 선언
		int kortot=0, engtot=0, mattot=0;
		// 각 개인별 총점과 평균 변수 선언
		int sum =0;
		float avg=0.0f;
		
		System.out.print("번호\t국어\t영어\t수학\t총점\t평균\n");
		System.out.print("---------------------------------------------\n");
		
		for(int i=0; i<score.length;i++) { //행을 의미함, 한번의 for 문으로 행이 진행될 때마다 계산되게끔 번호를 출력하게끔 진행.
			kortot += score[i][0];  // 총점을 계산하기 위한 공식
			engtot += score[i][1];
			mattot += score[i][2];
			System.out.print(i+1+"");
			for (int j=0;j<score[i].length;j++) {
				sum += score[i][j];
				System.out.printf("   %6d", score[i][j]);
			}
			avg = sum/(float)score[i].length;
			System.out.printf("  %5d\t%5.1f",sum,avg);
			System.out.println();
		}
		System.out.println("---------------------------------------------");
		System.out.printf("총점 :\t%4d \t%4d \t%4d\n",kortot,engtot,mattot);
		/*
		int [] [] score = {
				{1,100,100,100,300,100},
				{2,20,20,20,60,20},
				{3,30,30,30,90,30},
				{4,40,40,40,120,40},
				{5,50,50,50,150,50}
		};
		// float [][5] avg = {
		System.out.print("번호\t국어\t영어\t수학\t총점\t평균\n");
		for (int[]temp : score) {
			for (int i : temp) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		System.out.println();
		int sum1, sum2, sum3 = 0;
		sum1 = score[0][1] + score[1][1] + score[2][1] + score[3][1] + score[4][1];
		sum2 = score[0][2] + score[1][2] + score[2][2] + score[3][2] + score[4][2];
		sum3 = score[0][3] + score[1][3] + score[2][3] + score[3][3] + score[4][3];
		System.out.print("합계 :\t"+sum1+"\t"+sum2+"\t"+sum3);
		*/
	}
}