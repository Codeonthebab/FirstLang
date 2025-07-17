package com.exam;
/*
 [문 4] 
   2차원 배열을 이용하여 아래와 같이 출력하는 프로그램을 구현하시오.  
   단, 배열의 값을 반복문을 이용하여 저장
				
   20 16 12  8  4
   19 15 11  7  3
   18 14 10  6  2
   17 13  9  5  1
 */

public class Exam02 {

    public static void main(String[] args) {

        // 4x5 크기의 패턴을 만들기 위한 중첩 for문
        for (int i = 0; i < 4; i++) { // 바깥쪽: 행 (0~3)
            for (int j = 0; j < 5; j++) { // 안쪽: 열 (0~4)
                int result = (20 - i) - (4 * j);            
                System.out.print(result + "\t");
            }
            System.out.println();
        }
    }
}