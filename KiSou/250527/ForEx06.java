package com.loop;
import java.util.*;
public class ForEx06 {

    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.print("보고 싶은 구구단 단수를 적으세요 : ");
        int line = sc.nextInt();
       */
        for(int i = 2; i <= 9; i++) { // 행
        	for (int j = 1; j <= 9; j++) { // 컬럼
        		System.out.printf("[%d, %d] ", i, j);
        	}
        	System.out.println();
     	}
    }
}
