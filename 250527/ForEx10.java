package com.loop;
import java.util.*;
import java.util.stream.Stream;
public class ForEx10 {
/*
 *  [문]
 *  	중첩 for 문을 이용하여 다음과 같이 구현하시오. 
 *  [출력]
 *  			0
 *   		   101
 *  		  21012
 * 		     3210123
 * 		    432101234
 * 		   54321012345
 *		  6543210123456
 *		 765432101234567
 *	
 *	tip ) Math.abs(); 절대값을 구하는 함수
 */
    public static void main(String[] args) {
    	
    	int a, b;
    	final int num = 7;
    	
    	for (a = 0; a <= 7; a++) {
    		for (b = num; b >= -num; b--) {
    			if (Math.abs(b) > a)
    				System.out.print(' ');
    			else
    				System.out.print(Math.abs(b));
    	}
    		System.out.println();
    }
    }
}
