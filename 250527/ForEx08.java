package com.loop;
import java.util.*;
public class ForEx08 {
/*
 *  아스키 코드 값을 이용해서 A ~ Z까지 입력
 */
    public static void main(String[] args) {
    	for (char ch = 'A'; ch <= 'Z'; ch++) {
    		System.out.print(ch+" ");
    	}
    	System.out.println();
    	for (char ch = 65; ch <= 90; ch++) {
    		System.out.print((char)ch+" ");
    	}
    	System.out.println();
    	for(char ch = 'A'; ch <= 'Z'; ch++) {
    		for (char bh = ch; bh <= 'Z'; bh++) {
    			System.out.print(bh);
    		}
    		System.out.println();
    	}
}
}