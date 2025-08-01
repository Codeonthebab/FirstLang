package com.boardone;

public class BoardDAO {
	
	private static BoardDAO instance = null;
	private BoardDAO () { }
	
	public static BoardDAO getInstance() {
		
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO ();
			}
		}
		return instance;
	}
	
	// 여기서부터 게시판에 작업한 기능을 하나씩 메소드로 구현하여 추가하면 됨
	
	
	
}
