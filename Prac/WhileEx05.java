package com.loop2;

/*
 * 		while 문을 이용하여 구구단을 출력
 *  		
 */
public class WhileEx05 {

	public static void main(String[] args) {
		int i=2;
		
		while (i <= 9) {
			int j=1;
			while (j <= 9) {
				System.out.printf("[%2d * %2d = %2d] \n", i, j, i*j);
				j++;
			}
			i++;
			System.out.println("\n");
		}
}
}