package com.loop;
import java.util.*;
public class ForEx07 {

    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.print("보고 싶은 구구단 단수를 적으세요 : ");
        int line = sc.nextInt();
       */
        for(int i = 1; i <= 9; i++) { // 행
        	for (int j = 1; j <= 9; j++) { // 컬럼
        		if (i== j) {
        		System.out.printf("[%d, %d] ", i, j);
        		} else {
        			System.out.printf("%6c", ' ');
        		}
        	}
        	System.out.println();
     	}
    }
}