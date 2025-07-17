package com.loop2;
/* 
 *  	[문]
 *  		1부터 시작해 몇까지 더하면 누적 합계가 100을 넘지 않은지,
 *  		n까지의 수와 합계 출력하시오.
 *  		
 */
public class WhileEx02 {

	public static void main(String[] args) {
		int n = 0, sum = 0 ; 
		
		while ((sum += ++n) <= 100) { // 조건 => -1이 아니면 참
			/* 코드 간소화
			 * sum += n;
			 * if (sum <= 100) {
			 * System.out.printf("%d ==> %d \n", n, sum);
			 * }
			 * n++;
			*/
			System.out.printf("%d ==> %d\n", n, sum);
		}
	System.out.println("Game Over");
	}
}
