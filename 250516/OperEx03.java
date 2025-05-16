package com.operex;

/*		shift 연산자, (lefe, right)
 *		값을 2진수로 바꾼 후, 왼쪽인지 오른쪽인지 비트수를 이동함
 *		>> : 오른쪽 
 *		<< : 왼쪽
 *		  이동한 빈 자리는 0로 채운다
 * 
 */
public class OperEx03 {

	public static void main(String[] args) {
		int i = 10;
		int K = i >>2;
		
		System.out.println("i : "+i);
		System.out.println("K : "+ K);
	}

}
