package com.gaming;
import java.util.*;

public class Player {
	
	private String user ;
	
	public Player (String user) {
		this.user = user;
	}
	
	public String getName() {
		return user;
	}
	
	public String getWordFromUser() {
		Scanner sc = new Scanner (System.in);
		System.out.print(user + " >> ");
		String word = sc.next();
		return word;
	}

}
