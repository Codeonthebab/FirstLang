package com.arrayetwo;
import java.io.*; 

public class ArrayEx06 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] subname = {"국어 점수", "영어 점수", "수학 점수"};
		

		int numberOfStudents = 3; 
		int sub [][] = new int[numberOfStudents][subname.length + 2]; 
		// 각 사람별 배열 구조: [0]:국어, [1]:영어, [2]:수학, [3]:총점, [4]:석차

		float[] avg = new float[numberOfStudents];		// 각 학생의 평균을 저장할 배열
		
		// 점수 입력 및 총점 계산하기 위한 반복문
		for (int k = 0; k < numberOfStudents; k++) {	
			System.out.println((k+1) + "번째 학생 점수 입력:");
            
			// i는 과목 인덱스 (0, 1, 2)
			for (int i = 0; i < subname.length; i++) { 
				do {
					System.out.print(subname[i] + ": "); // "국어 점수:", "영어 점수:", "수학 점수:"
					sub[k][i] = Integer.parseInt(br.readLine()); // 해당 학생의 해당 과목 점수 입력
				} while (sub[k][i] < 0 || sub[k][i] > 100); 
				sub[k][sub[k].length - 2] += sub[k][i]; 
			} // end for (i: 과목별 점수 입력 및 총점 누적)
			
			avg[k] = (float)sub[k][sub[k].length - 2] / subname.length; 
			sub[k][sub[k].length - 1] = 1;
			
		} // end for (k: 학생별 처리하기 위한 반복문)
		for(int k = 0; k<sub.length; k++ ) {
			for (int i =0; i < sub.length; i++) {
				if (sub[k][sub[k].length - 2] < sub[i][sub[i].length - 2]) {
					sub[k][sub[k].length - 1]++;
				}
			}
		}
		System.out.println("\n--- 학생별 결과 ---");
		// 위에서 계산한 것들을 출력하기 위한 반복문
		for (int k = 0; k < numberOfStudents; k++) {
			System.out.println((k+1) + "번째 학생:");
			System.out.println("  총점 : " + sub[k][sub[k].length - 2]); // 해당 학생의 총점 출력
			System.out.printf("  평균 : %.2f\n", avg[k]); // 해당 학생의 평균 출력
			System.out.println("  석차 : "+sub[k][sub[k].length - 1] + "등 ");
			System.out.println("--------------------");
		}
		br.close();
	}
}