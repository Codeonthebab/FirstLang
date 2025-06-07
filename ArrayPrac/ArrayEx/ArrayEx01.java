package com.arrayetwo;
/*
 *  	[2차원 배열 -> 다차원 배열]
 *  	
 *  	배열선언
 *  	자료형 [][] 배열명;
 *  	자료형 배열명 [][];
 *  	자료형 [] 배열명[];
 *  
 *  	배열 초기화
 *  	배열명 = new 자료형 [행][열]
 *  	배열명 = new 자료형 [행][]; => 가변배열, 레기드배열, 비정형배열 // 열의 크기를 계속 다시 잡는 것
 *  	배열명 = { {1,2,3,4}(행),     => (0,0) = 1, (0,1) = 5. 식으로 배열을 알 수 있음 
 *  			  {5,6,7,8} (열) };
 */
public class ArrayEx01 {
	public static void main(String[] args) {
		// 배열 선언
		int[][] test = new int[2][3];
		
		// 배열에 값 저장
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// 배열에 저장된 값 출력
		for (int i = 0; i < 2; i++) { // 2대신에 test.length를 추가하면 정상적으로 표기 안되는걸 볼 수 있는데
			for (int j = 0; j<3; j++) { // 2에 위 랭쓰를 넣었을 경우, 3대신에 test[i].length 로 표기하여 [열]을 정상적으로 표기해주어야한다.
				System.out.print("test ["+i+ "] ["+j+ "] : "+test[i][j]+"\t");
			}
			System.out.println();
		}
	}
}