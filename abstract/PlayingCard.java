package com.abstractEx;

public interface PlayingCard {
	public static final int SPADE = 4;
	final int DIAMOND = 3; // public static fanal int DIAMOND = 3; 와 동일한 코드
	static int HEART = 5; //  public static fanal int HEART = 5; 와 동일한 코드
	int CLOVER = 1;  //public static fanal int CLOVER = 3; 와 동일한 코드
	
	public abstract String getCardNumber() ;
	String getCardKind(); // public abstract String getCardKind() ; 와 동일한 코드 
}
