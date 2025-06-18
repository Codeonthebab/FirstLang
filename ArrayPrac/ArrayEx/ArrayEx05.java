package com.arrayetwo;
import java.io.*; // BufferedReader를 사용하기 위해 필요
import java.util.Scanner; // System.in.read() 대신 Scanner 사용 시 필요

public class ArrayEx05 {
	public static void main(String[] args) throws IOException {
		// BufferedReader를 사용하면 한 줄 단위로 문자열을 읽고, Integer.parseInt로 변환해야 합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] subname = {"국어 점수", "영어 점수", "수학 점수"};
		
		// 학생 수 (행의 개수)는 임의로 3명으로 설정
		int numberOfStudents = 3; 
		
		// sub[학생 인덱스][과목 인덱스 또는 총점 인덱스]
		// 열의 개수 = 과목 수 (subname.length) + 1 (총점 공간)
		int sub [][] = new int[numberOfStudents][subname.length + 1]; 
		// sub[0]: 첫번째 사람
		// sub[1]: 두번째 사람
		// sub[2]: 세번째 사람
		// 각 사람별 배열 구조: [0]:국어, [1]:영어, [2]:수학, [3]:총점
		
		// 각 학생의 평균을 저장할 배열
		float[] avg = new float[numberOfStudents];
		
		// --- 점수 입력 및 총점 계산 루프 ---
		// k는 학생 인덱스 (0, 1, 2)
		for (int k = 0; k < numberOfStudents; k++) {	
			System.out.println((k+1) + "번째 학생 점수 입력:");
            
			// i는 과목 인덱스 (0, 1, 2)
			for (int i = 0; i < subname.length; i++) { // 주의: subname.length는 3 (과목 수)
				do {
					System.out.print(subname[i] + ": "); // "국어 점수:", "영어 점수:", "수학 점수:"
					sub[k][i] = Integer.parseInt(br.readLine()); // 해당 학생의 해당 과목 점수 입력
				} while (sub[k][i] < 0 || sub[k][i] > 100); // 0~100점 범위 유효성 검사

				// 총점 계산: 현재 학생(k)의 총점 칸(sub[k][3])에 현재 과목 점수를 더함
				// sub[k].length - 1 은 현재 행의 마지막 열 인덱스를 나타냅니다.
				// 여기서는 항상 3이 됩니다.
				sub[k][sub[k].length - 1] += sub[k][i]; 
			} // end for (i: 과목별 점수 입력 및 총점 누적)
			
			// --- 평균 계산 ---
			// avg[k]에 현재 학생(k)의 평균을 계산하여 저장
			// 총점은 sub[k][sub[k].length-1]에 저장되어 있습니다.
			// 과목의 개수는 subname.length (3) 입니다.
			avg[k] = (float)sub[k][sub[k].length - 1] / subname.length; 
            // 또는: avg[k] = (float)sub[k][sub[k].length - 1] / (sub[k].length - 1);
            // 소괄호로 묶어서 연산자 우선순위 명확히: (float)(sub[k].length - 1)
            // 저는 subname.length를 쓰는 것이 의미적으로 더 명확하다고 생각합니다.
            
		} // end for (k: 학생별 처리)
		
		System.out.println("\n--- 학생별 결과 ---");
		// --- 결과 출력 루프 ---
		for (int k = 0; k < numberOfStudents; k++) {
			System.out.println((k+1) + "번째 학생:");
			System.out.println("  총점 : " + sub[k][sub[k].length - 1]); // 해당 학생의 총점 출력
			System.out.printf("  평균 : %.2f\n", avg[k]); // 해당 학생의 평균 출력 (줄바꿈 추가)
			System.out.println("--------------------");
		}
		
		br.close(); // BufferedReader 자원 해제
	}
}