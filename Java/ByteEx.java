package com.variable;

/*	 byte 
 * 		- 1byte = 8bit
 * 		  범위 : 256 => -128 ~ 127
 * 
 *	 byte bb = 127; 했을 경우, 
 *		오류 발생 (*범위 초과) > int로 변경 시 128을 인식 
 *		(*그 이상 범위를 포괄하니까)
 *
 */


public class ByteEx {
	
	public static void main(String[] args) {
		byte bb = 127;
		int a;
		a = bb + 1;
		System.out.println("a = " +a);
		
	}
}
